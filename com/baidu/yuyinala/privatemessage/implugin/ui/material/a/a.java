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
    private View ebG;
    private TextView ktD;
    private Context mContext;
    private TextView mTitle;
    private AnimationSet oAT;
    private TextView oAU;
    private TextView oAV;
    private String oAW;
    private String oAX;
    private String oAY;
    private String oAZ;
    private RelativeLayout oBa;
    private View oBb;
    private View oBc;
    private View oBd;

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
        this.oAW = str;
        this.oAX = str2;
        this.oAY = str3;
        this.oAZ = str4;
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
                a.this.ebG.setVisibility(8);
                a.this.ebG.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.super.cancel();
                    }
                });
            }
        };
        this.oAT = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.J(getContext(), a.C0197a.bd_im_modal_out);
        this.oAT.setAnimationListener(animationListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.bd_im_alert_select_dialog);
        this.ebG = getWindow().getDecorView().findViewById(16908290);
        ViewGroup.LayoutParams layoutParams = this.ebG.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.ebG.setLayoutParams(layoutParams);
        this.oBa = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.oAU = (TextView) findViewById(a.f.bd_im_dialog_cancel);
        this.oAV = (TextView) findViewById(a.f.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.f.bd_im_dialog_title);
        this.ktD = (TextView) findViewById(a.f.bd_im_dialog_content);
        this.oBb = findViewById(a.f.bd_im_dialog_divider2);
        this.oBc = findViewById(a.f.bd_im_dialog_divider3);
        this.oBd = findViewById(a.f.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.oAW)) {
            this.mTitle.setText(this.oAW);
        }
        if (!TextUtils.isEmpty(this.oAX)) {
            this.ktD.setText(this.oAX);
        }
        if (!TextUtils.isEmpty(this.oAY)) {
            this.oAV.setText(this.oAY);
        }
        if (!TextUtils.isEmpty(this.oAZ)) {
            this.oAU.setText(this.oAZ);
        }
        egU();
    }

    public void egT() {
        super.cancel();
        zQ(true);
    }

    private void zQ(boolean z) {
        this.ebG.startAnimation(this.oAT);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.oAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.oAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void egU() {
    }
}
