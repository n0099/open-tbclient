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
    private HttpMessageListener dZw;
    private a jbb;
    private b jbc;
    private BdBaseActivity jbd;
    private com.baidu.adp.framework.listener.c jbe;
    private a.InterfaceC0015a jbf;
    private CustomMessageListener jbg;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void arJ();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void arK();

        void qd(String str);
    }

    private void aTM() {
        this.dZw = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.jbb != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jbb.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cne();
            }
        };
    }

    public void cne() {
        if (cng()) {
            if (this.jbb != null) {
                this.jbb.a(c.cnc().getLocationData());
            }
        } else if (j.jS()) {
            if (ab.cw(this.jbd.getActivity())) {
                com.baidu.adp.lib.d.a.hO().a(true, this.jbf);
            }
        } else if (this.jbb != null) {
            this.jbb.arJ();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jbe = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.jbb != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jbb.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.jbf = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void b(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.jbb != null) {
                        LocationModel.this.jbb.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.en(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.jbg = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.qR(false);
                        LocationModel.this.eo(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.jbc != null) {
                            LocationModel.this.jbc.qd(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.qR(true);
                    if (LocationModel.this.jbc != null) {
                        LocationModel.this.jbc.arK();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.jbd = baseActivity;
        registerListener(this.jbe);
        registerListener(this.jbg);
    }

    public void en(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.jbb != null) {
                this.jbb.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cnc().em(System.currentTimeMillis());
        c.cnc().b(aVar);
        if (this.jbb != null) {
            this.jbb.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0410a> cnb;
        int i;
        int i2;
        if (aVar != null && (cnb = aVar.cnb()) != null && !cnb.isEmpty()) {
            int size = cnb.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cnb.get(i3) != null) {
                    str = cnb.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cnb.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cna())) {
                if (cnb.size() >= 1) {
                    aVar.Ea(cnb.get(0).getName());
                    aVar.Eb(cnb.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0410a c0410a : cnb) {
                if (aVar.cna().equals(c0410a.getName())) {
                    aVar.Eb(c0410a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cnf() {
        return System.currentTimeMillis() - c.cnc().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean cng() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cnc().getLocationData();
        return (cnf() || locationData == null || StringUtils.isNull(locationData.cna())) ? false : true;
    }

    public void qR(boolean z) {
        c.cnc().qQ(z);
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("no_longer_show_address", c.cnc().cnd());
    }

    public void eo(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cnc().getLocationData();
        if (locationData != null) {
            locationData.Ea(str);
            locationData.Eb(str2);
        }
    }

    public static void cnh() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aTH() {
        return UtilHelper.isSystemLocationProviderEnabled(this.jbd.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cnc().cnd();
    }

    public void aTL() {
        if (this.dZw == null) {
            aTM();
            registerListener(this.dZw);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.jbb = aVar;
    }

    public void a(b bVar) {
        this.jbc = bVar;
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
