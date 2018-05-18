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
    private static a eBZ = null;
    private C0175a eCc;
    private LocationClient eCd;
    private LocationClientOption eCe;
    private Context mContext;
    private Address td;
    private boolean yx = true;
    private String eCa = "";
    private a.b eCb = null;
    private long sW = 0;
    private boolean eCf = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.d.a.om() || ab.aB(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.eK().a(a.aMf());
                        } else {
                            com.baidu.adp.lib.d.a.eK().b(a.aMf());
                        }
                    }
                }
            }
        });
    }

    public static a aMf() {
        if (eBZ == null) {
            synchronized (a.class) {
                if (eBZ == null) {
                    eBZ = new a();
                }
            }
        }
        return eBZ;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.eCb = bVar;
        this.eCa = "baidu";
        if (this.yx) {
            try {
                this.eCd = new LocationClient(this.mContext);
                this.eCe = new LocationClientOption();
                this.eCe.setOpenGps(true);
                this.eCe.setIgnoreKillProcess(true);
                this.eCe.setProdName(this.eCa);
                this.eCe.setAddrType("all");
                this.eCe.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
                this.eCc = new C0175a();
                this.eCd.registerLocationListener(this.eCc);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void I(boolean z) {
        if ((!com.baidu.d.a.om() || ab.aB(TbadkCoreApplication.getInst())) && this.yx && this.eCd != null) {
            try {
                this.eCf = z;
                if (z) {
                    this.eCe.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.eCd.setLocOption(this.eCe);
                if (!this.eCd.isStarted()) {
                    this.eCd.start();
                }
                this.eCd.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                eO();
                if (this.eCb != null) {
                    this.eCb.a(5, "", this.td, this.sW, this.eCf);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        eO();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0175a implements BDLocationListener {
        private C0175a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.d.a.om() || ab.aB(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.eO();
                a.this.td = new Address(Locale.getDefault());
                a.this.td.setLatitude(bDLocation.getLatitude());
                a.this.td.setLongitude(bDLocation.getLongitude());
                a.this.td.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                a.this.td.setExtras(bundle);
                a.this.sW = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.td.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.eCb != null) {
                    a.this.eCb.a(0, "", a.this.td, a.this.sW, a.this.eCf);
                    com.baidu.tieba.recapp.d.a.bjY().nc(String.valueOf(a.this.td.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bjY().nb(String.valueOf(a.this.td.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bjY().cQ(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void eO() {
        if (this.eCd != null && this.eCd.isStarted()) {
            try {
                this.eCd.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
