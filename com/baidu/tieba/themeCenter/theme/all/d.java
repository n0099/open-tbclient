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
    private List<com.baidu.tieba.themeCenter.b> dNQ;
    private List<com.baidu.tieba.themeCenter.b> dNR;
    private com.baidu.tieba.themeCenter.b dNS;
    private com.baidu.tieba.themeCenter.b dNT;
    private d.a dNU;
    private boolean dNV;
    private k mRecommand;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private final int dMt = 30;
    private int Np = 0;
    private boolean hasMore = true;
    private com.baidu.adp.framework.listener.a bah = new e(this, CmdConfigHttp.CMD_ALL_THEME_LIST, 309011);
    private CustomMessageListener dNW = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dNX = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);

    public d(AllThemeListActivity allThemeListActivity) {
        this.dNV = allThemeListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        com.baidu.tieba.tbadkCore.a.a.a(309011, AllThemeListSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309011, CmdConfigHttp.CMD_ALL_THEME_LIST, TbConfig.ALL_THEME_LIST_PAGE, AllThemeListHttpResponsedMessage.class, false, false, false, false);
        this.dNS = new com.baidu.tieba.themeCenter.b();
        this.dNS.setId(-1);
        this.dNS.setTitle(TbadkCoreApplication.m411getInst().getString(n.j.default_theme));
        this.dNT = new com.baidu.tieba.themeCenter.b();
        this.dNT.setId(-2);
        this.dNT.setTitle(TbadkCoreApplication.m411getInst().getString(n.j.night_theme));
        this.dNR = new ArrayList();
        this.dNR.add(this.dNS);
        this.dNR.add(this.dNT);
        registerListener(this.bah);
        registerListener(this.dNW);
        registerListener(this.dNX);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
        this.Np = 1;
        allThemeListRequestMessage.setPn(1);
        allThemeListRequestMessage.setRn(30);
        sendMessage(allThemeListRequestMessage);
        return false;
    }

    public void aHM() {
        if (this.hasMore) {
            this.Np++;
            AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
            allThemeListRequestMessage.setPn(this.Np);
            allThemeListRequestMessage.setRn(30);
            sendMessage(allThemeListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aBV() {
        return this.dNV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHN() {
        if (this.dNR != null && this.dNR.size() > 0) {
            if (this.dNQ == null || this.dNQ.size() <= 0) {
                if (this.dNR.size() >= 2) {
                    if (this.dNR.get(0) != null) {
                        this.dNR.get(0).nr(com.baidu.tieba.themeCenter.i.a(this.dNR.get(0), this.dNQ));
                    }
                    if (this.dNR.get(1) != null) {
                        this.dNR.get(1).nr(com.baidu.tieba.themeCenter.i.a(this.dNR.get(1), this.dNQ));
                    }
                }
                this.mThemeList = com.baidu.tieba.themeCenter.i.bT(this.dNR);
                return;
            }
            for (com.baidu.tieba.themeCenter.b bVar : this.dNR) {
                if (bVar != null) {
                    bVar.nr(com.baidu.tieba.themeCenter.i.a(bVar, this.dNQ));
                }
            }
            this.mThemeList = com.baidu.tieba.themeCenter.i.bT(this.dNR);
        }
    }

    public void a(d.a aVar) {
        this.dNU = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.bah);
        MessageManager.getInstance().unRegisterListener(this.dNW);
        MessageManager.getInstance().unRegisterListener(this.dNX);
    }
}
