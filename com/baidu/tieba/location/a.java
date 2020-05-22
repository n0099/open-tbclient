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
import com.baidu.tbadk.core.util.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes10.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a jeO = null;
    private LocationClient dfy;
    private C0663a jeR;
    private LocationClientOption jeS;
    private Address lastAddress;
    private Context mContext;
    private boolean OC = true;
    private String jeP = "";
    private a.b jeQ = null;
    private long lastLocationTime = 0;
    private boolean jeT = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.h.a.MI() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.kq().a(a.cvk());
                        } else {
                            com.baidu.adp.lib.c.a.kq().b(a.cvk());
                        }
                    }
                }
            }
        });
    }

    public static a cvk() {
        if (jeO == null) {
            synchronized (a.class) {
                if (jeO == null) {
                    jeO = new a();
                }
            }
        }
        return jeO;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.jeQ = bVar;
        this.jeP = "baidu";
        if (this.OC) {
            try {
                this.dfy = new LocationClient(this.mContext);
                this.jeS = new LocationClientOption();
                this.jeS.setOpenGps(true);
                this.jeS.setIgnoreKillProcess(true);
                this.jeS.setProdName(this.jeP);
                this.jeS.setAddrType(SchemeCollecter.CLASSIFY_ALL);
                this.jeS.setCoorType("bd09ll");
                this.jeR = new C0663a();
                this.dfy.registerLocationListener(this.jeR);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.h.a.MI() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.OC && this.dfy != null) {
            try {
                this.jeT = z;
                if (z) {
                    this.jeS.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.dfy.setLocOption(this.jeS);
                if (!this.dfy.isStarted()) {
                    this.dfy.start();
                }
                this.dfy.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.jeQ != null) {
                    this.jeQ.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.jeT);
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
    private class C0663a implements BDLocationListener {
        private C0663a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.h.a.MI() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + bDLocation.getLongitude());
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
                if (a.this.jeQ != null) {
                    a.this.jeQ.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.jeT);
                    com.baidu.tieba.recapp.d.a.cUZ().FZ(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cUZ().FY(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cUZ().fm(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.dfy != null && this.dfy.isStarted()) {
            try {
                this.dfy.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
