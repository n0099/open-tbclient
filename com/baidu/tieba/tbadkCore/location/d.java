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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private a fEn;
    private b fEo;
    private BdBaseActivity fEp;
    private HttpMessageListener fEq;
    private com.baidu.adp.framework.listener.e fEr;
    private a.InterfaceC0005a fEs;
    private CustomMessageListener fEt;

    /* loaded from: classes.dex */
    public interface a {
        void DL();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fN(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DM();

        void fO(String str);
    }

    private void bmM() {
        this.fEq = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void bmN() {
        if (bmP()) {
            if (this.fEn != null) {
                this.fEn.a(c.bmL().getLocationData());
            }
        } else if (i.gm()) {
            if (ae.Y(this.fEp.getActivity())) {
                com.baidu.adp.lib.e.a.dU().a(true, this.fEs);
            }
        } else if (this.fEn != null) {
            this.fEn.DL();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fEr = new e(this, 303017, true);
        this.fEs = new f(this);
        this.fEt = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.fEp = baseActivity;
        registerListener(this.fEr);
        registerListener(this.fEt);
    }

    public void bW(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.fEn != null) {
                this.fEn.fN(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bmL().setTimeStamp(System.currentTimeMillis());
        c.bmL().b(aVar);
        if (this.fEn != null) {
            this.fEn.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0082a> poi_info;
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
            for (a.C0082a c0082a : poi_info) {
                if (aVar.getFormatted_address().equals(c0082a.getName())) {
                    aVar.setSn(c0082a.getSn());
                    return;
                }
            }
        }
    }

    public boolean bmO() {
        return System.currentTimeMillis() - c.bmL().getTimeStamp() > 300000;
    }

    public boolean bmP() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bmL().getLocationData();
        return (bmO() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void ln(boolean z) {
        c.bmL().setNoLongerShowAddress(z);
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("no_longer_show_address", c.bmL().isNoLongerShowAddress());
    }

    public void bX(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bmL().getLocationData();
        if (locationData != null) {
            locationData.setFormatted_address(str);
            locationData.setSn(str2);
        }
    }

    public static void bmQ() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bmR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fEp.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bmL().isNoLongerShowAddress()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void bmS() {
        if (this.fEq == null) {
            bmM();
            registerListener(this.fEq);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", ThActivityDetailActivityConfig.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fEn = aVar;
    }

    public void a(b bVar) {
        this.fEo = bVar;
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
