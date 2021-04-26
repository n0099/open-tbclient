package com.baidu.wallet.paysdk.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.paysdk.ui.widget.HalfScreenContainerLayout;
/* loaded from: classes5.dex */
public abstract class HalfScreenBaseActivity extends PayBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static int f26513a;

    /* renamed from: b  reason: collision with root package name */
    public AnimationDrawable f26514b;

    /* renamed from: c  reason: collision with root package name */
    public View f26515c;
    public View mActionBar;
    public ViewGroup mContentView;
    public HalfScreenContainerLayout mHalfScreenContainer;
    public ViewGroup mHalfScreenPageView;
    public ImageView mLeftImg;
    public TextView mRightTxt;
    public View mRootView;
    public TextView mTitle;

    private void a() {
        int size;
        if (f26513a <= 1 || BaseActivity.mActivityStack.size() - 2 < 0 || !(BaseActivity.mActivityStack.get(size) instanceof HalfScreenBaseActivity)) {
            return;
        }
        findViewById(ResUtils.id(getActivity(), "ebpay_top_half")).setVisibility(4);
    }

    private void b() {
        int drawable;
        if (f26513a > 1) {
            drawable = ResUtils.drawable(this, "wallet_base_new_halfscreen_actionbar_back");
            this.mLeftImg.setContentDescription("返回");
        } else {
            drawable = ResUtils.drawable(this, "wallet_base_halfscreen_actionbar_close");
            this.mLeftImg.setContentDescription("关闭");
        }
        this.mLeftImg.setImageResource(drawable);
    }

    public static void resetInstanceCount() {
        f26513a = 0;
    }

    public abstract void addContentView();

    @Override // com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        int i2 = f26513a;
        if (i2 > 0) {
            f26513a = i2 - 1;
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void finishWithoutAnim() {
        super.finishWithoutAnim();
        int i2 = f26513a;
        if (i2 > 0) {
            f26513a = i2 - 1;
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f26513a++;
        setFlagPaySdk();
        setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_half_scrren_activity"));
        this.mHalfScreenPageView = (ViewGroup) findViewById(ResUtils.id(getActivity(), "ebpay_half_screen_page"));
        View findViewById = findViewById(ResUtils.id(getActivity(), "welcome_page"));
        this.f26515c = findViewById;
        findViewById.setVisibility(8);
        this.mRootView = findViewById(ResUtils.id(getActivity(), "root_view"));
        this.mHalfScreenContainer = (HalfScreenContainerLayout) findViewById(ResUtils.id(getActivity(), "ebpay_half_screen_container"));
        a();
        this.mActionBar = findViewById(ResUtils.id(getActivity(), "ebpay_halfscreen_action_bar"));
        this.mLeftImg = (ImageView) findViewById(ResUtils.id(getActivity(), "action_bar_left_img"));
        this.mTitle = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_title"));
        this.mRightTxt = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_left_txt"));
        b();
        this.f26514b = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        addContentView();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        int i2;
        super.onDestroy();
        if (isFinishing() || (i2 = f26513a) <= 0) {
            return;
        }
        f26513a = i2 - 1;
    }

    public void setPageTransparent(boolean z) {
        this.mRootView.setVisibility(z ? 4 : 0);
    }

    public void showLikeDismissLadingPage() {
        this.f26515c.setVisibility(8);
        this.f26514b.stop();
    }

    public void showLikeLoadingPage(boolean z) {
        setPageTransparent(false);
        if (z) {
            this.mHalfScreenPageView.setVisibility(8);
            this.f26515c.setVisibility(0);
            this.f26514b.start();
            return;
        }
        this.mHalfScreenPageView.setVisibility(0);
        this.f26515c.setVisibility(8);
        this.f26514b.stop();
    }
}
