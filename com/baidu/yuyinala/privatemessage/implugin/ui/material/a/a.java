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
    private View eoW;
    private TextView kSG;
    private Context mContext;
    private TextView mTitle;
    private AnimationSet pgb;
    private TextView pgc;
    private TextView pgd;
    private String pge;
    private String pgf;
    private String pgg;
    private String pgh;
    private RelativeLayout pgi;
    private View pgj;
    private View pgk;
    private View pgl;

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
        this.pge = str;
        this.pgf = str2;
        this.pgg = str3;
        this.pgh = str4;
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
                a.this.eoW.setVisibility(8);
                a.this.eoW.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.super.cancel();
                    }
                });
            }
        };
        this.pgb = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.S(getContext(), a.C0201a.bd_im_modal_out);
        this.pgb.setAnimationListener(animationListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.bd_im_alert_select_dialog);
        this.eoW = getWindow().getDecorView().findViewById(16908290);
        ViewGroup.LayoutParams layoutParams = this.eoW.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.eoW.setLayoutParams(layoutParams);
        this.pgi = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.pgc = (TextView) findViewById(a.f.bd_im_dialog_cancel);
        this.pgd = (TextView) findViewById(a.f.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.f.bd_im_dialog_title);
        this.kSG = (TextView) findViewById(a.f.bd_im_dialog_content);
        this.pgj = findViewById(a.f.bd_im_dialog_divider2);
        this.pgk = findViewById(a.f.bd_im_dialog_divider3);
        this.pgl = findViewById(a.f.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.pge)) {
            this.mTitle.setText(this.pge);
        }
        if (!TextUtils.isEmpty(this.pgf)) {
            this.kSG.setText(this.pgf);
        }
        if (!TextUtils.isEmpty(this.pgg)) {
            this.pgd.setText(this.pgg);
        }
        if (!TextUtils.isEmpty(this.pgh)) {
            this.pgc.setText(this.pgh);
        }
        elC();
    }

    public void elB() {
        super.cancel();
        AP(true);
    }

    private void AP(boolean z) {
        this.eoW.startAnimation(this.pgb);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.pgc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.pgd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void elC() {
    }
}
