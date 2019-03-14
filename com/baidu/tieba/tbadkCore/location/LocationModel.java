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
    private HttpMessageListener dPE;
    private a iIq;
    private b iIr;
    private BdBaseActivity iIs;
    private com.baidu.adp.framework.listener.c iIt;
    private a.InterfaceC0015a iIu;
    private CustomMessageListener iIv;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void amJ();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void amK();

        void oV(String str);
    }

    private void aNK() {
        this.dPE = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.iIq != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.iIq.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cfb();
            }
        };
    }

    public void cfb() {
        if (cfd()) {
            if (this.iIq != null) {
                this.iIq.a(c.ceZ().getLocationData());
            }
        } else if (j.kY()) {
            if (ab.cR(this.iIs.getActivity())) {
                com.baidu.adp.lib.d.a.iW().a(true, this.iIu);
            }
        } else if (this.iIq != null) {
            this.iIq.amJ();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.iIt = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.iIq != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.iIq.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.iIu = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void b(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.iIq != null) {
                        LocationModel.this.iIq.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.dY(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.iIv = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.qb(false);
                        LocationModel.this.dZ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.iIr != null) {
                            LocationModel.this.iIr.oV(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.qb(true);
                    if (LocationModel.this.iIr != null) {
                        LocationModel.this.iIr.amK();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.iIs = baseActivity;
        registerListener(this.iIt);
        registerListener(this.iIv);
    }

    public void dY(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.iIq != null) {
                this.iIq.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.ceZ().dO(System.currentTimeMillis());
        c.ceZ().b(aVar);
        if (this.iIq != null) {
            this.iIq.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0391a> ceX;
        int i;
        int i2;
        if (aVar != null && (ceX = aVar.ceX()) != null && !ceX.isEmpty()) {
            int size = ceX.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (ceX.get(i3) != null) {
                    str = ceX.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    ceX.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.ceW())) {
                if (ceX.size() >= 1) {
                    aVar.CD(ceX.get(0).getName());
                    aVar.CE(ceX.get(0).ceY());
                    return;
                }
                return;
            }
            for (a.C0391a c0391a : ceX) {
                if (aVar.ceW().equals(c0391a.getName())) {
                    aVar.CE(c0391a.ceY());
                    return;
                }
            }
        }
    }

    public boolean cfc() {
        return System.currentTimeMillis() - c.ceZ().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean cfd() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.ceZ().getLocationData();
        return (cfc() || locationData == null || StringUtils.isNull(locationData.ceW())) ? false : true;
    }

    public void qb(boolean z) {
        c.ceZ().qa(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.ceZ().cfa());
    }

    public void dZ(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.ceZ().getLocationData();
        if (locationData != null) {
            locationData.CD(str);
            locationData.CE(str2);
        }
    }

    public static void cfe() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aNF() {
        return UtilHelper.isSystemLocationProviderEnabled(this.iIs.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.ceZ().cfa();
    }

    public void aNJ() {
        if (this.dPE == null) {
            aNK();
            registerListener(this.dPE);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.iIq = aVar;
    }

    public void a(b bVar) {
        this.iIr = bVar;
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
