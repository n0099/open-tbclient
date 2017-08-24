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
    private HttpMessageListener bvf;
    private a glM;
    private b glN;
    private BdBaseActivity glO;
    private com.baidu.adp.framework.listener.c glP;
    private a.InterfaceC0004a glQ;
    private CustomMessageListener glR;

    /* loaded from: classes.dex */
    public interface a {
        void DR();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void ge(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DS();

        void gf(String str);
    }

    private void TL() {
        this.bvf = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    BdLog.i("mOpenShareLocSwitchListener response error!");
                    if (LocationModel.this.glM != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.glM.ge(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.btH();
            }
        };
    }

    public void btH() {
        if (btJ()) {
            if (this.glM != null) {
                this.glM.a(c.btF().getLocationData());
            }
        } else if (i.hr()) {
            if (aa.aC(this.glO.getActivity())) {
                com.baidu.adp.lib.d.a.fo().a(true, this.glQ);
            }
        } else if (this.glM != null) {
            this.glM.DR();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.glP = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getError() == 0 && (socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
                    return;
                }
                BdLog.i("mLocationListener response error!");
                if (LocationModel.this.glM != null) {
                    String str = null;
                    if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                        str = socketResponsedMessage.getErrorString();
                    }
                    LocationModel.this.glM.ge(str);
                }
            }
        };
        this.glQ = new a.InterfaceC0004a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
            public void b(int i, String str, Address address) {
                if (i == 0 && address != null) {
                    BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
                    LocationModel.this.cl(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
                    return;
                }
                BdLog.i("mGetLonAndLatCallback error!");
                if (LocationModel.this.glM != null) {
                    LocationModel.this.glM.ge(str);
                }
            }
        };
        this.glR = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.mD(false);
                        LocationModel.this.cm(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.glN != null) {
                            LocationModel.this.glN.gf(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.mD(true);
                    if (LocationModel.this.glN != null) {
                        LocationModel.this.glN.DS();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.glO = baseActivity;
        registerListener(this.glP);
        registerListener(this.glR);
    }

    public void cl(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.glM != null) {
                this.glM.ge(null);
                return;
            }
            return;
        }
        d(aVar);
        c.btF().cI(System.currentTimeMillis());
        c.btF().b(aVar);
        if (this.glM != null) {
            this.glM.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0123a> btC;
        int i;
        int i2;
        if (aVar != null && (btC = aVar.btC()) != null && !btC.isEmpty()) {
            int size = btC.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (btC.get(i3) != null) {
                    str = btC.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    btC.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.btB())) {
                if (btC.size() >= 1) {
                    aVar.sj(btC.get(0).getName());
                    aVar.sk(btC.get(0).btD());
                    return;
                }
                return;
            }
            for (a.C0123a c0123a : btC) {
                if (aVar.btB().equals(c0123a.getName())) {
                    aVar.sk(c0123a.btD());
                    return;
                }
            }
        }
    }

    public boolean btI() {
        return System.currentTimeMillis() - c.btF().bos() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean btJ() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.btF().getLocationData();
        return (btI() || locationData == null || StringUtils.isNull(locationData.btB())) ? false : true;
    }

    public void mD(boolean z) {
        c.btF().mC(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.btF().btG());
    }

    public void cm(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.btF().getLocationData();
        if (locationData != null) {
            locationData.sj(str);
            locationData.sk(str2);
        }
    }

    public static void btK() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean TG() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.glO.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.btF().btG()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void TK() {
        if (this.bvf == null) {
            TL();
            registerListener(this.bvf);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.glM = aVar;
    }

    public void a(b bVar) {
        this.glN = bVar;
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
