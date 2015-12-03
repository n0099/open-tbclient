package com.baidu.tieba.themeCenter.theme.all;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.dressCenter.k;
import com.baidu.tieba.themeCenter.theme.top.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<d> {
    private List<com.baidu.tieba.themeCenter.b> dGp;
    private List<com.baidu.tieba.themeCenter.b> dGq;
    private com.baidu.tieba.themeCenter.b dGr;
    private com.baidu.tieba.themeCenter.b dGs;
    private d.a dGt;
    private boolean dGu;
    private k mRecommand;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private final int dEQ = 30;
    private int MZ = 0;
    private boolean hasMore = true;
    private com.baidu.adp.framework.listener.a aWh = new e(this, CmdConfigHttp.CMD_ALL_THEME_LIST, 309011);
    private CustomMessageListener dGv = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dGw = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);

    public d(AllThemeListActivity allThemeListActivity) {
        this.dGu = allThemeListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        com.baidu.tieba.tbadkCore.a.a.a(309011, AllThemeListSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309011, CmdConfigHttp.CMD_ALL_THEME_LIST, TbConfig.ALL_THEME_LIST_PAGE, AllThemeListHttpResponsedMessage.class, false, false, false, false);
        this.dGr = new com.baidu.tieba.themeCenter.b();
        this.dGr.setId(-1);
        this.dGr.setTitle(TbadkCoreApplication.m411getInst().getString(n.i.default_theme));
        this.dGs = new com.baidu.tieba.themeCenter.b();
        this.dGs.setId(-2);
        this.dGs.setTitle(TbadkCoreApplication.m411getInst().getString(n.i.night_theme));
        this.dGq = new ArrayList();
        this.dGq.add(this.dGr);
        this.dGq.add(this.dGs);
        registerListener(this.aWh);
        registerListener(this.dGv);
        registerListener(this.dGw);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
        this.MZ = 1;
        allThemeListRequestMessage.setPn(1);
        allThemeListRequestMessage.setRn(30);
        sendMessage(allThemeListRequestMessage);
        return false;
    }

    public void aFx() {
        if (this.hasMore) {
            this.MZ++;
            AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
            allThemeListRequestMessage.setPn(this.MZ);
            allThemeListRequestMessage.setRn(30);
            sendMessage(allThemeListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean azO() {
        return this.dGu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFy() {
        if (this.dGq != null && this.dGq.size() > 0) {
            if (this.dGp == null || this.dGp.size() <= 0) {
                if (this.dGq.size() >= 2) {
                    if (this.dGq.get(0) != null) {
                        this.dGq.get(0).mP(com.baidu.tieba.themeCenter.i.a(this.dGq.get(0), this.dGp));
                    }
                    if (this.dGq.get(1) != null) {
                        this.dGq.get(1).mP(com.baidu.tieba.themeCenter.i.a(this.dGq.get(1), this.dGp));
                    }
                }
                this.mThemeList = com.baidu.tieba.themeCenter.i.bQ(this.dGq);
                return;
            }
            for (com.baidu.tieba.themeCenter.b bVar : this.dGq) {
                if (bVar != null) {
                    bVar.mP(com.baidu.tieba.themeCenter.i.a(bVar, this.dGp));
                }
            }
            this.mThemeList = com.baidu.tieba.themeCenter.i.bQ(this.dGq);
        }
    }

    public void a(d.a aVar) {
        this.dGt = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aWh);
        MessageManager.getInstance().unRegisterListener(this.dGv);
        MessageManager.getInstance().unRegisterListener(this.dGw);
    }
}
