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
    private HttpMessageListener dPI;
    private BdBaseActivity iIA;
    private com.baidu.adp.framework.listener.c iIB;
    private a.InterfaceC0015a iIC;
    private CustomMessageListener iID;
    private a iIy;
    private b iIz;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void amK();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void amL();

        void oV(String str);
    }

    private void aNL() {
        this.dPI = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.iIy != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.iIy.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.ceZ();
            }
        };
    }

    public void ceZ() {
        if (cfb()) {
            if (this.iIy != null) {
                this.iIy.a(c.ceX().getLocationData());
            }
        } else if (j.kY()) {
            if (ab.cR(this.iIA.getActivity())) {
                com.baidu.adp.lib.d.a.iW().a(true, this.iIC);
            }
        } else if (this.iIy != null) {
            this.iIy.amK();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.iIB = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.iIy != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.iIy.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.iIC = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void b(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.iIy != null) {
                        LocationModel.this.iIy.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.dZ(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.iID = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.qb(false);
                        LocationModel.this.ea(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.iIz != null) {
                            LocationModel.this.iIz.oV(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.qb(true);
                    if (LocationModel.this.iIz != null) {
                        LocationModel.this.iIz.amL();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.iIA = baseActivity;
        registerListener(this.iIB);
        registerListener(this.iID);
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
            if (this.iIy != null) {
                this.iIy.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.ceX().dO(System.currentTimeMillis());
        c.ceX().b(aVar);
        if (this.iIy != null) {
            this.iIy.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0310a> ceV;
        int i;
        int i2;
        if (aVar != null && (ceV = aVar.ceV()) != null && !ceV.isEmpty()) {
            int size = ceV.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (ceV.get(i3) != null) {
                    str = ceV.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    ceV.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.ceU())) {
                if (ceV.size() >= 1) {
                    aVar.CF(ceV.get(0).getName());
                    aVar.CG(ceV.get(0).ceW());
                    return;
                }
                return;
            }
            for (a.C0310a c0310a : ceV) {
                if (aVar.ceU().equals(c0310a.getName())) {
                    aVar.CG(c0310a.ceW());
                    return;
                }
            }
        }
    }

    public boolean cfa() {
        return System.currentTimeMillis() - c.ceX().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean cfb() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.ceX().getLocationData();
        return (cfa() || locationData == null || StringUtils.isNull(locationData.ceU())) ? false : true;
    }

    public void qb(boolean z) {
        c.ceX().qa(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", c.ceX().ceY());
    }

    public void ea(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.ceX().getLocationData();
        if (locationData != null) {
            locationData.CF(str);
            locationData.CG(str2);
        }
    }

    public static void cfc() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aNG() {
        return UtilHelper.isSystemLocationProviderEnabled(this.iIA.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.ceX().ceY();
    }

    public void aNK() {
        if (this.dPI == null) {
            aNL();
            registerListener(this.dPI);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.iIy = aVar;
    }

    public void a(b bVar) {
        this.iIz = bVar;
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
