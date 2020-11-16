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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes22.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a kLn = null;
    private LocationClient eaS;
    private C0786a kLq;
    private LocationClientOption kLr;
    private Address lastAddress;
    private Context mContext;
    private boolean QB = true;
    private String kLo = "";
    private a.b kLp = null;
    private long lastLocationTime = 0;
    private boolean kLs = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.m.a.aah() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.mk().a(a.daw());
                        } else {
                            com.baidu.adp.lib.c.a.mk().b(a.daw());
                        }
                    }
                }
            }
        });
    }

    public static a daw() {
        if (kLn == null) {
            synchronized (a.class) {
                if (kLn == null) {
                    kLn = new a();
                }
            }
        }
        return kLn;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.kLp = bVar;
        this.kLo = "baidu";
        if (this.QB) {
            try {
                this.eaS = new LocationClient(this.mContext);
                this.kLr = new LocationClientOption();
                this.kLr.setOpenGps(true);
                this.kLr.setIgnoreKillProcess(true);
                this.kLr.setProdName(this.kLo);
                this.kLr.setAddrType("all");
                this.kLr.setCoorType("bd09ll");
                this.kLq = new C0786a();
                this.eaS.registerLocationListener(this.kLq);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.m.a.aah() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.QB && this.eaS != null) {
            try {
                this.kLs = z;
                if (z) {
                    this.kLr.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eaS.setLocOption(this.kLr);
                if (!this.eaS.isStarted()) {
                    this.eaS.start();
                }
                this.eaS.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.kLp != null) {
                    this.kLp.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.kLs);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private class C0786a implements BDLocationListener {
        private C0786a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.m.a.aah() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + bDLocation.getLongitude());
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
                if (a.this.kLp != null) {
                    a.this.kLp.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.kLs);
                    com.baidu.tieba.recapp.d.a.dAG().LP(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.dAG().LO(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.dAG().gW(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.eaS != null && this.eaS.isStarted()) {
            try {
                this.eaS.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
