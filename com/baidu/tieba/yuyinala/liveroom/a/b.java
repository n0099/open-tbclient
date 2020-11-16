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
/* loaded from: classes4.dex */
public class b extends e implements f {
    private int bMu;
    private RoundRectRelativeLayout boV;
    private CommonWebLayout boW;
    private View boX;
    private float boY;
    private boolean gUn;
    private Activity mActivity;

    public b(Activity activity) {
        super(activity);
        this.mActivity = activity;
        init();
    }

    public CommonWebLayout Wq() {
        return this.boW;
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Ww()) {
            Wr();
        }
    }

    public void aG(String str, int i) {
        View findViewById;
        if (!this.mActivity.isFinishing() && (findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290)) != null) {
            this.bMu = 80;
            int Ws = Ws();
            this.boV.setCornerRadius(this.boY, this.boY, 0.0f, 0.0f);
            setWidth(Ws);
            setHeight((int) (ScreenHelper.getRealScreenHeight(this.mActivity) * 0.7f));
            showAtLocation(findViewById, 85, 0, 0);
            if (i == 2) {
                ah(this.boV);
            }
            Mi();
            this.boW.loadUrl(str);
        }
    }

    public void Wr() {
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
                if (b.this.boW != null) {
                    b.this.boW.release();
                }
            }
        });
    }

    private void initView() {
        this.boY = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.boV = new RoundRectRelativeLayout(this.mActivity);
        n(this.boV);
        o(this.boV);
        setContentView(this.boV);
    }

    private void n(ViewGroup viewGroup) {
        this.boW = new CommonWebLayout(this.mActivity);
        this.boW.setBackgroundColor(this.mActivity.getResources().getColor(a.c.sdk_black_alpha85));
        this.boW.setCallback(new com.baidu.live.view.web.c() { // from class: com.baidu.tieba.yuyinala.liveroom.a.b.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                if (b.this.boX != null) {
                    b.this.boX.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eW(int i) {
                super.eW(i);
                if (i == 100 && b.this.boX != null) {
                    b.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hP(String str) {
                super.hP(str);
                if (b.this.boX != null) {
                    b.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (b.this.boX != null) {
                    b.this.boX.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.boW, new ViewGroup.LayoutParams(-1, -1));
    }

    private void o(ViewGroup viewGroup) {
        this.boX = LayoutInflater.from(this.mActivity).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.boX, layoutParams);
        this.boX.setVisibility(8);
    }

    private int Ws() {
        return ScreenHelper.getRealScreenWidth(this.mActivity);
    }

    private void Mi() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bMu) {
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

    private boolean Ww() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gUn) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bMu) {
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
                    b.this.Wr();
                    b.this.gUn = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gUn = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eT(int i) {
        dismiss();
        if (this.boW != null) {
            this.boW.release();
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
