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
    private HttpMessageListener edu;
    private a jiA;
    private b jiB;
    private BdBaseActivity jiC;
    private com.baidu.adp.framework.listener.c jiD;
    private a.InterfaceC0015a jiE;
    private CustomMessageListener jiF;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void asR();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void asS();

        void qu(String str);
    }

    private void aVH() {
        this.edu = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.jiA != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jiA.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.cqt();
            }
        };
    }

    public void cqt() {
        if (cqv()) {
            if (this.jiA != null) {
                this.jiA.a(c.cqr().getLocationData());
            }
        } else if (j.kc()) {
            if (ab.cx(this.jiC.getActivity())) {
                com.baidu.adp.lib.d.a.hY().a(true, this.jiE);
            }
        } else if (this.jiA != null) {
            this.jiA.asR();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jiD = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.jiA != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jiA.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.jiE = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void b(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.jiA != null) {
                        LocationModel.this.jiA.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.eo(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.jiF = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.rh(false);
                        LocationModel.this.ep(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.jiB != null) {
                            LocationModel.this.jiB.qu(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.rh(true);
                    if (LocationModel.this.jiB != null) {
                        LocationModel.this.jiB.asS();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.jiC = baseActivity;
        registerListener(this.jiD);
        registerListener(this.jiF);
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
            if (this.jiA != null) {
                this.jiA.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.cqr().ew(System.currentTimeMillis());
        c.cqr().b(aVar);
        if (this.jiA != null) {
            this.jiA.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0415a> cqq;
        int i;
        int i2;
        if (aVar != null && (cqq = aVar.cqq()) != null && !cqq.isEmpty()) {
            int size = cqq.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cqq.get(i3) != null) {
                    str = cqq.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cqq.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.cqp())) {
                if (cqq.size() >= 1) {
                    aVar.EO(cqq.get(0).getName());
                    aVar.EP(cqq.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0415a c0415a : cqq) {
                if (aVar.cqp().equals(c0415a.getName())) {
                    aVar.EP(c0415a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cqu() {
        return System.currentTimeMillis() - c.cqr().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean cqv() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cqr().getLocationData();
        return (cqu() || locationData == null || StringUtils.isNull(locationData.cqp())) ? false : true;
    }

    public void rh(boolean z) {
        c.cqr().rg(z);
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("no_longer_show_address", c.cqr().cqs());
    }

    public void ep(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.cqr().getLocationData();
        if (locationData != null) {
            locationData.EO(str);
            locationData.EP(str2);
        }
    }

    public static void cqw() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aVC() {
        return UtilHelper.isSystemLocationProviderEnabled(this.jiC.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.cqr().cqs();
    }

    public void aVG() {
        if (this.edu == null) {
            aVH();
            registerListener(this.edu);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.jiA = aVar;
    }

    public void a(b bVar) {
        this.jiB = bVar;
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
