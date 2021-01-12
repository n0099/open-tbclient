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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pay.PayConst;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tieba.R;
import com.baidu.tieba.live.tbean.TbeanStatisticKey;
import com.baidu.tieba.tbean.BuyTBeanModel;
/* loaded from: classes8.dex */
public class BuyTBeanActivity extends BaseActivity<BuyTBeanActivity> implements BuyTBeanModel.a {
    private PayConfigModel lgE;
    private String mClickZone;
    private long mGiftBbean;
    private String mReferPage;
    private BuyTBeanModel nrQ;
    private a nrR;
    private boolean mIsPayDialog = true;
    private String SCENE_ID = "4001001000";
    private boolean nrS = false;
    private int isFromDecreaseGiftStepStrategy = 0;
    private long nrT = 0;
    private CustomMessageListener nrU = new CustomMessageListener(2921407) { // from class: com.baidu.tieba.tbean.BuyTBeanActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BuyTBeanActivity.this.isFromDecreaseGiftStepStrategy == 1 || BuyTBeanActivity.this.isFromDecreaseGiftStepStrategy == 2 || BuyTBeanActivity.this.isFromDecreaseGiftStepStrategy == 3) {
                BuyTBeanActivity.this.closeActivity();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getIntent().getStringExtra("scene_id") != null) {
            String str = this.SCENE_ID;
        }
        this.mReferPage = getIntent().getStringExtra("refer_page");
        this.mClickZone = getIntent().getStringExtra("click_zone");
        this.nrS = getIntent().getBooleanExtra(BuyTBeanActivityConfig.IS_FROM_ALA, false);
        this.isFromDecreaseGiftStepStrategy = getIntent().getIntExtra(BuyTBeanActivityConfig.IS_FROM_ALA_GIFT_PANEL, 0);
        this.nrT = getIntent().getLongExtra(BuyTBeanActivityConfig.TBEAN_LEFT_TO_BUY_ALA_GIFT, 0L);
        this.nrS = false;
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        super.onCreate(bundle);
        if (bundle != null) {
            this.mGiftBbean = bundle.getLong("gift_tbean");
        }
        getGiftTBean(getIntent());
        showLoadingDialog(getPageContext().getString(R.string.flist_loading));
        this.nrR = new a(this);
        setContentView(this.nrR.getRootView());
        if (this.isFromDecreaseGiftStepStrategy != 0 && this.nrT > 0) {
            this.nrR.hC(this.nrT);
        }
        this.nrR.hideRootView();
        this.nrQ = new BuyTBeanModel(this, this);
        this.nrQ.dNt();
        this.nrQ.registerYinJiHttpListener();
        this.nrQ.dNv();
        this.nrQ.dNu();
        this.lgE = new PayConfigModel(this, new com.baidu.tbadk.pay.a() { // from class: com.baidu.tieba.tbean.BuyTBeanActivity.1
            @Override // com.baidu.tbadk.pay.a
            public void onError(String str2) {
                BuyTBeanActivity.this.nrQ.requestYinJiInfo();
            }

            @Override // com.baidu.tbadk.pay.a
            public void onPayNative() {
                BuyTBeanActivity.this.nrQ.requestYinJiInfo();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tbean.BuyTBeanActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.pay.a
            public void onPayH5() {
                com.baidu.tbadk.pay.c.bDD().a(String.format(PayConst.PAY_H5_TBEAN, String.valueOf(BuyTBeanActivity.this.mGiftBbean), com.baidu.tbadk.pay.b.PAY_H5_TBEAN_RETURN_URL) + "&refer_page=" + BuyTBeanActivity.this.mReferPage + "&click_zone=" + BuyTBeanActivity.this.mClickZone, BuyTBeanActivity.this.getPageContext());
                BuyTBeanActivity.this.finish();
            }
        });
        this.lgE.bDC();
        registerListener(this.nrU);
        TiebaStatic.log(TbeanStatisticKey.BUY_TBEAN_ACTIVITY);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.nrR != null) {
            this.nrR.onChangeSkinType(i);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("gift_tbean", this.mGiftBbean);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.buy_tbean_use_rule || view.getId() == R.id.t_dou_introduce_activity_right_button) {
            be.bsB().b(getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
        } else if ((view.getId() == R.id.buy_tbean_close_image || view.getId() == R.id.buy_tbean_root_view) && this.nrR != null) {
            if (this.nrR.dNA()) {
                this.nrR.hideSoftKeyPad();
            } else {
                processClose();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            processClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void processClose() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.setAutoNight(true);
        aVar.jD(true);
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.Ac(getString(R.string.buy_tbean_exit_dialog_title));
        aVar.Ad(getString(R.string.buy_tbean_exit_dialog_sub_title));
        aVar.a(getString(R.string.go_on), new a.b() { // from class: com.baidu.tieba.tbean.BuyTBeanActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getString(R.string.buy_tbean_exit_dialog_quit), new a.b() { // from class: com.baidu.tieba.tbean.BuyTBeanActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                BuyTBeanActivity.this.finish();
            }
        });
        aVar.b(getPageContext()).bqe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("success", false)) {
            finish();
        }
    }

    private void getGiftTBean(Intent intent) {
        this.mGiftBbean = intent.getLongExtra("gift_tbean", 0L);
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.a
    public void onFailed(String str) {
        showToast(str);
        closeLoadingDialog();
        if (this.nrR != null) {
            this.nrR.showRootView();
            this.nrR.cGs();
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.a
    public void onSuccess() {
        closeLoadingDialog();
        if (this.nrR != null) {
            this.nrR.showRootView();
            this.nrR.cGt();
            this.nrR.a(this.nrQ.dNw(), this.nrQ.dNy(), this.nrQ.dNx(), this.nrQ.getUserInfo());
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.a
    public void onGetWalletUrl(String str) {
        if (!StringUtils.isNull(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, str));
        }
    }

    public void refresh() {
        if (this.nrQ != null && this.nrR != null) {
            showLoadingDialog(getPageContext().getString(R.string.flist_loading));
            this.nrR.hideRootView();
            this.nrQ.requestYinJiInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
        if (this.nrR != null) {
            this.nrR.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.nrR != null) {
            this.nrR.onKeyboardVisibilityChanged(z);
        }
    }

    public String getReferPage() {
        return this.mReferPage;
    }

    public String getClickZone() {
        return this.mClickZone;
    }

    public boolean dNr() {
        return this.mIsPayDialog;
    }

    public int isFromDecreaseGiftStepStrategy() {
        return this.isFromDecreaseGiftStepStrategy;
    }
}
