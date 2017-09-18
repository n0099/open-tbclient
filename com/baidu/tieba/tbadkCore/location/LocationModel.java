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
import com.baidu.adp.lib.util.i;
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
    private HttpMessageListener bwF;
    private a gli;
    private b glj;
    private BdBaseActivity glk;
    private com.baidu.adp.framework.listener.c gll;
    private a.InterfaceC0004a glm;
    private CustomMessageListener gln;

    /* loaded from: classes.dex */
    public interface a {
        void DM();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fY(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DN();

        void fZ(String str);
    }

    private void UH() {
        this.bwF = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gli != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gli.fY(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bth();
            }
        };
    }

    public void bth() {
        if (btj()) {
            if (this.gli != null) {
                this.gli.a(c.btf().getLocationData());
            }
        } else if (i.hi()) {
            if (ab.aI(this.glk.getActivity())) {
                com.baidu.adp.lib.d.a.fd().a(true, this.glm);
            }
        } else if (this.gli != null) {
            this.gli.DM();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gll = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gli != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gli.fY(str);
                }
            }
        };
        this.glm = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ck(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gli != null) {
                    LocationModel.this.gli.fY(str);
                }
            }
        };
        this.gln = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mK(false);
                        LocationModel.this.cl(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.glj != null) {
                            LocationModel.this.glj.fZ(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mK(true);
                    if (LocationModel.this.glj != null) {
                        LocationModel.this.glj.DN();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.glk = baseActivity;
        registerListener(this.gll);
        registerListener(this.gln);
    }

    public void ck(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gli != null) {
                this.gli.fY(null);
                return;
            }
            return;
        }
        d(aVar);
        c.btf().cD(System.currentTimeMillis());
        c.btf().b(aVar);
        if (this.gli != null) {
            this.gli.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0125a> btc;
        int i;
        int i2;
        if (aVar != null && (btc = aVar.btc()) != null && !btc.isEmpty()) {
            int size = btc.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (btc.get(i3) != null) {
                    str = btc.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    btc.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.btb())) {
                if (btc.size() >= 1) {
                    aVar.sg(btc.get(0).getName());
                    aVar.sh(btc.get(0).btd());
                    return;
                }
                return;
            }
            for (a.C0125a c0125a : btc) {
                if (aVar.btb().equals(c0125a.getName())) {
                    aVar.sh(c0125a.btd());
                    return;
                }
            }
        }
    }

    public boolean bti() {
        return System.currentTimeMillis() - c.btf().bnR() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean btj() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.btf().getLocationData();
        return (bti() || locationData == null || StringUtils.isNull(locationData.btb())) ? false : true;
    }

    public void mK(boolean z) {
        c.btf().mJ(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.btf().btg());
    }

    public void cl(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.btf().getLocationData();
        if (locationData != null) {
            locationData.sg(str);
            locationData.sh(str2);
        }
    }

    public static void btk() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean UC() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.glk.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.btf().btg()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void UG() {
        if (this.bwF == null) {
            UH();
            registerListener(this.bwF);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gli = aVar;
    }

    public void a(b bVar) {
        this.glj = bVar;
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
