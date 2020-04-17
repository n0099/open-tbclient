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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import java.util.Locale;
/* loaded from: classes10.dex */
public class a implements com.baidu.adp.lib.c.b {
    private static a iPJ = null;
    private LocationClient cUs;
    private C0592a iPM;
    private LocationClientOption iPN;
    private Address lastAddress;
    private Context mContext;
    private boolean Or = true;
    private String iPK = "";
    private a.b iPL = null;
    private long lastLocationTime = 0;
    private boolean iPO = false;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BAIDU_LOCATION_SWITCH) { // from class: com.baidu.tieba.location.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001330) {
                    if ((!com.baidu.h.a.KP() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            com.baidu.adp.lib.c.a.ko().a(a.coK());
                        } else {
                            com.baidu.adp.lib.c.a.ko().b(a.coK());
                        }
                    }
                }
            }
        });
    }

    public static a coK() {
        if (iPJ == null) {
            synchronized (a.class) {
                if (iPJ == null) {
                    iPJ = new a();
                }
            }
        }
        return iPJ;
    }

    private a() {
    }

    @Override // com.baidu.adp.lib.c.b
    public void a(a.b bVar) {
        this.mContext = TbadkCoreApplication.getInst().getContext();
        this.iPL = bVar;
        this.iPK = "baidu";
        if (this.Or) {
            try {
                this.cUs = new LocationClient(this.mContext);
                this.iPN = new LocationClientOption();
                this.iPN.setOpenGps(true);
                this.iPN.setIgnoreKillProcess(true);
                this.iPN.setProdName(this.iPK);
                this.iPN.setAddrType(SchemeCollecter.CLASSIFY_ALL);
                this.iPN.setCoorType("bd09ll");
                this.iPM = new C0592a();
                this.cUs.registerLocationListener(this.iPM);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void startLocation(boolean z) {
        if ((!com.baidu.h.a.KP() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.Or && this.cUs != null) {
            try {
                this.iPO = z;
                if (z) {
                    this.iPN.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.cUs.setLocOption(this.iPN);
                if (!this.cUs.isStarted()) {
                    this.cUs.start();
                }
                this.cUs.requestLocation();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                stopLocation();
                if (this.iPL != null) {
                    this.iPL.onProviderGetLocation(5, "", this.lastAddress, this.lastLocationTime, this.iPO);
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void destroy() {
        stopLocation();
    }

    /* renamed from: com.baidu.tieba.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0592a implements BDLocationListener {
        private C0592a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((!com.baidu.h.a.KP() || ab.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && bDLocation != null && bDLocation.getLocType() != 62 && bDLocation.getLocType() != 63 && bDLocation.getLocType() != 67 && bDLocation.getLocType() != 68 && bDLocation.getLocType() <= 161) {
                a.this.stopLocation();
                a.this.lastAddress = new Address(Locale.getDefault());
                a.this.lastAddress.setLatitude(bDLocation.getLatitude());
                a.this.lastAddress.setLongitude(bDLocation.getLongitude());
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
                if (a.this.iPL != null) {
                    a.this.iPL.onProviderGetLocation(0, "", a.this.lastAddress, a.this.lastLocationTime, a.this.iPO);
                    com.baidu.tieba.recapp.d.a.cOb().En(String.valueOf(a.this.lastAddress.getLatitude()));
                    com.baidu.tieba.recapp.d.a.cOb().Em(String.valueOf(a.this.lastAddress.getLongitude()));
                    com.baidu.tieba.recapp.d.a.cOb().fm(System.currentTimeMillis());
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.c.b
    public void stopLocation() {
        if (this.cUs != null && this.cUs.isStarted()) {
            try {
                this.cUs.stop();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
