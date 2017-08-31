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
    private HttpMessageListener bvR;
    private a gko;
    private b gkp;
    private BdBaseActivity gkq;
    private com.baidu.adp.framework.listener.c gkr;
    private a.InterfaceC0004a gks;
    private CustomMessageListener gkt;

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

    private void Ux() {
        this.bvR = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gko != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gko.fY(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bsW();
            }
        };
    }

    public void bsW() {
        if (bsY()) {
            if (this.gko != null) {
                this.gko.a(c.bsU().getLocationData());
            }
        } else if (i.hi()) {
            if (ab.aH(this.gkq.getActivity())) {
                com.baidu.adp.lib.d.a.fd().a(true, this.gks);
            }
        } else if (this.gko != null) {
            this.gko.DM();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gkr = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gko != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gko.fY(str);
                }
            }
        };
        this.gks = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ck(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gko != null) {
                    LocationModel.this.gko.fY(str);
                }
            }
        };
        this.gkt = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mJ(false);
                        LocationModel.this.cl(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gkp != null) {
                            LocationModel.this.gkp.fZ(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mJ(true);
                    if (LocationModel.this.gkp != null) {
                        LocationModel.this.gkp.DN();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gkq = baseActivity;
        registerListener(this.gkr);
        registerListener(this.gkt);
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
            if (this.gko != null) {
                this.gko.fY(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bsU().cD(System.currentTimeMillis());
        c.bsU().b(aVar);
        if (this.gko != null) {
            this.gko.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0126a> bsR;
        int i;
        int i2;
        if (aVar != null && (bsR = aVar.bsR()) != null && !bsR.isEmpty()) {
            int size = bsR.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bsR.get(i3) != null) {
                    str = bsR.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bsR.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bsQ())) {
                if (bsR.size() >= 1) {
                    aVar.se(bsR.get(0).getName());
                    aVar.sf(bsR.get(0).bsS());
                    return;
                }
                return;
            }
            for (a.C0126a c0126a : bsR) {
                if (aVar.bsQ().equals(c0126a.getName())) {
                    aVar.sf(c0126a.bsS());
                    return;
                }
            }
        }
    }

    public boolean bsX() {
        return System.currentTimeMillis() - c.bsU().bnG() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bsY() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsU().getLocationData();
        return (bsX() || locationData == null || StringUtils.isNull(locationData.bsQ())) ? false : true;
    }

    public void mJ(boolean z) {
        c.bsU().mI(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bsU().bsV());
    }

    public void cl(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsU().getLocationData();
        if (locationData != null) {
            locationData.se(str);
            locationData.sf(str2);
        }
    }

    public static void bsZ() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean Us() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gkq.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bsU().bsV()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void Uw() {
        if (this.bvR == null) {
            Ux();
            registerListener(this.bvR);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gko = aVar;
    }

    public void a(b bVar) {
        this.gkp = bVar;
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
