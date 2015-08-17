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
    private a cKi;
    private b cKj;
    private BdBaseActivity cKk;
    private HttpMessageListener cKl;
    private com.baidu.adp.framework.listener.e cKm;
    private a.InterfaceC0003a cKn;
    private CustomMessageListener cKo;

    /* loaded from: classes.dex */
    public interface a {
        void BF();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void eO(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BG();

        void eP(String str);
    }

    private void aqE() {
        this.cKl = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void aqF() {
        if (aqH()) {
            if (this.cKi != null) {
                this.cKi.a(c.aqC().getLocationData());
            }
        } else if (com.baidu.adp.lib.util.i.iO()) {
            com.baidu.adp.lib.d.a.gF().a(true, this.cKn);
        } else if (this.cKi != null) {
            this.cKi.BF();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cKm = new e(this, 303017, true);
        this.cKn = new f(this);
        this.cKo = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.cKk = baseActivity;
        registerListener(this.cKm);
        registerListener(this.cKo);
    }

    public void bb(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.cKi != null) {
                this.cKi.eO(null);
                return;
            }
            return;
        }
        d(aVar);
        c.aqC().P(System.currentTimeMillis());
        c.aqC().b(aVar);
        if (this.cKi != null) {
            this.cKi.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0073a> aqz;
        int i;
        int i2;
        if (aVar != null && (aqz = aVar.aqz()) != null && !aqz.isEmpty()) {
            int size = aqz.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (aqz.get(i3) != null) {
                    str = aqz.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    aqz.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.aqy())) {
                if (aqz.size() >= 1) {
                    aVar.kw(aqz.get(0).getName());
                    aVar.kx(aqz.get(0).aqA());
                    return;
                }
                return;
            }
            for (a.C0073a c0073a : aqz) {
                if (aVar.aqy().equals(c0073a.getName())) {
                    aVar.kx(c0073a.aqA());
                    return;
                }
            }
        }
    }

    public boolean aqG() {
        return System.currentTimeMillis() - c.aqC().Ia() > 300000;
    }

    public boolean aqH() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aqC().getLocationData();
        return (aqG() || locationData == null || StringUtils.isNull(locationData.aqy())) ? false : true;
    }

    public void fA(boolean z) {
        c.aqC().fz(z);
        com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("no_longer_show_address", c.aqC().aqD());
    }

    public void bc(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aqC().getLocationData();
        if (locationData != null) {
            locationData.kw(str);
            locationData.kx(str2);
        }
    }

    public static void aqI() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aqJ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cKk.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.aqC().aqD()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void aqK() {
        if (this.cKl == null) {
            aqE();
            registerListener(this.cKl);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.cKi = aVar;
    }

    public void a(b bVar) {
        this.cKj = bVar;
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
