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
    private View egY;
    private TextView kHH;
    private Context mContext;
    private TextView mTitle;
    private AnimationSet oRD;
    private TextView oRE;
    private TextView oRF;
    private String oRG;
    private String oRH;
    private String oRI;
    private String oRJ;
    private RelativeLayout oRK;
    private View oRL;
    private View oRM;
    private View oRN;

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
        this.oRG = str;
        this.oRH = str2;
        this.oRI = str3;
        this.oRJ = str4;
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
                a.this.egY.setVisibility(8);
                a.this.egY.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.super.cancel();
                    }
                });
            }
        };
        this.oRD = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.S(getContext(), a.C0205a.bd_im_modal_out);
        this.oRD.setAnimationListener(animationListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.bd_im_alert_select_dialog);
        this.egY = getWindow().getDecorView().findViewById(16908290);
        ViewGroup.LayoutParams layoutParams = this.egY.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.egY.setLayoutParams(layoutParams);
        this.oRK = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.oRE = (TextView) findViewById(a.f.bd_im_dialog_cancel);
        this.oRF = (TextView) findViewById(a.f.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.f.bd_im_dialog_title);
        this.kHH = (TextView) findViewById(a.f.bd_im_dialog_content);
        this.oRL = findViewById(a.f.bd_im_dialog_divider2);
        this.oRM = findViewById(a.f.bd_im_dialog_divider3);
        this.oRN = findViewById(a.f.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.oRG)) {
            this.mTitle.setText(this.oRG);
        }
        if (!TextUtils.isEmpty(this.oRH)) {
            this.kHH.setText(this.oRH);
        }
        if (!TextUtils.isEmpty(this.oRI)) {
            this.oRF.setText(this.oRI);
        }
        if (!TextUtils.isEmpty(this.oRJ)) {
            this.oRE.setText(this.oRJ);
        }
        emG();
    }

    public void emF() {
        super.cancel();
        AB(true);
    }

    private void AB(boolean z) {
        this.egY.startAnimation(this.oRD);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.oRE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.oRF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void emG() {
    }
}
