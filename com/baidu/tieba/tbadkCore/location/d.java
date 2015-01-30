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
    private i cam;
    private j can;
    private BdBaseActivity cao;
    private HttpMessageListener cap;
    private com.baidu.adp.framework.listener.e caq;
    private com.baidu.adp.lib.d.d car;
    private CustomMessageListener cas;

    private void aie() {
        this.cap = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void aif() {
        if (aih()) {
            if (this.cam != null) {
                this.cam.a(c.aic().getLocationData());
            }
        } else if (UtilHelper.isNetOk()) {
            com.baidu.adp.lib.d.a.dB().a(true, this.car);
        } else if (this.cam != null) {
            this.cam.Fx();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.caq = new e(this, 303017, true);
        this.car = new f(this);
        this.cas = new g(this, 2001232);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.cao = baseActivity;
        registerListener(this.caq);
        registerListener(this.cas);
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
            if (this.cam != null) {
                this.cam.fy(null);
                return;
            }
            return;
        }
        d(aVar);
        c.aic().H(System.currentTimeMillis());
        c.aic().b(aVar);
        if (this.cam != null) {
            this.cam.a(aVar);
        }
    }

    private void d(a aVar) {
        List<b> ahZ;
        int i;
        int i2;
        if (aVar != null && (ahZ = aVar.ahZ()) != null && !ahZ.isEmpty()) {
            int size = ahZ.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (ahZ.get(i3) != null) {
                    str = ahZ.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    ahZ.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.ahY())) {
                if (ahZ.size() >= 1) {
                    aVar.io(ahZ.get(0).getName());
                    aVar.ip(ahZ.get(0).aia());
                    return;
                }
                return;
            }
            for (b bVar : ahZ) {
                if (aVar.ahY().equals(bVar.getName())) {
                    aVar.ip(bVar.aia());
                    return;
                }
            }
        }
    }

    public boolean aig() {
        return System.currentTimeMillis() - c.aic().Dm() > 300000;
    }

    public boolean aih() {
        a locationData = c.aic().getLocationData();
        return (aig() || locationData == null || StringUtils.isNull(locationData.ahY())) ? false : true;
    }

    public void eE(boolean z) {
        c.aic().eD(z);
        com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("no_longer_show_address", c.aic().aid());
    }

    public void aS(String str, String str2) {
        a locationData = c.aic().getLocationData();
        if (locationData != null) {
            locationData.io(str);
            locationData.ip(str2);
        }
    }

    public static void aii() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aij() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.cao.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.aic().aid()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void aik() {
        if (this.cap == null) {
            aie();
            registerListener(this.cap);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(i iVar) {
        this.cam = iVar;
    }

    public void a(j jVar) {
        this.can = jVar;
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
