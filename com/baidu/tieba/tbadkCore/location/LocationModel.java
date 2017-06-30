package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener bpb;
    private a fOk;
    private b fOl;
    private BdBaseActivity fOm;
    private com.baidu.adp.framework.listener.e fOn;
    private a.InterfaceC0004a fOo;
    private CustomMessageListener fOp;

    /* loaded from: classes.dex */
    public interface a {
        void Dx();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fQ(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Dy();

        void fR(String str);
    }

    private void SD() {
        this.bpb = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void bnc() {
        if (bne()) {
            if (this.fOk != null) {
                this.fOk.a(d.bna().getLocationData());
            }
        } else if (i.hj()) {
            if (ag.aB(this.fOm.getActivity())) {
                com.baidu.adp.lib.d.a.ff().a(true, this.fOo);
            }
        } else if (this.fOk != null) {
            this.fOk.Dx();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fOn = new e(this, 303017, true);
        this.fOo = new f(this);
        this.fOp = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.fOm = baseActivity;
        registerListener(this.fOn);
        registerListener(this.fOp);
    }

    public void cg(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.fOk != null) {
                this.fOk.fQ(null);
                return;
            }
            return;
        }
        d(aVar);
        d.bna().cE(System.currentTimeMillis());
        d.bna().b(aVar);
        if (this.fOk != null) {
            this.fOk.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0086a> bmX;
        int i;
        int i2;
        if (aVar != null && (bmX = aVar.bmX()) != null && !bmX.isEmpty()) {
            int size = bmX.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bmX.get(i3) != null) {
                    str = bmX.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bmX.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bmW())) {
                if (bmX.size() >= 1) {
                    aVar.rl(bmX.get(0).getName());
                    aVar.rm(bmX.get(0).bmY());
                    return;
                }
                return;
            }
            for (a.C0086a c0086a : bmX) {
                if (aVar.bmW().equals(c0086a.getName())) {
                    aVar.rm(c0086a.bmY());
                    return;
                }
            }
        }
    }

    public boolean bnd() {
        return System.currentTimeMillis() - d.bna().bkj() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bne() {
        com.baidu.tieba.tbadkCore.location.a locationData = d.bna().getLocationData();
        return (bnd() || locationData == null || StringUtils.isNull(locationData.bmW())) ? false : true;
    }

    public void lU(boolean z) {
        d.bna().lT(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", d.bna().bnb());
    }

    public void ch(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = d.bna().getLocationData();
        if (locationData != null) {
            locationData.rl(str);
            locationData.rm(str2);
        }
    }

    public static void bnf() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean Sy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fOm.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (d.bna().bnb()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void SC() {
        if (this.bpb == null) {
            SD();
            registerListener(this.bpb);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fOk = aVar;
    }

    public void a(b bVar) {
        this.fOl = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
