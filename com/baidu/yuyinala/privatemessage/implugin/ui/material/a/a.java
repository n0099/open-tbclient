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
/* loaded from: classes10.dex */
public class a extends Dialog implements DialogInterface {
    private View ell;
    private TextView kIn;
    private Context mContext;
    private TextView mTitle;
    private AnimationSet oTj;
    private TextView oTk;
    private TextView oTl;
    private String oTm;
    private String oTn;
    private String oTo;
    private String oTp;
    private RelativeLayout oTq;
    private View oTr;
    private View oTs;
    private View oTt;

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
        this.oTm = str;
        this.oTn = str2;
        this.oTo = str3;
        this.oTp = str4;
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
                a.this.ell.setVisibility(8);
                a.this.ell.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.super.cancel();
                    }
                });
            }
        };
        this.oTj = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.S(getContext(), a.C0194a.bd_im_modal_out);
        this.oTj.setAnimationListener(animationListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.bd_im_alert_select_dialog);
        this.ell = getWindow().getDecorView().findViewById(16908290);
        ViewGroup.LayoutParams layoutParams = this.ell.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.ell.setLayoutParams(layoutParams);
        this.oTq = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.oTk = (TextView) findViewById(a.f.bd_im_dialog_cancel);
        this.oTl = (TextView) findViewById(a.f.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.f.bd_im_dialog_title);
        this.kIn = (TextView) findViewById(a.f.bd_im_dialog_content);
        this.oTr = findViewById(a.f.bd_im_dialog_divider2);
        this.oTs = findViewById(a.f.bd_im_dialog_divider3);
        this.oTt = findViewById(a.f.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.oTm)) {
            this.mTitle.setText(this.oTm);
        }
        if (!TextUtils.isEmpty(this.oTn)) {
            this.kIn.setText(this.oTn);
        }
        if (!TextUtils.isEmpty(this.oTo)) {
            this.oTl.setText(this.oTo);
        }
        if (!TextUtils.isEmpty(this.oTp)) {
            this.oTk.setText(this.oTp);
        }
        eiQ();
    }

    public void eiP() {
        super.cancel();
        Ax(true);
    }

    private void Ax(boolean z) {
        this.ell.startAnimation(this.oTj);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.oTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.oTl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void eiQ() {
    }
}
