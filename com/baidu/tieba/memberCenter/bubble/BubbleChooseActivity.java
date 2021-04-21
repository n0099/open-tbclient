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
import d.b.c.e.p.l;
import d.b.j0.r1.a.c;
import java.util.List;
/* loaded from: classes3.dex */
public class BubbleChooseActivity extends BaseActivity<BubbleChooseActivity> {
    public d.b.j0.r1.a.b mBubbleChooseView;
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
            BubbleChooseActivity.this.mBubbleChooseView.i(bubbleListData.getB_info(), BubbleListModel.u(bubbleListData.getB_info()));
            if (BubbleChooseActivity.this.mBubbleModel.w() <= 0 || (b_info = bubbleListData.getB_info()) == null || b_info.size() == 0) {
                return;
            }
            for (BubbleListData.BubbleData bubbleData : b_info) {
                if (bubbleData != null && bubbleData.getBcode() == BubbleChooseActivity.this.mBubbleModel.w()) {
                    if (!bubbleData.canUse() && !bubbleData.isFree()) {
                        break;
                    }
                    BubbleChooseActivity.this.mBubbleModel.C(BubbleChooseActivity.this.mBubbleModel.w());
                    BubbleChooseActivity.this.mBubbleModel.B(BubbleChooseActivity.this.mBubbleModel.w(), l.k(BubbleChooseActivity.this.getPageContext().getPageActivity()), l.i(BubbleChooseActivity.this.getPageContext().getPageActivity()));
                }
            }
            BubbleChooseActivity.this.mBubbleModel.D(-1);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BubbleListModel.d {
        public b() {
        }

        @Override // com.baidu.tieba.memberCenter.bubble.BubbleListModel.d
        public void a(SetBubbleResultData setBubbleResultData) {
            BubbleChooseActivity.this.mBubbleChooseView.h();
            int v = BubbleChooseActivity.this.mBubbleModel.v();
            d.b.j0.r1.a.a d2 = BubbleChooseActivity.this.mBubbleChooseView.d();
            if (v == 0) {
                d2.d(true);
                for (BubbleListData.BubbleData bubbleData : d2.b()) {
                    if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                }
                d2.notifyDataSetChanged();
            } else if (setBubbleResultData.getB_info().canUser()) {
                for (BubbleListData.BubbleData bubbleData2 : d2.b()) {
                    if (bubbleData2.getBcode() == v) {
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

        @Override // d.b.j0.r1.a.c.e
        public void a(int i) {
            BubbleChooseActivity.this.useBubble(i);
            BubbleChooseActivity.this.mBubbleChooseView.k();
        }

        @Override // d.b.j0.r1.a.c.e
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.e {
        public d() {
        }

        @Override // d.b.j0.r1.a.c.e
        public void a(int i) {
            TiebaStatic.eventStat(BubbleChooseActivity.this.getPageContext().getPageActivity(), "consume_19", PrefetchEvent.STATE_CLICK);
            BubbleChooseActivity.this.mBubbleModel.D(i);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) BubbleChooseActivity.this.getPageContext().getPageActivity(), true, 23004, "pop_unable", 7);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }

        @Override // d.b.j0.r1.a.c.e
        public void b() {
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
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
        bubbleListModel.E(this.mRequestDataCallBack);
        this.mBubbleModel.F(this.mSetBubbleCallBack);
        this.mBubbleModel.z(this.mRefreshListener);
        registerTask();
    }

    private void initView() {
        d.b.j0.r1.a.b bVar = new d.b.j0.r1.a.b(getPageContext());
        this.mBubbleChooseView = bVar;
        bVar.f().setOnItemClickListener(this);
        this.mBubbleChooseView.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.mBubbleModel.A(0, 50, l.k(getPageContext().getPageActivity()), l.i(getPageContext().getPageActivity()));
    }

    private void registerTask() {
        this.mBubbleModel.x();
        this.mBubbleModel.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void useBubble(int i) {
        this.mBubbleModel.B(i, l.k(getPageContext().getPageActivity()), l.i(getPageContext().getPageActivity()));
        this.mBubbleModel.C(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 23004) {
            loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mBubbleChooseView.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mBubbleChooseView.e()) {
            Activity pageActivity = getPageContext().getPageActivity();
            String string = getPageContext().getString(R.string.web_title_bubble_explain);
            d.b.i0.l.a.o(pageActivity, string, TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=1&_client_version=" + TbConfig.getVersion(), true, true, true);
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
            this.mBubbleModel.G(this.mRefreshListener);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData g2;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView != this.mBubbleChooseView.f() || view == null || !(view instanceof BubbleView) || (g2 = this.mBubbleChooseView.g(i)) == null) {
            return;
        }
        if (g2.getBcode() != 0 && !g2.canUse()) {
            if (g2.isFree()) {
                d.b.j0.r1.a.c.a(getPageContext(), g2, this.mFreeBubbleTipDialogCallback);
                return;
            } else {
                d.b.j0.r1.a.c.b(getPageContext(), g2, this.mPayBubbleTipDialogCallback);
                return;
            }
        }
        useBubble(g2.getBcode());
        this.mBubbleChooseView.k();
    }
}
