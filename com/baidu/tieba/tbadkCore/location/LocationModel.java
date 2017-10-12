package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
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
    private HttpMessageListener byo;
    private a giR;
    private b giS;
    private BdBaseActivity giT;
    private com.baidu.adp.framework.listener.c giU;
    private a.InterfaceC0004a giV;
    private CustomMessageListener giW;

    /* loaded from: classes.dex */
    public interface a {
        void Dq();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fR(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Dr();

        void fS(String str);
    }

    private void Vb() {
        this.byo = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.giR != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.giR.fR(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bsf();
            }
        };
    }

    public void bsf() {
        if (bsh()) {
            if (this.giR != null) {
                this.giR.a(c.bsd().getLocationData());
            }
        } else if (j.hh()) {
            if (ab.aI(this.giT.getActivity())) {
                com.baidu.adp.lib.d.a.fc().a(true, this.giV);
            }
        } else if (this.giR != null) {
            this.giR.Dq();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.giU = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.giR != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.giR.fR(str);
                }
            }
        };
        this.giV = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cf(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.giR != null) {
                    LocationModel.this.giR.fR(str);
                }
            }
        };
        this.giW = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mE(false);
                        LocationModel.this.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.giS != null) {
                            LocationModel.this.giS.fS(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mE(true);
                    if (LocationModel.this.giS != null) {
                        LocationModel.this.giS.Dr();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.giT = baseActivity;
        registerListener(this.giU);
        registerListener(this.giW);
    }

    public void cf(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.giR != null) {
                this.giR.fR(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bsd().cB(System.currentTimeMillis());
        c.bsd().b(aVar);
        if (this.giR != null) {
            this.giR.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0128a> bsa;
        int i;
        int i2;
        if (aVar != null && (bsa = aVar.bsa()) != null && !bsa.isEmpty()) {
            int size = bsa.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bsa.get(i3) != null) {
                    str = bsa.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bsa.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.brZ())) {
                if (bsa.size() >= 1) {
                    aVar.rQ(bsa.get(0).getName());
                    aVar.rR(bsa.get(0).bsb());
                    return;
                }
                return;
            }
            for (a.C0128a c0128a : bsa) {
                if (aVar.brZ().equals(c0128a.getName())) {
                    aVar.rR(c0128a.bsb());
                    return;
                }
            }
        }
    }

    public boolean bsg() {
        return System.currentTimeMillis() - c.bsd().bmK() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bsh() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsd().getLocationData();
        return (bsg() || locationData == null || StringUtils.isNull(locationData.brZ())) ? false : true;
    }

    public void mE(boolean z) {
        c.bsd().mD(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bsd().bse());
    }

    public void cg(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsd().getLocationData();
        if (locationData != null) {
            locationData.rQ(str);
            locationData.rR(str2);
        }
    }

    public static void bsi() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean UW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.giT.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bsd().bse()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void Va() {
        if (this.byo == null) {
            Vb();
            registerListener(this.byo);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.giR = aVar;
    }

    public void a(b bVar) {
        this.giS = bVar;
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
