package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class BackgroundListModel extends BdBaseModel<BackgroundListActivity> {
    private List<DressItemData> mBackgroundList;
    private com.baidu.tieba.themeCenter.dressCenter.e mRecommand;
    private a nJA;
    private boolean nJB;
    private BackgroundListActivity nJx;
    private List<DressItemData> nJy;
    private int currentPage = 0;
    private boolean hasMore = true;
    private boolean cVC = false;
    private com.baidu.adp.framework.listener.a nJC = new com.baidu.adp.framework.listener.a(1003034, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST) { // from class: com.baidu.tieba.themeCenter.background.BackgroundListModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundListHttpResponseMessage) || (responsedMessage instanceof BackgroundListSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        BackgroundListModel.a(BackgroundListModel.this);
                    } else {
                        if (responsedMessage instanceof BackgroundListHttpResponseMessage) {
                            BackgroundListHttpResponseMessage backgroundListHttpResponseMessage = (BackgroundListHttpResponseMessage) responsedMessage;
                            BackgroundListModel.this.mRecommand = backgroundListHttpResponseMessage.getRecommand();
                            BackgroundListModel.this.mBackgroundList = backgroundListHttpResponseMessage.getBackgroundList();
                            BackgroundListModel.this.hasMore = backgroundListHttpResponseMessage.hasMore();
                            BackgroundListModel.this.cVC = backgroundListHttpResponseMessage.getIsDefault();
                        } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                            BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                            BackgroundListModel.this.mRecommand = backgroundListSocketResponseMessage.getRecommand();
                            BackgroundListModel.this.mBackgroundList = backgroundListSocketResponseMessage.getBackgroundList();
                            BackgroundListModel.this.hasMore = backgroundListSocketResponseMessage.hasMore();
                            BackgroundListModel.this.cVC = backgroundListSocketResponseMessage.getIsDefault();
                        }
                        if (BackgroundListModel.this.nJy == null) {
                            BackgroundListModel.this.nJy = new ArrayList();
                            BackgroundListModel.this.nJy.add(BackgroundListModel.this.nJz);
                        }
                        if (BackgroundListModel.this.currentPage == 1) {
                            BackgroundListModel.this.nJy.clear();
                            BackgroundListModel.this.nJy.add(BackgroundListModel.this.nJz);
                        }
                        if (BackgroundListModel.this.mBackgroundList != null) {
                            BackgroundListModel.this.nJy.addAll(BackgroundListModel.this.mBackgroundList);
                        }
                    }
                    if (BackgroundListModel.this.nJA != null) {
                        BackgroundListModel.this.dRx();
                        BackgroundListModel.this.nJA.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.mRecommand, BackgroundListModel.this.nJy);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nJh = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.BackgroundListModel.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DressItemData Kn;
            DressItemData Kn2;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                    BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                    int propId = backgroundSetRequestMessage.getPropId();
                    if (responsedMessage.getError() == 0) {
                        if (propId == BackgroundListModel.this.nJx.getPropId() && (Kn = BackgroundListModel.this.Kn(propId)) != null) {
                            TiebaStatic.log(new ar("c10286").aq("obj_id", propId).aq("obj_type", Kn.getFreeUserLevel()));
                        }
                        com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), propId);
                        BackgroundListModel.this.Km(propId);
                        BackgroundListModel.this.nJA.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.mRecommand, BackgroundListModel.this.nJy);
                    } else if (responsedMessage.getError() != 2270014) {
                        int i = com.baidu.tieba.themeCenter.c.nIj;
                        if (responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nIk) {
                            i = com.baidu.tieba.themeCenter.c.nIi;
                        }
                        boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                        if (!fromDetail) {
                            if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == BackgroundListModel.this.getUniqueId()) && propId == BackgroundListModel.this.nJx.getPropId() && (Kn2 = BackgroundListModel.this.Kn(propId)) != null) {
                                BackgroundListModel.this.a(i, responsedMessage.getErrorString(), Kn2, fromDetail);
                            }
                        }
                    }
                }
            }
        }
    };
    private DressItemData nJz = new DressItemData();

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list);
    }

    static /* synthetic */ int a(BackgroundListModel backgroundListModel) {
        int i = backgroundListModel.currentPage;
        backgroundListModel.currentPage = i - 1;
        return i;
    }

    public void a(int i, String str, DressItemData dressItemData, boolean z) {
        int i2 = 0;
        if (dressItemData != null && dressItemData.getFreeUserLevel() == 101) {
            i2 = 9;
        }
        if (!StringUtils.isNull(str)) {
            if (i == com.baidu.tieba.themeCenter.c.nIi) {
                com.baidu.tieba.themeCenter.b.a(this.nJx.getPageContext(), z ? 4 : 2, str, i2, MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
            } else if (i == com.baidu.tieba.themeCenter.c.nIj) {
                com.baidu.tieba.themeCenter.b.a(this.nJx.getPageContext(), z ? 4 : 2, str, i2);
            }
        }
    }

    public BackgroundListModel(BackgroundListActivity backgroundListActivity) {
        this.nJx = backgroundListActivity;
        this.nJz.setPropsId(0);
        this.nJz.setTitle(TbadkCoreApplication.getInst().getString(R.string.default_background));
        this.nJy = new ArrayList();
        this.nJy.add(this.nJz);
        this.nJB = backgroundListActivity.getIntent().getBooleanExtra("member_buy_show", false);
        registerTask();
        registerListener(this.nJC);
        dRu();
        registerListener(this.nJh);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST, BackgroundListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST, 1003034, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
    }

    private void dRu() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, 1003036, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
        this.currentPage = 1;
        backgroundListRequestMessage.setPn(this.currentPage);
        backgroundListRequestMessage.setRn(9);
        sendMessage(backgroundListRequestMessage);
        return false;
    }

    public void dRv() {
        if (this.hasMore) {
            this.currentPage++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.currentPage);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean dRw() {
        return this.nJB;
    }

    public void a(a aVar) {
        this.nJA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km(int i) {
        if (this.nJy != null && this.nJy.size() > 0) {
            for (DressItemData dressItemData : this.nJy) {
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
    public void dRx() {
        DressItemData Kn;
        if (this.cVC && (Kn = Kn(0)) != null) {
            Kn.setInUse(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DressItemData Kn(int i) {
        if (this.nJy == null || this.nJy.size() <= 0) {
            return null;
        }
        for (DressItemData dressItemData : this.nJy) {
            if (dressItemData != null && dressItemData.getPropsId() == i) {
                return dressItemData;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.nJC);
        MessageManager.getInstance().unRegisterListener(this.nJh);
    }
}
