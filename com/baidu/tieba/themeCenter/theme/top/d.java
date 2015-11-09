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
    private List<com.baidu.tieba.themeCenter.b> dig;
    private a dik;
    private k mRecommand;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private com.baidu.adp.framework.listener.a aRd = new e(this, CmdConfigHttp.CMD_TOP_THEME_LIST, 309010);
    private CustomMessageListener dil = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dim = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list);
    }

    public d() {
        BP();
        registerListener(this.aRd);
        registerListener(this.dil);
        registerListener(this.dim);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB));
    }

    private void BP() {
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
    public void aAo() {
        if (this.dig != null && this.mThemeList != null && this.mThemeList.size() > 0) {
            for (com.baidu.tieba.themeCenter.theme.top.a aVar : this.mThemeList) {
                if (aVar != null && aVar.aAv() != null && aVar.aAv().size() > 0) {
                    for (com.baidu.tieba.themeCenter.b bVar : aVar.aAv()) {
                        if (bVar != null) {
                            bVar.lF(com.baidu.tieba.themeCenter.i.a(bVar, this.dig));
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
        this.dik = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aRd);
        MessageManager.getInstance().unRegisterListener(this.dil);
        MessageManager.getInstance().unRegisterListener(this.dim);
    }
}
