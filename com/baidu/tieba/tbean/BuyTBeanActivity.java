package com.baidu.tieba.tbean;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.BuyTBeanModel;
import d.a.n0.r.s.a;
/* loaded from: classes5.dex */
public class BuyTBeanActivity extends BaseActivity<BuyTBeanActivity> implements BuyTBeanModel.e {
    public static final String GIFT_TBEAN = "gift_tbean";
    public String mClickZone;
    public float mGiftBbean;
    public BuyTBeanModel mModel;
    public PayConfigModel mPayConfigModel;
    public String mReferPage;
    public d.a.o0.g3.a mTBeanView;
    public boolean mIsPayDialog = true;
    public String SCENE_ID = "4001001000";
    public boolean isFromAlaLiveRoom = false;
    public int isFromDecreaseGiftStepStrategy = 0;
    public float moneyLeft = 0.0f;
    public CustomMessageListener roomClosedListener = new d(2921407);

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.l0.a {
        public a() {
        }

        @Override // d.a.n0.l0.a
        public void a() {
            d.a.n0.l0.d.c().b(String.format("http://tieba.baidu.com/mo/q/tbeanget?difference=%1$s&fr=0&return_type=1&return_url=%2$s", String.valueOf(BuyTBeanActivity.this.mGiftBbean), d.a.n0.l0.c.f53279a) + "&refer_page=" + BuyTBeanActivity.this.mReferPage + "&click_zone=" + BuyTBeanActivity.this.mClickZone, BuyTBeanActivity.this.getPageContext());
            BuyTBeanActivity.this.finish();
        }

        @Override // d.a.n0.l0.a
        public void b() {
            BuyTBeanActivity.this.mModel.J();
        }

        @Override // d.a.n0.l0.a
        public void onError(String str) {
            BuyTBeanActivity.this.mModel.J();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            BuyTBeanActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BuyTBeanActivity.this.isFromDecreaseGiftStepStrategy == 1 || BuyTBeanActivity.this.isFromDecreaseGiftStepStrategy == 2 || BuyTBeanActivity.this.isFromDecreaseGiftStepStrategy == 3) {
                BuyTBeanActivity.this.closeActivity();
            }
        }
    }

    private void getGiftTBean(Intent intent) {
        this.mGiftBbean = intent.getFloatExtra("gift_tbean", 0.0f);
    }

    private void processClose() {
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this);
        aVar.setAutoNight(true);
        aVar.setCancelable(true);
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.setTitle(getString(R.string.buy_tbean_exit_dialog_title));
        aVar.setMessage(getString(R.string.buy_tbean_exit_dialog_sub_title));
        aVar.setPositiveButton(getString(R.string.go_on), new b());
        aVar.setNegativeButton(getString(R.string.buy_tbean_exit_dialog_quit), new c());
        aVar.create(getPageContext()).show();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    public String getClickZone() {
        return this.mClickZone;
    }

    public String getReferPage() {
        return this.mReferPage;
    }

    public boolean isFromAlaLiveRoom() {
        return this.isFromAlaLiveRoom;
    }

    public int isFromDecreaseGiftStepStrategy() {
        return this.isFromDecreaseGiftStepStrategy;
    }

    public boolean isPayDialog() {
        return this.mIsPayDialog;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (intent == null || !intent.getBooleanExtra("success", false)) {
            return;
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        d.a.o0.g3.a aVar = this.mTBeanView;
        if (aVar != null) {
            aVar.B(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.o0.g3.a aVar;
        if (view.getId() != R.id.buy_tbean_use_rule && view.getId() != R.id.t_dou_introduce_activity_right_button) {
            if ((view.getId() == R.id.buy_tbean_close_image || view.getId() == R.id.buy_tbean_root_view) && (aVar = this.mTBeanView) != null) {
                if (aVar.A()) {
                    this.mTBeanView.y();
                    return;
                } else {
                    processClose();
                    return;
                }
            }
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getIntent().getStringExtra("scene_id");
        this.mReferPage = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
        this.mClickZone = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
        this.isFromAlaLiveRoom = getIntent().getBooleanExtra(BuyTBeanActivityConfig.IS_FROM_ALA, false);
        this.isFromDecreaseGiftStepStrategy = getIntent().getIntExtra(BuyTBeanActivityConfig.IS_FROM_ALA_GIFT_PANEL, 0);
        this.moneyLeft = (float) getIntent().getLongExtra(BuyTBeanActivityConfig.TBEAN_LEFT_TO_BUY_ALA_GIFT, 0L);
        this.isFromAlaLiveRoom = false;
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        super.onCreate(bundle);
        if (bundle != null) {
            this.mGiftBbean = (float) bundle.getLong("gift_tbean");
        }
        getGiftTBean(getIntent());
        showLoadingDialog(getPageContext().getString(R.string.flist_loading));
        d.a.o0.g3.a aVar = new d.a.o0.g3.a(this);
        this.mTBeanView = aVar;
        setContentView(aVar.v());
        if (this.isFromDecreaseGiftStepStrategy != 0) {
            float f2 = this.moneyLeft;
            if (f2 > 0.0f) {
                this.mTBeanView.H(f2);
            }
        }
        this.mTBeanView.x();
        BuyTBeanModel buyTBeanModel = new BuyTBeanModel(this, this);
        this.mModel = buyTBeanModel;
        buyTBeanModel.I();
        this.mModel.H();
        this.mModel.G();
        this.mModel.F();
        PayConfigModel payConfigModel = new PayConfigModel(this, new a());
        this.mPayConfigModel = payConfigModel;
        payConfigModel.B();
        registerListener(this.roomClosedListener);
        TiebaStatic.log("c10295");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
        d.a.o0.g3.a aVar = this.mTBeanView;
        if (aVar != null) {
            aVar.C();
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.e
    public void onFailed(String str) {
        showToast(str);
        closeLoadingDialog();
        d.a.o0.g3.a aVar = this.mTBeanView;
        if (aVar != null) {
            aVar.J();
            this.mTBeanView.I();
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.e
    public void onGetWalletUrl(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, str));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            processClose();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        d.a.o0.g3.a aVar = this.mTBeanView;
        if (aVar != null) {
            aVar.D(z);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        refresh();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putFloat("gift_tbean", this.mGiftBbean);
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.e
    public void onSuccess() {
        closeLoadingDialog();
        d.a.o0.g3.a aVar = this.mTBeanView;
        if (aVar != null) {
            aVar.J();
            this.mTBeanView.w();
            this.mTBeanView.G(this.mModel.B(), this.mModel.D(), this.mModel.C(), this.mModel.E());
        }
    }

    public void refresh() {
        if (this.mModel == null || this.mTBeanView == null) {
            return;
        }
        showLoadingDialog(getPageContext().getString(R.string.flist_loading));
        this.mTBeanView.x();
        this.mModel.J();
    }
}
