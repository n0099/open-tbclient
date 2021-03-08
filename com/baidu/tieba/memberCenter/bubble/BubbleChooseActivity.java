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
/* loaded from: classes8.dex */
public class BubbleChooseActivity extends BaseActivity<BubbleChooseActivity> {
    private b lmU;
    private BubbleListModel lmV;
    private final int lmW = 0;
    private final int lmX = 50;
    private BubbleListModel.a lmY = new BubbleListModel.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.1
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void a(BubbleListData bubbleListData) {
            List<BubbleListData.BubbleData> b_info;
            BubbleChooseActivity.this.lmU.hideProgressBar();
            if (bubbleListData != null) {
                BubbleChooseActivity.this.lmU.setData(bubbleListData.getB_info(), BubbleListModel.eR(bubbleListData.getB_info()));
                if (BubbleChooseActivity.this.lmV.dfn() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == BubbleChooseActivity.this.lmV.dfn()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            BubbleChooseActivity.this.lmV.Et(BubbleChooseActivity.this.lmV.dfn());
                            BubbleChooseActivity.this.lmV.W(BubbleChooseActivity.this.lmV.dfn(), l.getEquipmentWidth(BubbleChooseActivity.this.getPageContext().getPageActivity()), l.getEquipmentHeight(BubbleChooseActivity.this.getPageContext().getPageActivity()));
                        }
                    }
                    BubbleChooseActivity.this.lmV.Eu(-1);
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void b(BubbleListData bubbleListData) {
            BubbleChooseActivity.this.lmU.hideProgressBar();
            BubbleChooseActivity.this.lmU.setData(null, false);
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
    private BubbleListModel.b lmZ = new BubbleListModel.b() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.2
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void a(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lmU.hideProgressBar();
            int dfm = BubbleChooseActivity.this.lmV.dfm();
            a dfj = BubbleChooseActivity.this.lmU.dfj();
            if (dfm == 0) {
                dfj.tT(true);
                for (BubbleListData.BubbleData bubbleData : dfj.cSp()) {
                    if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                }
                dfj.notifyDataSetChanged();
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : dfj.cSp()) {
                    if (bubbleData2.getBcode() == dfm) {
                        bubbleData2.setIs_def(1);
                    } else if (bubbleData2.isDef()) {
                        bubbleData2.setIs_def(0);
                    }
                }
                dfj.tT(false);
                dfj.notifyDataSetChanged();
            } else {
                BubbleChooseActivity.this.showToast(R.string.setdefualt_error);
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void b(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lmU.hideProgressBar();
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
    private c.a lna = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.3
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Er(int i) {
            BubbleChooseActivity.this.Eq(i);
            BubbleChooseActivity.this.lmU.showProgressBar();
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void dfi() {
        }
    };
    private c.a lnb = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.4
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Er(int i) {
            TiebaStatic.eventStat(BubbleChooseActivity.this.getPageContext().getPageActivity(), "consume_19", "click");
            BubbleChooseActivity.this.lmV.Eu(i);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BubbleChooseActivity.this.getPageContext().getPageActivity(), true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "pop_unable", 7);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void dfi() {
        }
    };
    public CustomMessageListener lnc = new CustomMessageListener(CmdConfigCustom.BUBBLE_LIST_REFRESH) { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.5
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
        this.lmV = new BubbleListModel(getPageContext());
        this.lmV.a(this.lmY);
        this.lmV.a(this.lmZ);
        this.lmV.a(this.lnc);
        registerTask();
    }

    private void initView() {
        this.lmU = new b(getPageContext());
        this.lmU.dfl().setOnItemClickListener(this);
        this.lmU.showProgressBar();
    }

    private void registerTask() {
        this.lmV.dfo();
        this.lmV.dfp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.lmV.I(0, 50, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lmV != null) {
            this.lmV.unRegisterListener();
            this.lmV.b(this.lnc);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lmU.dfk()) {
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getPageContext().getString(R.string.web_title_bubble_explain), e.SERVER_ADDRESS_WEB_VIEW + Config.BUBBLE_EXPLAIN + TbConfig.getVersion(), true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lmU.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData Es;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.lmU.dfl() && view != null && (view instanceof BubbleView) && (Es = this.lmU.Es(i)) != null) {
            if (Es.getBcode() == 0 || Es.canUse()) {
                Eq(Es.getBcode());
                this.lmU.showProgressBar();
            } else if (Es.isFree()) {
                c.a(getPageContext(), Es, this.lna);
            } else {
                c.b(getPageContext(), Es, this.lnb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq(int i) {
        this.lmV.W(i, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
        this.lmV.Et(i);
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
