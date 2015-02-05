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
public class d extends com.baidu.adp.base.f {
    private i cal;
    private j cam;
    private BdBaseActivity can;
    private HttpMessageListener cao;
    private com.baidu.adp.framework.listener.e cap;
    private com.baidu.adp.lib.d.d caq;
    private CustomMessageListener car;

    private void ahZ() {
        this.cao = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void aia() {
        if (aic()) {
            if (this.cal != null) {
                this.cal.a(c.ahX().getLocationData());
            }
        } else if (UtilHelper.isNetOk()) {
            com.baidu.adp.lib.d.a.dB().a(true, this.caq);
        } else if (this.cal != null) {
            this.cal.Fr();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cap = new e(this, 303017, true);
        this.caq = new f(this);
        this.car = new g(this, 2001232);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.can = baseActivity;
        registerListener(this.cap);
        registerListener(this.car);
    }

    public void aR(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        if (aVar == null) {
            if (this.cal != null) {
                this.cal.fv(null);
                return;
            }
            return;
        }
        d(aVar);
        c.ahX().H(System.currentTimeMillis());
        c.ahX().b(aVar);
        if (this.cal != null) {
            this.cal.a(aVar);
        }
    }

    private void d(a aVar) {
        List<b> ahU;
        int i;
        int i2;
        if (aVar != null && (ahU = aVar.ahU()) != null && !ahU.isEmpty()) {
            int size = ahU.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (ahU.get(i3) != null) {
                    str = ahU.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    ahU.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.ahT())) {
                if (ahU.size() >= 1) {
                    aVar.im(ahU.get(0).getName());
                    aVar.in(ahU.get(0).ahV());
                    return;
                }
                return;
            }
            for (b bVar : ahU) {
                if (aVar.ahT().equals(bVar.getName())) {
                    aVar.in(bVar.ahV());
                    return;
                }
            }
        }
    }

    public boolean aib() {
        return System.currentTimeMillis() - c.ahX().Dg() > 300000;
    }

    public boolean aic() {
        a locationData = c.ahX().getLocationData();
        return (aib() || locationData == null || StringUtils.isNull(locationData.ahT())) ? false : true;
    }

    public void eE(boolean z) {
        c.ahX().eD(z);
        com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("no_longer_show_address", c.ahX().ahY());
    }

    public void aS(String str, String str2) {
        a locationData = c.ahX().getLocationData();
        if (locationData != null) {
            locationData.im(str);
            locationData.in(str2);
        }
    }

    public static void aid() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aie() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.can.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.ahX().ahY()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void aif() {
        if (this.cao == null) {
            ahZ();
            registerListener(this.cao);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(i iVar) {
        this.cal = iVar;
    }

    public void a(j jVar) {
        this.cam = jVar;
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
