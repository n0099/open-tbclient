package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ac;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes10.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a jwM = null;
    private LocationClient dkk;
    private C0676a jwP;
    private LocationClientOption jwQ;
    private Address lastAddress;
    private Context mContext;
    private boolean Pg = true;
    private String jwN = "";
    private a.b jwO = null;
    private long lastLocationTime = 0;
    private boolean jwR = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.h.a.NR() || ac.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.kG().a(a.czl());
                        } else {
                            com.baidu.adp.lib.c.a.kG().b(a.czl());
                        }
                    }
                }
            }
        });
    }

    public static a czl() {
        if (jwM == null) {
            synchronized (a.class) {
                if (jwM == null) {
                    jwM = new a();
                }
            }
        }
        return jwM;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.jwO = bVar;
        this.jwN = "baidu";
        if (this.Pg) {
            try {
                this.dkk = new LocationClient(this.mContext);
                this.jwQ = new LocationClientOption();
                this.jwQ.setOpenGps(true);
                this.jwQ.setIgnoreKillProcess(true);
                this.jwQ.setProdName(this.jwN);
                this.jwQ.setAddrType(SchemeCollecter.CLASSIFY_ALL);
                this.jwQ.setCoorType("bd09ll");
                this.jwP = new C0676a();
                this.dkk.registerLocationListener(this.jwP);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.h.a.NR() || ac.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.Pg && this.dkk != null) {
            try {
                this.jwR = z;
                if (z) {
                    this.jwQ.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.dkk.setLocOption(this.jwQ);
                if (!this.dkk.isStarted()) {
                    this.dkk.start();
                }
                this.dkk.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.jwO != null) {
                    this.jwO.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.jwR);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0676a implements BDLocationListener {
        private C0676a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.h.a.NR() || ac.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + bDLocation.getLongitude());
                a.this.lastAddress.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.lastAddress.setExtras(bundle);
                a.this.lastLocationTime = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.lastAddress.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.jwO != null) {
                    a.this.jwO.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.jwR);
                    com.baidu.tieba.recapp.d.a.cZG().GB(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cZG().GA(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cZG().fp(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.dkk != null && this.dkk.isStarted()) {
            try {
                this.dkk.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
