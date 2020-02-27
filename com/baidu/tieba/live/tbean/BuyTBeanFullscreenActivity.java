package com.baidu.tieba.live.tbean;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.live.tbadk.BaseActivity;
/* loaded from: classes3.dex */
public class BuyTBeanFullscreenActivity extends BaseActivity<BuyTBeanActivity> implements IBuyTBeanActivity {
    private BuyTBeanController buyTBeanController;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setSoftInputMode(16);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        super.onCreate(bundle);
        this.buyTBeanController = new BuyTBeanController(getPageContext(), this, getIntent());
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.buyTBeanController != null) {
            this.buyTBeanController.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.buyTBeanController == null || !this.buyTBeanController.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.buyTBeanController != null) {
            this.buyTBeanController.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (this.buyTBeanController != null) {
            this.buyTBeanController.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
        if (this.buyTBeanController != null) {
            this.buyTBeanController.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (this.buyTBeanController != null) {
            this.buyTBeanController.onKeyboardVisibilityChanged(z);
        }
    }

    @Override // com.baidu.tieba.live.tbean.IBuyTBeanActivity
    public void setResultIntent(int i, Intent intent) {
        setResult(i, intent);
    }
}
