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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberpay.f;
/* loaded from: classes8.dex */
public class CardBoxMemberPayActivity extends BaseActivity implements View.OnClickListener {
    private static String lqC = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    private a lqD;
    private String lqE;
    public String mClickZone;
    public String mReferPage;
    private boolean jWR = false;
    private boolean lqF = false;
    public HttpMessageListener lqG = new HttpMessageListener(1003317) { // from class: com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            CardBoxMemberPayActivity.this.closeLoadingDialog();
            if (httpResponsedMessage instanceof ResponseCardBoxMemberPayMessage) {
                ResponseCardBoxMemberPayMessage responseCardBoxMemberPayMessage = (ResponseCardBoxMemberPayMessage) httpResponsedMessage;
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = responseCardBoxMemberPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = CardBoxMemberPayActivity.this.getResources().getString(R.string.neterror);
                    }
                    CardBoxMemberPayActivity.this.showToast(errorString);
                } else if (responseCardBoxMemberPayMessage.getMemberPayResult() != null) {
                    CardBoxMemberPayActivity.this.lqD.a(responseCardBoxMemberPayMessage.getMemberPayResult());
                } else {
                    CardBoxMemberPayActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    private CustomMessageListener ggs = new CustomMessageListener(2016526) { // from class: com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !customResponsedMessage.hasError()) {
                CardBoxMemberPayActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        initData(bundle);
        initUI();
        dfA();
    }

    private void initUI() {
        this.lqD = new a(this);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.lqE = bundle.getString(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.mReferPage = bundle.getString("refer_page");
            this.mClickZone = bundle.getString("click_zone");
        } else {
            Intent intent = getIntent();
            this.lqE = intent.getStringExtra(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.mReferPage = intent.getStringExtra("refer_page");
            this.mClickZone = intent.getStringExtra("click_zone");
        }
        registerListener(this.lqG);
        registerListener(this.ggs);
        dfz();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.jWR) {
            aCx();
        }
    }

    private void aCx() {
        this.lqD.getEmptyView().setBackgroundColor(ap.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.lqD.getEmptyView().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        this.lqD.dfE().startAnimation(loadAnimation);
        this.jWR = true;
    }

    private void Va() {
        this.lqF = true;
        this.lqD.getEmptyView().setBackgroundColor(ap.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.lqD.getEmptyView().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CardBoxMemberPayActivity.this.lqF = false;
                CardBoxMemberPayActivity.this.finish();
            }
        });
        this.lqD.dfE().startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!this.lqF) {
            Va();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lqD.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lqD != null) {
            if (view == this.lqD.dfF() && this.lqD.dfI() != null) {
                f.d dfI = this.lqD.dfI();
                b(dfI.lsr, dfI.lss / 100, dfI.lsu, dfI.isAutoPay);
            } else if (view == this.lqD.dfG()) {
                bf.bsY().b(getPageContext(), new String[]{lqC});
            } else if (view == this.lqD.getEmptyView()) {
                closeActivity();
            }
        }
    }

    private void dfz() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003317, TbConfig.SERVER_ADDRESS + TbConfig.CARD_BOX_MEMBER_PAY);
        tbHttpMessageTask.setResponsedClass(ResponseCardBoxMemberPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    private void dfA() {
        HttpMessage httpMessage = new HttpMessage(1003317);
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, this.lqE);
        sendMessage(httpMessage);
    }

    private void b(long j, long j2, long j3, int i) {
        PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, false, PageDialogHelper.PayForm.NOT_SET, this.mReferPage, this.mClickZone);
        payConfig.setFrom(4);
        String str = "";
        if (this.lqD != null && this.lqD.dfH() != null) {
            payConfig.setTitle(this.lqD.dfH());
            str = this.lqD.paymentPosKey;
        }
        payConfig.setOrderName(getPageContext().getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j3)}));
        payConfig.setAutoPay(i);
        payConfig.setPropsMon(String.valueOf(j3));
        payConfig.paymentPosKey = str;
        com.baidu.tbadk.pay.c.bDZ().a(payConfig, getPageContext().getPageActivity());
    }
}
