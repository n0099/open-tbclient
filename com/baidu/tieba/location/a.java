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
    private static a hdn = null;
    private LocationClient bmJ;
    private C0351a hdq;
    private LocationClientOption hdr;
    private Context mContext;
    private Address zU;
    private boolean Fv = true;
    private String hdo = "";
    private a.b hdp = null;
    private long zO = 0;
    private boolean hds = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.e.a.ud() || ab.cv(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.hO().a(a.bIU());
                        } else {
                            com.baidu.adp.lib.d.a.hO().b(a.bIU());
                        }
                    }
                }
            }
        });
    }

    public static a bIU() {
        if (hdn == null) {
            synchronized (a.class) {
                if (hdn == null) {
                    hdn = new a();
                }
            }
        }
        return hdn;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.hdp = bVar;
        this.hdo = "baidu";
        if (this.Fv) {
            try {
                this.bmJ = new LocationClient(this.mContext);
                this.hdr = new LocationClientOption();
                this.hdr.setOpenGps(true);
                this.hdr.setIgnoreKillProcess(true);
                this.hdr.setProdName(this.hdo);
                this.hdr.setAddrType("all");
                this.hdr.setCoorType("bd09ll");
                this.hdq = new C0351a();
                this.bmJ.registerLocationListener(this.hdq);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void Z(boolean z) {
        if ((!com.baidu.e.a.ud() || ab.cv(TbadkCoreApplication.getInst())) && this.Fv && this.bmJ != null) {
            try {
                this.hds = z;
                if (z) {
                    this.hdr.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.bmJ.setLocOption(this.hdr);
                if (!this.bmJ.isStarted()) {
                    this.bmJ.start();
                }
                this.bmJ.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                hS();
                if (this.hdp != null) {
                    this.hdp.a(5, "", this.zU, this.zO, this.hds);
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
                a.this.zU = new Address(Locale.getDefault());
                a.this.zU.setLatitude(bDLocation.getLatitude());
                a.this.zU.setLongitude(bDLocation.getLongitude());
                a.this.zU.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.zU.setExtras(bundle);
                a.this.zO = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.zU.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.hdp != null) {
                    a.this.hdp.a(0, "", a.this.zU, a.this.zO, a.this.hds);
                    com.baidu.tieba.recapp.d.a.cfz().xQ(String.valueOf(a.this.zU.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cfz().xP(String.valueOf(a.this.zU.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cfz().ej(System.currentTimeMillis());
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
