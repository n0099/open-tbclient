package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.e<o> {
    private BackgroundListActivity dhj;
    private List<DressItemData> dhk;
    private a dhl;
    private List<DressItemData> mBackgroundList;
    private com.baidu.tieba.themeCenter.dressCenter.k mRecommand;
    private final int dhm = 9;
    private int MI = 0;
    private boolean hasMore = true;
    private com.baidu.adp.framework.listener.a dhn = new p(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, 309021);
    private com.baidu.adp.framework.listener.a dgR = new q(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list);
    }

    public o(BackgroundListActivity backgroundListActivity) {
        this.dhj = backgroundListActivity;
        BP();
        registerListener(this.dhn);
        aAi();
        registerListener(this.dgR);
    }

    private void BP() {
        com.baidu.tieba.tbadkCore.a.a.a(309021, BackgroundListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
    }

    private void aAi() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
        this.MI = 1;
        backgroundListRequestMessage.setPn(this.MI);
        backgroundListRequestMessage.setRn(9);
        sendMessage(backgroundListRequestMessage);
        return false;
    }

    public void aAj() {
        if (this.hasMore) {
            this.MI++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.MI);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dhl = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(int i) {
        if (this.dhk != null && this.dhk.size() > 0) {
            for (DressItemData dressItemData : this.dhk) {
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
    public DressItemData lK(int i) {
        if (this.dhk == null || this.dhk.size() <= 0) {
            return null;
        }
        for (DressItemData dressItemData : this.dhk) {
            if (dressItemData != null && dressItemData.getPropsId() == i) {
                return dressItemData;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dhn);
        MessageManager.getInstance().unRegisterListener(this.dgR);
    }
}
