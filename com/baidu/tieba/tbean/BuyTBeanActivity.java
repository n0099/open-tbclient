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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.pay.PayConfigModel;
import com.baidu.tieba.R;
import com.baidu.tieba.live.tbean.TbeanStatisticKey;
import com.baidu.tieba.tbean.BuyTBeanModel;
/* loaded from: classes8.dex */
public class BuyTBeanActivity extends BaseActivity<BuyTBeanActivity> implements BuyTBeanModel.a {
    private PayConfigModel lrb;
    private String mClickZone;
    private long mGiftBbean;
    private String mReferPage;
    private BuyTBeanModel nEf;
    private a nEg;
    private boolean mIsPayDialog = true;
    private String SCENE_ID = "4001001000";
    private boolean nEh = false;
    private int isFromDecreaseGiftStepStrategy = 0;
    private long nEi = 0;
    private CustomMessageListener nEj = new CustomMessageListener(2921407) { // from class: com.baidu.tieba.tbean.BuyTBeanActivity.4
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
        this.nEh = getIntent().getBooleanExtra(BuyTBeanActivityConfig.IS_FROM_ALA, false);
        this.isFromDecreaseGiftStepStrategy = getIntent().getIntExtra(BuyTBeanActivityConfig.IS_FROM_ALA_GIFT_PANEL, 0);
        this.nEi = getIntent().getLongExtra(BuyTBeanActivityConfig.TBEAN_LEFT_TO_BUY_ALA_GIFT, 0L);
        this.nEh = false;
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
        this.nEg = new a(this);
        setContentView(this.nEg.getRootView());
        if (this.isFromDecreaseGiftStepStrategy != 0 && this.nEi > 0) {
            this.nEg.hH(this.nEi);
        }
        this.nEg.hideRootView();
        this.nEf = new BuyTBeanModel(this, this);
        this.nEf.dPV();
        this.nEf.registerYinJiHttpListener();
        this.nEf.dPX();
        this.nEf.dPW();
        this.lrb = new PayConfigModel(this, new com.baidu.tbadk.pay.a() { // from class: com.baidu.tieba.tbean.BuyTBeanActivity.1
            @Override // com.baidu.tbadk.pay.a
            public void onError(String str2) {
                BuyTBeanActivity.this.nEf.requestYinJiInfo();
            }

            @Override // com.baidu.tbadk.pay.a
            public void onPayNative() {
                BuyTBeanActivity.this.nEf.requestYinJiInfo();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tbean.BuyTBeanActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.pay.a
            public void onPayH5() {
                com.baidu.tbadk.pay.c.bDZ().a(String.format(PayConst.PAY_H5_TBEAN, String.valueOf(BuyTBeanActivity.this.mGiftBbean), com.baidu.tbadk.pay.b.PAY_H5_TBEAN_RETURN_URL) + "&refer_page=" + BuyTBeanActivity.this.mReferPage + "&click_zone=" + BuyTBeanActivity.this.mClickZone, BuyTBeanActivity.this.getPageContext());
                BuyTBeanActivity.this.finish();
            }
        });
        this.lrb.bDY();
        registerListener(this.nEj);
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
        if (this.nEg != null) {
            this.nEg.onChangeSkinType(i);
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
            bf.bsY().b(getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
        } else if ((view.getId() == R.id.buy_tbean_close_image || view.getId() == R.id.buy_tbean_root_view) && this.nEg != null) {
            if (this.nEg.dQc()) {
                this.nEg.hideSoftKeyPad();
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
        aVar.jF(true);
        aVar.setTitleShowCenter(true);
        aVar.setMessageShowCenter(true);
        aVar.AA(getString(R.string.buy_tbean_exit_dialog_title));
        aVar.AB(getString(R.string.buy_tbean_exit_dialog_sub_title));
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
        aVar.b(getPageContext()).bqz();
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
        if (this.nEg != null) {
            this.nEg.showRootView();
            this.nEg.cHS();
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.a
    public void onSuccess() {
        closeLoadingDialog();
        if (this.nEg != null) {
            this.nEg.showRootView();
            this.nEg.cHT();
            this.nEg.a(this.nEf.dPY(), this.nEf.dQa(), this.nEf.dPZ(), this.nEf.getUserInfo());
        }
    }

    @Override // com.baidu.tieba.tbean.BuyTBeanModel.a
    public void onGetWalletUrl(String str) {
        if (!StringUtils.isNull(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, str));
        }
    }

    public void refresh() {
        if (this.nEf != null && this.nEg != null) {
            showLoadingDialog(getPageContext().getString(R.string.flist_loading));
            this.nEg.hideRootView();
            this.nEf.requestYinJiInfo();
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
        if (this.nEg != null) {
            this.nEg.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.nEg != null) {
            this.nEg.onKeyboardVisibilityChanged(z);
        }
    }

    public String getReferPage() {
        return this.mReferPage;
    }

    public String getClickZone() {
        return this.mClickZone;
    }

    public boolean dPT() {
        return this.mIsPayDialog;
    }

    public int isFromDecreaseGiftStepStrategy() {
        return this.isFromDecreaseGiftStepStrategy;
    }
}
