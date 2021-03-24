package com.baidu.wallet.base.widget;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.BaseActivity;
/* loaded from: classes5.dex */
public class LoadingActivity extends BaseActivity {
    public static final int FLAG_LOGIN_LOADING = 256;
    public AnimationDrawable mAnimationDrawable;

    public static synchronized void exitLoading() {
        synchronized (LoadingActivity.class) {
            BaseActivity.clearTasksWithFlag(256);
        }
    }

    private void initView() {
        setContentView(ResUtils.layout(getActivity(), "wallet_base_layout_loading"));
        AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        this.mAnimationDrawable = animationDrawable;
        animationDrawable.stop();
        this.mAnimationDrawable.start();
        setImmersiveActivityMargeinTop();
    }

    private void setFlag() {
        this.mFlag |= 256;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "wallet_base_layout_loading"));
        setFlag();
        initView();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable == null || !animationDrawable.isRunning()) {
            return;
        }
        this.mAnimationDrawable.stop();
    }

    public void setImmersiveActivityMargeinTop() {
        if (Build.VERSION.SDK_INT >= 19 && getActivity() != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "welcome_page"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(getActivity()), 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }
}
