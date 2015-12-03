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
    private com.baidu.tieba.themeCenter.b dGs;
    private ArrayList<com.baidu.tieba.themeCenter.b> dHc;
    private a dHd;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private ArrayList<ThemeSkinUpdateInfo> mUpdateList;
    private boolean dHe = true;
    private boolean dGX = false;
    private com.baidu.adp.framework.listener.a aWh = new e(this, CmdConfigHttp.CMD_THEME_LIST_UPDATE, 309013);
    private CustomMessageListener dGv = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dGw = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);
    private com.baidu.tieba.themeCenter.b dHb = new com.baidu.tieba.themeCenter.b();

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, List<com.baidu.tieba.themeCenter.theme.top.a> list);
    }

    public d() {
        this.dHb.setTitle(TbadkCoreApplication.m411getInst().getString(n.i.default_theme));
        this.dHb.setId(-1);
        this.dGs = new com.baidu.tieba.themeCenter.b();
        this.dGs.setTitle(TbadkCoreApplication.m411getInst().getString(n.i.night_theme));
        this.dGs.setId(-2);
        CQ();
        registerListener(this.aWh);
        registerListener(this.dGv);
        registerListener(this.dGw);
    }

    private void CQ() {
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

    public void hv(boolean z) {
        this.dGX = z;
        if (this.dHd != null) {
            aFy();
            this.dHd.a(this.dHe, this.mThemeList);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dGv);
        MessageManager.getInstance().unRegisterListener(this.aWh);
        MessageManager.getInstance().unRegisterListener(this.dGw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFy() {
        if (this.dHc == null || this.dHc.size() <= 0) {
            this.dHe = false;
            this.dGX = false;
            return;
        }
        if (this.dHc.size() > 2) {
            this.dHe = true;
        } else {
            this.dHe = false;
            this.dGX = false;
        }
        Iterator<com.baidu.tieba.themeCenter.b> it = this.dHc.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.themeCenter.b next = it.next();
            if (next != null) {
                next.mP(i.a(next, this.mUpdateList));
                if (!this.dGX) {
                    next.hZ(8);
                } else {
                    next.hZ(7);
                }
            }
        }
        this.mThemeList = i.bQ(this.dHc);
    }

    public void a(a aVar) {
        this.dHd = aVar;
    }
}
