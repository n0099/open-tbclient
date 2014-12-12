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
    private i bYt;
    private j bYu;
    private BdBaseActivity bYv;
    private HttpMessageListener bYw;
    private com.baidu.adp.framework.listener.e bYx;
    private com.baidu.adp.lib.d.d bYy;
    private CustomMessageListener bYz;

    private void ahA() {
        this.bYw = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void ahB() {
        if (ahD()) {
            if (this.bYt != null) {
                this.bYt.a(c.ahy().getLocationData());
            }
        } else if (UtilHelper.isNetOk()) {
            com.baidu.adp.lib.d.a.dD().a(true, this.bYy);
        } else if (this.bYt != null) {
            this.bYt.EZ();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.bYx = new e(this, 303017, true);
        this.bYy = new f(this);
        this.bYz = new g(this, 2001232);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.bYv = baseActivity;
        registerListener(this.bYx);
        registerListener(this.bYz);
    }

    public void aO(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        if (aVar == null) {
            if (this.bYt != null) {
                this.bYt.ft(null);
                return;
            }
            return;
        }
        d(aVar);
        c.ahy().H(System.currentTimeMillis());
        c.ahy().b(aVar);
        if (this.bYt != null) {
            this.bYt.a(aVar);
        }
    }

    private void d(a aVar) {
        List<b> ahv;
        int i;
        int i2;
        if (aVar != null && (ahv = aVar.ahv()) != null && !ahv.isEmpty()) {
            int size = ahv.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (ahv.get(i3) != null) {
                    str = ahv.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    ahv.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.ahu())) {
                if (ahv.size() >= 1) {
                    aVar.ih(ahv.get(0).getName());
                    aVar.ii(ahv.get(0).ahw());
                    return;
                }
                return;
            }
            for (b bVar : ahv) {
                if (aVar.ahu().equals(bVar.getName())) {
                    aVar.ii(bVar.ahw());
                    return;
                }
            }
        }
    }

    public boolean ahC() {
        return System.currentTimeMillis() - c.ahy().CN() > 300000;
    }

    public boolean ahD() {
        a locationData = c.ahy().getLocationData();
        return (ahC() || locationData == null || StringUtils.isNull(locationData.ahu())) ? false : true;
    }

    public void ex(boolean z) {
        c.ahy().ew(z);
        com.baidu.tbadk.core.sharedPref.b.og().putBoolean("no_longer_show_address", c.ahy().ahz());
    }

    public void aP(String str, String str2) {
        a locationData = c.ahy().getLocationData();
        if (locationData != null) {
            locationData.ih(str);
            locationData.ii(str2);
        }
    }

    public static void ahE() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean ahF() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.bYv.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.ahy().ahz()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void ahG() {
        if (this.bYw == null) {
            ahA();
            registerListener(this.bYw);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(i iVar) {
        this.bYt = iVar;
    }

    public void a(j jVar) {
        this.bYu = jVar;
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
