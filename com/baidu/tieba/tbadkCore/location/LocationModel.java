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
    private a jaX;
    private b jaY;
    private BdBaseActivity jaZ;
    private com.baidu.adp.framework.listener.c jba;
    private a.InterfaceC0015a jbb;
    private CustomMessageListener jbc;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void arJ();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void arK();

        void qe(String str);
    }

    private void aTM() {
        this.dZw = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.jaX != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jaX.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cnd();
            }
        };
    }

    public void cnd() {
        if (cnf()) {
            if (this.jaX != null) {
                this.jaX.a(c.cnb().getLocationData());
            }
        } else if (j.jS()) {
            if (ab.cw(this.jaZ.getActivity())) {
                com.baidu.adp.lib.d.a.hO().a(true, this.jbb);
            }
        } else if (this.jaX != null) {
            this.jaX.arJ();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jba = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.jaX != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jaX.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.jbb = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void b(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.jaX != null) {
                        LocationModel.this.jaX.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.en(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.jbc = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.qQ(false);
                        LocationModel.this.eo(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.jaY != null) {
                            LocationModel.this.jaY.qe(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.qQ(true);
                    if (LocationModel.this.jaY != null) {
                        LocationModel.this.jaY.arK();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.jaZ = baseActivity;
        registerListener(this.jba);
        registerListener(this.jbc);
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
            if (this.jaX != null) {
                this.jaX.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cnb().em(System.currentTimeMillis());
        c.cnb().b(aVar);
        if (this.jaX != null) {
            this.jaX.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0410a> cna;
        int i;
        int i2;
        if (aVar != null && (cna = aVar.cna()) != null && !cna.isEmpty()) {
            int size = cna.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cna.get(i3) != null) {
                    str = cna.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cna.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cmZ())) {
                if (cna.size() >= 1) {
                    aVar.DY(cna.get(0).getName());
                    aVar.DZ(cna.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0410a c0410a : cna) {
                if (aVar.cmZ().equals(c0410a.getName())) {
                    aVar.DZ(c0410a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cne() {
        return System.currentTimeMillis() - c.cnb().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean cnf() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cnb().getLocationData();
        return (cne() || locationData == null || StringUtils.isNull(locationData.cmZ())) ? false : true;
    }

    public void qQ(boolean z) {
        c.cnb().qP(z);
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("no_longer_show_address", c.cnb().cnc());
    }

    public void eo(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cnb().getLocationData();
        if (locationData != null) {
            locationData.DY(str);
            locationData.DZ(str2);
        }
    }

    public static void cng() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aTH() {
        return UtilHelper.isSystemLocationProviderEnabled(this.jaZ.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cnb().cnc();
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
        this.jaX = aVar;
    }

    public void a(b bVar) {
        this.jaY = bVar;
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
