package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<d> {
    private com.baidu.adp.framework.listener.a aQK = new e(this, CmdConfigHttp.CMD_SKIN_DETAIL, 309012);
    private a dgu;
    private com.baidu.tieba.themeCenter.b mSkinData;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.themeCenter.b bVar);
    }

    public d() {
        com.baidu.tieba.tbadkCore.a.a.a(309012, SkinDetailSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309012, CmdConfigHttp.CMD_SKIN_DETAIL, TbConfig.SKIN_DETAIL_PAGE, SkinDetailHttpResponsedMessage.class, false, false, false, false);
        registerListener(this.aQK);
    }

    public void ly(int i) {
        SkinDetailReauestMessage skinDetailReauestMessage = new SkinDetailReauestMessage();
        skinDetailReauestMessage.setThemeId(i);
        sendMessage(skinDetailReauestMessage);
    }

    public void a(a aVar) {
        this.dgu = aVar;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aQK);
    }
}
