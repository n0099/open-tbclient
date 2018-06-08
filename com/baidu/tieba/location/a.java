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
import com.baidu.tbadk.core.util.ac;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a implements com.baidu.adp.lib.d.b {
    private static a eNt = null;
    private C0191a eNw;
    private LocationClient eNx;
    private LocationClientOption eNy;
    private Context mContext;
    private Address zm;
    private boolean EF = true;
    private String eNu = "";
    private a.b eNv = null;
    private long zg = 0;
    private boolean eNz = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.d.a.rz() || ac.aL(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.hB().a(a.aRc());
                        } else {
                            com.baidu.adp.lib.d.a.hB().b(a.aRc());
                        }
                    }
                }
            }
        });
    }

    public static a aRc() {
        if (eNt == null) {
            synchronized (a.class) {
                if (eNt == null) {
                    eNt = new a();
                }
            }
        }
        return eNt;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.eNv = bVar;
        this.eNu = "baidu";
        if (this.EF) {
            try {
                this.eNx = new LocationClient(this.mContext);
                this.eNy = new LocationClientOption();
                this.eNy.setOpenGps(true);
                this.eNy.setIgnoreKillProcess(true);
                this.eNy.setProdName(this.eNu);
                this.eNy.setAddrType("all");
                this.eNy.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.eNw = new C0191a();
                this.eNx.registerLocationListener(this.eNw);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void K(boolean z) {
        if ((!com.baidu.d.a.rz() || ac.aL(TbadkCoreApplication.getInst())) && this.EF && this.eNx != null) {
            try {
                this.eNz = z;
                if (z) {
                    this.eNy.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eNx.setLocOption(this.eNy);
                if (!this.eNx.isStarted()) {
                    this.eNx.start();
                }
                this.eNx.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                hF();
                if (this.eNv != null) {
                    this.eNv.a(5, "", this.zm, this.zg, this.eNz);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        hF();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0191a implements BDLocationListener {
        private C0191a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.d.a.rz() || ac.aL(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.hF();
                a.this.zm = new Address(Locale.getDefault());
                a.this.zm.setLatitude(bDLocation.getLatitude());
                a.this.zm.setLongitude(bDLocation.getLongitude());
                a.this.zm.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                a.this.zm.setExtras(bundle);
                a.this.zg = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.zm.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.eNv != null) {
                    a.this.eNv.a(0, "", a.this.zm, a.this.zg, a.this.eNz);
                    com.baidu.tieba.recapp.d.a.boX().nO(String.valueOf(a.this.zm.getLatitude()));
                    com.baidu.tieba.recapp.d.a.boX().nN(String.valueOf(a.this.zm.getLongitude()));
                    com.baidu.tieba.recapp.d.a.boX().cW(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void hF() {
        if (this.eNx != null && this.eNx.isStarted()) {
            try {
                this.eNx.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
