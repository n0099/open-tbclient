package com.baidu.tieba.wallet.pay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class WalletPayResultActivity extends BaseActivity<WalletPayResultActivity> {
    public String PAY_RESULT_VISIT;
    public Boolean isPayDialog;
    public Handler mHandler;
    public PayConfig mPayData;
    public Boolean mPayResult;
    public IWalletPayResultView mView;
    public Runnable myTask;

    public WalletPayResultActivity() {
        Boolean bool = Boolean.FALSE;
        this.isPayDialog = bool;
        this.mPayResult = bool;
        this.mView = null;
        this.PAY_RESULT_VISIT = "c10484";
        this.myTask = new Runnable() { // from class: com.baidu.tieba.wallet.pay.WalletPayResultActivity.1
            @Override // java.lang.Runnable
            public void run() {
                WalletPayResultActivity.this.setResult(-1, new Intent());
                WalletPayResultActivity.this.finish();
            }
        };
    }

    private void initUI() {
        if (this.mPayData.getPayType() == 1) {
            this.mView = new WalletPayResultView(this, this.mPayResult.booleanValue(), this.mPayData);
        } else if (this.mPayData.getPayType() == 2) {
            this.mView = new NewWalletPayResultView(this, this.mPayResult.booleanValue(), this.mPayData);
        }
    }

    private void reBuyProduct() {
        PayConfig payConfig = this.mPayData;
        if (payConfig != null) {
            if (payConfig.getPayType() == 1) {
                Intent intent = new Intent();
                intent.putExtra("rebuy", true);
                setResult(-1, intent);
                finish();
            } else if (this.mPayData.getPayType() == 2) {
                Intent intent2 = new Intent();
                intent2.putExtra("rebuy", true);
                setResult(-1, intent2);
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        IWalletPayResultView iWalletPayResultView = this.mView;
        if (iWalletPayResultView != null) {
            iWalletPayResultView.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        PayConfig payConfig = this.mPayData;
        if (payConfig == null) {
            return;
        }
        if (payConfig.getPayType() == 2) {
            IWalletPayResultView iWalletPayResultView = this.mView;
            if (iWalletPayResultView instanceof NewWalletPayResultView) {
                NewWalletPayResultView newWalletPayResultView = (NewWalletPayResultView) iWalletPayResultView;
                if (this.mPayResult.booleanValue()) {
                    if (view == newWalletPayResultView.getLeftBtn()) {
                        sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(this, 3)));
                        finish();
                        return;
                    } else if (view == newWalletPayResultView.getRightView()) {
                        setResult(-1, new Intent());
                        finish();
                        return;
                    } else {
                        return;
                    }
                } else if (view == newWalletPayResultView.getLeftBtn()) {
                    setResult(-1, new Intent());
                    finish();
                    return;
                } else if (view == newWalletPayResultView.getRightView()) {
                    reBuyProduct();
                    return;
                } else {
                    return;
                }
            }
        }
        if (view.getId() == R.id.pay_fail_rebuy_btn) {
            reBuyProduct();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TiebaStatic.log(this.PAY_RESULT_VISIT);
        this.mPayResult = Boolean.valueOf(getIntent().getBooleanExtra(WalletPayResultActivityConfig.PAY_RESULT, false));
        this.isPayDialog = Boolean.valueOf(getIntent().getBooleanExtra(WalletPayResultActivityConfig.IS_DIALOG, false));
        PayConfig payConfig = (PayConfig) getIntent().getSerializableExtra(WalletPayResultActivityConfig.PAYDATA);
        this.mPayData = payConfig;
        if (payConfig.getPayType() == 1) {
            if (this.isPayDialog.booleanValue()) {
                setTheme(16973835);
                requestWindowFeature(1);
            } else {
                setTheme(R.style.swipeback_activity_style);
            }
        } else if (this.mPayData.getPayType() == 2) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        initUI();
        if (this.mPayData.getPayType() == 1) {
            if (this.isPayDialog.booleanValue()) {
                PageDialogHelper.a(getActivity());
            }
            if (this.isPayDialog.booleanValue()) {
                findViewById(R.id.pay_result_bar).setVisibility(8);
            } else {
                findViewById(R.id.tbean_dialog_wrapper).setVisibility(8);
            }
            this.mHandler = new Handler(Looper.getMainLooper());
            if (this.mPayResult.booleanValue()) {
                this.mHandler.postDelayed(this.myTask, 5000L);
            }
        }
        ((ImageView) findViewById(R.id.tbean_dialog_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.wallet.pay.WalletPayResultActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletPayResultActivity.this.setResult(-1, new Intent());
                WalletPayResultActivity.this.finish();
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            setResult(-1, new Intent());
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.myTask);
        }
    }
}
