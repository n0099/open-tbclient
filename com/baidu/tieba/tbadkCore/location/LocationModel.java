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
    private HttpMessageListener edn;
    private a jhs;
    private b jht;
    private BdBaseActivity jhu;
    private com.baidu.adp.framework.listener.c jhv;
    private a.InterfaceC0015a jhw;
    private CustomMessageListener jhx;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void asP();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void asQ();

        void qu(String str);
    }

    private void aVF() {
        this.edn = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.jhs != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jhs.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cpX();
            }
        };
    }

    public void cpX() {
        if (cpZ()) {
            if (this.jhs != null) {
                this.jhs.a(c.cpV().getLocationData());
            }
        } else if (j.kc()) {
            if (ab.cx(this.jhu.getActivity())) {
                com.baidu.adp.lib.d.a.hY().a(true, this.jhw);
            }
        } else if (this.jhs != null) {
            this.jhs.asP();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jhv = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.jhs != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jhs.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.jhw = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void b(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.jhs != null) {
                        LocationModel.this.jhs.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eo(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.jhx = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.rg(false);
                        LocationModel.this.ep(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.jht != null) {
                            LocationModel.this.jht.qu(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.rg(true);
                    if (LocationModel.this.jht != null) {
                        LocationModel.this.jht.asQ();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.jhu = baseActivity;
        registerListener(this.jhv);
        registerListener(this.jhx);
    }

    public void eo(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.jhs != null) {
                this.jhs.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cpV().ew(System.currentTimeMillis());
        c.cpV().b(aVar);
        if (this.jhs != null) {
            this.jhs.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0415a> cpU;
        int i;
        int i2;
        if (aVar != null && (cpU = aVar.cpU()) != null && !cpU.isEmpty()) {
            int size = cpU.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cpU.get(i3) != null) {
                    str = cpU.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cpU.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cpT())) {
                if (cpU.size() >= 1) {
                    aVar.EN(cpU.get(0).getName());
                    aVar.EO(cpU.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0415a c0415a : cpU) {
                if (aVar.cpT().equals(c0415a.getName())) {
                    aVar.EO(c0415a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cpY() {
        return System.currentTimeMillis() - c.cpV().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean cpZ() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cpV().getLocationData();
        return (cpY() || locationData == null || StringUtils.isNull(locationData.cpT())) ? false : true;
    }

    public void rg(boolean z) {
        c.cpV().rf(z);
        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("no_longer_show_address", c.cpV().cpW());
    }

    public void ep(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cpV().getLocationData();
        if (locationData != null) {
            locationData.EN(str);
            locationData.EO(str2);
        }
    }

    public static void cqa() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aVA() {
        return UtilHelper.isSystemLocationProviderEnabled(this.jhu.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cpV().cpW();
    }

    public void aVE() {
        if (this.edn == null) {
            aVF();
            registerListener(this.edn);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.jhs = aVar;
    }

    public void a(b bVar) {
        this.jht = bVar;
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
