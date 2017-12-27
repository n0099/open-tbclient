package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import android.net.http.Headers;
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
    private HttpMessageListener czN;
    private a hkP;
    private b hkQ;
    private BdBaseActivity hkR;
    private com.baidu.adp.framework.listener.c hkS;
    private a.InterfaceC0017a hkT;
    private CustomMessageListener hkU;

    /* loaded from: classes.dex */
    public interface a {
        void Lu();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void gh(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Lv();

        void gi(String str);
    }

    private void agw() {
        this.czN = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.hkP != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.hkP.gh(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.bCV();
            }
        };
    }

    public void bCV() {
        if (bCX()) {
            if (this.hkP != null) {
                this.hkP.a(c.bCT().getLocationData());
            }
        } else if (j.oI()) {
            if (ab.aS(this.hkR.getActivity())) {
                com.baidu.adp.lib.d.a.mF().a(true, this.hkT);
            }
        } else if (this.hkP != null) {
            this.hkP.Lu();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.hkS = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.hkP != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.hkP.gh(str);
                }
            }
        };
        this.hkT = new a.InterfaceC0017a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0017a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.ci(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.hkP != null) {
                    LocationModel.this.hkP.gh(str);
                }
            }
        };
        this.hkU = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.nA(false);
                        LocationModel.this.cj(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.hkQ != null) {
                            LocationModel.this.hkQ.gi(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.nA(true);
                    if (LocationModel.this.hkQ != null) {
                        LocationModel.this.hkQ.Lv();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.hkR = baseActivity;
        registerListener(this.hkS);
        registerListener(this.hkU);
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
            if (this.hkP != null) {
                this.hkP.gh(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bCT().cW(System.currentTimeMillis());
        c.bCT().b(aVar);
        if (this.hkP != null) {
            this.hkP.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0157a> bCQ;
        int i;
        int i2;
        if (aVar != null && (bCQ = aVar.bCQ()) != null && !bCQ.isEmpty()) {
            int size = bCQ.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bCQ.get(i3) != null) {
                    str = bCQ.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bCQ.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bCP())) {
                if (bCQ.size() >= 1) {
                    aVar.te(bCQ.get(0).getName());
                    aVar.tf(bCQ.get(0).bCR());
                    return;
                }
                return;
            }
            for (a.C0157a c0157a : bCQ) {
                if (aVar.bCP().equals(c0157a.getName())) {
                    aVar.tf(c0157a.bCR());
                    return;
                }
            }
        }
    }

    public boolean bCW() {
        return System.currentTimeMillis() - c.bCT().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bCX() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bCT().getLocationData();
        return (bCW() || locationData == null || StringUtils.isNull(locationData.bCP())) ? false : true;
    }

    public void nA(boolean z) {
        c.bCT().nz(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.bCT().bCU());
    }

    public void cj(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bCT().getLocationData();
        if (locationData != null) {
            locationData.te(str);
            locationData.tf(str2);
        }
    }

    public static void bCY() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean agr() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.hkR.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bCT().bCU()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void agv() {
        if (this.czN == null) {
            agw();
            registerListener(this.czN);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.hkP = aVar;
    }

    public void a(b bVar) {
        this.hkQ = bVar;
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
