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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener bke;
    private a fwn;
    private b fwo;
    private BdBaseActivity fwp;
    private com.baidu.adp.framework.listener.e fwq;
    private a.InterfaceC0004a fwr;
    private CustomMessageListener fws;

    /* loaded from: classes.dex */
    public interface a {
        void Dj();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fy(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Dk();

        void fz(String str);
    }

    private void Qz() {
        this.bke = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void bhu() {
        if (bhw()) {
            if (this.fwn != null) {
                this.fwn.a(d.bhs().getLocationData());
            }
        } else if (i.hk()) {
            if (ae.aB(this.fwp.getActivity())) {
                com.baidu.adp.lib.d.a.fg().a(true, this.fwr);
            }
        } else if (this.fwn != null) {
            this.fwn.Dj();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fwq = new e(this, 303017, true);
        this.fwr = new f(this);
        this.fws = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.fwp = baseActivity;
        registerListener(this.fwq);
        registerListener(this.fws);
    }

    public void cc(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.fwn != null) {
                this.fwn.fy(null);
                return;
            }
            return;
        }
        d(aVar);
        d.bhs().ck(System.currentTimeMillis());
        d.bhs().b(aVar);
        if (this.fwn != null) {
            this.fwn.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0081a> bhp;
        int i;
        int i2;
        if (aVar != null && (bhp = aVar.bhp()) != null && !bhp.isEmpty()) {
            int size = bhp.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (bhp.get(i3) != null) {
                    str = bhp.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    bhp.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bho())) {
                if (bhp.size() >= 1) {
                    aVar.pZ(bhp.get(0).getName());
                    aVar.qa(bhp.get(0).bhq());
                    return;
                }
                return;
            }
            for (a.C0081a c0081a : bhp) {
                if (aVar.bho().equals(c0081a.getName())) {
                    aVar.qa(c0081a.bhq());
                    return;
                }
            }
        }
    }

    public boolean bhv() {
        return System.currentTimeMillis() - d.bhs().ask() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bhw() {
        com.baidu.tieba.tbadkCore.location.a locationData = d.bhs().getLocationData();
        return (bhv() || locationData == null || StringUtils.isNull(locationData.bho())) ? false : true;
    }

    public void la(boolean z) {
        d.bhs().kZ(z);
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("no_longer_show_address", d.bhs().bht());
    }

    public void cd(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = d.bhs().getLocationData();
        if (locationData != null) {
            locationData.pZ(str);
            locationData.qa(str2);
        }
    }

    public static void bhx() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean Qu() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fwp.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (d.bhs().bht()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void Qy() {
        if (this.bke == null) {
            Qz();
            registerListener(this.bke);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fwn = aVar;
    }

    public void a(b bVar) {
        this.fwo = bVar;
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
