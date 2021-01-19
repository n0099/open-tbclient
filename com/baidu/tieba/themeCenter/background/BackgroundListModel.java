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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class BackgroundListModel extends BdBaseModel<BackgroundListActivity> {
    private List<DressItemData> mBackgroundList;
    private com.baidu.tieba.themeCenter.dressCenter.e mRecommand;
    private BackgroundListActivity nxh;
    private List<DressItemData> nxi;
    private a nxk;
    private boolean nxl;
    private int currentPage = 0;
    private boolean hasMore = true;
    private boolean cRP = false;
    private com.baidu.adp.framework.listener.a nxm = new com.baidu.adp.framework.listener.a(1003034, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST) { // from class: com.baidu.tieba.themeCenter.background.BackgroundListModel.1
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
                            BackgroundListModel.this.cRP = backgroundListHttpResponseMessage.getIsDefault();
                        } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                            BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                            BackgroundListModel.this.mRecommand = backgroundListSocketResponseMessage.getRecommand();
                            BackgroundListModel.this.mBackgroundList = backgroundListSocketResponseMessage.getBackgroundList();
                            BackgroundListModel.this.hasMore = backgroundListSocketResponseMessage.hasMore();
                            BackgroundListModel.this.cRP = backgroundListSocketResponseMessage.getIsDefault();
                        }
                        if (BackgroundListModel.this.nxi == null) {
                            BackgroundListModel.this.nxi = new ArrayList();
                            BackgroundListModel.this.nxi.add(BackgroundListModel.this.nxj);
                        }
                        if (BackgroundListModel.this.currentPage == 1) {
                            BackgroundListModel.this.nxi.clear();
                            BackgroundListModel.this.nxi.add(BackgroundListModel.this.nxj);
                        }
                        if (BackgroundListModel.this.mBackgroundList != null) {
                            BackgroundListModel.this.nxi.addAll(BackgroundListModel.this.mBackgroundList);
                        }
                    }
                    if (BackgroundListModel.this.nxk != null) {
                        BackgroundListModel.this.dOV();
                        BackgroundListModel.this.nxk.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.mRecommand, BackgroundListModel.this.nxi);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nwR = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.BackgroundListModel.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DressItemData JO;
            DressItemData JO2;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                    BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                    int propId = backgroundSetRequestMessage.getPropId();
                    if (responsedMessage.getError() == 0) {
                        if (propId == BackgroundListModel.this.nxh.getPropId() && (JO = BackgroundListModel.this.JO(propId)) != null) {
                            TiebaStatic.log(new aq("c10286").an("obj_id", propId).an("obj_type", JO.getFreeUserLevel()));
                        }
                        com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), propId);
                        BackgroundListModel.this.JN(propId);
                        BackgroundListModel.this.nxk.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.mRecommand, BackgroundListModel.this.nxi);
                    } else if (responsedMessage.getError() != 2270014) {
                        int i = com.baidu.tieba.themeCenter.c.nvT;
                        if (responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nvU) {
                            i = com.baidu.tieba.themeCenter.c.nvS;
                        }
                        boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                        if (!fromDetail) {
                            if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == BackgroundListModel.this.getUniqueId()) && propId == BackgroundListModel.this.nxh.getPropId() && (JO2 = BackgroundListModel.this.JO(propId)) != null) {
                                BackgroundListModel.this.a(i, responsedMessage.getErrorString(), JO2, fromDetail);
                            }
                        }
                    }
                }
            }
        }
    };
    private DressItemData nxj = new DressItemData();

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
            if (i == com.baidu.tieba.themeCenter.c.nvS) {
                com.baidu.tieba.themeCenter.b.a(this.nxh.getPageContext(), z ? 4 : 2, str, i2, MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
            } else if (i == com.baidu.tieba.themeCenter.c.nvT) {
                com.baidu.tieba.themeCenter.b.a(this.nxh.getPageContext(), z ? 4 : 2, str, i2);
            }
        }
    }

    public BackgroundListModel(BackgroundListActivity backgroundListActivity) {
        this.nxh = backgroundListActivity;
        this.nxj.setPropsId(0);
        this.nxj.setTitle(TbadkCoreApplication.getInst().getString(R.string.default_background));
        this.nxi = new ArrayList();
        this.nxi.add(this.nxj);
        this.nxl = backgroundListActivity.getIntent().getBooleanExtra("member_buy_show", false);
        registerTask();
        registerListener(this.nxm);
        dOS();
        registerListener(this.nwR);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST, BackgroundListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST, 1003034, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
    }

    private void dOS() {
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

    public void dOT() {
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

    public boolean dOU() {
        return this.nxl;
    }

    public void a(a aVar) {
        this.nxk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JN(int i) {
        if (this.nxi != null && this.nxi.size() > 0) {
            for (DressItemData dressItemData : this.nxi) {
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
    public void dOV() {
        DressItemData JO;
        if (this.cRP && (JO = JO(0)) != null) {
            JO.setInUse(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DressItemData JO(int i) {
        if (this.nxi == null || this.nxi.size() <= 0) {
            return null;
        }
        for (DressItemData dressItemData : this.nxi) {
            if (dressItemData != null && dressItemData.getPropsId() == i) {
                return dressItemData;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.nxm);
        MessageManager.getInstance().unRegisterListener(this.nwR);
    }
}
