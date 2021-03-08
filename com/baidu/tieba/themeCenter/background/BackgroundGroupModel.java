package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.List;
/* loaded from: classes8.dex */
public class BackgroundGroupModel extends BdBaseModel<BackgroundGroupActivity> {
    private List<b> mGroupList;
    private com.baidu.tieba.themeCenter.dressCenter.e mRecommand;
    private BackgroundGroupActivity nJd;
    private a nJe;
    private boolean nJf;
    private com.baidu.adp.framework.listener.a nJg;
    private com.baidu.adp.framework.listener.a nJh;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<b> list);
    }

    public void a(int i, String str, DressItemData dressItemData, boolean z) {
        int i2 = 0;
        if (dressItemData != null && dressItemData.getFreeUserLevel() == 101) {
            i2 = 9;
        }
        if (!StringUtils.isNull(str)) {
            if (i == com.baidu.tieba.themeCenter.c.nIi) {
                com.baidu.tieba.themeCenter.b.a(this.nJd.getPageContext(), z ? 4 : 2, str, i2, MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
            } else if (i == com.baidu.tieba.themeCenter.c.nIj) {
                com.baidu.tieba.themeCenter.b.a(this.nJd.getPageContext(), z ? 4 : 2, str, i2);
            }
        }
    }

    public BackgroundGroupModel(BackgroundGroupActivity backgroundGroupActivity) {
        super(backgroundGroupActivity.getPageContext());
        this.nJg = new com.baidu.adp.framework.listener.a(1003033, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_GROUP) { // from class: com.baidu.tieba.themeCenter.background.BackgroundGroupModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof BackgroundGroupHttpResponseMessage) || (responsedMessage instanceof BackgroundGroupSocketResponseMessage)) {
                        if (responsedMessage.getError() != 0) {
                            if (BackgroundGroupModel.this.nJe != null) {
                                BackgroundGroupModel.this.nJe.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundGroupModel.this.mRecommand, BackgroundGroupModel.this.mGroupList);
                                return;
                            }
                            return;
                        }
                        if (responsedMessage instanceof BackgroundGroupHttpResponseMessage) {
                            BackgroundGroupHttpResponseMessage backgroundGroupHttpResponseMessage = (BackgroundGroupHttpResponseMessage) responsedMessage;
                            BackgroundGroupModel.this.mRecommand = backgroundGroupHttpResponseMessage.getRecommand();
                            BackgroundGroupModel.this.mGroupList = backgroundGroupHttpResponseMessage.getGroupList();
                        } else if (responsedMessage instanceof BackgroundGroupSocketResponseMessage) {
                            BackgroundGroupSocketResponseMessage backgroundGroupSocketResponseMessage = (BackgroundGroupSocketResponseMessage) responsedMessage;
                            BackgroundGroupModel.this.mRecommand = backgroundGroupSocketResponseMessage.getRecommand();
                            BackgroundGroupModel.this.mGroupList = backgroundGroupSocketResponseMessage.getGroupList();
                        }
                        if (BackgroundGroupModel.this.nJe != null) {
                            BackgroundGroupModel.this.nJe.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundGroupModel.this.mRecommand, BackgroundGroupModel.this.mGroupList);
                        }
                    }
                }
            }
        };
        this.nJh = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.BackgroundGroupModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                DressItemData Kn;
                DressItemData Kn2;
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                        BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                        int propId = backgroundSetRequestMessage.getPropId();
                        if (responsedMessage.getError() == 0) {
                            if (propId == BackgroundGroupModel.this.nJd.getPropId() && (Kn = BackgroundGroupModel.this.Kn(propId)) != null) {
                                TiebaStatic.log(new ar("c10286").aq("obj_id", propId).aq("obj_type", Kn.getFreeUserLevel()));
                            }
                            com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), propId);
                            BackgroundGroupModel.this.Km(propId);
                            BackgroundGroupModel.this.nJe.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundGroupModel.this.mRecommand, BackgroundGroupModel.this.mGroupList);
                        } else if (responsedMessage.getError() != 2270014) {
                            int i = com.baidu.tieba.themeCenter.c.nIj;
                            if (responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nIk) {
                                i = com.baidu.tieba.themeCenter.c.nIi;
                            }
                            boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                            if (!fromDetail) {
                                if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == BackgroundGroupModel.this.getUniqueId()) && propId == BackgroundGroupModel.this.nJd.getPropId() && (Kn2 = BackgroundGroupModel.this.Kn(propId)) != null) {
                                    BackgroundGroupModel.this.a(i, responsedMessage.getErrorString(), Kn2, fromDetail);
                                }
                            }
                        }
                    }
                }
            }
        };
        this.nJd = backgroundGroupActivity;
        this.nJf = backgroundGroupActivity.getIntent().getBooleanExtra("member_buy_show", false);
        dRt();
        registerListener(this.nJg);
        dRu();
        registerListener(this.nJh);
    }

    private void dRt() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_GROUP, BackgroundGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_GROUP, 1003033, TbConfig.PERSONAL_BACKGROUND_GROUP_PAGE, BackgroundGroupHttpResponseMessage.class, false, false, false, false);
    }

    private void dRu() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, 1003036, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new BackgroundGroupRequestMessage());
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.nJe = aVar;
    }

    public boolean dLf() {
        return this.nJf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km(int i) {
        if (this.mGroupList != null && this.mGroupList.size() > 0) {
            for (b bVar : this.mGroupList) {
                if (bVar != null && bVar.getBackgroundList() != null) {
                    for (DressItemData dressItemData : bVar.getBackgroundList()) {
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
    public DressItemData Kn(int i) {
        if (this.mGroupList == null || this.mGroupList.size() <= 0) {
            return null;
        }
        for (b bVar : this.mGroupList) {
            if (bVar != null && bVar.getBackgroundList() != null) {
                for (DressItemData dressItemData : bVar.getBackgroundList()) {
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
