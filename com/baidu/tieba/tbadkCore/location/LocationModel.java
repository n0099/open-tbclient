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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener dOV;
    private a iIb;
    private b iIc;
    private BdBaseActivity iId;
    private com.baidu.adp.framework.listener.c iIe;
    private a.InterfaceC0015a iIf;
    private CustomMessageListener iIg;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void amG();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void amH();

        void oW(String str);
    }

    private void aNz() {
        this.dOV = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.iIb != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.iIb.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.ceX();
            }
        };
    }

    public void ceX() {
        if (ceZ()) {
            if (this.iIb != null) {
                this.iIb.a(c.ceV().getLocationData());
            }
        } else if (j.kY()) {
            if (ab.cR(this.iId.getActivity())) {
                com.baidu.adp.lib.d.a.iW().a(true, this.iIf);
            }
        } else if (this.iIb != null) {
            this.iIb.amG();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.iIe = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.iIb != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.iIb.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.iIf = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void b(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.iIb != null) {
                        LocationModel.this.iIb.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.dZ(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.iIg = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.qb(false);
                        LocationModel.this.ea(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.iIc != null) {
                            LocationModel.this.iIc.oW(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.qb(true);
                    if (LocationModel.this.iIc != null) {
                        LocationModel.this.iIc.amH();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.iId = baseActivity;
        registerListener(this.iIe);
        registerListener(this.iIg);
    }

    public void dZ(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.iIb != null) {
                this.iIb.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.ceV().dO(System.currentTimeMillis());
        c.ceV().b(aVar);
        if (this.iIb != null) {
            this.iIb.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0391a> ceT;
        int i;
        int i2;
        if (aVar != null && (ceT = aVar.ceT()) != null && !ceT.isEmpty()) {
            int size = ceT.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (ceT.get(i3) != null) {
                    str = ceT.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    ceT.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.ceS())) {
                if (ceT.size() >= 1) {
                    aVar.CC(ceT.get(0).getName());
                    aVar.CD(ceT.get(0).ceU());
                    return;
                }
                return;
            }
            for (a.C0391a c0391a : ceT) {
                if (aVar.ceS().equals(c0391a.getName())) {
                    aVar.CD(c0391a.ceU());
                    return;
                }
            }
        }
    }

    public boolean ceY() {
        return System.currentTimeMillis() - c.ceV().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean ceZ() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.ceV().getLocationData();
        return (ceY() || locationData == null || StringUtils.isNull(locationData.ceS())) ? false : true;
    }

    public void qb(boolean z) {
        c.ceV().qa(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.ceV().ceW());
    }

    public void ea(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.ceV().getLocationData();
        if (locationData != null) {
            locationData.CC(str);
            locationData.CD(str2);
        }
    }

    public static void cfa() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aNu() {
        return UtilHelper.isSystemLocationProviderEnabled(this.iId.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.ceV().ceW();
    }

    public void aNy() {
        if (this.dOV == null) {
            aNz();
            registerListener(this.dOV);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.iIb = aVar;
    }

    public void a(b bVar) {
        this.iIc = bVar;
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
