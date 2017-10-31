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
    private HttpMessageListener bCM;
    private a gro;
    private b grp;
    private BdBaseActivity grq;
    private com.baidu.adp.framework.listener.c grr;
    private a.InterfaceC0004a grs;
    private CustomMessageListener grt;

    /* loaded from: classes.dex */
    public interface a {
        void Dz();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fX(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DA();

        void fY(String str);
    }

    private void WP() {
        this.bCM = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gro != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gro.fX(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bvc();
            }
        };
    }

    public void bvc() {
        if (bve()) {
            if (this.gro != null) {
                this.gro.a(c.bva().getLocationData());
            }
        } else if (j.hh()) {
            if (ab.aH(this.grq.getActivity())) {
                com.baidu.adp.lib.d.a.fc().a(true, this.grs);
            }
        } else if (this.gro != null) {
            this.gro.Dz();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.grr = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gro != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gro.fX(str);
                }
            }
        };
        this.grs = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cb(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gro != null) {
                    LocationModel.this.gro.fX(str);
                }
            }
        };
        this.grt = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mz(false);
                        LocationModel.this.cc(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.grp != null) {
                            LocationModel.this.grp.fY(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mz(true);
                    if (LocationModel.this.grp != null) {
                        LocationModel.this.grp.DA();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.grq = baseActivity;
        registerListener(this.grr);
        registerListener(this.grt);
    }

    public void cb(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.gro != null) {
                this.gro.fX(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bva().cD(System.currentTimeMillis());
        c.bva().b(aVar);
        if (this.gro != null) {
            this.gro.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0128a> buX;
        int i;
        int i2;
        if (aVar != null && (buX = aVar.buX()) != null && !buX.isEmpty()) {
            int size = buX.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (buX.get(i3) != null) {
                    str = buX.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    buX.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.buW())) {
                if (buX.size() >= 1) {
                    aVar.sx(buX.get(0).getName());
                    aVar.sy(buX.get(0).buY());
                    return;
                }
                return;
            }
            for (a.C0128a c0128a : buX) {
                if (aVar.buW().equals(c0128a.getName())) {
                    aVar.sy(c0128a.buY());
                    return;
                }
            }
        }
    }

    public boolean bvd() {
        return System.currentTimeMillis() - c.bva().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bve() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bva().getLocationData();
        return (bvd() || locationData == null || StringUtils.isNull(locationData.buW())) ? false : true;
    }

    public void mz(boolean z) {
        c.bva().my(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bva().bvb());
    }

    public void cc(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bva().getLocationData();
        if (locationData != null) {
            locationData.sx(str);
            locationData.sy(str2);
        }
    }

    public static void bvf() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean WK() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.grq.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bva().bvb()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void WO() {
        if (this.bCM == null) {
            WP();
            registerListener(this.bCM);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gro = aVar;
    }

    public void a(b bVar) {
        this.grp = bVar;
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
