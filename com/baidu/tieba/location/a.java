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
import java.util.Locale;
/* loaded from: classes8.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a lhV = null;
    private LocationClient eor;
    private Address lastAddress;
    private C0785a lhY;
    private LocationClientOption lhZ;
    private Context mContext;
    private boolean Rt = true;
    private String lhW = "";
    private a.b lhX = null;
    private long lastLocationTime = 0;
    private boolean lia = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.l.a.adh() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.lH().a(a.ddJ());
                        } else {
                            com.baidu.adp.lib.c.a.lH().b(a.ddJ());
                        }
                    }
                }
            }
        });
    }

    public static a ddJ() {
        if (lhV == null) {
            synchronized (a.class) {
                if (lhV == null) {
                    lhV = new a();
                }
            }
        }
        return lhV;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.lhX = bVar;
        this.lhW = "baidu";
        if (this.Rt) {
            try {
                this.eor = new LocationClient(this.mContext);
                this.lhZ = new LocationClientOption();
                this.lhZ.setOpenGps(true);
                this.lhZ.setIgnoreKillProcess(true);
                this.lhZ.setProdName(this.lhW);
                this.lhZ.setAddrType("all");
                this.lhZ.setCoorType("bd09ll");
                this.lhY = new C0785a();
                this.eor.registerLocationListener(this.lhY);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.l.a.adh() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.Rt && this.eor != null) {
            try {
                this.lia = z;
                if (z) {
                    this.lhZ.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eor.setLocOption(this.lhZ);
                if (!this.eor.isStarted()) {
                    this.eor.start();
                }
                this.eor.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.lhX != null) {
                    this.lhX.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.lia);
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
    private class C0785a implements BDLocationListener {
        private C0785a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.l.a.adh() || ae.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
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
                if (a.this.lhX != null) {
                    a.this.lhX.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.lia);
                    com.baidu.tieba.recapp.c.a.dEm().RO(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.c.a.dEm().RN(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.c.a.dEm().hB(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.eor != null && this.eor.isStarted()) {
            try {
                this.eor.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
