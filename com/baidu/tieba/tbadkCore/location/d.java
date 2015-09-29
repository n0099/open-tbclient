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
    private a dam;
    private b dan;
    private BdBaseActivity dao;
    private HttpMessageListener dap;
    private com.baidu.adp.framework.listener.e daq;
    private a.InterfaceC0003a dar;
    private CustomMessageListener das;

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

    private void axe() {
        this.dap = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void axf() {
        if (axh()) {
            if (this.dam != null) {
                this.dam.a(c.axc().getLocationData());
            }
        } else if (i.iM()) {
            com.baidu.adp.lib.d.a.gC().a(true, this.dar);
        } else if (this.dam != null) {
            this.dam.BF();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.daq = new e(this, 303017, true);
        this.dar = new f(this);
        this.das = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.dao = baseActivity;
        registerListener(this.daq);
        registerListener(this.das);
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
            if (this.dam != null) {
                this.dam.fb(null);
                return;
            }
            return;
        }
        d(aVar);
        c.axc().Z(System.currentTimeMillis());
        c.axc().b(aVar);
        if (this.dam != null) {
            this.dam.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0078a> awZ;
        int i;
        int i2;
        if (aVar != null && (awZ = aVar.awZ()) != null && !awZ.isEmpty()) {
            int size = awZ.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (awZ.get(i3) != null) {
                    str = awZ.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    awZ.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.awY())) {
                if (awZ.size() >= 1) {
                    aVar.lA(awZ.get(0).getName());
                    aVar.lB(awZ.get(0).axa());
                    return;
                }
                return;
            }
            for (a.C0078a c0078a : awZ) {
                if (aVar.awY().equals(c0078a.getName())) {
                    aVar.lB(c0078a.axa());
                    return;
                }
            }
        }
    }

    public boolean axg() {
        return System.currentTimeMillis() - c.axc().HI() > 300000;
    }

    public boolean axh() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.axc().getLocationData();
        return (axg() || locationData == null || StringUtils.isNull(locationData.awY())) ? false : true;
    }

    public void gv(boolean z) {
        c.axc().gu(z);
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("no_longer_show_address", c.axc().axd());
    }

    public void bg(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.axc().getLocationData();
        if (locationData != null) {
            locationData.lA(str);
            locationData.lB(str2);
        }
    }

    public static void axi() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean axj() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.dao.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.axc().axd()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void axk() {
        if (this.dap == null) {
            axe();
            registerListener(this.dap);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.dam = aVar;
    }

    public void a(b bVar) {
        this.dan = bVar;
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
