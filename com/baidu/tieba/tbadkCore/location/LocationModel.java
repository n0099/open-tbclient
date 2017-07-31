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
    private HttpMessageListener bus;
    private a gjU;
    private b gjV;
    private BdBaseActivity gjW;
    private com.baidu.adp.framework.listener.c gjX;
    private a.InterfaceC0005a gjY;
    private CustomMessageListener gjZ;

    /* loaded from: classes.dex */
    public interface a {
        void DR();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void ga(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DS();

        void gb(String str);
    }

    private void Tr() {
        this.bus = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gjU != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gjU.ga(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.btg();
            }
        };
    }

    public void btg() {
        if (bti()) {
            if (this.gjU != null) {
                this.gjU.a(c.bte().getLocationData());
            }
        } else if (i.hr()) {
            if (aa.aC(this.gjW.getActivity())) {
                com.baidu.adp.lib.d.a.fo().a(true, this.gjY);
            }
        } else if (this.gjU != null) {
            this.gjU.DR();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gjX = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gjU != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gjU.ga(str);
                }
            }
        };
        this.gjY = new a.InterfaceC0005a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0005a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ci(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gjU != null) {
                    LocationModel.this.gjU.ga(str);
                }
            }
        };
        this.gjZ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mA(false);
                        LocationModel.this.cj(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gjV != null) {
                            LocationModel.this.gjV.gb(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mA(true);
                    if (LocationModel.this.gjV != null) {
                        LocationModel.this.gjV.DS();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gjW = baseActivity;
        registerListener(this.gjX);
        registerListener(this.gjZ);
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
            if (this.gjU != null) {
                this.gjU.ga(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bte().cI(System.currentTimeMillis());
        c.bte().b(aVar);
        if (this.gjU != null) {
            this.gjU.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0122a> btb;
        int i;
        int i2;
        if (aVar != null && (btb = aVar.btb()) != null && !btb.isEmpty()) {
            int size = btb.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (btb.get(i3) != null) {
                    str = btb.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    btb.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bta())) {
                if (btb.size() >= 1) {
                    aVar.sc(btb.get(0).getName());
                    aVar.sd(btb.get(0).btc());
                    return;
                }
                return;
            }
            for (a.C0122a c0122a : btb) {
                if (aVar.bta().equals(c0122a.getName())) {
                    aVar.sd(c0122a.btc());
                    return;
                }
            }
        }
    }

    public boolean bth() {
        return System.currentTimeMillis() - c.bte().bnS() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bti() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bte().getLocationData();
        return (bth() || locationData == null || StringUtils.isNull(locationData.bta())) ? false : true;
    }

    public void mA(boolean z) {
        c.bte().mz(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bte().btf());
    }

    public void cj(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bte().getLocationData();
        if (locationData != null) {
            locationData.sc(str);
            locationData.sd(str2);
        }
    }

    public static void btj() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean Tm() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gjW.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bte().btf()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void Tq() {
        if (this.bus == null) {
            Tr();
            registerListener(this.bus);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gjU = aVar;
    }

    public void a(b bVar) {
        this.gjV = bVar;
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
