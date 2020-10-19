package com.baidu.tieba.live.tbean;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
/* loaded from: classes4.dex */
public class BuyTBeanFullscreenActivity extends BaseActivity<BuyTBeanActivity> implements IBuyTBeanActivity {
    private int availableHeight;
    private BuyTBeanController buyTBeanController;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean mIsKeyboardOpen = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setSoftInputMode(16);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.buyTBeanController = new BuyTBeanController(getPageContext(), this, getIntent());
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
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
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
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
    public void addGlobalLayoutListener() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullscreenActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                BuyTBeanFullscreenActivity.this.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(BuyTBeanFullscreenActivity.this.getPageContext().getPageActivity());
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(BuyTBeanFullscreenActivity.this.getPageContext().getPageActivity());
                boolean z = BuyTBeanFullscreenActivity.this.availableHeight != rect.bottom;
                BuyTBeanFullscreenActivity.this.availableHeight = rect.bottom;
                if (Math.abs(screenFullSize[1] - rect.bottom) > screenFullSize[1] / 4 && (!BuyTBeanFullscreenActivity.this.mIsKeyboardOpen || z)) {
                    BuyTBeanFullscreenActivity.this.mIsKeyboardOpen = true;
                    TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                    BuyTBeanFullscreenActivity.this.onKeyboardVisibilityChanged(true);
                } else if (Math.abs(screenFullSize[1] - rect.height()) <= statusBarHeight && BuyTBeanFullscreenActivity.this.mIsKeyboardOpen) {
                    BuyTBeanFullscreenActivity.this.mIsKeyboardOpen = false;
                    BuyTBeanFullscreenActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
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
