package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetUpdateInfo.ThemeSkinUpdateInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<d> {
    private com.baidu.tieba.themeCenter.b dNT;
    private ArrayList<com.baidu.tieba.themeCenter.b> dOD;
    private a dOE;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private ArrayList<ThemeSkinUpdateInfo> mUpdateList;
    private boolean dOF = true;
    private boolean dOy = false;
    private com.baidu.adp.framework.listener.a bah = new e(this, CmdConfigHttp.CMD_THEME_LIST_UPDATE, 309013);
    private CustomMessageListener dNW = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dNX = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);
    private com.baidu.tieba.themeCenter.b dOC = new com.baidu.tieba.themeCenter.b();

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, List<com.baidu.tieba.themeCenter.theme.top.a> list);
    }

    public d() {
        this.dOC.setTitle(TbadkCoreApplication.m411getInst().getString(n.j.default_theme));
        this.dOC.setId(-1);
        this.dNT = new com.baidu.tieba.themeCenter.b();
        this.dNT.setTitle(TbadkCoreApplication.m411getInst().getString(n.j.night_theme));
        this.dNT.setId(-2);
        CF();
        registerListener(this.bah);
        registerListener(this.dNW);
        registerListener(this.dNX);
    }

    private void CF() {
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

    public void hE(boolean z) {
        this.dOy = z;
        if (this.dOE != null) {
            aHN();
            this.dOE.a(this.dOF, this.mThemeList);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dNW);
        MessageManager.getInstance().unRegisterListener(this.bah);
        MessageManager.getInstance().unRegisterListener(this.dNX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHN() {
        if (this.dOD == null || this.dOD.size() <= 0) {
            this.dOF = false;
            this.dOy = false;
            return;
        }
        if (this.dOD.size() > 2) {
            this.dOF = true;
        } else {
            this.dOF = false;
            this.dOy = false;
        }
        Iterator<com.baidu.tieba.themeCenter.b> it = this.dOD.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.themeCenter.b next = it.next();
            if (next != null) {
                next.nr(i.a(next, this.mUpdateList));
                if (!this.dOy) {
                    next.iz(8);
                } else {
                    next.iz(7);
                }
            }
        }
        this.mThemeList = i.bT(this.dOD);
    }

    public void a(a aVar) {
        this.dOE = aVar;
    }
}
