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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener czX;
    private a haq;
    private b har;
    private BdBaseActivity has;
    private com.baidu.adp.framework.listener.c hat;
    private a.InterfaceC0017a hau;
    private CustomMessageListener hav;

    /* loaded from: classes.dex */
    public interface a {
        void Lj();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gi(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Lk();

        void gj(String str);
    }

    private void agk() {
        this.czX = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.haq != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.haq.gi(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bwr();
            }
        };
    }

    public void bwr() {
        if (bwt()) {
            if (this.haq != null) {
                this.haq.a(c.bwp().getLocationData());
            }
        } else if (j.oI()) {
            if (ab.aS(this.has.getActivity())) {
                com.baidu.adp.lib.d.a.mF().a(true, this.hau);
            }
        } else if (this.haq != null) {
            this.haq.Lj();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hat = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.haq != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.haq.gi(str);
                }
            }
        };
        this.hau = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ce(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.haq != null) {
                    LocationModel.this.haq.gi(str);
                }
            }
        };
        this.hav = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mC(false);
                        LocationModel.this.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.har != null) {
                            LocationModel.this.har.gj(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mC(true);
                    if (LocationModel.this.har != null) {
                        LocationModel.this.har.Lk();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.has = baseActivity;
        registerListener(this.hat);
        registerListener(this.hav);
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
            if (this.haq != null) {
                this.haq.gi(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bwp().cO(System.currentTimeMillis());
        c.bwp().b(aVar);
        if (this.haq != null) {
            this.haq.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0156a> bwm;
        int i;
        int i2;
        if (aVar != null && (bwm = aVar.bwm()) != null && !bwm.isEmpty()) {
            int size = bwm.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bwm.get(i3) != null) {
                    str = bwm.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bwm.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bwl())) {
                if (bwm.size() >= 1) {
                    aVar.sy(bwm.get(0).getName());
                    aVar.sz(bwm.get(0).bwn());
                    return;
                }
                return;
            }
            for (a.C0156a c0156a : bwm) {
                if (aVar.bwl().equals(c0156a.getName())) {
                    aVar.sz(c0156a.bwn());
                    return;
                }
            }
        }
    }

    public boolean bws() {
        return System.currentTimeMillis() - c.bwp().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bwt() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwp().getLocationData();
        return (bws() || locationData == null || StringUtils.isNull(locationData.bwl())) ? false : true;
    }

    public void mC(boolean z) {
        c.bwp().mB(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bwp().bwq());
    }

    public void cf(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwp().getLocationData();
        if (locationData != null) {
            locationData.sy(str);
            locationData.sz(str2);
        }
    }

    public static void bwu() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean agf() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.has.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bwp().bwq()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void agj() {
        if (this.czX == null) {
            agk();
            registerListener(this.czX);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.haq = aVar;
    }

    public void a(b bVar) {
        this.har = bVar;
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
