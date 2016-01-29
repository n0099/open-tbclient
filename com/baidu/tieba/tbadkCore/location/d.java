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
    private a dYN;
    private b dYO;
    private BdBaseActivity dYP;
    private HttpMessageListener dYQ;
    private com.baidu.adp.framework.listener.e dYR;
    private a.InterfaceC0004a dYS;
    private CustomMessageListener dYT;

    /* loaded from: classes.dex */
    public interface a {
        void DA();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fu(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DB();

        void fv(String str);
    }

    private void aNd() {
        this.dYQ = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void aNe() {
        if (aNg()) {
            if (this.dYN != null) {
                this.dYN.a(c.aNb().getLocationData());
            }
        } else if (i.iZ()) {
            com.baidu.adp.lib.e.a.gL().a(true, this.dYS);
        } else if (this.dYN != null) {
            this.dYN.DA();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.dYR = new e(this, 303017, true);
        this.dYS = new f(this);
        this.dYT = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.dYP = baseActivity;
        registerListener(this.dYR);
        registerListener(this.dYT);
    }

    public void bo(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.dYN != null) {
                this.dYN.fu(null);
                return;
            }
            return;
        }
        d(aVar);
        c.aNb().bQ(System.currentTimeMillis());
        c.aNb().b(aVar);
        if (this.dYN != null) {
            this.dYN.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0087a> aMY;
        int i;
        int i2;
        if (aVar != null && (aMY = aVar.aMY()) != null && !aMY.isEmpty()) {
            int size = aMY.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (aMY.get(i3) != null) {
                    str = aMY.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    aMY.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.aMX())) {
                if (aMY.size() >= 1) {
                    aVar.mL(aMY.get(0).getName());
                    aVar.mM(aMY.get(0).aMZ());
                    return;
                }
                return;
            }
            for (a.C0087a c0087a : aMY) {
                if (aVar.aMX().equals(c0087a.getName())) {
                    aVar.mM(c0087a.aMZ());
                    return;
                }
            }
        }
    }

    public boolean aNf() {
        return System.currentTimeMillis() - c.aNb().afI() > 300000;
    }

    public boolean aNg() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aNb().getLocationData();
        return (aNf() || locationData == null || StringUtils.isNull(locationData.aMX())) ? false : true;
    }

    public void hW(boolean z) {
        c.aNb().hV(z);
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("no_longer_show_address", c.aNb().aNc());
    }

    public void bp(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aNb().getLocationData();
        if (locationData != null) {
            locationData.mL(str);
            locationData.mM(str2);
        }
    }

    public static void aNh() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aNi() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.dYP.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.aNb().aNc()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void aNj() {
        if (this.dYQ == null) {
            aNd();
            registerListener(this.dYQ);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.dYN = aVar;
    }

    public void a(b bVar) {
        this.dYO = bVar;
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
