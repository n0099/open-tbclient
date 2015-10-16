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
        void BF();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fb(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BG();

        void fc(String str);
    }

    private void axo() {
        this.daR = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void axp() {
        if (axr()) {
            if (this.daO != null) {
                this.daO.a(c.axm().getLocationData());
            }
        } else if (i.iM()) {
            com.baidu.adp.lib.d.a.gC().a(true, this.daT);
        } else if (this.daO != null) {
            this.daO.BF();
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
        c.axm().aj(System.currentTimeMillis());
        c.axm().b(aVar);
        if (this.daO != null) {
            this.daO.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0078a> axj;
        int i;
        int i2;
        if (aVar != null && (axj = aVar.axj()) != null && !axj.isEmpty()) {
            int size = axj.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (axj.get(i3) != null) {
                    str = axj.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    axj.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.axi())) {
                if (axj.size() >= 1) {
                    aVar.lD(axj.get(0).getName());
                    aVar.lE(axj.get(0).axk());
                    return;
                }
                return;
            }
            for (a.C0078a c0078a : axj) {
                if (aVar.axi().equals(c0078a.getName())) {
                    aVar.lE(c0078a.axk());
                    return;
                }
            }
        }
    }

    public boolean axq() {
        return System.currentTimeMillis() - c.axm().HI() > 300000;
    }

    public boolean axr() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.axm().getLocationData();
        return (axq() || locationData == null || StringUtils.isNull(locationData.axi())) ? false : true;
    }

    public void gv(boolean z) {
        c.axm().gu(z);
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("no_longer_show_address", c.axm().axn());
    }

    public void bg(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.axm().getLocationData();
        if (locationData != null) {
            locationData.lD(str);
            locationData.lE(str2);
        }
    }

    public static void axs() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean axt() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.daQ.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.axm().axn()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void axu() {
        if (this.daR == null) {
            axo();
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
