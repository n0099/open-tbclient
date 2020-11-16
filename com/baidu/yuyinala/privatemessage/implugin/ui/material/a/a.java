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
    private View dZY;
    private TextView kun;
    private Context mContext;
    private TextView mTitle;
    private String oCA;
    private String oCB;
    private String oCC;
    private String oCD;
    private RelativeLayout oCE;
    private View oCF;
    private View oCG;
    private View oCH;
    private AnimationSet oCx;
    private TextView oCy;
    private TextView oCz;

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
        this.oCA = str;
        this.oCB = str2;
        this.oCC = str3;
        this.oCD = str4;
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
                a.this.dZY.setVisibility(8);
                a.this.dZY.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.super.cancel();
                    }
                });
            }
        };
        this.oCx = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.J(getContext(), a.C0195a.bd_im_modal_out);
        this.oCx.setAnimationListener(animationListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.bd_im_alert_select_dialog);
        this.dZY = getWindow().getDecorView().findViewById(16908290);
        ViewGroup.LayoutParams layoutParams = this.dZY.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.dZY.setLayoutParams(layoutParams);
        this.oCE = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.oCy = (TextView) findViewById(a.f.bd_im_dialog_cancel);
        this.oCz = (TextView) findViewById(a.f.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.f.bd_im_dialog_title);
        this.kun = (TextView) findViewById(a.f.bd_im_dialog_content);
        this.oCF = findViewById(a.f.bd_im_dialog_divider2);
        this.oCG = findViewById(a.f.bd_im_dialog_divider3);
        this.oCH = findViewById(a.f.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.oCA)) {
            this.mTitle.setText(this.oCA);
        }
        if (!TextUtils.isEmpty(this.oCB)) {
            this.kun.setText(this.oCB);
        }
        if (!TextUtils.isEmpty(this.oCC)) {
            this.oCz.setText(this.oCC);
        }
        if (!TextUtils.isEmpty(this.oCD)) {
            this.oCy.setText(this.oCD);
        }
        egS();
    }

    public void egR() {
        super.cancel();
        zX(true);
    }

    private void zX(boolean z) {
        this.dZY.startAnimation(this.oCx);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.oCy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.oCz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void egS() {
    }
}
