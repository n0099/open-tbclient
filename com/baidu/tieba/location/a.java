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
    private static a eRk = null;
    private C0193a eRn;
    private LocationClient eRo;
    private LocationClientOption eRp;
    private Context mContext;
    private Address zk;
    private boolean EH = true;
    private String eRl = "";
    private a.b eRm = null;
    private long ze = 0;
    private boolean eRq = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.d.a.rz() || ac.aL(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.hB().a(a.aRI());
                        } else {
                            com.baidu.adp.lib.d.a.hB().b(a.aRI());
                        }
                    }
                }
            }
        });
    }

    public static a aRI() {
        if (eRk == null) {
            synchronized (a.class) {
                if (eRk == null) {
                    eRk = new a();
                }
            }
        }
        return eRk;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.eRm = bVar;
        this.eRl = "baidu";
        if (this.EH) {
            try {
                this.eRo = new LocationClient(this.mContext);
                this.eRp = new LocationClientOption();
                this.eRp.setOpenGps(true);
                this.eRp.setIgnoreKillProcess(true);
                this.eRp.setProdName(this.eRl);
                this.eRp.setAddrType("all");
                this.eRp.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.eRn = new C0193a();
                this.eRo.registerLocationListener(this.eRn);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void K(boolean z) {
        if ((!com.baidu.d.a.rz() || ac.aL(TbadkCoreApplication.getInst())) && this.EH && this.eRo != null) {
            try {
                this.eRq = z;
                if (z) {
                    this.eRp.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eRo.setLocOption(this.eRp);
                if (!this.eRo.isStarted()) {
                    this.eRo.start();
                }
                this.eRo.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                hF();
                if (this.eRm != null) {
                    this.eRm.a(5, "", this.zk, this.ze, this.eRq);
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
    private class C0193a implements BDLocationListener {
        private C0193a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.d.a.rz() || ac.aL(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.hF();
                a.this.zk = new Address(Locale.getDefault());
                a.this.zk.setLatitude(bDLocation.getLatitude());
                a.this.zk.setLongitude(bDLocation.getLongitude());
                a.this.zk.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                a.this.zk.setExtras(bundle);
                a.this.ze = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.zk.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.eRm != null) {
                    a.this.eRm.a(0, "", a.this.zk, a.this.ze, a.this.eRq);
                    com.baidu.tieba.recapp.d.a.bpy().nP(String.valueOf(a.this.zk.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bpy().nO(String.valueOf(a.this.zk.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bpy().cR(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void hF() {
        if (this.eRo != null && this.eRo.isStarted()) {
            try {
                this.eRo.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
