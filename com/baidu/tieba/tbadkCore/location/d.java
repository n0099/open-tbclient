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
    private a fxh;
    private b fxi;
    private BdBaseActivity fxj;
    private HttpMessageListener fxl;
    private com.baidu.adp.framework.listener.e fxm;
    private a.InterfaceC0005a fxn;
    private CustomMessageListener fxo;

    /* loaded from: classes.dex */
    public interface a {
        void DG();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fK(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DH();

        void fL(String str);
    }

    private void bkw() {
        this.fxl = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void bkx() {
        if (bkz()) {
            if (this.fxh != null) {
                this.fxh.a(c.bkv().getLocationData());
            }
        } else if (i.gm()) {
            if (ag.Y(this.fxj.getActivity())) {
                com.baidu.adp.lib.e.a.dU().a(true, this.fxn);
            }
        } else if (this.fxh != null) {
            this.fxh.DG();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fxm = new e(this, 303017, true);
        this.fxn = new f(this);
        this.fxo = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.fxj = baseActivity;
        registerListener(this.fxm);
        registerListener(this.fxo);
    }

    public void bU(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.fxh != null) {
                this.fxh.fK(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bkv().setTimeStamp(System.currentTimeMillis());
        c.bkv().b(aVar);
        if (this.fxh != null) {
            this.fxh.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0081a> poi_info;
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
            for (a.C0081a c0081a : poi_info) {
                if (aVar.getFormatted_address().equals(c0081a.getName())) {
                    aVar.setSn(c0081a.getSn());
                    return;
                }
            }
        }
    }

    public boolean bky() {
        return System.currentTimeMillis() - c.bkv().getTimeStamp() > 300000;
    }

    public boolean bkz() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bkv().getLocationData();
        return (bky() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void kO(boolean z) {
        c.bkv().setNoLongerShowAddress(z);
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("no_longer_show_address", c.bkv().isNoLongerShowAddress());
    }

    public void bV(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bkv().getLocationData();
        if (locationData != null) {
            locationData.setFormatted_address(str);
            locationData.setSn(str2);
        }
    }

    public static void bkA() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bkB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fxj.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bkv().isNoLongerShowAddress()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void bkC() {
        if (this.fxl == null) {
            bkw();
            registerListener(this.fxl);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", ThActivityDetailActivityConfig.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fxh = aVar;
    }

    public void a(b bVar) {
        this.fxi = bVar;
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
