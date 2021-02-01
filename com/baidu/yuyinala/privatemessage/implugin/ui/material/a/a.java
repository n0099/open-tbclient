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
    private TextView kQq;
    private Context mContext;
    private TextView mTitle;
    private String pdA;
    private String pdB;
    private String pdC;
    private RelativeLayout pdD;
    private View pdE;
    private View pdF;
    private View pdG;
    private AnimationSet pdw;
    private TextView pdx;
    private TextView pdy;
    private String pdz;

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
        this.pdz = str;
        this.pdA = str2;
        this.pdB = str3;
        this.pdC = str4;
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
        this.pdw = (AnimationSet) com.baidu.yuyinala.privatemessage.implugin.ui.material.c.a.S(getContext(), a.C0195a.bd_im_modal_out);
        this.pdw.setAnimationListener(animationListener);
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
        this.pdD = (RelativeLayout) findViewById(a.f.searchbox_alert_dialog);
        this.pdx = (TextView) findViewById(a.f.bd_im_dialog_cancel);
        this.pdy = (TextView) findViewById(a.f.bd_im_dialog_ensure);
        this.mTitle = (TextView) findViewById(a.f.bd_im_dialog_title);
        this.kQq = (TextView) findViewById(a.f.bd_im_dialog_content);
        this.pdE = findViewById(a.f.bd_im_dialog_divider2);
        this.pdF = findViewById(a.f.bd_im_dialog_divider3);
        this.pdG = findViewById(a.f.bd_im_dialog_divider4);
        if (!TextUtils.isEmpty(this.pdz)) {
            this.mTitle.setText(this.pdz);
        }
        if (!TextUtils.isEmpty(this.pdA)) {
            this.kQq.setText(this.pdA);
        }
        if (!TextUtils.isEmpty(this.pdB)) {
            this.pdy.setText(this.pdB);
        }
        if (!TextUtils.isEmpty(this.pdC)) {
            this.pdx.setText(this.pdC);
        }
        elk();
    }

    public void elj() {
        super.cancel();
        AQ(true);
    }

    private void AQ(boolean z) {
        this.ent.startAnimation(this.pdw);
    }

    public void a(final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        this.pdx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        this.pdy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener2.onClick(view);
            }
        });
    }

    private void elk() {
    }
}
