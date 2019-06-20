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
    private static a hdr = null;
    private LocationClient bmJ;
    private C0351a hdu;
    private LocationClientOption hdv;
    private Context mContext;
    private Address zT;
    private boolean Fu = true;
    private String hds = "";
    private a.b hdt = null;
    private long zN = 0;
    private boolean hdw = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.ud() || ab.cv(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.hO().a(a.bIY());
                        } else {
                            com.baidu.adp.lib.d.a.hO().b(a.bIY());
                        }
                    }
                }
            }
        });
    }

    public static a bIY() {
        if (hdr == null) {
            synchronized (a.class) {
                if (hdr == null) {
                    hdr = new a();
                }
            }
        }
        return hdr;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.hdt = bVar;
        this.hds = "baidu";
        if (this.Fu) {
            try {
                this.bmJ = new LocationClient(this.mContext);
                this.hdv = new LocationClientOption();
                this.hdv.setOpenGps(true);
                this.hdv.setIgnoreKillProcess(true);
                this.hdv.setProdName(this.hds);
                this.hdv.setAddrType("all");
                this.hdv.setCoorType("bd09ll");
                this.hdu = new C0351a();
                this.bmJ.registerLocationListener(this.hdu);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void Z(boolean z) {
        if ((!com.baidu.e.a.ud() || ab.cv(TbadkCoreApplication.getInst())) && this.Fu && this.bmJ != null) {
            try {
                this.hdw = z;
                if (z) {
                    this.hdv.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bmJ.setLocOption(this.hdv);
                if (!this.bmJ.isStarted()) {
                    this.bmJ.start();
                }
                this.bmJ.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                hS();
                if (this.hdt != null) {
                    this.hdt.a(5, "", this.zT, this.zN, this.hdw);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        hS();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0351a implements BDLocationListener {
        private C0351a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.e.a.ud() || ab.cv(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.hS();
                a.this.zT = new Address(Locale.getDefault());
                a.this.zT.setLatitude(bDLocation.getLatitude());
                a.this.zT.setLongitude(bDLocation.getLongitude());
                a.this.zT.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.zT.setExtras(bundle);
                a.this.zN = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.zT.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.hdt != null) {
                    a.this.hdt.a(0, "", a.this.zT, a.this.zN, a.this.hdw);
                    com.baidu.tieba.recapp.d.a.cfC().xS(String.valueOf(a.this.zT.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cfC().xR(String.valueOf(a.this.zT.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cfC().ej(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void hS() {
        if (this.bmJ != null && this.bmJ.isStarted()) {
            try {
                this.bmJ.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
