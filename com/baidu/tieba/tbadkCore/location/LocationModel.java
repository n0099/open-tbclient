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
    private HttpMessageListener byc;
    private a giD;
    private b giE;
    private BdBaseActivity giF;
    private com.baidu.adp.framework.listener.c giG;
    private a.InterfaceC0004a giH;
    private CustomMessageListener giI;

    /* loaded from: classes.dex */
    public interface a {
        void Dk();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fQ(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Dl();

        void fR(String str);
    }

    private void UX() {
        this.byc = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.giD != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.giD.fQ(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.brY();
            }
        };
    }

    public void brY() {
        if (bsa()) {
            if (this.giD != null) {
                this.giD.a(c.brW().getLocationData());
            }
        } else if (j.hh()) {
            if (ab.aH(this.giF.getActivity())) {
                com.baidu.adp.lib.d.a.fc().a(true, this.giH);
            }
        } else if (this.giD != null) {
            this.giD.Dk();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.giG = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.giD != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.giD.fQ(str);
                }
            }
        };
        this.giH = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ce(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.giD != null) {
                    LocationModel.this.giD.fQ(str);
                }
            }
        };
        this.giI = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mD(false);
                        LocationModel.this.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.giE != null) {
                            LocationModel.this.giE.fR(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mD(true);
                    if (LocationModel.this.giE != null) {
                        LocationModel.this.giE.Dl();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.giF = baseActivity;
        registerListener(this.giG);
        registerListener(this.giI);
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
            if (this.giD != null) {
                this.giD.fQ(null);
                return;
            }
            return;
        }
        d(aVar);
        c.brW().cC(System.currentTimeMillis());
        c.brW().b(aVar);
        if (this.giD != null) {
            this.giD.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0128a> brT;
        int i;
        int i2;
        if (aVar != null && (brT = aVar.brT()) != null && !brT.isEmpty()) {
            int size = brT.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (brT.get(i3) != null) {
                    str = brT.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    brT.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.brS())) {
                if (brT.size() >= 1) {
                    aVar.rP(brT.get(0).getName());
                    aVar.rQ(brT.get(0).brU());
                    return;
                }
                return;
            }
            for (a.C0128a c0128a : brT) {
                if (aVar.brS().equals(c0128a.getName())) {
                    aVar.rQ(c0128a.brU());
                    return;
                }
            }
        }
    }

    public boolean brZ() {
        return System.currentTimeMillis() - c.brW().bmD() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bsa() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.brW().getLocationData();
        return (brZ() || locationData == null || StringUtils.isNull(locationData.brS())) ? false : true;
    }

    public void mD(boolean z) {
        c.brW().mC(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.brW().brX());
    }

    public void cf(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.brW().getLocationData();
        if (locationData != null) {
            locationData.rP(str);
            locationData.rQ(str2);
        }
    }

    public static void bsb() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean US() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.giF.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.brW().brX()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void UW() {
        if (this.byc == null) {
            UX();
            registerListener(this.byc);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.giD = aVar;
    }

    public void a(b bVar) {
        this.giE = bVar;
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
