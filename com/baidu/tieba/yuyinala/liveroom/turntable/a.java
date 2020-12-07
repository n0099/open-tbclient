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
    private int bRA;
    private RoundRectRelativeLayout bue;
    private CommonWebLayout bug;
    private View buh;
    private float bui;
    private Context mContext;
    private InterfaceC0935a oqP;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.turntable.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0935a {
        void onDismiss();
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CommonWebLayout getWebView() {
        return this.bug;
    }

    public void a(InterfaceC0935a interfaceC0935a) {
        this.oqP = interfaceC0935a;
    }

    public void GD(String str) {
        View findViewById;
        int YT;
        int YU;
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing() && (findViewById = ((Activity) this.mContext).getWindow().getDecorView().findViewById(16908290)) != null) {
            switch (UtilHelper.getRealScreenOrientation(this.mContext)) {
                case 1:
                    this.bRA = 80;
                    YT = YR();
                    YU = YS();
                    this.bue.setCornerRadius(this.bui, this.bui, 0.0f, 0.0f);
                    break;
                case 2:
                    this.bRA = 5;
                    YT = YT();
                    YU = YU();
                    this.bue.setCornerRadius(this.bui, 0.0f, 0.0f, this.bui);
                    break;
                default:
                    this.bRA = 80;
                    YT = YR();
                    YU = YS();
                    this.bue.setCornerRadius(this.bui, this.bui, 0.0f, 0.0f);
                    break;
            }
            setWidth(YT);
            setHeight(YU);
            showAtLocation(findViewById, 85, 0, 0);
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                ah(this.bue);
            }
            OD();
            this.bug.loadUrl(str);
        }
    }

    public void YQ() {
        super.dismiss();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!YV()) {
            YQ();
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
                if (a.this.bug != null) {
                    a.this.bug.release();
                }
                if (a.this.oqP != null) {
                    a.this.oqP.onDismiss();
                }
            }
        });
    }

    private void initView() {
        this.bui = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds26);
        this.bue = new RoundRectRelativeLayout(this.mContext);
        n(this.bue);
        o(this.bue);
        setContentView(this.bue);
    }

    private void n(ViewGroup viewGroup) {
        this.bug = new CommonWebLayout(this.mContext);
        this.bug.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha85));
        this.bug.setCallback(new c() { // from class: com.baidu.tieba.yuyinala.liveroom.turntable.a.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void is(String str) {
                super.is(str);
                if (a.this.buh != null) {
                    a.this.buh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && a.this.buh != null) {
                    a.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void it(String str) {
                super.it(str);
                if (a.this.buh != null) {
                    a.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (a.this.buh != null) {
                    a.this.buh.setVisibility(8);
                }
            }
        });
        viewGroup.addView(this.bug, new ViewGroup.LayoutParams(-1, -1));
    }

    private void o(ViewGroup viewGroup) {
        this.buh = LayoutInflater.from(this.mContext).inflate(a.g.live_web_pop_progress, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewGroup.addView(this.buh, layoutParams);
        this.buh.setVisibility(8);
    }

    private int YR() {
        return ScreenHelper.getRealScreenWidth(this.mContext);
    }

    private int YS() {
        return (YR() * 470) / 375;
    }

    private int YT() {
        return (YU() * 375) / 470;
    }

    private int YU() {
        return ScreenHelper.getRealScreenHeight(this.mContext);
    }

    private void OD() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bRA) {
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

    private boolean YV() {
        if (getContentView() == null) {
            return false;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bRA) {
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
                    a.this.YQ();
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
    public void fr(int i) {
        dismiss();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
