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
    private HttpMessageListener bLd;
    private a gDW;
    private b gDX;
    private BdBaseActivity gDY;
    private com.baidu.adp.framework.listener.c gDZ;
    private a.InterfaceC0004a gEa;
    private CustomMessageListener gEb;

    /* loaded from: classes.dex */
    public interface a {
        void DT();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void ga(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DU();

        void gb(String str);
    }

    private void YO() {
        this.bLd = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gDW != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gDW.ga(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bxF();
            }
        };
    }

    public void bxF() {
        if (bxH()) {
            if (this.gDW != null) {
                this.gDW.a(c.bxD().getLocationData());
            }
        } else if (j.hh()) {
            if (ab.aG(this.gDY.getActivity())) {
                com.baidu.adp.lib.d.a.fc().a(true, this.gEa);
            }
        } else if (this.gDW != null) {
            this.gDW.DT();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gDZ = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gDW != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gDW.ga(str);
                }
            }
        };
        this.gEa = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ch(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gDW != null) {
                    LocationModel.this.gDW.ga(str);
                }
            }
        };
        this.gEb = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.ng(false);
                        LocationModel.this.ci(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gDX != null) {
                            LocationModel.this.gDX.gb(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.ng(true);
                    if (LocationModel.this.gDX != null) {
                        LocationModel.this.gDX.DU();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gDY = baseActivity;
        registerListener(this.gDZ);
        registerListener(this.gEb);
    }

    public void ch(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gDW != null) {
                this.gDW.ga(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bxD().cN(System.currentTimeMillis());
        c.bxD().b(aVar);
        if (this.gDW != null) {
            this.gDW.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0145a> bxA;
        int i;
        int i2;
        if (aVar != null && (bxA = aVar.bxA()) != null && !bxA.isEmpty()) {
            int size = bxA.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bxA.get(i3) != null) {
                    str = bxA.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bxA.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bxz())) {
                if (bxA.size() >= 1) {
                    aVar.tf(bxA.get(0).getName());
                    aVar.tg(bxA.get(0).bxB());
                    return;
                }
                return;
            }
            for (a.C0145a c0145a : bxA) {
                if (aVar.bxz().equals(c0145a.getName())) {
                    aVar.tg(c0145a.bxB());
                    return;
                }
            }
        }
    }

    public boolean bxG() {
        return System.currentTimeMillis() - c.bxD().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bxH() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxD().getLocationData();
        return (bxG() || locationData == null || StringUtils.isNull(locationData.bxz())) ? false : true;
    }

    public void ng(boolean z) {
        c.bxD().nf(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bxD().bxE());
    }

    public void ci(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxD().getLocationData();
        if (locationData != null) {
            locationData.tf(str);
            locationData.tg(str2);
        }
    }

    public static void bxI() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean YJ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gDY.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bxD().bxE()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void YN() {
        if (this.bLd == null) {
            YO();
            registerListener(this.bLd);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gDW = aVar;
    }

    public void a(b bVar) {
        this.gDX = bVar;
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
