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
    private b lkS;
    private BubbleListModel lkT;
    private final int lkU = 0;
    private final int lkV = 50;
    private BubbleListModel.a lkW = new BubbleListModel.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.1
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void a(BubbleListData bubbleListData) {
            List<BubbleListData.BubbleData> b_info;
            BubbleChooseActivity.this.lkS.hideProgressBar();
            if (bubbleListData != null) {
                BubbleChooseActivity.this.lkS.setData(bubbleListData.getB_info(), BubbleListModel.eR(bubbleListData.getB_info()));
                if (BubbleChooseActivity.this.lkT.dfe() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == BubbleChooseActivity.this.lkT.dfe()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            BubbleChooseActivity.this.lkT.Eq(BubbleChooseActivity.this.lkT.dfe());
                            BubbleChooseActivity.this.lkT.W(BubbleChooseActivity.this.lkT.dfe(), l.getEquipmentWidth(BubbleChooseActivity.this.getPageContext().getPageActivity()), l.getEquipmentHeight(BubbleChooseActivity.this.getPageContext().getPageActivity()));
                        }
                    }
                    BubbleChooseActivity.this.lkT.Er(-1);
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void b(BubbleListData bubbleListData) {
            BubbleChooseActivity.this.lkS.hideProgressBar();
            BubbleChooseActivity.this.lkS.setData(null, false);
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
    private BubbleListModel.b lkX = new BubbleListModel.b() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.2
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void a(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lkS.hideProgressBar();
            int dfd = BubbleChooseActivity.this.lkT.dfd();
            a dfa = BubbleChooseActivity.this.lkS.dfa();
            if (dfd == 0) {
                dfa.tT(true);
                for (BubbleListData.BubbleData bubbleData : dfa.cSi()) {
                    if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                }
                dfa.notifyDataSetChanged();
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : dfa.cSi()) {
                    if (bubbleData2.getBcode() == dfd) {
                        bubbleData2.setIs_def(1);
                    } else if (bubbleData2.isDef()) {
                        bubbleData2.setIs_def(0);
                    }
                }
                dfa.tT(false);
                dfa.notifyDataSetChanged();
            } else {
                BubbleChooseActivity.this.showToast(R.string.setdefualt_error);
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void b(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lkS.hideProgressBar();
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
    private c.a lkY = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.3
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Eo(int i) {
            BubbleChooseActivity.this.En(i);
            BubbleChooseActivity.this.lkS.showProgressBar();
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void deZ() {
        }
    };
    private c.a lkZ = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.4
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Eo(int i) {
            TiebaStatic.eventStat(BubbleChooseActivity.this.getPageContext().getPageActivity(), "consume_19", "click");
            BubbleChooseActivity.this.lkT.Er(i);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BubbleChooseActivity.this.getPageContext().getPageActivity(), true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "pop_unable", 7);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void deZ() {
        }
    };
    public CustomMessageListener lla = new CustomMessageListener(CmdConfigCustom.BUBBLE_LIST_REFRESH) { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.5
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
        this.lkT = new BubbleListModel(getPageContext());
        this.lkT.a(this.lkW);
        this.lkT.a(this.lkX);
        this.lkT.a(this.lla);
        registerTask();
    }

    private void initView() {
        this.lkS = new b(getPageContext());
        this.lkS.dfc().setOnItemClickListener(this);
        this.lkS.showProgressBar();
    }

    private void registerTask() {
        this.lkT.dff();
        this.lkT.dfg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.lkT.I(0, 50, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lkT != null) {
            this.lkT.unRegisterListener();
            this.lkT.b(this.lla);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lkS.dfb()) {
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getPageContext().getString(R.string.web_title_bubble_explain), e.SERVER_ADDRESS_WEB_VIEW + Config.BUBBLE_EXPLAIN + TbConfig.getVersion(), true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lkS.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData Ep;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.lkS.dfc() && view != null && (view instanceof BubbleView) && (Ep = this.lkS.Ep(i)) != null) {
            if (Ep.getBcode() == 0 || Ep.canUse()) {
                En(Ep.getBcode());
                this.lkS.showProgressBar();
            } else if (Ep.isFree()) {
                c.a(getPageContext(), Ep, this.lkY);
            } else {
                c.b(getPageContext(), Ep, this.lkZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void En(int i) {
        this.lkT.W(i, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
        this.lkT.Eq(i);
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
