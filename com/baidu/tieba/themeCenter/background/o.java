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
    private BackgroundListActivity dEM;
    private List<DressItemData> dEN;
    private a dEP;
    private boolean dER;
    private List<DressItemData> mBackgroundList;
    private com.baidu.tieba.themeCenter.dressCenter.k mRecommand;
    private final int dEQ = 9;
    private int MZ = 0;
    private boolean hasMore = true;
    private boolean dgo = false;
    private com.baidu.adp.framework.listener.a dES = new p(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, 309021);
    private com.baidu.adp.framework.listener.a cRZ = new q(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    private DressItemData dEO = new DressItemData();

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list);
    }

    public o(BackgroundListActivity backgroundListActivity) {
        this.dEM = backgroundListActivity;
        this.dEO.setPropsId(0);
        this.dEO.setTitle(TbadkCoreApplication.m411getInst().getString(n.i.default_background));
        this.dEN = new ArrayList();
        this.dEN.add(this.dEO);
        this.dER = backgroundListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        CQ();
        registerListener(this.dES);
        aFo();
        registerListener(this.cRZ);
    }

    private void CQ() {
        com.baidu.tieba.tbadkCore.a.a.a(309021, BackgroundListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
    }

    private void aFo() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
        this.MZ = 1;
        backgroundListRequestMessage.setPn(this.MZ);
        backgroundListRequestMessage.setRn(9);
        sendMessage(backgroundListRequestMessage);
        return false;
    }

    public void aFr() {
        if (this.hasMore) {
            this.MZ++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.MZ);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aFs() {
        return this.dER;
    }

    public void a(a aVar) {
        this.dEP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mT(int i) {
        if (this.dEN != null && this.dEN.size() > 0) {
            for (DressItemData dressItemData : this.dEN) {
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
    public void aFt() {
        DressItemData mU;
        if (this.dgo && (mU = mU(0)) != null) {
            mU.setInUse(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DressItemData mU(int i) {
        if (this.dEN == null || this.dEN.size() <= 0) {
            return null;
        }
        for (DressItemData dressItemData : this.dEN) {
            if (dressItemData != null && dressItemData.getPropsId() == i) {
                return dressItemData;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dES);
        MessageManager.getInstance().unRegisterListener(this.cRZ);
    }
}
