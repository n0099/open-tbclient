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
    private HttpMessageListener cAi;
    private a haK;
    private b haL;
    private BdBaseActivity haM;
    private com.baidu.adp.framework.listener.c haN;
    private a.InterfaceC0017a haO;
    private CustomMessageListener haP;

    /* loaded from: classes.dex */
    public interface a {
        void Ll();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gp(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Lm();

        void gq(String str);
    }

    private void agn() {
        this.cAi = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.haK != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.haK.gp(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bwt();
            }
        };
    }

    public void bwt() {
        if (bwv()) {
            if (this.haK != null) {
                this.haK.a(c.bwr().getLocationData());
            }
        } else if (j.oJ()) {
            if (ab.aS(this.haM.getActivity())) {
                com.baidu.adp.lib.d.a.mG().a(true, this.haO);
            }
        } else if (this.haK != null) {
            this.haK.Ll();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.haN = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.haK != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.haK.gp(str);
                }
            }
        };
        this.haO = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cd(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.haK != null) {
                    LocationModel.this.haK.gp(str);
                }
            }
        };
        this.haP = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mE(false);
                        LocationModel.this.ce(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.haL != null) {
                            LocationModel.this.haL.gq(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mE(true);
                    if (LocationModel.this.haL != null) {
                        LocationModel.this.haL.Lm();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.haM = baseActivity;
        registerListener(this.haN);
        registerListener(this.haP);
    }

    public void cd(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.haK != null) {
                this.haK.gp(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bwr().cQ(System.currentTimeMillis());
        c.bwr().b(aVar);
        if (this.haK != null) {
            this.haK.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0157a> bwo;
        int i;
        int i2;
        if (aVar != null && (bwo = aVar.bwo()) != null && !bwo.isEmpty()) {
            int size = bwo.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bwo.get(i3) != null) {
                    str = bwo.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bwo.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bwn())) {
                if (bwo.size() >= 1) {
                    aVar.sF(bwo.get(0).getName());
                    aVar.sG(bwo.get(0).bwp());
                    return;
                }
                return;
            }
            for (a.C0157a c0157a : bwo) {
                if (aVar.bwn().equals(c0157a.getName())) {
                    aVar.sG(c0157a.bwp());
                    return;
                }
            }
        }
    }

    public boolean bwu() {
        return System.currentTimeMillis() - c.bwr().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bwv() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwr().getLocationData();
        return (bwu() || locationData == null || StringUtils.isNull(locationData.bwn())) ? false : true;
    }

    public void mE(boolean z) {
        c.bwr().mD(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bwr().bws());
    }

    public void ce(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bwr().getLocationData();
        if (locationData != null) {
            locationData.sF(str);
            locationData.sG(str2);
        }
    }

    public static void bww() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean agi() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.haM.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bwr().bws()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void agm() {
        if (this.cAi == null) {
            agn();
            registerListener(this.cAi);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.haK = aVar;
    }

    public void a(b bVar) {
        this.haL = bVar;
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
