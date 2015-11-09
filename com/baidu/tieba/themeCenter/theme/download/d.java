package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetUpdateInfo.ThemeSkinUpdateInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<d> {
    private ArrayList<com.baidu.tieba.themeCenter.b> diS;
    private a diT;
    private com.baidu.tieba.themeCenter.b dij;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private ArrayList<ThemeSkinUpdateInfo> mUpdateList;
    private boolean diU = true;
    private boolean diM = false;
    private com.baidu.adp.framework.listener.a aRd = new e(this, CmdConfigHttp.CMD_THEME_LIST_UPDATE, 309013);
    private CustomMessageListener dil = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dim = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);
    private com.baidu.tieba.themeCenter.b diR = new com.baidu.tieba.themeCenter.b();

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, List<com.baidu.tieba.themeCenter.theme.top.a> list);
    }

    public d() {
        this.diR.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.default_theme));
        this.diR.setId(-1);
        this.dij = new com.baidu.tieba.themeCenter.b();
        this.dij.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.night_theme));
        this.dij.setId(-2);
        BP();
        registerListener(this.aRd);
        registerListener(this.dil);
        registerListener(this.dim);
    }

    private void BP() {
        com.baidu.tieba.tbadkCore.a.a.a(309013, SkinUpdateSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309013, CmdConfigHttp.CMD_THEME_LIST_UPDATE, TbConfig.THEME_LIST_UPDATE, SkinUpdateHttpResponsedMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        sendMessage(new SkinUpdateRequestMessage());
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB));
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void gN(boolean z) {
        this.diM = z;
        if (this.diT != null) {
            aAo();
            this.diT.a(this.diU, this.mThemeList);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dil);
        MessageManager.getInstance().unRegisterListener(this.aRd);
        MessageManager.getInstance().unRegisterListener(this.dim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAo() {
        if (this.diS == null || this.diS.size() <= 0) {
            this.diU = false;
            this.diM = false;
            return;
        }
        if (this.diS.size() > 2) {
            this.diU = true;
        } else {
            this.diU = false;
            this.diM = false;
        }
        Iterator<com.baidu.tieba.themeCenter.b> it = this.diS.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.themeCenter.b next = it.next();
            if (next != null) {
                next.lF(com.baidu.tieba.themeCenter.i.a(next, this.mUpdateList));
                if (!this.diM) {
                    next.hm(8);
                } else {
                    next.hm(7);
                }
            }
        }
        this.mThemeList = com.baidu.tieba.themeCenter.i.bC(this.diS);
    }

    public void a(a aVar) {
        this.diT = aVar;
    }
}
