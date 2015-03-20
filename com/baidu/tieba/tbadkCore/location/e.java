package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    private j cpo;
    private k cpp;
    private BdBaseActivity cpq;
    private HttpMessageListener cpr;
    private com.baidu.adp.framework.listener.e cps;
    private com.baidu.adp.lib.d.d cpt;
    private CustomMessageListener cpu;

    private void and() {
        this.cpr = new i(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void ane() {
        if (ang()) {
            if (this.cpo != null) {
                this.cpo.a(d.anb().getLocationData());
            }
        } else if (UtilHelper.isNetOk()) {
            com.baidu.adp.lib.d.a.gZ().a(true, this.cpt);
        } else if (this.cpo != null) {
            this.cpo.IQ();
        }
    }

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cps = new f(this, 303017, true);
        this.cpt = new g(this);
        this.cpu = new h(this, 2001232);
        BdLog.addLogPackage(e.class.getPackage().getName());
        this.cpq = baseActivity;
        registerListener(this.cps);
        registerListener(this.cpu);
    }

    public void aW(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        if (aVar == null) {
            if (this.cpo != null) {
                this.cpo.fE(null);
                return;
            }
            return;
        }
        d(aVar);
        d.anb().M(System.currentTimeMillis());
        d.anb().b(aVar);
        if (this.cpo != null) {
            this.cpo.a(aVar);
        }
    }

    private void d(a aVar) {
        List<b> amY;
        int i;
        int i2;
        if (aVar != null && (amY = aVar.amY()) != null && !amY.isEmpty()) {
            int size = amY.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (amY.get(i3) != null) {
                    str = amY.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    amY.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.amX())) {
                if (amY.size() >= 1) {
                    aVar.iG(amY.get(0).getName());
                    aVar.iH(amY.get(0).amZ());
                    return;
                }
                return;
            }
            for (b bVar : amY) {
                if (aVar.amX().equals(bVar.getName())) {
                    aVar.iH(bVar.amZ());
                    return;
                }
            }
        }
    }

    public boolean anf() {
        return System.currentTimeMillis() - d.anb().Gb() > 300000;
    }

    public boolean ang() {
        a locationData = d.anb().getLocationData();
        return (anf() || locationData == null || StringUtils.isNull(locationData.amX())) ? false : true;
    }

    public void eR(boolean z) {
        d.anb().eQ(z);
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("no_longer_show_address", d.anb().anc());
    }

    public void aX(String str, String str2) {
        a locationData = d.anb().getLocationData();
        if (locationData != null) {
            locationData.iG(str);
            locationData.iH(str2);
        }
    }

    public static void anh() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean ani() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cpq.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (d.anb().anc()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void anj() {
        if (this.cpr == null) {
            and();
            registerListener(this.cpr);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(j jVar) {
        this.cpo = jVar;
    }

    public void a(k kVar) {
        this.cpp = kVar;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
