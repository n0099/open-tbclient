package com.baidu.tieba.themeCenter.background;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<BackgroundGroupActivity> {
    private BackgroundGroupActivity deH;
    private List<c> deI;
    private a deJ;
    private com.baidu.adp.framework.listener.a deK;
    private com.baidu.adp.framework.listener.a deL;
    private com.baidu.tieba.themeCenter.dressCenter.k mRecommand;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.k kVar, List<c> list);
    }

    public d(BackgroundGroupActivity backgroundGroupActivity) {
        super(backgroundGroupActivity.getPageContext());
        this.deK = new e(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, 309020);
        this.deL = new f(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.deH = backgroundGroupActivity;
        azl();
        registerListener(this.deK);
        azm();
        registerListener(this.deL);
    }

    private void azl() {
        com.baidu.tieba.tbadkCore.a.a.a(309020, BackgroundGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309020, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, TbConfig.PERSONAL_BACKGROUND_GROUP_PAGE, BackgroundGroupHttpResponseMessage.class, false, false, false, false);
    }

    private void azm() {
        com.baidu.tieba.tbadkCore.a.a.a(309022, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        sendMessage(new BackgroundGroupRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.deJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lt(int i) {
        if (this.deI != null && this.deI.size() > 0) {
            for (c cVar : this.deI) {
                if (cVar != null && cVar.getBackgroundList() != null) {
                    for (DressItemData dressItemData : cVar.getBackgroundList()) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DressItemData lu(int i) {
        if (this.deI == null || this.deI.size() <= 0) {
            return null;
        }
        for (c cVar : this.deI) {
            if (cVar != null && cVar.getBackgroundList() != null) {
                for (DressItemData dressItemData : cVar.getBackgroundList()) {
                    if (dressItemData != null && dressItemData.getPropsId() == i) {
                        return dressItemData;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
