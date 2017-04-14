package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener bhv;
    private a fxO;
    private b fxP;
    private BdBaseActivity fxQ;
    private com.baidu.adp.framework.listener.e fxR;
    private a.InterfaceC0004a fxS;
    private CustomMessageListener fxT;

    /* loaded from: classes.dex */
    public interface a {
        void Ef();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fB(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Eg();

        void fC(String str);
    }

    private void Qe() {
        this.bhv = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void biW() {
        if (biY()) {
            if (this.fxO != null) {
                this.fxO.a(d.biU().getLocationData());
            }
        } else if (i.hj()) {
            if (ae.ay(this.fxQ.getActivity())) {
                com.baidu.adp.lib.d.a.ff().a(true, this.fxS);
            }
        } else if (this.fxO != null) {
            this.fxO.Ef();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fxR = new e(this, 303017, true);
        this.fxS = new f(this);
        this.fxT = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.fxQ = baseActivity;
        registerListener(this.fxR);
        registerListener(this.fxT);
    }

    public void cd(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.fxO != null) {
                this.fxO.fB(null);
                return;
            }
            return;
        }
        d(aVar);
        d.biU().cz(System.currentTimeMillis());
        d.biU().b(aVar);
        if (this.fxO != null) {
            this.fxO.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0075a> biR;
        int i;
        int i2;
        if (aVar != null && (biR = aVar.biR()) != null && !biR.isEmpty()) {
            int size = biR.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (biR.get(i3) != null) {
                    str = biR.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    biR.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.biQ())) {
                if (biR.size() >= 1) {
                    aVar.qe(biR.get(0).getName());
                    aVar.qf(biR.get(0).biS());
                    return;
                }
                return;
            }
            for (a.C0075a c0075a : biR) {
                if (aVar.biQ().equals(c0075a.getName())) {
                    aVar.qf(c0075a.biS());
                    return;
                }
            }
        }
    }

    public boolean biX() {
        return System.currentTimeMillis() - d.biU().auo() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean biY() {
        com.baidu.tieba.tbadkCore.location.a locationData = d.biU().getLocationData();
        return (biX() || locationData == null || StringUtils.isNull(locationData.biQ())) ? false : true;
    }

    public void lm(boolean z) {
        d.biU().ll(z);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("no_longer_show_address", d.biU().biV());
    }

    public void ce(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = d.biU().getLocationData();
        if (locationData != null) {
            locationData.qe(str);
            locationData.qf(str2);
        }
    }

    public static void biZ() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean PZ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fxQ.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (d.biU().biV()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void Qd() {
        if (this.bhv == null) {
            Qe();
            registerListener(this.bhv);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fxO = aVar;
    }

    public void a(b bVar) {
        this.fxP = bVar;
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
