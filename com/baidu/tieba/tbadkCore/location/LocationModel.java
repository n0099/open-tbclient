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
    private HttpMessageListener bhC;
    private a fwe;
    private b fwf;
    private BdBaseActivity fwg;
    private com.baidu.adp.framework.listener.e fwh;
    private a.InterfaceC0004a fwi;
    private CustomMessageListener fwj;

    /* loaded from: classes.dex */
    public interface a {
        void DH();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fv(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void DI();

        void fw(String str);
    }

    private void PG() {
        this.bhC = new g(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void bil() {
        if (bin()) {
            if (this.fwe != null) {
                this.fwe.a(c.bij().getLocationData());
            }
        } else if (i.he()) {
            if (ae.aw(this.fwg.getActivity())) {
                com.baidu.adp.lib.d.a.fa().a(true, this.fwi);
            }
        } else if (this.fwe != null) {
            this.fwe.DH();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fwh = new d(this, 303017, true);
        this.fwi = new e(this);
        this.fwj = new f(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.fwg = baseActivity;
        registerListener(this.fwh);
        registerListener(this.fwj);
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
            if (this.fwe != null) {
                this.fwe.fv(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bij().cz(System.currentTimeMillis());
        c.bij().b(aVar);
        if (this.fwe != null) {
            this.fwe.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0076a> big;
        int i;
        int i2;
        if (aVar != null && (big = aVar.big()) != null && !big.isEmpty()) {
            int size = big.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (big.get(i3) != null) {
                    str = big.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    big.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bif())) {
                if (big.size() >= 1) {
                    aVar.pN(big.get(0).getName());
                    aVar.pO(big.get(0).bih());
                    return;
                }
                return;
            }
            for (a.C0076a c0076a : big) {
                if (aVar.bif().equals(c0076a.getName())) {
                    aVar.pO(c0076a.bih());
                    return;
                }
            }
        }
    }

    public boolean bim() {
        return System.currentTimeMillis() - c.bij().auv() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bin() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bij().getLocationData();
        return (bim() || locationData == null || StringUtils.isNull(locationData.bif())) ? false : true;
    }

    public void lj(boolean z) {
        c.bij().li(z);
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("no_longer_show_address", c.bij().bik());
    }

    public void cd(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bij().getLocationData();
        if (locationData != null) {
            locationData.pN(str);
            locationData.pO(str2);
        }
    }

    public static void bio() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean PB() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fwg.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bij().bik()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void PF() {
        if (this.bhC == null) {
            PG();
            registerListener(this.bhC);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fwe = aVar;
    }

    public void a(b bVar) {
        this.fwf = bVar;
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
