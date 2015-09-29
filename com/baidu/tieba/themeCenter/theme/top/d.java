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
    private List<com.baidu.tieba.themeCenter.b> dga;
    private a dge;
    private k mRecommand;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private com.baidu.adp.framework.listener.a aQK = new e(this, CmdConfigHttp.CMD_TOP_THEME_LIST, 309010);
    private CustomMessageListener dgf = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dgg = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list);
    }

    public d() {
        BZ();
        registerListener(this.aQK);
        registerListener(this.dgf);
        registerListener(this.dgg);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB));
    }

    private void BZ() {
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
    public void azs() {
        if (this.dga != null && this.mThemeList != null && this.mThemeList.size() > 0) {
            for (com.baidu.tieba.themeCenter.theme.top.a aVar : this.mThemeList) {
                if (aVar != null && aVar.azz() != null && aVar.azz().size() > 0) {
                    for (com.baidu.tieba.themeCenter.b bVar : aVar.azz()) {
                        if (bVar != null) {
                            bVar.lp(com.baidu.tieba.themeCenter.i.a(bVar, this.dga));
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
        this.dge = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aQK);
        MessageManager.getInstance().unRegisterListener(this.dgf);
        MessageManager.getInstance().unRegisterListener(this.dgg);
    }
}
