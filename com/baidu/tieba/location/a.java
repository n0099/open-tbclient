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
import com.baidu.tbadk.core.util.ad;
import java.util.Locale;
/* loaded from: classes8.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a lek = null;
    private LocationClient eqW;
    private Address lastAddress;
    private C0799a leo;
    private LocationClientOption lep;
    private Context mContext;
    private boolean Rx = true;
    private String lel = "";
    private a.b lem = null;
    private long lastLocationTime = 0;
    private boolean leq = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.n.a.afm() || ad.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.lI().a(a.dfw());
                        } else {
                            com.baidu.adp.lib.c.a.lI().b(a.dfw());
                        }
                    }
                }
            }
        });
    }

    public static a dfw() {
        if (lek == null) {
            synchronized (a.class) {
                if (lek == null) {
                    lek = new a();
                }
            }
        }
        return lek;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.lem = bVar;
        this.lel = "baidu";
        if (this.Rx) {
            try {
                this.eqW = new LocationClient(this.mContext);
                this.lep = new LocationClientOption();
                this.lep.setOpenGps(true);
                this.lep.setIgnoreKillProcess(true);
                this.lep.setProdName(this.lel);
                this.lep.setAddrType("all");
                this.lep.setCoorType("bd09ll");
                this.leo = new C0799a();
                this.eqW.registerLocationListener(this.leo);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.n.a.afm() || ad.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.Rx && this.eqW != null) {
            try {
                this.leq = z;
                if (z) {
                    this.lep.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eqW.setLocOption(this.lep);
                if (!this.eqW.isStarted()) {
                    this.eqW.start();
                }
                this.eqW.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.lem != null) {
                    this.lem.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.leq);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0799a implements BDLocationListener {
        private C0799a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.n.a.afm() || ad.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.bvr().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
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
                if (a.this.lem != null) {
                    a.this.lem.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.leq);
                    com.baidu.tieba.recapp.c.a.dFO().RQ(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.c.a.dFO().RP(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.c.a.dFO().hw(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.eqW != null && this.eqW.isStarted()) {
            try {
                this.eqW.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
