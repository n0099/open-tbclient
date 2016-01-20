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
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private a dIN;
    private b dIO;
    private BdBaseActivity dIP;
    private HttpMessageListener dIQ;
    private com.baidu.adp.framework.listener.e dIR;
    private a.InterfaceC0004a dIS;
    private CustomMessageListener dIT;

    /* loaded from: classes.dex */
    public interface a {
        void Ck();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fw(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Cl();

        void fx(String str);
    }

    private void aFY() {
        this.dIQ = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void aFZ() {
        if (aGb()) {
            if (this.dIN != null) {
                this.dIN.a(c.aFW().getLocationData());
            }
        } else if (i.iQ()) {
            com.baidu.adp.lib.e.a.gD().a(true, this.dIS);
        } else if (this.dIN != null) {
            this.dIN.Ck();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dIR = new e(this, 303017, true);
        this.dIS = new f(this);
        this.dIT = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.dIP = baseActivity;
        registerListener(this.dIR);
        registerListener(this.dIT);
    }

    public void bd(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.dIN != null) {
                this.dIN.fw(null);
                return;
            }
            return;
        }
        d(aVar);
        c.aFW().aq(System.currentTimeMillis());
        c.aFW().b(aVar);
        if (this.dIN != null) {
            this.dIN.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0083a> aFT;
        int i;
        int i2;
        if (aVar != null && (aFT = aVar.aFT()) != null && !aFT.isEmpty()) {
            int size = aFT.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (aFT.get(i3) != null) {
                    str = aFT.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    aFT.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.aFS())) {
                if (aFT.size() >= 1) {
                    aVar.mv(aFT.get(0).getName());
                    aVar.mw(aFT.get(0).aFU());
                    return;
                }
                return;
            }
            for (a.C0083a c0083a : aFT) {
                if (aVar.aFS().equals(c0083a.getName())) {
                    aVar.mw(c0083a.aFU());
                    return;
                }
            }
        }
    }

    public boolean aGa() {
        return System.currentTimeMillis() - c.aFW().Jl() > 300000;
    }

    public boolean aGb() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aFW().getLocationData();
        return (aGa() || locationData == null || StringUtils.isNull(locationData.aFS())) ? false : true;
    }

    public void hv(boolean z) {
        c.aFW().hu(z);
        com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("no_longer_show_address", c.aFW().aFX());
    }

    public void be(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aFW().getLocationData();
        if (locationData != null) {
            locationData.mv(str);
            locationData.mw(str2);
        }
    }

    public static void aGc() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aGd() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.dIP.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.aFW().aFX()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void aGe() {
        if (this.dIQ == null) {
            aFY();
            registerListener(this.dIQ);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.dIN = aVar;
    }

    public void a(b bVar) {
        this.dIO = bVar;
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
