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
    private ArrayList<com.baidu.tieba.themeCenter.b> dgM;
    private a dgN;
    private com.baidu.tieba.themeCenter.b dgd;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;
    private ArrayList<ThemeSkinUpdateInfo> mUpdateList;
    private boolean dgO = true;
    private boolean dgG = false;
    private com.baidu.adp.framework.listener.a aQK = new e(this, CmdConfigHttp.CMD_THEME_LIST_UPDATE, 309013);
    private CustomMessageListener dgf = new f(this, CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB);
    private CustomMessageListener dgg = new g(this, CmdConfigCustom.CMD_REFRESH_THEME_LIST);
    private com.baidu.tieba.themeCenter.b dgL = new com.baidu.tieba.themeCenter.b();

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, List<com.baidu.tieba.themeCenter.theme.top.a> list);
    }

    public d() {
        this.dgL.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.default_theme));
        this.dgL.setId(-1);
        this.dgd = new com.baidu.tieba.themeCenter.b();
        this.dgd.setTitle(TbadkCoreApplication.m411getInst().getString(i.h.night_theme));
        this.dgd.setId(-2);
        BZ();
        registerListener(this.aQK);
        registerListener(this.dgf);
        registerListener(this.dgg);
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
        this.dgG = z;
        if (this.dgN != null) {
            azs();
            this.dgN.a(this.dgO, this.mThemeList);
        }
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dgf);
        MessageManager.getInstance().unRegisterListener(this.aQK);
        MessageManager.getInstance().unRegisterListener(this.dgg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azs() {
        if (this.dgM == null || this.dgM.size() <= 0) {
            this.dgO = false;
            this.dgG = false;
            return;
        }
        if (this.dgM.size() > 2) {
            this.dgO = true;
        } else {
            this.dgO = false;
            this.dgG = false;
        }
        Iterator<com.baidu.tieba.themeCenter.b> it = this.dgM.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.themeCenter.b next = it.next();
            if (next != null) {
                next.lp(com.baidu.tieba.themeCenter.i.a(next, this.mUpdateList));
                if (!this.dgG) {
                    next.gZ(8);
                } else {
                    next.gZ(7);
                }
            }
        }
        this.mThemeList = com.baidu.tieba.themeCenter.i.bx(this.dgM);
    }

    public void a(a aVar) {
        this.dgN = aVar;
    }
}
