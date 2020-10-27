package com.baidu.yuyinala.privatemessage.implugin.ui.material.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class a extends Dialog implements DialogInterface {
    private View dVO;
    private TextView knH;
    private Context mContext;
    private TextView mTitle;
    private AnimationSet orA;
    private TextView orB;
    private TextView orC;
    private String orD;
    private String orE;
    private String orF;
    private String orG;
    private RelativeLayout orH;
    private View orI;
    private View orJ;
    private View orK;

    protected a(Context context) {
        super(context, a.j.NoTitleDialog);
        this.mContext = context;
        initAnimation();
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    public a(Context context, String str, String str2, String str3, String str4) {
        this(context);
        this.mContext = context;
        this.orD = str;
        this.orE = str2;
        this.orF = str3;
        this.orG = str4;
    }

    private void initAnimation() {
        Animation.AnimationListener animationListener = new Animation.AnimationListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.dVO.setVisibility(8);
                a.this.dVO.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.super.cancel();
                    }
                });
            }
        };
        this.orA = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.I(getContext(), a.C0195a.bd_im_modal_out);
        this.orA.setAnimationListener(animationListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.bd_im_alert_select_dialog);
        this.dVO = getWindow().getDecorView().findViewById(16908290);
        ViewGroup.LayoutParams layoutParams = this.dVO.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.dVO.setLayoutParams(layoutParams);
        this.orH = (RelativeLayout) findViewById(a.g.searchbox_alert_dialog);
        this.orB = (TextView) findViewById(a.g.bd_im_dialog_cancel);
        this.orC = (TextView) findViewById(a.g.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.g.bd_im_dialog_title);
        this.knH = (TextView) findViewById(a.g.bd_im_dialog_content);
        this.orI = findViewById(a.g.bd_im_dialog_divider2);
        this.orJ = findViewById(a.g.bd_im_dialog_divider3);
        this.orK = findViewById(a.g.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.orD)) {
            this.mTitle.setText(this.orD);
        }
        if (!TextUtils.isEmpty(this.orE)) {
            this.knH.setText(this.orE);
        }
        if (!TextUtils.isEmpty(this.orF)) {
            this.orC.setText(this.orF);
        }
        if (!TextUtils.isEmpty(this.orG)) {
            this.orB.setText(this.orG);
        }
        edf();
    }

    public void ede() {
        super.cancel();
        zF(true);
    }

    private void zF(boolean z) {
        this.dVO.startAnimation(this.orA);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.orB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.orC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void edf() {
    }
}
