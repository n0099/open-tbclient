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
    private HttpMessageListener bCZ;
    private a gsr;
    private b gss;
    private BdBaseActivity gst;
    private com.baidu.adp.framework.listener.c gsu;
    private a.InterfaceC0004a gsv;
    private CustomMessageListener gsw;

    /* loaded from: classes.dex */
    public interface a {
        void DL();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fY(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DM();

        void fZ(String str);
    }

    private void Xa() {
        this.bCZ = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.gsr != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.gsr.fY(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bvo();
            }
        };
    }

    public void bvo() {
        if (bvq()) {
            if (this.gsr != null) {
                this.gsr.a(c.bvm().getLocationData());
            }
        } else if (j.hh()) {
            if (ab.aH(this.gst.getActivity())) {
                com.baidu.adp.lib.d.a.fc().a(true, this.gsv);
            }
        } else if (this.gsr != null) {
            this.gsr.DL();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.gsu = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.gsr != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.gsr.fY(str);
                }
            }
        };
        this.gsv = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cf(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.gsr != null) {
                    LocationModel.this.gsr.fY(str);
                }
            }
        };
        this.gsw = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mH(false);
                        LocationModel.this.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.gss != null) {
                            LocationModel.this.gss.fZ(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mH(true);
                    if (LocationModel.this.gss != null) {
                        LocationModel.this.gss.DM();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.gst = baseActivity;
        registerListener(this.gsu);
        registerListener(this.gsw);
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
            if (this.gsr != null) {
                this.gsr.fY(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bvm().cF(System.currentTimeMillis());
        c.bvm().b(aVar);
        if (this.gsr != null) {
            this.gsr.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0131a> bvj;
        int i;
        int i2;
        if (aVar != null && (bvj = aVar.bvj()) != null && !bvj.isEmpty()) {
            int size = bvj.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bvj.get(i3) != null) {
                    str = bvj.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bvj.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bvi())) {
                if (bvj.size() >= 1) {
                    aVar.sD(bvj.get(0).getName());
                    aVar.sE(bvj.get(0).bvk());
                    return;
                }
                return;
            }
            for (a.C0131a c0131a : bvj) {
                if (aVar.bvi().equals(c0131a.getName())) {
                    aVar.sE(c0131a.bvk());
                    return;
                }
            }
        }
    }

    public boolean bvp() {
        return System.currentTimeMillis() - c.bvm().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bvq() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bvm().getLocationData();
        return (bvp() || locationData == null || StringUtils.isNull(locationData.bvi())) ? false : true;
    }

    public void mH(boolean z) {
        c.bvm().mG(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bvm().bvn());
    }

    public void cg(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bvm().getLocationData();
        if (locationData != null) {
            locationData.sD(str);
            locationData.sE(str2);
        }
    }

    public static void bvr() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean WV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.gst.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bvm().bvn()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void WZ() {
        if (this.bCZ == null) {
            Xa();
            registerListener(this.bCZ);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gsr = aVar;
    }

    public void a(b bVar) {
        this.gss = bVar;
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
