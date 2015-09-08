package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private a cSI;
    private b cSJ;
    private BdBaseActivity cSK;
    private HttpMessageListener cSL;
    private com.baidu.adp.framework.listener.e cSM;
    private a.InterfaceC0003a cSN;
    private CustomMessageListener cSO;

    /* loaded from: classes.dex */
    public interface a {
        void BS();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void eW(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BT();

        void eX(String str);
    }

    private void auS() {
        this.cSL = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void auT() {
        if (auV()) {
            if (this.cSI != null) {
                this.cSI.a(c.auQ().getLocationData());
            }
        } else if (com.baidu.adp.lib.util.i.iL()) {
            com.baidu.adp.lib.d.a.gC().a(true, this.cSN);
        } else if (this.cSI != null) {
            this.cSI.BS();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cSM = new e(this, 303017, true);
        this.cSN = new f(this);
        this.cSO = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.cSK = baseActivity;
        registerListener(this.cSM);
        registerListener(this.cSO);
    }

    public void bf(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.cSI != null) {
                this.cSI.eW(null);
                return;
            }
            return;
        }
        d(aVar);
        c.auQ().Q(System.currentTimeMillis());
        c.auQ().b(aVar);
        if (this.cSI != null) {
            this.cSI.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0075a> auN;
        int i;
        int i2;
        if (aVar != null && (auN = aVar.auN()) != null && !auN.isEmpty()) {
            int size = auN.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (auN.get(i3) != null) {
                    str = auN.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    auN.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.auM())) {
                if (auN.size() >= 1) {
                    aVar.lb(auN.get(0).getName());
                    aVar.lc(auN.get(0).auO());
                    return;
                }
                return;
            }
            for (a.C0075a c0075a : auN) {
                if (aVar.auM().equals(c0075a.getName())) {
                    aVar.lc(c0075a.auO());
                    return;
                }
            }
        }
    }

    public boolean auU() {
        return System.currentTimeMillis() - c.auQ().HO() > 300000;
    }

    public boolean auV() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.auQ().getLocationData();
        return (auU() || locationData == null || StringUtils.isNull(locationData.auM())) ? false : true;
    }

    public void gl(boolean z) {
        c.auQ().gk(z);
        com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("no_longer_show_address", c.auQ().auR());
    }

    public void bg(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.auQ().getLocationData();
        if (locationData != null) {
            locationData.lb(str);
            locationData.lc(str2);
        }
    }

    public static void auW() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean auX() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cSK.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.auQ().auR()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void auY() {
        if (this.cSL == null) {
            auS();
            registerListener(this.cSL);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.cSI = aVar;
    }

    public void a(b bVar) {
        this.cSJ = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
