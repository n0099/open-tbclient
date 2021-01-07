package com.baidu.tieba.memberCenter.bubble;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.c;
import java.util.List;
/* loaded from: classes9.dex */
public class BubbleChooseActivity extends BaseActivity<BubbleChooseActivity> {
    private b lhh;
    private BubbleListModel lhi;
    private final int lhj = 0;
    private final int lhk = 50;
    private BubbleListModel.a lhl = new BubbleListModel.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.1
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void a(BubbleListData bubbleListData) {
            List<BubbleListData.BubbleData> b_info;
            BubbleChooseActivity.this.lhh.hideProgressBar();
            if (bubbleListData != null) {
                BubbleChooseActivity.this.lhh.setData(bubbleListData.getB_info(), BubbleListModel.eT(bubbleListData.getB_info()));
                if (BubbleChooseActivity.this.lhi.dgP() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == BubbleChooseActivity.this.lhi.dgP()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            BubbleChooseActivity.this.lhi.FE(BubbleChooseActivity.this.lhi.dgP());
                            BubbleChooseActivity.this.lhi.Y(BubbleChooseActivity.this.lhi.dgP(), l.getEquipmentWidth(BubbleChooseActivity.this.getPageContext().getPageActivity()), l.getEquipmentHeight(BubbleChooseActivity.this.getPageContext().getPageActivity()));
                        }
                    }
                    BubbleChooseActivity.this.lhi.FF(-1);
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void b(BubbleListData bubbleListData) {
            BubbleChooseActivity.this.lhh.hideProgressBar();
            BubbleChooseActivity.this.lhh.setData(null, false);
            if (bubbleListData != null) {
                if (!bubbleListData.getError_code().equals("0")) {
                    if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                        BubbleChooseActivity.this.showToast(bubbleListData.getError_msg());
                        return;
                    } else {
                        BubbleChooseActivity.this.showToast(R.string.neterror);
                        return;
                    }
                }
                BubbleChooseActivity.this.showToast(R.string.neterror);
                return;
            }
            BubbleChooseActivity.this.showToast(R.string.neterror);
        }
    };
    private BubbleListModel.b lhm = new BubbleListModel.b() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.2
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void a(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lhh.hideProgressBar();
            int dgO = BubbleChooseActivity.this.lhi.dgO();
            a dgL = BubbleChooseActivity.this.lhh.dgL();
            if (dgO == 0) {
                dgL.tK(true);
                for (BubbleListData.BubbleData bubbleData : dgL.cTU()) {
                    if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                }
                dgL.notifyDataSetChanged();
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : dgL.cTU()) {
                    if (bubbleData2.getBcode() == dgO) {
                        bubbleData2.setIs_def(1);
                    } else if (bubbleData2.isDef()) {
                        bubbleData2.setIs_def(0);
                    }
                }
                dgL.tK(false);
                dgL.notifyDataSetChanged();
            } else {
                BubbleChooseActivity.this.showToast(R.string.setdefualt_error);
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void b(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lhh.hideProgressBar();
            if (setBubbleResultData != null) {
                if (!setBubbleResultData.getError_code().equals("0")) {
                    if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                        BubbleChooseActivity.this.showToast(setBubbleResultData.getError_msg());
                        return;
                    } else {
                        BubbleChooseActivity.this.showToast(R.string.neterror);
                        return;
                    }
                }
                BubbleChooseActivity.this.showToast(R.string.neterror);
                return;
            }
            BubbleChooseActivity.this.showToast(R.string.neterror);
        }
    };
    private c.a lhn = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.3
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void FC(int i) {
            BubbleChooseActivity.this.FB(i);
            BubbleChooseActivity.this.lhh.showProgressBar();
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void dgK() {
        }
    };
    private c.a lho = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.4
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void FC(int i) {
            TiebaStatic.eventStat(BubbleChooseActivity.this.getPageContext().getPageActivity(), "consume_19", "click");
            BubbleChooseActivity.this.lhi.FF(i);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BubbleChooseActivity.this.getPageContext().getPageActivity(), true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "pop_unable", 7);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void dgK() {
        }
    };
    public CustomMessageListener lhp = new CustomMessageListener(CmdConfigCustom.BUBBLE_LIST_REFRESH) { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BubbleChooseActivity.this.loadData();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initView();
        loadData();
    }

    private void initData() {
        this.lhi = new BubbleListModel(getPageContext());
        this.lhi.a(this.lhl);
        this.lhi.a(this.lhm);
        this.lhi.a(this.lhp);
        registerTask();
    }

    private void initView() {
        this.lhh = new b(getPageContext());
        this.lhh.dgN().setOnItemClickListener(this);
        this.lhh.showProgressBar();
    }

    private void registerTask() {
        this.lhi.dgQ();
        this.lhi.dgR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.lhi.K(0, 50, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lhi != null) {
            this.lhi.unRegisterListener();
            this.lhi.b(this.lhp);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lhh.dgM()) {
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getPageContext().getString(R.string.web_title_bubble_explain), e.SERVER_ADDRESS_WEB_VIEW + Config.BUBBLE_EXPLAIN + TbConfig.getVersion(), true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lhh.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData FD;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.lhh.dgN() && view != null && (view instanceof BubbleView) && (FD = this.lhh.FD(i)) != null) {
            if (FD.getBcode() == 0 || FD.canUse()) {
                FB(FD.getBcode());
                this.lhh.showProgressBar();
            } else if (FD.isFree()) {
                c.a(getPageContext(), FD, this.lhn);
            } else {
                c.b(getPageContext(), FD, this.lho);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FB(int i) {
        this.lhi.Y(i, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
        this.lhi.FE(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 23004) {
            loadData();
        }
    }
}
