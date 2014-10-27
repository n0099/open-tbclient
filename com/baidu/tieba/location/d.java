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
    private i blO;
    private j blP;
    private BdBaseActivity blQ;
    private HttpMessageListener blR;
    private com.baidu.adp.framework.listener.e blS;
    private com.baidu.adp.lib.d.d blT;
    private CustomMessageListener blU;

    private void Sq() {
        this.blR = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void Sr() {
        if (St()) {
            if (this.blO != null) {
                this.blO.a(c.So().getLocationData());
            }
        } else if (UtilHelper.isNetOk()) {
            com.baidu.adp.lib.d.a.dE().a(true, this.blT);
        } else if (this.blO != null) {
            this.blO.EG();
        }
    }

    public d(BdBaseActivity bdBaseActivity) {
        super(bdBaseActivity);
        this.blS = new e(this, 303017, true);
        this.blT = new f(this);
        this.blU = new g(this, 2001232);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.blQ = bdBaseActivity;
        registerListener(this.blS);
        registerListener(this.blU);
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
            if (this.blO != null) {
                this.blO.eY(null);
                return;
            }
            return;
        }
        d(aVar);
        c.So().V(System.currentTimeMillis());
        c.So().b(aVar);
        if (this.blO != null) {
            this.blO.a(aVar);
        }
    }

    private void d(a aVar) {
        List<b> Sm;
        int i;
        int i2;
        if (aVar != null && (Sm = aVar.Sm()) != null && !Sm.isEmpty()) {
            int size = Sm.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (Sm.get(i3) != null) {
                    str = Sm.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    Sm.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.Sl()) && Sm.size() >= 1) {
                aVar.gK(Sm.get(0).getName());
            }
        }
    }

    public boolean Ss() {
        return System.currentTimeMillis() - c.So().KE() > 300000;
    }

    public boolean St() {
        a locationData = c.So().getLocationData();
        return (Ss() || locationData == null || StringUtils.isNull(locationData.Sl())) ? false : true;
    }

    public void dx(boolean z) {
        c.So().dw(z);
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("no_longer_show_address", c.So().Sp());
    }

    public void gL(String str) {
        a locationData = c.So().getLocationData();
        if (locationData != null) {
            locationData.gK(str);
        }
    }

    public static void Su() {
        ai.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean Sv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.blQ)) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.So().Sp()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void Sw() {
        if (this.blR == null) {
            Sq();
            registerListener(this.blR);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(i iVar) {
        this.blO = iVar;
    }

    public void a(j jVar) {
        this.blP = jVar;
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
