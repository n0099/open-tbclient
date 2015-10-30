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
    private List<com.baidu.tieba.themeCenter.b> dgA;
    private List<com.baidu.tieba.themeCenter.b> dgB;
    private com.baidu.tieba.themeCenter.b dgC;
    private com.baidu.tieba.themeCenter.b dgD;
    private d.a dgE;
    private k mRecommand;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private final int dfG = 30;
    private int MH = 0;
    private boolean hasMore = true;
    private com.baidu.adp.framework.listener.a aQV = new e(this, CmdConfigHttp.CMD_ALL_THEME_LIST, 309011);
    private CustomMessageListener dgF = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dgG = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);

    public d() {
        com.baidu.tieba.tbadkCore.a.a.a(309011, AllThemeListSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309011, CmdConfigHttp.CMD_ALL_THEME_LIST, TbConfig.ALL_THEME_LIST_PAGE, AllThemeListHttpResponsedMessage.class, false, false, false, false);
        this.dgC = new com.baidu.tieba.themeCenter.b();
        this.dgC.setId(-1);
        this.dgC.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.default_theme));
        this.dgD = new com.baidu.tieba.themeCenter.b();
        this.dgD.setId(-2);
        this.dgD.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.night_theme));
        this.dgB = new ArrayList();
        this.dgB.add(this.dgC);
        this.dgB.add(this.dgD);
        registerListener(this.aQV);
        registerListener(this.dgF);
        registerListener(this.dgG);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
        this.MH = 1;
        allThemeListRequestMessage.setPn(1);
        allThemeListRequestMessage.setRn(30);
        sendMessage(allThemeListRequestMessage);
        return false;
    }

    public void azx() {
        if (this.hasMore) {
            this.MH++;
            AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
            allThemeListRequestMessage.setPn(this.MH);
            allThemeListRequestMessage.setRn(30);
            sendMessage(allThemeListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azy() {
        if (this.dgB != null && this.dgB.size() > 0) {
            if (this.dgA == null || this.dgA.size() <= 0) {
                if (this.dgB.size() >= 2) {
                    if (this.dgB.get(0) != null) {
                        this.dgB.get(0).lr(com.baidu.tieba.themeCenter.i.a(this.dgB.get(0), this.dgA));
                    }
                    if (this.dgB.get(1) != null) {
                        this.dgB.get(1).lr(com.baidu.tieba.themeCenter.i.a(this.dgB.get(1), this.dgA));
                    }
                }
                this.mThemeList = com.baidu.tieba.themeCenter.i.by(this.dgB);
                return;
            }
            for (com.baidu.tieba.themeCenter.b bVar : this.dgB) {
                if (bVar != null) {
                    bVar.lr(com.baidu.tieba.themeCenter.i.a(bVar, this.dgA));
                }
            }
            this.mThemeList = com.baidu.tieba.themeCenter.i.by(this.dgB);
        }
    }

    public void a(d.a aVar) {
        this.dgE = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aQV);
        MessageManager.getInstance().unRegisterListener(this.dgF);
        MessageManager.getInstance().unRegisterListener(this.dgG);
    }
}
