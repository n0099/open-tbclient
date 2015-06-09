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
    private j ctG;
    private k ctH;
    private BdBaseActivity ctI;
    private HttpMessageListener ctJ;
    private com.baidu.adp.framework.listener.e ctK;
    private com.baidu.adp.lib.d.d ctL;
    private CustomMessageListener ctM;

    private void apk() {
        this.ctJ = new i(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void apl() {
        if (apn()) {
            if (this.ctG != null) {
                this.ctG.a(d.api().getLocationData());
            }
        } else if (UtilHelper.isNetOk()) {
            com.baidu.adp.lib.d.a.gK().a(true, this.ctL);
        } else if (this.ctG != null) {
            this.ctG.JX();
        }
    }

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ctK = new f(this, 303017, true);
        this.ctL = new g(this);
        this.ctM = new h(this, 2001232);
        BdLog.addLogPackage(e.class.getPackage().getName());
        this.ctI = baseActivity;
        registerListener(this.ctK);
        registerListener(this.ctM);
    }

    public void bb(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        if (aVar == null) {
            if (this.ctG != null) {
                this.ctG.gh(null);
                return;
            }
            return;
        }
        d(aVar);
        d.api().N(System.currentTimeMillis());
        d.api().b(aVar);
        if (this.ctG != null) {
            this.ctG.a(aVar);
        }
    }

    private void d(a aVar) {
        List<b> apf;
        int i;
        int i2;
        if (aVar != null && (apf = aVar.apf()) != null && !apf.isEmpty()) {
            int size = apf.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (apf.get(i3) != null) {
                    str = apf.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    apf.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.ape())) {
                if (apf.size() >= 1) {
                    aVar.jD(apf.get(0).getName());
                    aVar.jE(apf.get(0).apg());
                    return;
                }
                return;
            }
            for (b bVar : apf) {
                if (aVar.ape().equals(bVar.getName())) {
                    aVar.jE(bVar.apg());
                    return;
                }
            }
        }
    }

    public boolean apm() {
        return System.currentTimeMillis() - d.api().Hl() > 300000;
    }

    public boolean apn() {
        a locationData = d.api().getLocationData();
        return (apm() || locationData == null || StringUtils.isNull(locationData.ape())) ? false : true;
    }

    public void fi(boolean z) {
        d.api().fh(z);
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("no_longer_show_address", d.api().apj());
    }

    public void bc(String str, String str2) {
        a locationData = d.api().getLocationData();
        if (locationData != null) {
            locationData.jD(str);
            locationData.jE(str2);
        }
    }

    public static void apo() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean app() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.ctI.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (d.api().apj()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void apq() {
        if (this.ctJ == null) {
            apk();
            registerListener(this.ctJ);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(j jVar) {
        this.ctG = jVar;
    }

    public void a(k kVar) {
        this.ctH = kVar;
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
