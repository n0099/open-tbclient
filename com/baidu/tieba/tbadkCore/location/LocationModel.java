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
    private HttpMessageListener cAN;
    private a hrP;
    private b hrQ;
    private BdBaseActivity hrR;
    private com.baidu.adp.framework.listener.c hrS;
    private a.InterfaceC0017a hrT;
    private CustomMessageListener hrU;

    /* loaded from: classes.dex */
    public interface a {
        void Nf();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void dk(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Ng();

        void ii(String str);
    }

    private void amQ() {
        this.cAN = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.hrP != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.hrP.dk(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bFz();
            }
        };
    }

    public void bFz() {
        if (bFB()) {
            if (this.hrP != null) {
                this.hrP.a(c.bFx().getLocationData());
            }
        } else if (j.kV()) {
            if (ab.bC(this.hrR.getActivity())) {
                com.baidu.adp.lib.d.a.iW().a(true, this.hrT);
            }
        } else if (this.hrP != null) {
            this.hrP.Nf();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hrS = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.hrP != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.hrP.dk(str);
                }
            }
        };
        this.hrT = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cP(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.hrP != null) {
                    LocationModel.this.hrP.dk(str);
                }
            }
        };
        this.hrU = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.nB(false);
                        LocationModel.this.cQ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.hrQ != null) {
                            LocationModel.this.hrQ.ii(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.nB(true);
                    if (LocationModel.this.hrQ != null) {
                        LocationModel.this.hrQ.Ng();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.hrR = baseActivity;
        registerListener(this.hrS);
        registerListener(this.hrU);
    }

    public void cP(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.hrP != null) {
                this.hrP.dk(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bFx().dj(System.currentTimeMillis());
        c.bFx().b(aVar);
        if (this.hrP != null) {
            this.hrP.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0317a> bFv;
        int i;
        int i2;
        if (aVar != null && (bFv = aVar.bFv()) != null && !bFv.isEmpty()) {
            int size = bFv.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bFv.get(i3) != null) {
                    str = bFv.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bFv.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bFu())) {
                if (bFv.size() >= 1) {
                    aVar.wa(bFv.get(0).getName());
                    aVar.wb(bFv.get(0).bFw());
                    return;
                }
                return;
            }
            for (a.C0317a c0317a : bFv) {
                if (aVar.bFu().equals(c0317a.getName())) {
                    aVar.wb(c0317a.bFw());
                    return;
                }
            }
        }
    }

    public boolean bFA() {
        return System.currentTimeMillis() - c.bFx().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bFB() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bFx().getLocationData();
        return (bFA() || locationData == null || StringUtils.isNull(locationData.bFu())) ? false : true;
    }

    public void nB(boolean z) {
        c.bFx().nA(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bFx().bFy());
    }

    public void cQ(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bFx().getLocationData();
        if (locationData != null) {
            locationData.wa(str);
            locationData.wb(str2);
        }
    }

    public static void bFC() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean amL() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.hrR.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bFx().bFy()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void amP() {
        if (this.cAN == null) {
            amQ();
            registerListener(this.cAN);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.hrP = aVar;
    }

    public void a(b bVar) {
        this.hrQ = bVar;
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
