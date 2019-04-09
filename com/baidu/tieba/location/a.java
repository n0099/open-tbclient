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
    private static a gLU = null;
    private Address Cl;
    private LocationClient bgE;
    private C0333a gLX;
    private LocationClientOption gLY;
    private Context mContext;
    private boolean HK = true;
    private String gLV = "";
    private a.b gLW = null;
    private long Cf = 0;
    private boolean gLZ = false;

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
        if (gLU == null) {
            synchronized (a.class) {
                if (gLU == null) {
                    gLU = new a();
                }
            }
        }
        return gLU;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.gLW = bVar;
        this.gLV = "baidu";
        if (this.HK) {
            try {
                this.bgE = new LocationClient(this.mContext);
                this.gLY = new LocationClientOption();
                this.gLY.setOpenGps(true);
                this.gLY.setIgnoreKillProcess(true);
                this.gLY.setProdName(this.gLV);
                this.gLY.setAddrType("all");
                this.gLY.setCoorType("bd09ll");
                this.gLX = new C0333a();
                this.bgE.registerLocationListener(this.gLX);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ah(boolean z) {
        if ((!com.baidu.e.a.ts() || ab.cQ(TbadkCoreApplication.getInst())) && this.HK && this.bgE != null) {
            try {
                this.gLZ = z;
                if (z) {
                    this.gLY.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bgE.setLocOption(this.gLY);
                if (!this.bgE.isStarted()) {
                    this.bgE.start();
                }
                this.bgE.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                ja();
                if (this.gLW != null) {
                    this.gLW.a(5, "", this.Cl, this.Cf, this.gLZ);
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
                if (a.this.gLW != null) {
                    a.this.gLW.a(0, "", a.this.Cl, a.this.Cf, a.this.gLZ);
                    com.baidu.tieba.recapp.d.a.bXv().wB(String.valueOf(a.this.Cl.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bXv().wA(String.valueOf(a.this.Cl.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bXv().dL(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ja() {
        if (this.bgE != null && this.bgE.isStarted()) {
            try {
                this.bgE.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
