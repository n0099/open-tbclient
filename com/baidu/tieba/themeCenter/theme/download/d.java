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
    private com.baidu.tieba.themeCenter.b dgD;
    private ArrayList<com.baidu.tieba.themeCenter.b> dhm;
    private a dhn;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private ArrayList<ThemeSkinUpdateInfo> mUpdateList;
    private boolean dho = true;
    private boolean dhg = false;
    private com.baidu.adp.framework.listener.a aQV = new e(this, CmdConfigHttp.CMD_THEME_LIST_UPDATE, 309013);
    private CustomMessageListener dgF = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dgG = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);
    private com.baidu.tieba.themeCenter.b dhl = new com.baidu.tieba.themeCenter.b();

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, List<com.baidu.tieba.themeCenter.theme.top.a> list);
    }

    public d() {
        this.dhl.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.default_theme));
        this.dhl.setId(-1);
        this.dgD = new com.baidu.tieba.themeCenter.b();
        this.dgD.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.night_theme));
        this.dgD.setId(-2);
        BZ();
        registerListener(this.aQV);
        registerListener(this.dgF);
        registerListener(this.dgG);
    }

    private void BZ() {
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

    public void gK(boolean z) {
        this.dhg = z;
        if (this.dhn != null) {
            azC();
            this.dhn.a(this.dho, this.mThemeList);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dgF);
        MessageManager.getInstance().unRegisterListener(this.aQV);
        MessageManager.getInstance().unRegisterListener(this.dgG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azC() {
        if (this.dhm == null || this.dhm.size() <= 0) {
            this.dho = false;
            this.dhg = false;
            return;
        }
        if (this.dhm.size() > 2) {
            this.dho = true;
        } else {
            this.dho = false;
            this.dhg = false;
        }
        Iterator<com.baidu.tieba.themeCenter.b> it = this.dhm.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.themeCenter.b next = it.next();
            if (next != null) {
                next.lr(com.baidu.tieba.themeCenter.i.a(next, this.mUpdateList));
                if (!this.dhg) {
                    next.gZ(8);
                } else {
                    next.gZ(7);
                }
            }
        }
        this.mThemeList = com.baidu.tieba.themeCenter.i.by(this.dhm);
    }

    public void a(a aVar) {
        this.dhn = aVar;
    }
}
