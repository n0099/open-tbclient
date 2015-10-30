package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.e<o> {
    private BackgroundListActivity dfD;
    private List<DressItemData> dfE;
    private a dfF;
    private List<DressItemData> mBackgroundList;
    private com.baidu.tieba.themeCenter.dressCenter.k mRecommand;
    private final int dfG = 9;
    private int MH = 0;
    private boolean hasMore = true;
    private com.baidu.adp.framework.listener.a dfH = new p(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, 309021);
    private com.baidu.adp.framework.listener.a dfl = new q(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list);
    }

    public o(BackgroundListActivity backgroundListActivity) {
        this.dfD = backgroundListActivity;
        BW();
        registerListener(this.dfH);
        azs();
        registerListener(this.dfl);
    }

    private void BW() {
        com.baidu.tieba.tbadkCore.a.a.a(309021, BackgroundListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
    }

    private void azs() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
        this.MH = 1;
        backgroundListRequestMessage.setPn(this.MH);
        backgroundListRequestMessage.setRn(9);
        sendMessage(backgroundListRequestMessage);
        return false;
    }

    public void azt() {
        if (this.hasMore) {
            this.MH++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.MH);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dfF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv(int i) {
        if (this.dfE != null && this.dfE.size() > 0) {
            for (DressItemData dressItemData : this.dfE) {
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
    public DressItemData lw(int i) {
        if (this.dfE == null || this.dfE.size() <= 0) {
            return null;
        }
        for (DressItemData dressItemData : this.dfE) {
            if (dressItemData != null && dressItemData.getPropsId() == i) {
                return dressItemData;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dfH);
        MessageManager.getInstance().unRegisterListener(this.dfl);
    }
}
