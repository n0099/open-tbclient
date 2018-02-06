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
/* loaded from: classes3.dex */
public class a implements com.baidu.adp.lib.d.b {
    private static a fgn = null;
    private Address aiN;
    private C0191a fgq;
    private LocationClient fgr;
    private LocationClientOption fgs;
    private Context mContext;
    private boolean aob = true;
    private String fgo = "";
    private a.b fgp = null;
    private long aiH = 0;
    private boolean fgt = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.d.a.vB() || ab.aR(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.mG().a(a.aRk());
                        } else {
                            com.baidu.adp.lib.d.a.mG().b(a.aRk());
                        }
                    }
                }
            }
        });
    }

    public static a aRk() {
        if (fgn == null) {
            synchronized (a.class) {
                if (fgn == null) {
                    fgn = new a();
                }
            }
        }
        return fgn;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fgp = bVar;
        this.fgo = "baidu";
        if (this.aob) {
            try {
                this.fgr = new LocationClient(this.mContext);
                this.fgs = new LocationClientOption();
                this.fgs.setOpenGps(true);
                this.fgs.setIgnoreKillProcess(true);
                this.fgs.setProdName(this.fgo);
                this.fgs.setAddrType("all");
                this.fgs.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.fgq = new C0191a();
                this.fgr.registerLocationListener(this.fgq);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ap(boolean z) {
        if ((!com.baidu.d.a.vB() || ab.aR(TbadkCoreApplication.getInst())) && this.aob && this.fgr != null) {
            try {
                this.fgt = z;
                if (z) {
                    this.fgs.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.fgr.setLocOption(this.fgs);
                if (!this.fgr.isStarted()) {
                    this.fgr.start();
                }
                this.fgr.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                mK();
                if (this.fgp != null) {
                    this.fgp.a(5, "", this.aiN, this.aiH, this.fgt);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        mK();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0191a implements BDLocationListener {
        private C0191a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.d.a.vB() || ab.aR(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.mK();
                a.this.aiN = new Address(Locale.getDefault());
                a.this.aiN.setLatitude(bDLocation.getLatitude());
                a.this.aiN.setLongitude(bDLocation.getLongitude());
                a.this.aiN.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                a.this.aiN.setExtras(bundle);
                a.this.aiH = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.aiN.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.fgp != null) {
                    a.this.fgp.a(0, "", a.this.aiN, a.this.aiH, a.this.fgt);
                    com.baidu.tieba.recapp.d.a.boS().mV(String.valueOf(a.this.aiN.getLatitude()));
                    com.baidu.tieba.recapp.d.a.boS().mU(String.valueOf(a.this.aiN.getLongitude()));
                    com.baidu.tieba.recapp.d.a.boS().cM(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void mK() {
        if (this.fgr != null && this.fgr.isStarted()) {
            try {
                this.fgr.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
