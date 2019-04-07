package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.util.Locale;
/* loaded from: classes5.dex */
public class a implements com.baidu.adp.lib.d.b {
    private static a gLT = null;
    private Address Cl;
    private LocationClient bgD;
    private C0333a gLW;
    private LocationClientOption gLX;
    private Context mContext;
    private boolean HK = true;
    private String gLU = "";
    private a.b gLV = null;
    private long Cf = 0;
    private boolean gLY = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.ts() || ab.cQ(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.iW().a(a.bBk());
                        } else {
                            com.baidu.adp.lib.d.a.iW().b(a.bBk());
                        }
                    }
                }
            }
        });
    }

    public static a bBk() {
        if (gLT == null) {
            synchronized (a.class) {
                if (gLT == null) {
                    gLT = new a();
                }
            }
        }
        return gLT;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.gLV = bVar;
        this.gLU = "baidu";
        if (this.HK) {
            try {
                this.bgD = new LocationClient(this.mContext);
                this.gLX = new LocationClientOption();
                this.gLX.setOpenGps(true);
                this.gLX.setIgnoreKillProcess(true);
                this.gLX.setProdName(this.gLU);
                this.gLX.setAddrType("all");
                this.gLX.setCoorType("bd09ll");
                this.gLW = new C0333a();
                this.bgD.registerLocationListener(this.gLW);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ah(boolean z) {
        if ((!com.baidu.e.a.ts() || ab.cQ(TbadkCoreApplication.getInst())) && this.HK && this.bgD != null) {
            try {
                this.gLY = z;
                if (z) {
                    this.gLX.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bgD.setLocOption(this.gLX);
                if (!this.bgD.isStarted()) {
                    this.bgD.start();
                }
                this.bgD.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                ja();
                if (this.gLV != null) {
                    this.gLV.a(5, "", this.Cl, this.Cf, this.gLY);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        ja();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0333a implements BDLocationListener {
        private C0333a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.e.a.ts() || ab.cQ(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.ja();
                a.this.Cl = new Address(Locale.getDefault());
                a.this.Cl.setLatitude(bDLocation.getLatitude());
                a.this.Cl.setLongitude(bDLocation.getLongitude());
                a.this.Cl.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.Cl.setExtras(bundle);
                a.this.Cf = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.Cl.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.gLV != null) {
                    a.this.gLV.a(0, "", a.this.Cl, a.this.Cf, a.this.gLY);
                    com.baidu.tieba.recapp.d.a.bXv().wB(String.valueOf(a.this.Cl.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bXv().wA(String.valueOf(a.this.Cl.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bXv().dL(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ja() {
        if (this.bgD != null && this.bgD.isStarted()) {
            try {
                this.bgD.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
