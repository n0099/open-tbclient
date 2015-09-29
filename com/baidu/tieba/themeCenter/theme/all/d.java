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
    private List<com.baidu.tieba.themeCenter.b> dga;
    private List<com.baidu.tieba.themeCenter.b> dgb;
    private com.baidu.tieba.themeCenter.b dgc;
    private com.baidu.tieba.themeCenter.b dgd;
    private d.a dge;
    private k mRecommand;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private final int dfg = 30;
    private int MG = 0;
    private boolean hasMore = true;
    private com.baidu.adp.framework.listener.a aQK = new e(this, CmdConfigHttp.CMD_ALL_THEME_LIST, 309011);
    private CustomMessageListener dgf = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dgg = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);

    public d() {
        com.baidu.tieba.tbadkCore.a.a.a(309011, AllThemeListSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309011, CmdConfigHttp.CMD_ALL_THEME_LIST, TbConfig.ALL_THEME_LIST_PAGE, AllThemeListHttpResponsedMessage.class, false, false, false, false);
        this.dgc = new com.baidu.tieba.themeCenter.b();
        this.dgc.setId(-1);
        this.dgc.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.default_theme));
        this.dgd = new com.baidu.tieba.themeCenter.b();
        this.dgd.setId(-2);
        this.dgd.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.night_theme));
        this.dgb = new ArrayList();
        this.dgb.add(this.dgc);
        this.dgb.add(this.dgd);
        registerListener(this.aQK);
        registerListener(this.dgf);
        registerListener(this.dgg);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
        this.MG = 1;
        allThemeListRequestMessage.setPn(1);
        allThemeListRequestMessage.setRn(30);
        sendMessage(allThemeListRequestMessage);
        return false;
    }

    public void azr() {
        if (this.hasMore) {
            this.MG++;
            AllThemeListRequestMessage allThemeListRequestMessage = new AllThemeListRequestMessage();
            allThemeListRequestMessage.setPn(this.MG);
            allThemeListRequestMessage.setRn(30);
            sendMessage(allThemeListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azs() {
        if (this.dgb != null && this.dgb.size() > 0) {
            if (this.dga == null || this.dga.size() <= 0) {
                if (this.dgb.size() >= 2) {
                    if (this.dgb.get(0) != null) {
                        this.dgb.get(0).lp(com.baidu.tieba.themeCenter.i.a(this.dgb.get(0), this.dga));
                    }
                    if (this.dgb.get(1) != null) {
                        this.dgb.get(1).lp(com.baidu.tieba.themeCenter.i.a(this.dgb.get(1), this.dga));
                    }
                }
                this.mThemeList = com.baidu.tieba.themeCenter.i.bx(this.dgb);
                return;
            }
            for (com.baidu.tieba.themeCenter.b bVar : this.dgb) {
                if (bVar != null) {
                    bVar.lp(com.baidu.tieba.themeCenter.i.a(bVar, this.dga));
                }
            }
            this.mThemeList = com.baidu.tieba.themeCenter.i.bx(this.dgb);
        }
    }

    public void a(d.a aVar) {
        this.dge = aVar;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.aQK);
        MessageManager.getInstance().unRegisterListener(this.dgf);
        MessageManager.getInstance().unRegisterListener(this.dgg);
    }
}
