package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.e<o> {
    private BackgroundListActivity dMp;
    private List<DressItemData> dMq;
    private a dMs;
    private boolean dMu;
    private List<DressItemData> mBackgroundList;
    private com.baidu.tieba.themeCenter.dressCenter.k mRecommand;
    private final int dMt = 9;
    private int Np = 0;
    private boolean hasMore = true;
    private boolean dlU = false;
    private com.baidu.adp.framework.listener.a dMv = new p(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, 309021);
    private com.baidu.adp.framework.listener.a cWE = new q(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private DressItemData dMr = new DressItemData();

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list);
    }

    public o(BackgroundListActivity backgroundListActivity) {
        this.dMp = backgroundListActivity;
        this.dMr.setPropsId(0);
        this.dMr.setTitle(TbadkCoreApplication.m411getInst().getString(n.j.default_background));
        this.dMq = new ArrayList();
        this.dMq.add(this.dMr);
        this.dMu = backgroundListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        CF();
        registerListener(this.dMv);
        aHD();
        registerListener(this.cWE);
    }

    private void CF() {
        com.baidu.tieba.tbadkCore.a.a.a(309021, BackgroundListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
    }

    private void aHD() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
        this.Np = 1;
        backgroundListRequestMessage.setPn(this.Np);
        backgroundListRequestMessage.setRn(9);
        sendMessage(backgroundListRequestMessage);
        return false;
    }

    public void aHG() {
        if (this.hasMore) {
            this.Np++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.Np);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aHH() {
        return this.dMu;
    }

    public void a(a aVar) {
        this.dMs = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(int i) {
        if (this.dMq != null && this.dMq.size() > 0) {
            for (DressItemData dressItemData : this.dMq) {
                if (dressItemData != null) {
                    if (dressItemData.getPropsId() == i) {
                        dressItemData.setInUse(true);
                    } else {
                        dressItemData.setInUse(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHI() {
        DressItemData nw;
        if (this.dlU && (nw = nw(0)) != null) {
            nw.setInUse(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DressItemData nw(int i) {
        if (this.dMq == null || this.dMq.size() <= 0) {
            return null;
        }
        for (DressItemData dressItemData : this.dMq) {
            if (dressItemData != null && dressItemData.getPropsId() == i) {
                return dressItemData;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dMv);
        MessageManager.getInstance().unRegisterListener(this.cWE);
    }
}
