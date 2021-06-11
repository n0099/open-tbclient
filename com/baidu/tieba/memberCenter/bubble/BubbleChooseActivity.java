package com.baidu.tieba.memberCenter.bubble;

import android.app.Activity;
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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import d.a.c.e.p.l;
import d.a.n0.s1.a.c;
import java.util.List;
/* loaded from: classes3.dex */
public class BubbleChooseActivity extends BaseActivity<BubbleChooseActivity> {
    public d.a.n0.s1.a.b mBubbleChooseView;
    public BubbleListModel mBubbleModel;
    public final int PAGE_NUM = 0;
    public final int PAGE_LENGTH = 50;
    public BubbleListModel.c mRequestDataCallBack = new a();
    public BubbleListModel.d mSetBubbleCallBack = new b();
    public c.e mFreeBubbleTipDialogCallback = new c();
    public c.e mPayBubbleTipDialogCallback = new d();
    public CustomMessageListener mRefreshListener = new e(2010040);

    /* loaded from: classes3.dex */
    public class a implements BubbleListModel.c {
        public a() {
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void a(BubbleListData bubbleListData) {
            BubbleChooseActivity.this.mBubbleChooseView.h();
            BubbleChooseActivity.this.mBubbleChooseView.i(null, false);
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

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.c
        public void b(BubbleListData bubbleListData) {
            List<BubbleListData.BubbleData> b_info;
            BubbleChooseActivity.this.mBubbleChooseView.h();
            if (bubbleListData == null) {
                return;
            }
            BubbleChooseActivity.this.mBubbleChooseView.i(bubbleListData.getB_info(), BubbleListModel.y(bubbleListData.getB_info()));
            if (BubbleChooseActivity.this.mBubbleModel.A() <= 0 || (b_info = bubbleListData.getB_info()) == null || b_info.size() == 0) {
                return;
            }
            for (BubbleListData.BubbleData bubbleData : b_info) {
                if (bubbleData != null && bubbleData.getBcode() == BubbleChooseActivity.this.mBubbleModel.A()) {
                    if (!bubbleData.canUse() && !bubbleData.isFree()) {
                        break;
                    }
                    BubbleChooseActivity.this.mBubbleModel.G(BubbleChooseActivity.this.mBubbleModel.A());
                    BubbleChooseActivity.this.mBubbleModel.F(BubbleChooseActivity.this.mBubbleModel.A(), l.k(BubbleChooseActivity.this.getPageContext().getPageActivity()), l.i(BubbleChooseActivity.this.getPageContext().getPageActivity()));
                }
            }
            BubbleChooseActivity.this.mBubbleModel.H(-1);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BubbleListModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void a(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.mBubbleChooseView.h();
            int z = BubbleChooseActivity.this.mBubbleModel.z();
            d.a.n0.s1.a.a d2 = BubbleChooseActivity.this.mBubbleChooseView.d();
            if (z == 0) {
                d2.d(true);
                for (BubbleListData.BubbleData bubbleData : d2.b()) {
                    if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                }
                d2.notifyDataSetChanged();
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : d2.b()) {
                    if (bubbleData2.getBcode() == z) {
                        bubbleData2.setIs_def(1);
                    } else if (bubbleData2.isDef()) {
                        bubbleData2.setIs_def(0);
                    }
                }
                d2.d(false);
                d2.notifyDataSetChanged();
            } else {
                BubbleChooseActivity.this.showToast(R.string.setdefualt_error);
            }
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void b(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.mBubbleChooseView.h();
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
    }

    /* loaded from: classes3.dex */
    public class c implements c.e {
        public c() {
        }

        @Override // d.a.n0.s1.a.c.e
        public void a(int i2) {
            BubbleChooseActivity.this.useBubble(i2);
            BubbleChooseActivity.this.mBubbleChooseView.k();
        }

        @Override // d.a.n0.s1.a.c.e
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.e {
        public d() {
        }

        @Override // d.a.n0.s1.a.c.e
        public void a(int i2) {
            TiebaStatic.eventStat(BubbleChooseActivity.this.getPageContext().getPageActivity(), "consume_19", PrefetchEvent.STATE_CLICK);
            BubbleChooseActivity.this.mBubbleModel.H(i2);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BubbleChooseActivity.this.getPageContext().getPageActivity(), true, 23004, "pop_unable", 7);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }

        @Override // d.a.n0.s1.a.c.e
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BubbleChooseActivity.this.loadData();
        }
    }

    private void initData() {
        BubbleListModel bubbleListModel = new BubbleListModel(getPageContext());
        this.mBubbleModel = bubbleListModel;
        bubbleListModel.I(this.mRequestDataCallBack);
        this.mBubbleModel.J(this.mSetBubbleCallBack);
        this.mBubbleModel.D(this.mRefreshListener);
        registerTask();
    }

    private void initView() {
        d.a.n0.s1.a.b bVar = new d.a.n0.s1.a.b(getPageContext());
        this.mBubbleChooseView = bVar;
        bVar.f().setOnItemClickListener(this);
        this.mBubbleChooseView.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.mBubbleModel.E(0, 50, l.k(getPageContext().getPageActivity()), l.i(getPageContext().getPageActivity()));
    }

    private void registerTask() {
        this.mBubbleModel.B();
        this.mBubbleModel.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void useBubble(int i2) {
        this.mBubbleModel.F(i2, l.k(getPageContext().getPageActivity()), l.i(getPageContext().getPageActivity()));
        this.mBubbleModel.G(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 23004) {
            loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mBubbleChooseView.onChangeSkinType(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mBubbleChooseView.e()) {
            Activity pageActivity = getPageContext().getPageActivity();
            String string = getPageContext().getString(R.string.web_title_bubble_explain);
            d.a.m0.l.a.o(pageActivity, string, TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=1&_client_version=" + TbConfig.getVersion(), true, true, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initView();
        loadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BubbleListModel bubbleListModel = this.mBubbleModel;
        if (bubbleListModel != null) {
            bubbleListModel.unRegisterListener();
            this.mBubbleModel.K(this.mRefreshListener);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        BubbleListData.BubbleData g2;
        super.onItemClick(adapterView, view, i2, j);
        if (adapterView != this.mBubbleChooseView.f() || view == null || !(view instanceof BubbleView) || (g2 = this.mBubbleChooseView.g(i2)) == null) {
            return;
        }
        if (g2.getBcode() != 0 && !g2.canUse()) {
            if (g2.isFree()) {
                d.a.n0.s1.a.c.a(getPageContext(), g2, this.mFreeBubbleTipDialogCallback);
                return;
            } else {
                d.a.n0.s1.a.c.b(getPageContext(), g2, this.mPayBubbleTipDialogCallback);
                return;
            }
        }
        useBubble(g2.getBcode());
        this.mBubbleChooseView.k();
    }
}
