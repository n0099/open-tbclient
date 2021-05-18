package com.baidu.tieba.memberCenter.memberpay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import d.a.j0.l0.d;
import d.a.k0.r1.f.f;
/* loaded from: classes3.dex */
public class CardBoxMemberPayActivity extends BaseActivity implements View.OnClickListener {
    public static String MEMBER_AGREEMENT_JUMP_URL = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public String mClickZone;
    public String mPackedId;
    public String mReferPage;
    public d.a.k0.r1.f.a mView;
    public boolean mHasShowAnim = false;
    public boolean mAnimateRunning = false;
    public HttpMessageListener mRequestMemberPayInfoListener = new b(CmdConfigHttp.CARD_BOX_MEMBER_PAY_CMD);
    public CustomMessageListener mCloseListener = new c(2016526);

    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CardBoxMemberPayActivity.this.mAnimateRunning = false;
            CardBoxMemberPayActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            CardBoxMemberPayActivity.this.closeLoadingDialog();
            if (httpResponsedMessage instanceof ResponseCardBoxMemberPayMessage) {
                ResponseCardBoxMemberPayMessage responseCardBoxMemberPayMessage = (ResponseCardBoxMemberPayMessage) httpResponsedMessage;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    if (responseCardBoxMemberPayMessage.getMemberPayResult() != null) {
                        CardBoxMemberPayActivity.this.mView.m(responseCardBoxMemberPayMessage.getMemberPayResult());
                        return;
                    }
                    CardBoxMemberPayActivity.this.showToast(R.string.neterror);
                    return;
                }
                String errorString = responseCardBoxMemberPayMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = CardBoxMemberPayActivity.this.getResources().getString(R.string.neterror);
                }
                CardBoxMemberPayActivity.this.showToast(errorString);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.hasError()) {
                return;
            }
            CardBoxMemberPayActivity.this.finish();
        }
    }

    private void hideAnimation() {
        this.mAnimateRunning = true;
        this.mView.e().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.mView.e().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new a());
        this.mView.g().startAnimation(loadAnimation);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mPackedId = bundle.getString(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.mReferPage = bundle.getString(MemberPayStatistic.REFER_PAGE);
            this.mClickZone = bundle.getString(MemberPayStatistic.CLICK_ZONE);
        } else {
            Intent intent = getIntent();
            this.mPackedId = intent.getStringExtra(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.mReferPage = intent.getStringExtra(MemberPayStatistic.REFER_PAGE);
            this.mClickZone = intent.getStringExtra(MemberPayStatistic.CLICK_ZONE);
        }
        registerListener(this.mRequestMemberPayInfoListener);
        registerListener(this.mCloseListener);
        registerGetMemberPayInfoTask();
    }

    private void initUI() {
        this.mView = new d.a.k0.r1.f.a(this);
    }

    private void registerGetMemberPayInfoTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CARD_BOX_MEMBER_PAY_CMD, TbConfig.SERVER_ADDRESS + TbConfig.CARD_BOX_MEMBER_PAY);
        tbHttpMessageTask.setResponsedClass(ResponseCardBoxMemberPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void requestMemberPayInfo() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CARD_BOX_MEMBER_PAY_CMD);
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, this.mPackedId);
        sendMessage(httpMessage);
    }

    private void showAnimation() {
        this.mView.e().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.mView.e().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        this.mView.g().startAnimation(loadAnimation);
        this.mHasShowAnim = true;
    }

    private void startDealIntentService(long j, long j2, long j3, int i2) {
        String str;
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, false, PageDialogHelper.PayForm.NOT_SET, this.mReferPage, this.mClickZone);
        payConfig.setFrom(4);
        d.a.k0.r1.f.a aVar = this.mView;
        if (aVar == null || aVar.i() == null) {
            str = "";
        } else {
            payConfig.setTitle(this.mView.i());
            str = this.mView.r;
        }
        payConfig.setOrderName(getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i2);
        payConfig.setPropsMon(String.valueOf(j3));
        payConfig.paymentPosKey = str;
        d.c().a(payConfig, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (this.mAnimateRunning) {
            return;
        }
        hideAnimation();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.j(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.k0.r1.f.a aVar = this.mView;
        if (aVar == null) {
            return;
        }
        if (view == aVar.h() && this.mView.d() != null) {
            f.d d2 = this.mView.d();
            startDealIntentService(d2.f60436i, d2.j / 100, d2.l, d2.n);
        } else if (view == this.mView.f()) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{MEMBER_AGREEMENT_JUMP_URL});
        } else if (view == this.mView.e()) {
            closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        initData(bundle);
        initUI();
        requestMemberPayInfo();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.mHasShowAnim) {
            return;
        }
        showAnimation();
    }
}
