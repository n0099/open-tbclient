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
import com.baidu.tbadk.core.util.ag;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private a erF;
    private b erG;
    private BdBaseActivity erH;
    private HttpMessageListener erI;
    private com.baidu.adp.framework.listener.e erJ;
    private a.InterfaceC0005a erK;
    private CustomMessageListener erL;

    /* loaded from: classes.dex */
    public interface a {
        void Ek();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fC(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void El();

        void fD(String str);
    }

    private void aUf() {
        this.erI = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void aUg() {
        if (aUi()) {
            if (this.erF != null) {
                this.erF.a(c.aUd().getLocationData());
            }
        } else if (i.jf()) {
            if (ag.Q(this.erH.getActivity())) {
                com.baidu.adp.lib.e.a.gL().a(true, this.erK);
            }
        } else if (this.erF != null) {
            this.erF.Ek();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.erJ = new e(this, 303017, true);
        this.erK = new f(this);
        this.erL = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.erH = baseActivity;
        registerListener(this.erJ);
        registerListener(this.erL);
    }

    public void bG(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.erF != null) {
                this.erF.fC(null);
                return;
            }
            return;
        }
        d(aVar);
        c.aUd().ca(System.currentTimeMillis());
        c.aUd().b(aVar);
        if (this.erF != null) {
            this.erF.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0085a> aUa;
        int i;
        int i2;
        if (aVar != null && (aUa = aVar.aUa()) != null && !aUa.isEmpty()) {
            int size = aUa.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (aUa.get(i3) != null) {
                    str = aUa.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    aUa.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.aTZ())) {
                if (aUa.size() >= 1) {
                    aVar.nX(aUa.get(0).getName());
                    aVar.nY(aUa.get(0).aUb());
                    return;
                }
                return;
            }
            for (a.C0085a c0085a : aUa) {
                if (aVar.aTZ().equals(c0085a.getName())) {
                    aVar.nY(c0085a.aUb());
                    return;
                }
            }
        }
    }

    public boolean aUh() {
        return System.currentTimeMillis() - c.aUd().ajc() > 300000;
    }

    public boolean aUi() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aUd().getLocationData();
        return (aUh() || locationData == null || StringUtils.isNull(locationData.aTZ())) ? false : true;
    }

    public void iL(boolean z) {
        c.aUd().iK(z);
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("no_longer_show_address", c.aUd().aUe());
    }

    public void bH(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aUd().getLocationData();
        if (locationData != null) {
            locationData.nX(str);
            locationData.nY(str2);
        }
    }

    public static void aUj() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aUk() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.erH.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.aUd().aUe()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void aUl() {
        if (this.erI == null) {
            aUf();
            registerListener(this.erI);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.erF = aVar;
    }

    public void a(b bVar) {
        this.erG = bVar;
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
