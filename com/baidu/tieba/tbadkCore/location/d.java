package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private CustomMessageListener fiA;
    private a fit;
    private b fiu;
    private BdBaseActivity fiv;
    private HttpMessageListener fiw;
    private com.baidu.adp.framework.listener.e fiy;
    private a.InterfaceC0005a fiz;

    /* loaded from: classes.dex */
    public interface a {
        void Dt();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fJ(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Du();

        void fK(String str);
    }

    private void bgG() {
        this.fiw = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void bgH() {
        if (bgJ()) {
            if (this.fit != null) {
                this.fit.a(c.bgE().getLocationData());
            }
        } else if (i.gm()) {
            if (ae.W(this.fiv.getActivity())) {
                com.baidu.adp.lib.e.a.dU().a(true, this.fiz);
            }
        } else if (this.fit != null) {
            this.fit.Dt();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fiy = new e(this, 303017, true);
        this.fiz = new f(this);
        this.fiA = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.fiv = baseActivity;
        registerListener(this.fiy);
        registerListener(this.fiA);
    }

    public void bZ(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.fit != null) {
                this.fit.fJ(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bgE().cE(System.currentTimeMillis());
        c.bgE().b(aVar);
        if (this.fit != null) {
            this.fit.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0076a> bgB;
        int i;
        int i2;
        if (aVar != null && (bgB = aVar.bgB()) != null && !bgB.isEmpty()) {
            int size = bgB.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bgB.get(i3) != null) {
                    str = bgB.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bgB.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bgA())) {
                if (bgB.size() >= 1) {
                    aVar.qm(bgB.get(0).getName());
                    aVar.qn(bgB.get(0).bgC());
                    return;
                }
                return;
            }
            for (a.C0076a c0076a : bgB) {
                if (aVar.bgA().equals(c0076a.getName())) {
                    aVar.qn(c0076a.bgC());
                    return;
                }
            }
        }
    }

    public boolean bgI() {
        return System.currentTimeMillis() - c.bgE().atU() > 300000;
    }

    public boolean bgJ() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bgE().getLocationData();
        return (bgI() || locationData == null || StringUtils.isNull(locationData.bgA())) ? false : true;
    }

    public void kY(boolean z) {
        c.bgE().kX(z);
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("no_longer_show_address", c.bgE().bgF());
    }

    public void ca(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bgE().getLocationData();
        if (locationData != null) {
            locationData.qm(str);
            locationData.qn(str2);
        }
    }

    public static void bgK() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bgL() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fiv.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bgE().bgF()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void bgM() {
        if (this.fiw == null) {
            bgG();
            registerListener(this.fiw);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fit = aVar;
    }

    public void a(b bVar) {
        this.fiu = bVar;
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
