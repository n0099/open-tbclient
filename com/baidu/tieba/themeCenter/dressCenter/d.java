package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<d> {
    private com.baidu.adp.framework.listener.a aQK = new e(this, CmdConfigHttp.CMD_DRESSUP_CENTER, 309001);
    private a dfK;
    private k mRecommand;
    private List<b> mThemeCarouselList;
    private List<j> mThemeList;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, List<b> list, k kVar, List<j> list2);
    }

    public d() {
        BZ();
        registerListener(this.aQK);
    }

    private void BZ() {
        com.baidu.tieba.tbadkCore.a.a.a(309001, DressupCenterSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309001, CmdConfigHttp.CMD_DRESSUP_CENTER, TbConfig.DRESSUP_CENTER_PAGE, DressupCenterHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        sendMessage(new DressupCenterRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dfK = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aQK);
    }
}
