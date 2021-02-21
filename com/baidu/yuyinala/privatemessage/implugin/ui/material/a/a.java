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
    private View ent;
    private TextView kQE;
    private Context mContext;
    private TextView mTitle;
    private AnimationSet pdW;
    private TextView pdX;
    private TextView pdY;
    private String pdZ;
    private String pea;
    private String peb;
    private String pec;
    private RelativeLayout ped;
    private View pee;
    private View pef;
    private View peg;

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
        this.pdZ = str;
        this.pea = str2;
        this.peb = str3;
        this.pec = str4;
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
                a.this.ent.setVisibility(8);
                a.this.ent.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.super.cancel();
                    }
                });
            }
        };
        this.pdW = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.S(getContext(), a.C0195a.bd_im_modal_out);
        this.pdW.setAnimationListener(animationListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.bd_im_alert_select_dialog);
        this.ent = getWindow().getDecorView().findViewById(16908290);
        ViewGroup.LayoutParams layoutParams = this.ent.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        this.ent.setLayoutParams(layoutParams);
        this.ped = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.pdX = (TextView) findViewById(a.f.bd_im_dialog_cancel);
        this.pdY = (TextView) findViewById(a.f.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.f.bd_im_dialog_title);
        this.kQE = (TextView) findViewById(a.f.bd_im_dialog_content);
        this.pee = findViewById(a.f.bd_im_dialog_divider2);
        this.pef = findViewById(a.f.bd_im_dialog_divider3);
        this.peg = findViewById(a.f.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.pdZ)) {
            this.mTitle.setText(this.pdZ);
        }
        if (!TextUtils.isEmpty(this.pea)) {
            this.kQE.setText(this.pea);
        }
        if (!TextUtils.isEmpty(this.peb)) {
            this.pdY.setText(this.peb);
        }
        if (!TextUtils.isEmpty(this.pec)) {
            this.pdX.setText(this.pec);
        }
        els();
    }

    public void elr() {
        super.cancel();
        AQ(true);
    }

    private void AQ(boolean z) {
        this.ent.startAnimation(this.pdW);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.pdX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.pdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void els() {
    }
}
