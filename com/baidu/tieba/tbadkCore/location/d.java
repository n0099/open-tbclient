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
    private a dcZ;
    private b dda;
    private BdBaseActivity ddb;
    private HttpMessageListener ddc;
    private com.baidu.adp.framework.listener.e ddd;
    private a.InterfaceC0003a dde;
    private CustomMessageListener ddf;

    /* loaded from: classes.dex */
    public interface a {
        void Bv();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fd(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Bw();

        void fe(String str);
    }

    private void ayt() {
        this.ddc = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void ayu() {
        if (ayw()) {
            if (this.dcZ != null) {
                this.dcZ.a(c.ayr().getLocationData());
            }
        } else if (i.iN()) {
            com.baidu.adp.lib.d.a.gC().a(true, this.dde);
        } else if (this.dcZ != null) {
            this.dcZ.Bv();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ddd = new e(this, 303017, true);
        this.dde = new f(this);
        this.ddf = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.ddb = baseActivity;
        registerListener(this.ddd);
        registerListener(this.ddf);
    }

    public void be(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.dcZ != null) {
                this.dcZ.fd(null);
                return;
            }
            return;
        }
        d(aVar);
        c.ayr().ah(System.currentTimeMillis());
        c.ayr().b(aVar);
        if (this.dcZ != null) {
            this.dcZ.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0078a> ayo;
        int i;
        int i2;
        if (aVar != null && (ayo = aVar.ayo()) != null && !ayo.isEmpty()) {
            int size = ayo.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (ayo.get(i3) != null) {
                    str = ayo.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    ayo.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.ayn())) {
                if (ayo.size() >= 1) {
                    aVar.lJ(ayo.get(0).getName());
                    aVar.lK(ayo.get(0).ayp());
                    return;
                }
                return;
            }
            for (a.C0078a c0078a : ayo) {
                if (aVar.ayn().equals(c0078a.getName())) {
                    aVar.lK(c0078a.ayp());
                    return;
                }
            }
        }
    }

    public boolean ayv() {
        return System.currentTimeMillis() - c.ayr().HB() > 300000;
    }

    public boolean ayw() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.ayr().getLocationData();
        return (ayv() || locationData == null || StringUtils.isNull(locationData.ayn())) ? false : true;
    }

    public void gB(boolean z) {
        c.ayr().gA(z);
        com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("no_longer_show_address", c.ayr().ays());
    }

    public void bf(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.ayr().getLocationData();
        if (locationData != null) {
            locationData.lJ(str);
            locationData.lK(str2);
        }
    }

    public static void ayx() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean ayy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.ddb.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.ayr().ays()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void ayz() {
        if (this.ddc == null) {
            ayt();
            registerListener(this.ddc);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.dcZ = aVar;
    }

    public void a(b bVar) {
        this.dda = bVar;
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
