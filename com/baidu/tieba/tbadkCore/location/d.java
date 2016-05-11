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
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private a euO;
    private b euP;
    private BdBaseActivity euQ;
    private HttpMessageListener euR;
    private com.baidu.adp.framework.listener.e euS;
    private a.InterfaceC0005a euT;
    private CustomMessageListener euU;

    /* loaded from: classes.dex */
    public interface a {
        void Cd();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fz(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Ce();

        void fA(String str);
    }

    private void aUA() {
        this.euR = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void aUB() {
        if (aUD()) {
            if (this.euO != null) {
                this.euO.a(c.aUz().getLocationData());
            }
        } else if (i.fq()) {
            if (ag.P(this.euQ.getActivity())) {
                com.baidu.adp.lib.e.a.cZ().a(true, this.euT);
            }
        } else if (this.euO != null) {
            this.euO.Cd();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.euS = new e(this, 303017, true);
        this.euT = new f(this);
        this.euU = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.euQ = baseActivity;
        registerListener(this.euS);
        registerListener(this.euU);
    }

    public void bL(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.euO != null) {
                this.euO.fz(null);
                return;
            }
            return;
        }
        d(aVar);
        c.aUz().setTimeStamp(System.currentTimeMillis());
        c.aUz().b(aVar);
        if (this.euO != null) {
            this.euO.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0077a> poi_info;
        int i;
        int i2;
        if (aVar != null && (poi_info = aVar.getPoi_info()) != null && !poi_info.isEmpty()) {
            int size = poi_info.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (poi_info.get(i3) != null) {
                    str = poi_info.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    poi_info.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.getFormatted_address())) {
                if (poi_info.size() >= 1) {
                    aVar.setFormatted_address(poi_info.get(0).getName());
                    aVar.setSn(poi_info.get(0).getSn());
                    return;
                }
                return;
            }
            for (a.C0077a c0077a : poi_info) {
                if (aVar.getFormatted_address().equals(c0077a.getName())) {
                    aVar.setSn(c0077a.getSn());
                    return;
                }
            }
        }
    }

    public boolean aUC() {
        return System.currentTimeMillis() - c.aUz().getTimeStamp() > 300000;
    }

    public boolean aUD() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aUz().getLocationData();
        return (aUC() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void jA(boolean z) {
        c.aUz().setNoLongerShowAddress(z);
        com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("no_longer_show_address", c.aUz().isNoLongerShowAddress());
    }

    public void bM(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.aUz().getLocationData();
        if (locationData != null) {
            locationData.setFormatted_address(str);
            locationData.setSn(str2);
        }
    }

    public static void aUE() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean aUF() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.euQ.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m11getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.aUz().isNoLongerShowAddress()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void aUG() {
        if (this.euR == null) {
            aUA();
            registerListener(this.euR);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", ThActivityDetailActivityConfig.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.euO = aVar;
    }

    public void a(b bVar) {
        this.euP = bVar;
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
