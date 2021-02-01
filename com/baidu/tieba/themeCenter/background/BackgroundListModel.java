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
/* loaded from: classes9.dex */
public class BackgroundListModel extends BdBaseModel<BackgroundListActivity> {
    private List<DressItemData> mBackgroundList;
    private com.baidu.tieba.themeCenter.dressCenter.e mRecommand;
    private BackgroundListActivity nGR;
    private List<DressItemData> nGS;
    private a nGU;
    private boolean nGV;
    private int currentPage = 0;
    private boolean hasMore = true;
    private boolean cUc = false;
    private com.baidu.adp.framework.listener.a nGW = new com.baidu.adp.framework.listener.a(1003034, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST) { // from class: com.baidu.tieba.themeCenter.background.BackgroundListModel.1
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
                            BackgroundListModel.this.cUc = backgroundListHttpResponseMessage.getIsDefault();
                        } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                            BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                            BackgroundListModel.this.mRecommand = backgroundListSocketResponseMessage.getRecommand();
                            BackgroundListModel.this.mBackgroundList = backgroundListSocketResponseMessage.getBackgroundList();
                            BackgroundListModel.this.hasMore = backgroundListSocketResponseMessage.hasMore();
                            BackgroundListModel.this.cUc = backgroundListSocketResponseMessage.getIsDefault();
                        }
                        if (BackgroundListModel.this.nGS == null) {
                            BackgroundListModel.this.nGS = new ArrayList();
                            BackgroundListModel.this.nGS.add(BackgroundListModel.this.nGT);
                        }
                        if (BackgroundListModel.this.currentPage == 1) {
                            BackgroundListModel.this.nGS.clear();
                            BackgroundListModel.this.nGS.add(BackgroundListModel.this.nGT);
                        }
                        if (BackgroundListModel.this.mBackgroundList != null) {
                            BackgroundListModel.this.nGS.addAll(BackgroundListModel.this.mBackgroundList);
                        }
                    }
                    if (BackgroundListModel.this.nGU != null) {
                        BackgroundListModel.this.dRg();
                        BackgroundListModel.this.nGU.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.mRecommand, BackgroundListModel.this.nGS);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nGB = new com.baidu.adp.framework.listener.a(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET) { // from class: com.baidu.tieba.themeCenter.background.BackgroundListModel.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DressItemData Ki;
            DressItemData Ki2;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                    BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                    int propId = backgroundSetRequestMessage.getPropId();
                    if (responsedMessage.getError() == 0) {
                        if (propId == BackgroundListModel.this.nGR.getPropId() && (Ki = BackgroundListModel.this.Ki(propId)) != null) {
                            TiebaStatic.log(new ar("c10286").ap("obj_id", propId).ap("obj_type", Ki.getFreeUserLevel()));
                        }
                        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND + TbadkCoreApplication.getCurrentAccount(), propId);
                        BackgroundListModel.this.Kh(propId);
                        BackgroundListModel.this.nGU.a(responsedMessage.getError(), responsedMessage.getErrorString(), BackgroundListModel.this.mRecommand, BackgroundListModel.this.nGS);
                    } else if (responsedMessage.getError() != 2270014) {
                        int i = com.baidu.tieba.themeCenter.c.nFD;
                        if (responsedMessage.getError() == com.baidu.tieba.themeCenter.c.nFE) {
                            i = com.baidu.tieba.themeCenter.c.nFC;
                        }
                        boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                        if (!fromDetail) {
                            if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == BackgroundListModel.this.getUniqueId()) && propId == BackgroundListModel.this.nGR.getPropId() && (Ki2 = BackgroundListModel.this.Ki(propId)) != null) {
                                BackgroundListModel.this.a(i, responsedMessage.getErrorString(), Ki2, fromDetail);
                            }
                        }
                    }
                }
            }
        }
    };
    private DressItemData nGT = new DressItemData();

    /* loaded from: classes9.dex */
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
            if (i == com.baidu.tieba.themeCenter.c.nFC) {
                com.baidu.tieba.themeCenter.b.a(this.nGR.getPageContext(), z ? 4 : 2, str, i2, MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
            } else if (i == com.baidu.tieba.themeCenter.c.nFD) {
                com.baidu.tieba.themeCenter.b.a(this.nGR.getPageContext(), z ? 4 : 2, str, i2);
            }
        }
    }

    public BackgroundListModel(BackgroundListActivity backgroundListActivity) {
        this.nGR = backgroundListActivity;
        this.nGT.setPropsId(0);
        this.nGT.setTitle(TbadkCoreApplication.getInst().getString(R.string.default_background));
        this.nGS = new ArrayList();
        this.nGS.add(this.nGT);
        this.nGV = backgroundListActivity.getIntent().getBooleanExtra("member_buy_show", false);
        registerTask();
        registerListener(this.nGW);
        dRd();
        registerListener(this.nGB);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST, BackgroundListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST, 1003034, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
    }

    private void dRd() {
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

    public void dRe() {
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

    public boolean dRf() {
        return this.nGV;
    }

    public void a(a aVar) {
        this.nGU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(int i) {
        if (this.nGS != null && this.nGS.size() > 0) {
            for (DressItemData dressItemData : this.nGS) {
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
    public void dRg() {
        DressItemData Ki;
        if (this.cUc && (Ki = Ki(0)) != null) {
            Ki.setInUse(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DressItemData Ki(int i) {
        if (this.nGS == null || this.nGS.size() <= 0) {
            return null;
        }
        for (DressItemData dressItemData : this.nGS) {
            if (dressItemData != null && dressItemData.getPropsId() == i) {
                return dressItemData;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.nGW);
        MessageManager.getInstance().unRegisterListener(this.nGB);
    }
}
