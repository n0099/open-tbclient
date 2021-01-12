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
    private b lcB;
    private BubbleListModel lcC;
    private final int lcD = 0;
    private final int lcE = 50;
    private BubbleListModel.a lcF = new BubbleListModel.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.1
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void a(BubbleListData bubbleListData) {
            List<BubbleListData.BubbleData> b_info;
            BubbleChooseActivity.this.lcB.hideProgressBar();
            if (bubbleListData != null) {
                BubbleChooseActivity.this.lcB.setData(bubbleListData.getB_info(), BubbleListModel.eT(bubbleListData.getB_info()));
                if (BubbleChooseActivity.this.lcC.dcX() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == BubbleChooseActivity.this.lcC.dcX()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            BubbleChooseActivity.this.lcC.DY(BubbleChooseActivity.this.lcC.dcX());
                            BubbleChooseActivity.this.lcC.Y(BubbleChooseActivity.this.lcC.dcX(), l.getEquipmentWidth(BubbleChooseActivity.this.getPageContext().getPageActivity()), l.getEquipmentHeight(BubbleChooseActivity.this.getPageContext().getPageActivity()));
                        }
                    }
                    BubbleChooseActivity.this.lcC.DZ(-1);
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void b(BubbleListData bubbleListData) {
            BubbleChooseActivity.this.lcB.hideProgressBar();
            BubbleChooseActivity.this.lcB.setData(null, false);
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
    private BubbleListModel.b lcG = new BubbleListModel.b() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.2
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void a(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lcB.hideProgressBar();
            int dcW = BubbleChooseActivity.this.lcC.dcW();
            a dcT = BubbleChooseActivity.this.lcB.dcT();
            if (dcW == 0) {
                dcT.tG(true);
                for (BubbleListData.BubbleData bubbleData : dcT.cQc()) {
                    if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                }
                dcT.notifyDataSetChanged();
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : dcT.cQc()) {
                    if (bubbleData2.getBcode() == dcW) {
                        bubbleData2.setIs_def(1);
                    } else if (bubbleData2.isDef()) {
                        bubbleData2.setIs_def(0);
                    }
                }
                dcT.tG(false);
                dcT.notifyDataSetChanged();
            } else {
                BubbleChooseActivity.this.showToast(R.string.setdefualt_error);
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void b(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lcB.hideProgressBar();
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
    private c.a lcH = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.3
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void DW(int i) {
            BubbleChooseActivity.this.DV(i);
            BubbleChooseActivity.this.lcB.showProgressBar();
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void dcS() {
        }
    };
    private c.a lcI = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.4
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void DW(int i) {
            TiebaStatic.eventStat(BubbleChooseActivity.this.getPageContext().getPageActivity(), "consume_19", "click");
            BubbleChooseActivity.this.lcC.DZ(i);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BubbleChooseActivity.this.getPageContext().getPageActivity(), true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "pop_unable", 7);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void dcS() {
        }
    };
    public CustomMessageListener lcJ = new CustomMessageListener(CmdConfigCustom.BUBBLE_LIST_REFRESH) { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.5
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
        this.lcC = new BubbleListModel(getPageContext());
        this.lcC.a(this.lcF);
        this.lcC.a(this.lcG);
        this.lcC.a(this.lcJ);
        registerTask();
    }

    private void initView() {
        this.lcB = new b(getPageContext());
        this.lcB.dcV().setOnItemClickListener(this);
        this.lcB.showProgressBar();
    }

    private void registerTask() {
        this.lcC.dcY();
        this.lcC.dcZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.lcC.K(0, 50, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lcC != null) {
            this.lcC.unRegisterListener();
            this.lcC.b(this.lcJ);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lcB.dcU()) {
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getPageContext().getString(R.string.web_title_bubble_explain), e.SERVER_ADDRESS_WEB_VIEW + Config.BUBBLE_EXPLAIN + TbConfig.getVersion(), true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lcB.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData DX;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.lcB.dcV() && view != null && (view instanceof BubbleView) && (DX = this.lcB.DX(i)) != null) {
            if (DX.getBcode() == 0 || DX.canUse()) {
                DV(DX.getBcode());
                this.lcB.showProgressBar();
            } else if (DX.isFree()) {
                c.a(getPageContext(), DX, this.lcH);
            } else {
                c.b(getPageContext(), DX, this.lcI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DV(int i) {
        this.lcC.Y(i, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
        this.lcC.DY(i);
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
