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
    private HttpMessageListener bll;
    private a fEf;
    private b fEg;
    private BdBaseActivity fEh;
    private com.baidu.adp.framework.listener.e fEi;
    private a.InterfaceC0004a fEj;
    private CustomMessageListener fEk;

    /* loaded from: classes.dex */
    public interface a {
        void Dd();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fw(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void De();

        void fx(String str);
    }

    private void QL() {
        this.bll = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void biO() {
        if (biQ()) {
            if (this.fEf != null) {
                this.fEf.a(d.biM().getLocationData());
            }
        } else if (i.hk()) {
            if (ae.aB(this.fEh.getActivity())) {
                com.baidu.adp.lib.d.a.fg().a(true, this.fEj);
            }
        } else if (this.fEf != null) {
            this.fEf.Dd();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.fEi = new e(this, 303017, true);
        this.fEj = new f(this);
        this.fEk = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.fEh = baseActivity;
        registerListener(this.fEi);
        registerListener(this.fEk);
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
            if (this.fEf != null) {
                this.fEf.fw(null);
                return;
            }
            return;
        }
        d(aVar);
        d.biM().cp(System.currentTimeMillis());
        d.biM().b(aVar);
        if (this.fEf != null) {
            this.fEf.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0083a> biJ;
        int i;
        int i2;
        if (aVar != null && (biJ = aVar.biJ()) != null && !biJ.isEmpty()) {
            int size = biJ.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (biJ.get(i3) != null) {
                    str = biJ.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    biJ.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.biI())) {
                if (biJ.size() >= 1) {
                    aVar.qn(biJ.get(0).getName());
                    aVar.qo(biJ.get(0).biK());
                    return;
                }
                return;
            }
            for (a.C0083a c0083a : biJ) {
                if (aVar.biI().equals(c0083a.getName())) {
                    aVar.qo(c0083a.biK());
                    return;
                }
            }
        }
    }

    public boolean biP() {
        return System.currentTimeMillis() - d.biM().ath() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean biQ() {
        com.baidu.tieba.tbadkCore.location.a locationData = d.biM().getLocationData();
        return (biP() || locationData == null || StringUtils.isNull(locationData.biI())) ? false : true;
    }

    public void lv(boolean z) {
        d.biM().lu(z);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("no_longer_show_address", d.biM().biN());
    }

    public void cd(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = d.biM().getLocationData();
        if (locationData != null) {
            locationData.qn(str);
            locationData.qo(str2);
        }
    }

    public static void biR() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean QG() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fEh.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (d.biM().biN()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void QK() {
        if (this.bll == null) {
            QL();
            registerListener(this.bll);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.fEf = aVar;
    }

    public void a(b bVar) {
        this.fEg = bVar;
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
