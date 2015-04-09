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
    private j cpE;
    private k cpF;
    private BdBaseActivity cpG;
    private HttpMessageListener cpH;
    private com.baidu.adp.framework.listener.e cpI;
    private com.baidu.adp.lib.d.d cpJ;
    private CustomMessageListener cpK;

    private void ans() {
        this.cpH = new i(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void ant() {
        if (anv()) {
            if (this.cpE != null) {
                this.cpE.a(d.anq().getLocationData());
            }
        } else if (UtilHelper.isNetOk()) {
            com.baidu.adp.lib.d.a.gZ().a(true, this.cpJ);
        } else if (this.cpE != null) {
            this.cpE.IW();
        }
    }

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cpI = new f(this, 303017, true);
        this.cpJ = new g(this);
        this.cpK = new h(this, 2001232);
        BdLog.addLogPackage(e.class.getPackage().getName());
        this.cpG = baseActivity;
        registerListener(this.cpI);
        registerListener(this.cpK);
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
            if (this.cpE != null) {
                this.cpE.fH(null);
                return;
            }
            return;
        }
        d(aVar);
        d.anq().M(System.currentTimeMillis());
        d.anq().b(aVar);
        if (this.cpE != null) {
            this.cpE.a(aVar);
        }
    }

    private void d(a aVar) {
        List<b> ann;
        int i;
        int i2;
        if (aVar != null && (ann = aVar.ann()) != null && !ann.isEmpty()) {
            int size = ann.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (ann.get(i3) != null) {
                    str = ann.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    ann.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.anm())) {
                if (ann.size() >= 1) {
                    aVar.iJ(ann.get(0).getName());
                    aVar.iK(ann.get(0).ano());
                    return;
                }
                return;
            }
            for (b bVar : ann) {
                if (aVar.anm().equals(bVar.getName())) {
                    aVar.iK(bVar.ano());
                    return;
                }
            }
        }
    }

    public boolean anu() {
        return System.currentTimeMillis() - d.anq().Gh() > 300000;
    }

    public boolean anv() {
        a locationData = d.anq().getLocationData();
        return (anu() || locationData == null || StringUtils.isNull(locationData.anm())) ? false : true;
    }

    public void eP(boolean z) {
        d.anq().eO(z);
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("no_longer_show_address", d.anq().anr());
    }

    public void aX(String str, String str2) {
        a locationData = d.anq().getLocationData();
        if (locationData != null) {
            locationData.iJ(str);
            locationData.iK(str2);
        }
    }

    public static void anw() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean anx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cpG.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (d.anq().anr()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void any() {
        if (this.cpH == null) {
            ans();
            registerListener(this.cpH);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(j jVar) {
        this.cpE = jVar;
    }

    public void a(k kVar) {
        this.cpF = kVar;
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
