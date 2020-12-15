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
    private TextView kHJ;
    private Context mContext;
    private TextView mTitle;
    private AnimationSet oRF;
    private TextView oRG;
    private TextView oRH;
    private String oRI;
    private String oRJ;
    private String oRK;
    private String oRL;
    private RelativeLayout oRM;
    private View oRN;
    private View oRO;
    private View oRP;

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
        this.oRI = str;
        this.oRJ = str2;
        this.oRK = str3;
        this.oRL = str4;
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
        this.oRF = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.S(getContext(), a.C0205a.bd_im_modal_out);
        this.oRF.setAnimationListener(animationListener);
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
        this.oRM = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.oRG = (TextView) findViewById(a.f.bd_im_dialog_cancel);
        this.oRH = (TextView) findViewById(a.f.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.f.bd_im_dialog_title);
        this.kHJ = (TextView) findViewById(a.f.bd_im_dialog_content);
        this.oRN = findViewById(a.f.bd_im_dialog_divider2);
        this.oRO = findViewById(a.f.bd_im_dialog_divider3);
        this.oRP = findViewById(a.f.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.oRI)) {
            this.mTitle.setText(this.oRI);
        }
        if (!TextUtils.isEmpty(this.oRJ)) {
            this.kHJ.setText(this.oRJ);
        }
        if (!TextUtils.isEmpty(this.oRK)) {
            this.oRH.setText(this.oRK);
        }
        if (!TextUtils.isEmpty(this.oRL)) {
            this.oRG.setText(this.oRL);
        }
        emH();
    }

    public void emG() {
        super.cancel();
        AB(true);
    }

    private void AB(boolean z) {
        this.egY.startAnimation(this.oRF);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.oRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.oRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void emH() {
    }
}
