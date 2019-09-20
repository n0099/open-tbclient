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
    private HttpMessageListener efe;
    private a jkV;
    private b jkW;
    private BdBaseActivity jkX;
    private com.baidu.adp.framework.listener.c jkY;
    private a.InterfaceC0015a jkZ;
    private CustomMessageListener jla;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void atd();

        void onFail(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void ate();

        void qF(String str);
    }

    private void aWl() {
        this.efe = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    if (LocationModel.this.jkV != null) {
                        String str = null;
                        if (httpResponsedMessage != null && httpResponsedMessage.getError() > 0) {
                            str = httpResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jkV.onFail(str);
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().setLocationShared(true);
                LocationModel.this.crh();
            }
        };
    }

    public void crh() {
        if (crj()) {
            if (this.jkV != null) {
                this.jkV.a(c.crf().getLocationData());
            }
        } else if (j.kc()) {
            if (ab.cx(this.jkX.getActivity())) {
                com.baidu.adp.lib.d.a.hY().a(true, this.jkZ);
            }
        } else if (this.jkV != null) {
            this.jkV.atd();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jkY = new com.baidu.adp.framework.listener.c(303017, true) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
                    if (LocationModel.this.jkV != null) {
                        String str = null;
                        if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                            str = socketResponsedMessage.getErrorString();
                        }
                        LocationModel.this.jkV.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
            }
        };
        this.jkZ = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.2
            @Override // com.baidu.adp.lib.d.a.InterfaceC0015a
            public void b(int i, String str, Address address) {
                if (i != 0 || address == null) {
                    if (LocationModel.this.jkV != null) {
                        LocationModel.this.jkV.onFail(str);
                        return;
                    }
                    return;
                }
                LocationModel.this.ep(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            }
        };
        this.jla = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.tbadkCore.location.LocationModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel.this.rk(false);
                        LocationModel.this.eq(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                        if (LocationModel.this.jkW != null) {
                            LocationModel.this.jkW.qF(responsedSelectLocation.getName());
                            return;
                        }
                        return;
                    }
                    LocationModel.this.rk(true);
                    if (LocationModel.this.jkW != null) {
                        LocationModel.this.jkW.ate();
                    }
                }
            }
        };
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.jkX = baseActivity;
        registerListener(this.jkY);
        registerListener(this.jla);
    }

    public void ep(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.jkV != null) {
                this.jkV.onFail(null);
                return;
            }
            return;
        }
        d(aVar);
        c.crf().ez(System.currentTimeMillis());
        c.crf().b(aVar);
        if (this.jkV != null) {
            this.jkV.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0426a> cre;
        int i;
        int i2;
        if (aVar != null && (cre = aVar.cre()) != null && !cre.isEmpty()) {
            int size = cre.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (cre.get(i3) != null) {
                    str = cre.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    cre.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.crd())) {
                if (cre.size() >= 1) {
                    aVar.Fo(cre.get(0).getName());
                    aVar.Fp(cre.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0426a c0426a : cre) {
                if (aVar.crd().equals(c0426a.getName())) {
                    aVar.Fp(c0426a.getSn());
                    return;
                }
            }
        }
    }

    public boolean cri() {
        return System.currentTimeMillis() - c.crf().getTimeStamp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean crj() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.crf().getLocationData();
        return (cri() || locationData == null || StringUtils.isNull(locationData.crd())) ? false : true;
    }

    public void rk(boolean z) {
        c.crf().rj(z);
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("no_longer_show_address", c.crf().crg());
    }

    public void eq(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.crf().getLocationData();
        if (locationData != null) {
            locationData.Fo(str);
            locationData.Fp(str2);
        }
    }

    public static void crk() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aWg() {
        return UtilHelper.isSystemLocationProviderEnabled(this.jkX.getPageContext().getPageActivity()) && TbadkCoreApplication.getInst().getLocationShared() && !c.crf().crg();
    }

    public void aWk() {
        if (this.efe == null) {
            aWl();
            registerListener(this.efe);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", Headers.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.jkV = aVar;
    }

    public void a(b bVar) {
        this.jkW = bVar;
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
