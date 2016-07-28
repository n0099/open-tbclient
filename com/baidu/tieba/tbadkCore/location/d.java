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
    private a fmH;
    private b fmI;
    private BdBaseActivity fmJ;
    private HttpMessageListener fmK;
    private com.baidu.adp.framework.listener.e fmL;
    private a.InterfaceC0005a fmM;
    private CustomMessageListener fmN;

    /* loaded from: classes.dex */
    public interface a {
        void Cl();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fD(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Cm();

        void fE(String str);
    }

    private void bgj() {
        this.fmK = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void bgk() {
        if (bgm()) {
            if (this.fmH != null) {
                this.fmH.a(c.bgi().getLocationData());
            }
        } else if (i.fq()) {
            if (ag.O(this.fmJ.getActivity())) {
                com.baidu.adp.lib.e.a.cZ().a(true, this.fmM);
            }
        } else if (this.fmH != null) {
            this.fmH.Cl();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fmL = new e(this, 303017, true);
        this.fmM = new f(this);
        this.fmN = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.fmJ = baseActivity;
        registerListener(this.fmL);
        registerListener(this.fmN);
    }

    public void bS(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.fmH != null) {
                this.fmH.fD(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bgi().setTimeStamp(System.currentTimeMillis());
        c.bgi().b(aVar);
        if (this.fmH != null) {
            this.fmH.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0078a> poi_info;
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
            for (a.C0078a c0078a : poi_info) {
                if (aVar.getFormatted_address().equals(c0078a.getName())) {
                    aVar.setSn(c0078a.getSn());
                    return;
                }
            }
        }
    }

    public boolean bgl() {
        return System.currentTimeMillis() - c.bgi().getTimeStamp() > 300000;
    }

    public boolean bgm() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bgi().getLocationData();
        return (bgl() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void kz(boolean z) {
        c.bgi().setNoLongerShowAddress(z);
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("no_longer_show_address", c.bgi().isNoLongerShowAddress());
    }

    public void bT(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bgi().getLocationData();
        if (locationData != null) {
            locationData.setFormatted_address(str);
            locationData.setSn(str2);
        }
    }

    public static void bgn() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bgo() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fmJ.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m10getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bgi().isNoLongerShowAddress()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void bgp() {
        if (this.fmK == null) {
            bgj();
            registerListener(this.fmK);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", ThActivityDetailActivityConfig.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fmH = aVar;
    }

    public void a(b bVar) {
        this.fmI = bVar;
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
