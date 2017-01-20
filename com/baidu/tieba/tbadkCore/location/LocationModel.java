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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.List;
/* loaded from: classes.dex */
public class LocationModel extends BdBaseModel {
    private HttpMessageListener baR;
    private a frH;
    private b frI;
    private BdBaseActivity frJ;
    private com.baidu.adp.framework.listener.e frK;
    private a.InterfaceC0004a frL;
    private CustomMessageListener frM;

    /* loaded from: classes.dex */
    public interface a {
        void Do();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fG(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Dp();

        void fH(String str);
    }

    private void OM() {
        this.baR = new g(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void biv() {
        if (bix()) {
            if (this.frH != null) {
                this.frH.a(c.bit().getLocationData());
            }
        } else if (i.gk()) {
            if (ad.Y(this.frJ.getActivity())) {
                com.baidu.adp.lib.d.a.dS().a(true, this.frL);
            }
        } else if (this.frH != null) {
            this.frH.Do();
        }
    }

    public LocationModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.frK = new d(this, 303017, true);
        this.frL = new e(this);
        this.frM = new f(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(LocationModel.class.getPackage().getName());
        this.frJ = baseActivity;
        registerListener(this.frK);
        registerListener(this.frM);
    }

    public void ci(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.frH != null) {
                this.frH.fG(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bit().cx(System.currentTimeMillis());
        c.bit().b(aVar);
        if (this.frH != null) {
            this.frH.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0077a> biq;
        int i;
        int i2;
        if (aVar != null && (biq = aVar.biq()) != null && !biq.isEmpty()) {
            int size = biq.size();
            int i3 = 0;
            while (i3 < size) {
                String str = null;
                if (biq.get(i3) != null) {
                    str = biq.get(i3).getName();
                }
                if (StringUtils.isNull(str)) {
                    biq.remove(i3);
                    i = size - 1;
                    i2 = i3 - 1;
                } else {
                    i = size;
                    i2 = i3;
                }
                i3 = i2 + 1;
                size = i;
            }
            if (StringUtils.isNull(aVar.bip())) {
                if (biq.size() >= 1) {
                    aVar.qF(biq.get(0).getName());
                    aVar.qG(biq.get(0).bir());
                    return;
                }
                return;
            }
            for (a.C0077a c0077a : biq) {
                if (aVar.bip().equals(c0077a.getName())) {
                    aVar.qG(c0077a.bir());
                    return;
                }
            }
        }
    }

    public boolean biw() {
        return System.currentTimeMillis() - c.bit().ava() > ReportUserInfoModel.TIME_INTERVAL;
    }

    public boolean bix() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bit().getLocationData();
        return (biw() || locationData == null || StringUtils.isNull(locationData.bip())) ? false : true;
    }

    public void lk(boolean z) {
        c.bit().lj(z);
        com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("no_longer_show_address", c.bit().biu());
    }

    public void cj(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bit().getLocationData();
        if (locationData != null) {
            locationData.qF(str);
            locationData.qG(str2);
        }
    }

    public static void biy() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean OH() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.frJ.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bit().biu()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void OL() {
        if (this.baR == null) {
            OM();
            registerListener(this.baR);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.frH = aVar;
    }

    public void a(b bVar) {
        this.frI = bVar;
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
