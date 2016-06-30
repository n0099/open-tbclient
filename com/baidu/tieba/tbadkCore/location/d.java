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
    private a eZE;
    private b eZF;
    private BdBaseActivity eZG;
    private HttpMessageListener eZH;
    private com.baidu.adp.framework.listener.e eZI;
    private a.InterfaceC0005a eZJ;
    private CustomMessageListener eZK;

    /* loaded from: classes.dex */
    public interface a {
        void Cm();

        void a(com.baidu.tieba.tbadkCore.location.a aVar);

        void fF(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Cn();

        void fG(String str);
    }

    private void bcU() {
        this.eZH = new h(this, CmdConfigHttp.SET_PRIVATE_CMD);
    }

    public void bcV() {
        if (bcX()) {
            if (this.eZE != null) {
                this.eZE.a(c.bcT().getLocationData());
            }
        } else if (i.fr()) {
            if (ag.O(this.eZG.getActivity())) {
                com.baidu.adp.lib.e.a.da().a(true, this.eZJ);
            }
        } else if (this.eZE != null) {
            this.eZE.Cm();
        }
    }

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.eZI = new e(this, 303017, true);
        this.eZJ = new f(this);
        this.eZK = new g(this, CmdConfigCustom.CMD_SELECT_LOCATION);
        BdLog.addLogPackage(d.class.getPackage().getName());
        this.eZG = baseActivity;
        registerListener(this.eZI);
        registerListener(this.eZK);
    }

    public void bN(String str, String str2) {
        LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
        locationSocketRequestMessage.setLat(str2);
        locationSocketRequestMessage.setLng(str);
        sendMessage(locationSocketRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null) {
            if (this.eZE != null) {
                this.eZE.fF(null);
                return;
            }
            return;
        }
        d(aVar);
        c.bcT().setTimeStamp(System.currentTimeMillis());
        c.bcT().b(aVar);
        if (this.eZE != null) {
            this.eZE.a(aVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.location.a aVar) {
        List<a.C0079a> poi_info;
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
            for (a.C0079a c0079a : poi_info) {
                if (aVar.getFormatted_address().equals(c0079a.getName())) {
                    aVar.setSn(c0079a.getSn());
                    return;
                }
            }
        }
    }

    public boolean bcW() {
        return System.currentTimeMillis() - c.bcT().getTimeStamp() > 300000;
    }

    public boolean bcX() {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bcT().getLocationData();
        return (bcW() || locationData == null || StringUtils.isNull(locationData.getFormatted_address())) ? false : true;
    }

    public void kl(boolean z) {
        c.bcT().setNoLongerShowAddress(z);
        com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("no_longer_show_address", c.bcT().isNoLongerShowAddress());
    }

    public void bO(String str, String str2) {
        com.baidu.tieba.tbadkCore.location.a locationData = c.bcT().getLocationData();
        if (locationData != null) {
            locationData.setFormatted_address(str);
            locationData.setSn(str2);
        }
    }

    public static void bcY() {
        com.baidu.tieba.tbadkCore.a.a.a(303017, LocationSocketResponsedMessage.class, false, false);
    }

    public boolean bcZ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eZG.getPageContext().getPageActivity())) {
            BdLog.i("canDoLocationRequest:system location not enabled!");
            return false;
        } else if (!TbadkCoreApplication.m9getInst().getLocationShared()) {
            BdLog.i("canDoLocationRequest:location setting is not shared!");
            return false;
        } else if (c.bcT().isNoLongerShowAddress()) {
            BdLog.i("canDoLocationRequest:no longer show address!");
            return false;
        } else {
            return true;
        }
    }

    public void bda() {
        if (this.eZH == null) {
            bcU();
            registerListener(this.eZH);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", ThActivityDetailActivityConfig.LOCATION);
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.eZE = aVar;
    }

    public void a(b bVar) {
        this.eZF = bVar;
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
