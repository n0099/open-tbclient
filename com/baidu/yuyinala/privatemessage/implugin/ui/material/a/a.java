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
/* loaded from: classes11.dex */
public class a extends Dialog implements DialogInterface {
    private View eqa;
    private TextView kMS;
    private Context mContext;
    private TextView mTitle;
    private AnimationSet oXK;
    private TextView oXL;
    private TextView oXM;
    private String oXN;
    private String oXO;
    private String oXP;
    private String oXQ;
    private RelativeLayout oXR;
    private View oXS;
    private View oXT;
    private View oXU;

    protected a(Context context) {
        super(context, a.i.NoTitleDialog);
        this.mContext = context;
        initAnimation();
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    public a(Context context, String str, String str2, String str3, String str4) {
        this(context);
        this.mContext = context;
        this.oXN = str;
        this.oXO = str2;
        this.oXP = str3;
        this.oXQ = str4;
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
                a.this.eqa.setVisibility(8);
                a.this.eqa.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.super.cancel();
                    }
                });
            }
        };
        this.oXK = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.S(getContext(), a.C0203a.bd_im_modal_out);
        this.oXK.setAnimationListener(animationListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.bd_im_alert_select_dialog);
        this.eqa = getWindow().getDecorView().findViewById(16908290);
        ViewGroup.LayoutParams layoutParams = this.eqa.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.eqa.setLayoutParams(layoutParams);
        this.oXR = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.oXL = (TextView) findViewById(a.f.bd_im_dialog_cancel);
        this.oXM = (TextView) findViewById(a.f.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.f.bd_im_dialog_title);
        this.kMS = (TextView) findViewById(a.f.bd_im_dialog_content);
        this.oXS = findViewById(a.f.bd_im_dialog_divider2);
        this.oXT = findViewById(a.f.bd_im_dialog_divider3);
        this.oXU = findViewById(a.f.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.oXN)) {
            this.mTitle.setText(this.oXN);
        }
        if (!TextUtils.isEmpty(this.oXO)) {
            this.kMS.setText(this.oXO);
        }
        if (!TextUtils.isEmpty(this.oXP)) {
            this.oXM.setText(this.oXP);
        }
        if (!TextUtils.isEmpty(this.oXQ)) {
            this.oXL.setText(this.oXQ);
        }
        emJ();
    }

    public void emI() {
        super.cancel();
        AB(true);
    }

    private void AB(boolean z) {
        this.eqa.startAnimation(this.oXK);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.oXL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.oXM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void emJ() {
    }
}
