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
    private j ctF;
    private k ctG;
    private BdBaseActivity ctH;
    private HttpMessageListener ctI;
    private com.baidu.adp.framework.listener.e ctJ;
    private com.baidu.adp.lib.d.d ctK;
    private CustomMessageListener ctL;

    private void apj() {
        this.ctI = new i(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void apk() {
        if (apm()) {
            if (this.ctF != null) {
                this.ctF.a(d.aph().getLocationData());
            }
        } else if (UtilHelper.isNetOk()) {
            com.baidu.adp.lib.d.a.gK().a(true, this.ctK);
        } else if (this.ctF != null) {
            this.ctF.JW();
        }
    }

    public e(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ctJ = new f(this, 303017, true);
        this.ctK = new g(this);
        this.ctL = new h(this, 2001232);
        BdLog.addLogPackage(e.class.getPackage().getName());
        this.ctH = baseActivity;
        registerListener(this.ctJ);
        registerListener(this.ctL);
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
            if (this.ctF != null) {
                this.ctF.gh(null);
                return;
            }
            return;
        }
        d(aVar);
        d.aph().N(System.currentTimeMillis());
        d.aph().b(aVar);
        if (this.ctF != null) {
            this.ctF.a(aVar);
        }
    }

    private void d(a aVar) {
        List<b> ape;
        int i;
        int i2;
        if (aVar != null && (ape = aVar.ape()) != null && !ape.isEmpty()) {
            int size = ape.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (ape.get(i3) != null) {
                    str = ape.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    ape.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.apd())) {
                if (ape.size() >= 1) {
                    aVar.jD(ape.get(0).getName());
                    aVar.jE(ape.get(0).apf());
                    return;
                }
                return;
            }
            for (b bVar : ape) {
                if (aVar.apd().equals(bVar.getName())) {
                    aVar.jE(bVar.apf());
                    return;
                }
            }
        }
    }

    public boolean apl() {
        return System.currentTimeMillis() - d.aph().Hk() > 300000;
    }

    public boolean apm() {
        a locationData = d.aph().getLocationData();
        return (apl() || locationData == null || StringUtils.isNull(locationData.apd())) ? false : true;
    }

    public void fi(boolean z) {
        d.aph().fh(z);
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("no_longer_show_address", d.aph().api());
    }

    public void bc(String str, String str2) {
        a locationData = d.aph().getLocationData();
        if (locationData != null) {
            locationData.jD(str);
            locationData.jE(str2);
        }
    }

    public static void apn() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean apo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.ctH.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (d.aph().api()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void app() {
        if (this.ctI == null) {
            apj();
            registerListener(this.ctI);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(j jVar) {
        this.ctF = jVar;
    }

    public void a(k kVar) {
        this.ctG = kVar;
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
