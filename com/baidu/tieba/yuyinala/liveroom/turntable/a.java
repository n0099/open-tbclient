package com.baidu.tieba.yuyinala.liveroom.turntable;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.live.view.e;
import com.baidu.live.view.web.CommonWebLayout;
import com.baidu.live.view.web.c;
import com.baidu.live.view.web.f;
/* loaded from: classes4.dex */
public class a extends e implements f {
    private int bMu;
    private RoundRectRelativeLayout boV;
    private CommonWebLayout boW;
    private View boX;
    private float boY;
    private Context mContext;
    private InterfaceC0918a obP;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.turntable.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0918a {
        void onDismiss();
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout Wq() {
        return this.boW;
    }

    public void a(InterfaceC0918a interfaceC0918a) {
        this.obP = interfaceC0918a;
    }

    public void FO(String str) {
        View findViewById;
        int Wu;
        int Wv;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.bMu = 80;
                    Wu = Ws();
                    Wv = Wt();
                    this.boV.setCornerRadius(this.boY, this.boY, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bMu = 5;
                    Wu = Wu();
                    Wv = Wv();
                    this.boV.setCornerRadius(this.boY, 0.0f, 0.0f, this.boY);
                    break;
                default:
                    this.bMu = 80;
                    Wu = Ws();
                    Wv = Wt();
                    this.boV.setCornerRadius(this.boY, this.boY, 0.0f, 0.0f);
                    break;
            }
            setWidth(Wu);
            setHeight(Wv);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                ah(this.boV);
            }
            Mi();
            this.boW.loadUrl(str);
        }
    }

    public void Wr() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Ww()) {
            Wr();
        }
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.turntable.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.boW != null) {
                    a.this.boW.release();
                }
                if (a.this.obP != null) {
                    a.this.obP.onDismiss();
                }
            }
        });
    }

    private void initView() {
        this.boY = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.boV = new RoundRectRelativeLayout(this.mContext);
        n(this.boV);
        o(this.boV);
        setContentView(this.boV);
    }

    private void n(ViewGroup viewGroup) {
        this.boW = new CommonWebLayout(this.mContext);
        this.boW.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.boW.setCallback(new c() { // from class: com.baidu.tieba.yuyinala.liveroom.turntable.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                if (a.this.boX != null) {
                    a.this.boX.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eW(int i) {
                super.eW(i);
                if (i == 100 && a.this.boX != null) {
                    a.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hP(String str) {
                super.hP(str);
                if (a.this.boX != null) {
                    a.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.boX != null) {
                    a.this.boX.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.boW, new ViewGroup.LayoutParams(-1, -1));
    }

    private void o(ViewGroup viewGroup) {
        this.boX = LayoutInflater.from(this.mContext).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.boX, layoutParams);
        this.boX.setVisibility(8);
    }

    private int Ws() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int Wt() {
        return (Ws() * 470) / 375;
    }

    private int Wu() {
        return (Wv() * 375) / 470;
    }

    private int Wv() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
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
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.turntable.a.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    a.this.Wr();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eT(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
