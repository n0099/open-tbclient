package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<d> {
    private List<com.baidu.tieba.themeCenter.b> dig;
    private List<com.baidu.tieba.themeCenter.b> dih;
    private com.baidu.tieba.themeCenter.b dii;
    private com.baidu.tieba.themeCenter.b dij;
    private d.a dik;
    private k mRecommand;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private final int dhm = 30;
    private int MI = 0;
    private boolean hasMore = true;
    private com.baidu.adp.framework.listener.a aRd = new e(this, CmdConfigHttp.CMD_ALL_THEME_LIST, 309011);
    private CustomMessageListener dil = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dim = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);

    public d() {
        com.baidu.tieba.tbadkCore.a.a.a(309011, AllThemeListSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309011, CmdConfigHttp.CMD_ALL_THEME_LIST, TbConfig.ALL_THEME_LIST_PAGE, AllThemeListHttpResponsedMessage.class, false, false, false, false);
        this.dii = new com.baidu.tieba.themeCenter.b();
        this.dii.setId(-1);
        this.dii.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.default_theme));
        this.dij = new com.baidu.tieba.themeCenter.b();
        this.dij.setId(-2);
        this.dij.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.night_theme));
        this.dih = new ArrayList();
        this.dih.add(this.dii);
        this.dih.add(this.dij);
        registerListener(this.aRd);
        registerListener(this.dil);
        registerListener(this.dim);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
        this.MI = 1;
        allThemeListRequestMessage.setPn(1);
        allThemeListRequestMessage.setRn(30);
        sendMessage(allThemeListRequestMessage);
        return false;
    }

    public void aAn() {
        if (this.hasMore) {
            this.MI++;
            AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
            allThemeListRequestMessage.setPn(this.MI);
            allThemeListRequestMessage.setRn(30);
            sendMessage(allThemeListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAo() {
        if (this.dih != null && this.dih.size() > 0) {
            if (this.dig == null || this.dig.size() <= 0) {
                if (this.dih.size() >= 2) {
                    if (this.dih.get(0) != null) {
                        this.dih.get(0).lF(com.baidu.tieba.themeCenter.i.a(this.dih.get(0), this.dig));
                    }
                    if (this.dih.get(1) != null) {
                        this.dih.get(1).lF(com.baidu.tieba.themeCenter.i.a(this.dih.get(1), this.dig));
                    }
                }
                this.mThemeList = com.baidu.tieba.themeCenter.i.bC(this.dih);
                return;
            }
            for (com.baidu.tieba.themeCenter.b bVar : this.dih) {
                if (bVar != null) {
                    bVar.lF(com.baidu.tieba.themeCenter.i.a(bVar, this.dig));
                }
            }
            this.mThemeList = com.baidu.tieba.themeCenter.i.bC(this.dih);
        }
    }

    public void a(d.a aVar) {
        this.dik = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aRd);
        MessageManager.getInstance().unRegisterListener(this.dil);
        MessageManager.getInstance().unRegisterListener(this.dim);
    }
}
