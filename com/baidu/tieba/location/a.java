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
    private static a fkf = null;
    private Address Cj;
    private C0228a fki;
    private LocationClient fkj;
    private LocationClientOption fkk;
    private Context mContext;
    private boolean mIsOpen = true;
    private String fkg = "";
    private a.b fkh = null;
    private long Cd = 0;
    private boolean fkl = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001330) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.f.a.uf() || ab.bA(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.d.a.iX().a(a.aYi());
                        } else {
                            com.baidu.adp.lib.d.a.iX().b(a.aYi());
                        }
                    }
                }
            }
        });
    }

    public static a aYi() {
        if (fkf == null) {
            synchronized (a.class) {
                if (fkf == null) {
                    fkf = new a();
                }
            }
        }
        return fkf;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.d.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.fkh = bVar;
        this.fkg = "baidu";
        if (this.mIsOpen) {
            try {
                this.fkj = new LocationClient(this.mContext);
                this.fkk = new LocationClientOption();
                this.fkk.setOpenGps(true);
                this.fkk.setIgnoreKillProcess(true);
                this.fkk.setProdName(this.fkg);
                this.fkk.setAddrType("all");
                this.fkk.setCoorType("bd09ll");
                this.fki = new C0228a();
                this.fkj.registerLocationListener(this.fki);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void T(boolean z) {
        if ((!com.baidu.f.a.uf() || ab.bA(TbadkCoreApplication.getInst())) && this.mIsOpen && this.fkj != null) {
            try {
                this.fkl = z;
                if (z) {
                    this.fkk.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.fkj.setLocOption(this.fkk);
                if (!this.fkj.isStarted()) {
                    this.fkj.start();
                }
                this.fkj.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                ja();
                if (this.fkh != null) {
                    this.fkh.a(5, "", this.Cj, this.Cd, this.fkl);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void destroy() {
        ja();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0228a implements BDLocationListener {
        private C0228a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.f.a.uf() || ab.bA(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.ja();
                a.this.Cj = new Address(Locale.getDefault());
                a.this.Cj.setLatitude(bDLocation.getLatitude());
                a.this.Cj.setLongitude(bDLocation.getLongitude());
                a.this.Cj.setLocality(bDLocation.getCity());
                Bundle bundle = new Bundle();
                bundle.putFloat("radius", bDLocation.getRadius());
                bundle.putDouble("altitude", bDLocation.getAltitude());
                bundle.putFloat("speed", bDLocation.getSpeed());
                bundle.putString("cityCode", bDLocation.getCityCode());
                bundle.putString("street", bDLocation.getStreet());
                bundle.putString("streetNumber", bDLocation.getStreetNumber());
                bundle.putString("province", bDLocation.getProvince());
                a.this.Cj.setExtras(bundle);
                a.this.Cd = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                    stringBuffer.append(bDLocation.getCity());
                }
                stringBuffer.append(bDLocation.getDistrict());
                stringBuffer.append(bDLocation.getStreet());
                if (bDLocation.getAddrStr() != null) {
                    a.this.Cj.setAddressLine(0, stringBuffer.toString());
                }
                if (a.this.fkh != null) {
                    a.this.fkh.a(0, "", a.this.Cj, a.this.Cd, a.this.fkl);
                    com.baidu.tieba.recapp.d.a.bua().pc(String.valueOf(a.this.Cj.getLatitude()));
                    com.baidu.tieba.recapp.d.a.bua().pb(String.valueOf(a.this.Cj.getLongitude()));
                    com.baidu.tieba.recapp.d.a.bua().cZ(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.d.b
    public void ja() {
        if (this.fkj != null && this.fkj.isStarted()) {
            try {
                this.fkj.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
