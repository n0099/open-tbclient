package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.base.BdBaseActivity;
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
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private a daO;
    private b daP;
    private BdBaseActivity daQ;
    private HttpMessageListener daR;
    private com.baidu.adp.framework.listener.e daS;
    private a.InterfaceC0003a daT;
    private CustomMessageListener daU;

    /* loaded from: classes.dex */
    public interface a {
        void BC();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fb(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BD();

        void fc(String str);
    }

    private void axk() {
        this.daR = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void axl() {
        if (axn()) {
            if (this.daO != null) {
                this.daO.a(c.axi().getLocationData());
            }
        } else if (i.iM()) {
            com.baidu.adp.lib.d.a.gC().a(true, this.daT);
        } else if (this.daO != null) {
            this.daO.BC();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.daS = new e(this, 303017, true);
        this.daT = new f(this);
        this.daU = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.daQ = baseActivity;
        registerListener(this.daS);
        registerListener(this.daU);
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
            if (this.daO != null) {
                this.daO.fb(null);
                return;
            }
            return;
        }
        d(aVar);
        c.axi().ah(System.currentTimeMillis());
        c.axi().b(aVar);
        if (this.daO != null) {
            this.daO.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0078a> axf;
        int i;
        int i2;
        if (aVar != null && (axf = aVar.axf()) != null && !axf.isEmpty()) {
            int size = axf.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (axf.get(i3) != null) {
                    str = axf.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    axf.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.axe())) {
                if (axf.size() >= 1) {
                    aVar.lD(axf.get(0).getName());
                    aVar.lE(axf.get(0).axg());
                    return;
                }
                return;
            }
            for (a.C0078a c0078a : axf) {
                if (aVar.axe().equals(c0078a.getName())) {
                    aVar.lE(c0078a.axg());
                    return;
                }
            }
        }
    }

    public boolean axm() {
        return System.currentTimeMillis() - c.axi().HE() > 300000;
    }

    public boolean axn() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.axi().getLocationData();
        return (axm() || locationData == null || StringUtils.isNull(locationData.axe())) ? false : true;
    }

    public void gv(boolean z) {
        c.axi().gu(z);
        com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("no_longer_show_address", c.axi().axj());
    }

    public void bg(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.axi().getLocationData();
        if (locationData != null) {
            locationData.lD(str);
            locationData.lE(str2);
        }
    }

    public static void axo() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean axp() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.daQ.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.axi().axj()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void axq() {
        if (this.daR == null) {
            axk();
            registerListener(this.daR);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.daO = aVar;
    }

    public void a(b bVar) {
        this.daP = bVar;
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
