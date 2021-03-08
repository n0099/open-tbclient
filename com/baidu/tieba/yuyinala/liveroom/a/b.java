package com.baidu.tieba.yuyinala.liveroom.a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.f;
/* loaded from: classes10.dex */
public class b extends e implements f {
    private float bBH;
    private RoundRectRelativeLayout bXV;
    private int bXW;
    private CommonWebLayout bXc;
    private View bXd;
    private boolean hEE;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bXc;
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Yl()) {
            Yf();
        }
    }

    public void cd(String str, int i) {
        View findViewById;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            this.bXW = 80;
            int Yh = Yh();
            this.bXV.setCornerRadius(this.bBH, this.bBH, 0.0f, 0.0f);
            setWidth(Yh);
            setHeight((int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.7f));
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                ah(this.bXV);
            }
            LQ();
            this.bXc.loadUrl(str);
        }
    }

    public void Yf() {
        super.dismiss();
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.a.b.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (b.this.bXc != null) {
                    b.this.bXc.release();
                }
            }
        });
    }

    private void initView() {
        this.bBH = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bXV = new RoundRectRelativeLayout(this.mActivity);
        x(this.bXV);
        y(this.bXV);
        setContentView(this.bXV);
    }

    private void x(ViewGroup viewGroup) {
        this.bXc = new CommonWebLayout(this.mActivity);
        this.bXc.setBackgroundColor(this.mActivity.getResources().getColor(a.c.sdk_transparent));
        this.bXc.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.yuyinala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iz(String str) {
                super.iz(str);
                if (b.this.bXd != null) {
                    b.this.bXd.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fo(int i) {
                super.fo(i);
                if (i == 100 && b.this.bXd != null) {
                    b.this.bXd.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iA(String str) {
                super.iA(str);
                if (b.this.bXd != null) {
                    b.this.bXd.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void f(String str, int i, String str2) {
                super.f(str, i, str2);
                if (b.this.bXd != null) {
                    b.this.bXd.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bXc, new ViewGroup.LayoutParams(-1, -1));
    }

    private void y(ViewGroup viewGroup) {
        this.bXd = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.bXd, layoutParams);
        this.bXd.setVisibility(8);
    }

    private int Yh() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private void LQ() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bXW) {
                case 5:
                    translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    break;
                case 80:
                    translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                    break;
            }
            if (translateAnimation != null) {
                translateAnimation.setDuration(250L);
                translateAnimation.setInterpolator(new LinearInterpolator());
                getContentView().startAnimation(translateAnimation);
            }
        }
    }

    private boolean Yl() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hEE) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bXW) {
            case 5:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                break;
            case 80:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
                break;
        }
        if (translateAnimation != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.a.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    b.this.Yf();
                    b.this.hEE = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hEE = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fq(int i) {
        dismiss();
        if (this.bXc != null) {
            this.bXc.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
