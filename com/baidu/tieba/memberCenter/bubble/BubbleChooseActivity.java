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
    private b lkE;
    private BubbleListModel lkF;
    private final int lkG = 0;
    private final int lkH = 50;
    private BubbleListModel.a lkI = new BubbleListModel.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.1
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void a(BubbleListData bubbleListData) {
            List<BubbleListData.BubbleData> b_info;
            BubbleChooseActivity.this.lkE.hideProgressBar();
            if (bubbleListData != null) {
                BubbleChooseActivity.this.lkE.setData(bubbleListData.getB_info(), BubbleListModel.eR(bubbleListData.getB_info()));
                if (BubbleChooseActivity.this.lkF.deX() > 0 && (b_info = bubbleListData.getB_info()) != null && b_info.size() != 0) {
                    for (BubbleListData.BubbleData bubbleData : b_info) {
                        if (bubbleData != null && bubbleData.getBcode() == BubbleChooseActivity.this.lkF.deX()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            BubbleChooseActivity.this.lkF.Eq(BubbleChooseActivity.this.lkF.deX());
                            BubbleChooseActivity.this.lkF.W(BubbleChooseActivity.this.lkF.deX(), l.getEquipmentWidth(BubbleChooseActivity.this.getPageContext().getPageActivity()), l.getEquipmentHeight(BubbleChooseActivity.this.getPageContext().getPageActivity()));
                        }
                    }
                    BubbleChooseActivity.this.lkF.Er(-1);
                }
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.a
        public void b(BubbleListData bubbleListData) {
            BubbleChooseActivity.this.lkE.hideProgressBar();
            BubbleChooseActivity.this.lkE.setData(null, false);
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
    private BubbleListModel.b lkJ = new BubbleListModel.b() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.2
        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void a(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lkE.hideProgressBar();
            int deW = BubbleChooseActivity.this.lkF.deW();
            a deT = BubbleChooseActivity.this.lkE.deT();
            if (deW == 0) {
                deT.tT(true);
                for (BubbleListData.BubbleData bubbleData : deT.cSb()) {
                    if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                }
                deT.notifyDataSetChanged();
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : deT.cSb()) {
                    if (bubbleData2.getBcode() == deW) {
                        bubbleData2.setIs_def(1);
                    } else if (bubbleData2.isDef()) {
                        bubbleData2.setIs_def(0);
                    }
                }
                deT.tT(false);
                deT.notifyDataSetChanged();
            } else {
                BubbleChooseActivity.this.showToast(R.string.setdefualt_error);
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.b
        public void b(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.lkE.hideProgressBar();
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
    private c.a lkK = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.3
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Eo(int i) {
            BubbleChooseActivity.this.En(i);
            BubbleChooseActivity.this.lkE.showProgressBar();
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void deS() {
        }
    };
    private c.a lkL = new c.a() { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.4
        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void Eo(int i) {
            TiebaStatic.eventStat(BubbleChooseActivity.this.getPageContext().getPageActivity(), "consume_19", "click");
            BubbleChooseActivity.this.lkF.Er(i);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BubbleChooseActivity.this.getPageContext().getPageActivity(), true, (int) RequestResponseCode.REQUEST_PAY_BUBBLE_CODE, "pop_unable", 7);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
        }

        @Override // com.baidu.tieba.memberCenter.bubble.c.a
        public void deS() {
        }
    };
    public CustomMessageListener lkM = new CustomMessageListener(CmdConfigCustom.BUBBLE_LIST_REFRESH) { // from class: com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity.5
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
        this.lkF = new BubbleListModel(getPageContext());
        this.lkF.a(this.lkI);
        this.lkF.a(this.lkJ);
        this.lkF.a(this.lkM);
        registerTask();
    }

    private void initView() {
        this.lkE = new b(getPageContext());
        this.lkE.deV().setOnItemClickListener(this);
        this.lkE.showProgressBar();
    }

    private void registerTask() {
        this.lkF.deY();
        this.lkF.deZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.lkF.I(0, 50, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lkF != null) {
            this.lkF.unRegisterListener();
            this.lkF.b(this.lkM);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.lkE.deU()) {
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getPageContext().getString(R.string.web_title_bubble_explain), e.SERVER_ADDRESS_WEB_VIEW + Config.BUBBLE_EXPLAIN + TbConfig.getVersion(), true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lkE.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData Ep;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.lkE.deV() && view != null && (view instanceof BubbleView) && (Ep = this.lkE.Ep(i)) != null) {
            if (Ep.getBcode() == 0 || Ep.canUse()) {
                En(Ep.getBcode());
                this.lkE.showProgressBar();
            } else if (Ep.isFree()) {
                c.a(getPageContext(), Ep, this.lkK);
            } else {
                c.b(getPageContext(), Ep, this.lkL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void En(int i) {
        this.lkF.W(i, l.getEquipmentWidth(getPageContext().getPageActivity()), l.getEquipmentHeight(getPageContext().getPageActivity()));
        this.lkF.Eq(i);
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
