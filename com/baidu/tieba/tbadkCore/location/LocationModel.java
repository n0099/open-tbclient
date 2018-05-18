package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import android.net.http.Headers;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener bUJ;
    private a gzD;
    private b gzE;
    private BdBaseActivity gzF;
    private com.baidu.adp.framework.listener.c gzG;
    private a.InterfaceC0006a gzH;
    private CustomMessageListener gzI;

    /* loaded from: classes.dex */
    public interface a {
        void Es();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gq(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Et();

        void gr(String str);
    }

    private void abv() {
        this.bUJ = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gzD != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gzD.gq(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bsE();
            }
        };
    }

    public void bsE() {
        if (bsG()) {
            if (this.gzD != null) {
                this.gzD.a(c.bsC().getLocationData());
            }
        } else if (j.gP()) {
            if (ab.aB(this.gzF.getActivity())) {
                com.baidu.adp.lib.d.a.eK().a(true, this.gzH);
            }
        } else if (this.gzD != null) {
            this.gzD.Es();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gzG = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gzD != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gzD.gq(str);
                }
            }
        };
        this.gzH = new a.InterfaceC0006a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0006a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ce(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gzD != null) {
                    LocationModel.this.gzD.gq(str);
                }
            }
        };
        this.gzI = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mu(false);
                        LocationModel.this.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gzE != null) {
                            LocationModel.this.gzE.gr(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mu(true);
                    if (LocationModel.this.gzE != null) {
                        LocationModel.this.gzE.Et();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gzF = baseActivity;
        registerListener(this.gzG);
        registerListener(this.gzI);
    }

    public void ce(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gzD != null) {
                this.gzD.gq(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bsC().cT(System.currentTimeMillis());
        c.bsC().b(aVar);
        if (this.gzD != null) {
            this.gzD.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0219a> bsz;
        int i;
        int i2;
        if (aVar != null && (bsz = aVar.bsz()) != null && !bsz.isEmpty()) {
            int size = bsz.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bsz.get(i3) != null) {
                    str = bsz.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bsz.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bsy())) {
                if (bsz.size() >= 1) {
                    aVar.sX(bsz.get(0).getName());
                    aVar.sY(bsz.get(0).bsA());
                    return;
                }
                return;
            }
            for (a.C0219a c0219a : bsz) {
                if (aVar.bsy().equals(c0219a.getName())) {
                    aVar.sY(c0219a.bsA());
                    return;
                }
            }
        }
    }

    public boolean bsF() {
        return System.currentTimeMillis() - c.bsC().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bsG() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsC().getLocationData();
        return (bsF() || locationData == null || StringUtils.isNull(locationData.bsy())) ? false : true;
    }

    public void mu(boolean z) {
        c.bsC().mt(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bsC().bsD());
    }

    public void cf(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsC().getLocationData();
        if (locationData != null) {
            locationData.sX(str);
            locationData.sY(str2);
        }
    }

    public static void bsH() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean abq() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gzF.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bsC().bsD()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void abu() {
        if (this.bUJ == null) {
            abv();
            registerListener(this.bUJ);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gzD = aVar;
    }

    public void a(b bVar) {
        this.gzE = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
