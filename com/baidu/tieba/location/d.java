package com.baidu.tieba.location;

import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ai;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private i bmc;
    private j bmd;
    private BdBaseActivity bme;
    private HttpMessageListener bmf;
    private com.baidu.adp.framework.listener.e bmg;
    private com.baidu.adp.lib.d.d bmh;
    private CustomMessageListener bmi;

    private void St() {
        this.bmf = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void Su() {
        if (Sw()) {
            if (this.bmc != null) {
                this.bmc.a(c.Sr().getLocationData());
            }
        } else if (UtilHelper.isNetOk()) {
            com.baidu.adp.lib.d.a.dE().a(true, this.bmh);
        } else if (this.bmc != null) {
            this.bmc.EI();
        }
    }

    public d(BdBaseActivity bdBaseActivity) {
        super(bdBaseActivity);
        this.bmg = new e(this, 303017, true);
        this.bmh = new f(this);
        this.bmi = new g(this, 2001232);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.bme = bdBaseActivity;
        registerListener(this.bmg);
        registerListener(this.bmi);
    }

    public void ax(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        if (aVar == null) {
            if (this.bmc != null) {
                this.bmc.eY(null);
                return;
            }
            return;
        }
        d(aVar);
        c.Sr().V(System.currentTimeMillis());
        c.Sr().b(aVar);
        if (this.bmc != null) {
            this.bmc.a(aVar);
        }
    }

    private void d(a aVar) {
        List<b> Sp;
        int i;
        int i2;
        if (aVar != null && (Sp = aVar.Sp()) != null && !Sp.isEmpty()) {
            int size = Sp.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (Sp.get(i3) != null) {
                    str = Sp.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    Sp.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.So()) && Sp.size() >= 1) {
                aVar.gK(Sp.get(0).getName());
            }
        }
    }

    public boolean Sv() {
        return System.currentTimeMillis() - c.Sr().KI() > 300000;
    }

    public boolean Sw() {
        a locationData = c.Sr().getLocationData();
        return (Sv() || locationData == null || StringUtils.isNull(locationData.So())) ? false : true;
    }

    public void dx(boolean z) {
        c.Sr().dw(z);
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("no_longer_show_address", c.Sr().Ss());
    }

    public void gL(String str) {
        a locationData = c.Sr().getLocationData();
        if (locationData != null) {
            locationData.gK(str);
        }
    }

    public static void Sx() {
        ai.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean Sy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.bme)) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.Sr().Ss()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void Sz() {
        if (this.bmf == null) {
            St();
            registerListener(this.bmf);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(i iVar) {
        this.bmc = iVar;
    }

    public void a(j jVar) {
        this.bmd = jVar;
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
