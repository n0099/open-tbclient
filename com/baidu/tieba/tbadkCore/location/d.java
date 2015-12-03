package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.e.a;
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
    private a dBk;
    private b dBl;
    private BdBaseActivity dBm;
    private HttpMessageListener dBn;
    private com.baidu.adp.framework.listener.e dBo;
    private a.InterfaceC0003a dBp;
    private CustomMessageListener dBq;

    /* loaded from: classes.dex */
    public interface a {
        void Cv();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fs(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Cw();

        void ft(String str);
    }

    private void aDL() {
        this.dBn = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void aDM() {
        if (aDO()) {
            if (this.dBk != null) {
                this.dBk.a(c.aDJ().getLocationData());
            }
        } else if (i.iP()) {
            com.baidu.adp.lib.e.a.gD().a(true, this.dBp);
        } else if (this.dBk != null) {
            this.dBk.Cv();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dBo = new e(this, 303017, true);
        this.dBp = new f(this);
        this.dBq = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.dBm = baseActivity;
        registerListener(this.dBo);
        registerListener(this.dBq);
    }

    public void bh(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.dBk != null) {
                this.dBk.fs(null);
                return;
            }
            return;
        }
        d(aVar);
        c.aDJ().ap(System.currentTimeMillis());
        c.aDJ().b(aVar);
        if (this.dBk != null) {
            this.dBk.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0087a> aDG;
        int i;
        int i2;
        if (aVar != null && (aDG = aVar.aDG()) != null && !aDG.isEmpty()) {
            int size = aDG.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (aDG.get(i3) != null) {
                    str = aDG.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    aDG.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.aDF())) {
                if (aDG.size() >= 1) {
                    aVar.mx(aDG.get(0).getName());
                    aVar.my(aDG.get(0).aDH());
                    return;
                }
                return;
            }
            for (a.C0087a c0087a : aDG) {
                if (aVar.aDF().equals(c0087a.getName())) {
                    aVar.my(c0087a.aDH());
                    return;
                }
            }
        }
    }

    public boolean aDN() {
        return System.currentTimeMillis() - c.aDJ().IU() > 300000;
    }

    public boolean aDO() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aDJ().getLocationData();
        return (aDN() || locationData == null || StringUtils.isNull(locationData.aDF())) ? false : true;
    }

    public void hm(boolean z) {
        c.aDJ().hl(z);
        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("no_longer_show_address", c.aDJ().aDK());
    }

    public void bi(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aDJ().getLocationData();
        if (locationData != null) {
            locationData.mx(str);
            locationData.my(str2);
        }
    }

    public static void aDP() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aDQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.dBm.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.aDJ().aDK()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void aDR() {
        if (this.dBn == null) {
            aDL();
            registerListener(this.dBn);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.dBk = aVar;
    }

    public void a(b bVar) {
        this.dBl = bVar;
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
