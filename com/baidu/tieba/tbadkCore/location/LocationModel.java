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
    private a giS;
    private b giT;
    private BdBaseActivity giU;
    private com.baidu.adp.framework.listener.c giV;
    private a.InterfaceC0004a giW;
    private CustomMessageListener giX;

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
                    if (LocationModel.this.giS != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.giS.fR(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bsg();
            }
        };
    }

    public void bsg() {
        if (bsi()) {
            if (this.giS != null) {
                this.giS.a(c.bse().getLocationData());
            }
        } else if (j.hh()) {
            if (ab.aI(this.giU.getActivity())) {
                com.baidu.adp.lib.d.a.fc().a(true, this.giW);
            }
        } else if (this.giS != null) {
            this.giS.Dq();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.giV = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.giS != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.giS.fR(str);
                }
            }
        };
        this.giW = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cf(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.giS != null) {
                    LocationModel.this.giS.fR(str);
                }
            }
        };
        this.giX = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mE(false);
                        LocationModel.this.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.giT != null) {
                            LocationModel.this.giT.fS(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mE(true);
                    if (LocationModel.this.giT != null) {
                        LocationModel.this.giT.Dr();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.giU = baseActivity;
        registerListener(this.giV);
        registerListener(this.giX);
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
            if (this.giS != null) {
                this.giS.fR(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bse().cB(System.currentTimeMillis());
        c.bse().b(aVar);
        if (this.giS != null) {
            this.giS.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0128a> bsb;
        int i;
        int i2;
        if (aVar != null && (bsb = aVar.bsb()) != null && !bsb.isEmpty()) {
            int size = bsb.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bsb.get(i3) != null) {
                    str = bsb.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bsb.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bsa())) {
                if (bsb.size() >= 1) {
                    aVar.rQ(bsb.get(0).getName());
                    aVar.rR(bsb.get(0).bsc());
                    return;
                }
                return;
            }
            for (a.C0128a c0128a : bsb) {
                if (aVar.bsa().equals(c0128a.getName())) {
                    aVar.rR(c0128a.bsc());
                    return;
                }
            }
        }
    }

    public boolean bsh() {
        return System.currentTimeMillis() - c.bse().bmL() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bsi() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bse().getLocationData();
        return (bsh() || locationData == null || StringUtils.isNull(locationData.bsa())) ? false : true;
    }

    public void mE(boolean z) {
        c.bse().mD(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bse().bsf());
    }

    public void cg(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bse().getLocationData();
        if (locationData != null) {
            locationData.rQ(str);
            locationData.rR(str2);
        }
    }

    public static void bsj() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean UW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.giU.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bse().bsf()) {
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
        this.giS = aVar;
    }

    public void a(b bVar) {
        this.giT = bVar;
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
