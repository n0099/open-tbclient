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
    private HttpMessageListener bjH;
    private a fAe;
    private b fAf;
    private BdBaseActivity fAg;
    private com.baidu.adp.framework.listener.e fAh;
    private a.InterfaceC0004a fAi;
    private CustomMessageListener fAj;

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

    private void Re() {
        this.bjH = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void bjX() {
        if (bjZ()) {
            if (this.fAe != null) {
                this.fAe.a(d.bjV().getLocationData());
            }
        } else if (i.hk()) {
            if (ae.ay(this.fAg.getActivity())) {
                com.baidu.adp.lib.d.a.fg().a(true, this.fAi);
            }
        } else if (this.fAe != null) {
            this.fAe.Ef();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fAh = new e(this, 303017, true);
        this.fAi = new f(this);
        this.fAj = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.fAg = baseActivity;
        registerListener(this.fAh);
        registerListener(this.fAj);
    }

    public void cc(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.fAe != null) {
                this.fAe.fB(null);
                return;
            }
            return;
        }
        d(aVar);
        d.bjV().cz(System.currentTimeMillis());
        d.bjV().b(aVar);
        if (this.fAe != null) {
            this.fAe.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0075a> bjS;
        int i;
        int i2;
        if (aVar != null && (bjS = aVar.bjS()) != null && !bjS.isEmpty()) {
            int size = bjS.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bjS.get(i3) != null) {
                    str = bjS.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bjS.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bjR())) {
                if (bjS.size() >= 1) {
                    aVar.qf(bjS.get(0).getName());
                    aVar.qg(bjS.get(0).bjT());
                    return;
                }
                return;
            }
            for (a.C0075a c0075a : bjS) {
                if (aVar.bjR().equals(c0075a.getName())) {
                    aVar.qg(c0075a.bjT());
                    return;
                }
            }
        }
    }

    public boolean bjY() {
        return System.currentTimeMillis() - d.bjV().avp() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bjZ() {
        com.baidu.tieba.tbadkCore.location.a locationData = d.bjV().getLocationData();
        return (bjY() || locationData == null || StringUtils.isNull(locationData.bjR())) ? false : true;
    }

    public void lw(boolean z) {
        d.bjV().lv(z);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("no_longer_show_address", d.bjV().bjW());
    }

    public void cd(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = d.bjV().getLocationData();
        if (locationData != null) {
            locationData.qf(str);
            locationData.qg(str2);
        }
    }

    public static void bka() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean QZ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fAg.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (d.bjV().bjW()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void Rd() {
        if (this.bjH == null) {
            Re();
            registerListener(this.bjH);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fAe = aVar;
    }

    public void a(b bVar) {
        this.fAf = bVar;
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
