package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.themeCenter.dressCenter.k;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<d> {
    private List<com.baidu.tieba.themeCenter.b> dgA;
    private a dgE;
    private k mRecommand;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private com.baidu.adp.framework.listener.a aQV = new e(this, CmdConfigHttp.CMD_TOP_THEME_LIST, 309010);
    private CustomMessageListener dgF = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dgG = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list);
    }

    public d() {
        BW();
        registerListener(this.aQV);
        registerListener(this.dgF);
        registerListener(this.dgG);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB));
    }

    private void BW() {
        com.baidu.tieba.tbadkCore.a.a.a(309010, TopThemeListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309010, CmdConfigHttp.CMD_TOP_THEME_LIST, TbConfig.TOP_THEME_LIST_PAGE, TopThemeListHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        sendMessage(new TopThemeListRequestMessage());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azy() {
        if (this.dgA != null && this.mThemeList != null && this.mThemeList.size() > 0) {
            for (com.baidu.tieba.themeCenter.theme.top.a aVar : this.mThemeList) {
                if (aVar != null && aVar.azF() != null && aVar.azF().size() > 0) {
                    for (com.baidu.tieba.themeCenter.b bVar : aVar.azF()) {
                        if (bVar != null) {
                            bVar.lr(com.baidu.tieba.themeCenter.i.a(bVar, this.dgA));
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dgE = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aQV);
        MessageManager.getInstance().unRegisterListener(this.dgF);
        MessageManager.getInstance().unRegisterListener(this.dgG);
    }
}
