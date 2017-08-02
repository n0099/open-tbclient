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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener bth;
    private a giJ;
    private b giK;
    private BdBaseActivity giL;
    private com.baidu.adp.framework.listener.c giM;
    private a.InterfaceC0005a giN;
    private CustomMessageListener giO;

    /* loaded from: classes.dex */
    public interface a {
        void DJ();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fU(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DK();

        void fV(String str);
    }

    private void Tm() {
        this.bth = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.giJ != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.giJ.fU(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bsZ();
            }
        };
    }

    public void bsZ() {
        if (btb()) {
            if (this.giJ != null) {
                this.giJ.a(c.bsX().getLocationData());
            }
        } else if (i.hh()) {
            if (aa.aB(this.giL.getActivity())) {
                com.baidu.adp.lib.d.a.fd().a(true, this.giN);
            }
        } else if (this.giJ != null) {
            this.giJ.DJ();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.giM = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.giJ != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.giJ.fU(str);
                }
            }
        };
        this.giN = new a.InterfaceC0005a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0005a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ci(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.giJ != null) {
                    LocationModel.this.giJ.fU(str);
                }
            }
        };
        this.giO = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mA(false);
                        LocationModel.this.cj(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.giK != null) {
                            LocationModel.this.giK.fV(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mA(true);
                    if (LocationModel.this.giK != null) {
                        LocationModel.this.giK.DK();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.giL = baseActivity;
        registerListener(this.giM);
        registerListener(this.giO);
    }

    public void ci(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.giJ != null) {
                this.giJ.fU(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bsX().cI(System.currentTimeMillis());
        c.bsX().b(aVar);
        if (this.giJ != null) {
            this.giJ.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0123a> bsU;
        int i;
        int i2;
        if (aVar != null && (bsU = aVar.bsU()) != null && !bsU.isEmpty()) {
            int size = bsU.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bsU.get(i3) != null) {
                    str = bsU.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bsU.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bsT())) {
                if (bsU.size() >= 1) {
                    aVar.rX(bsU.get(0).getName());
                    aVar.rY(bsU.get(0).bsV());
                    return;
                }
                return;
            }
            for (a.C0123a c0123a : bsU) {
                if (aVar.bsT().equals(c0123a.getName())) {
                    aVar.rY(c0123a.bsV());
                    return;
                }
            }
        }
    }

    public boolean bta() {
        return System.currentTimeMillis() - c.bsX().bnJ() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean btb() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsX().getLocationData();
        return (bta() || locationData == null || StringUtils.isNull(locationData.bsT())) ? false : true;
    }

    public void mA(boolean z) {
        c.bsX().mz(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bsX().bsY());
    }

    public void cj(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsX().getLocationData();
        if (locationData != null) {
            locationData.rX(str);
            locationData.rY(str2);
        }
    }

    public static void btc() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean Th() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.giL.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bsX().bsY()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void Tl() {
        if (this.bth == null) {
            Tm();
            registerListener(this.bth);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.giJ = aVar;
    }

    public void a(b bVar) {
        this.giK = bVar;
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
