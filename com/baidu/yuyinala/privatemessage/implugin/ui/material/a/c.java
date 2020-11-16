package com.baidu.yuyinala.privatemessage.implugin.ui.material.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.f.k;
/* loaded from: classes4.dex */
public class c {
    private View hYH;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout oCW;
    private Button oCX;
    private TextView oCY;
    private ImageView oCZ;
    private LinearLayout oDb;
    private int oDc;
    private boolean oCN = false;
    private int oDa = 300;

    public c(Context context, View view, int i, long j) {
        this.oDc = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.oDc = i;
        this.mUserId = j;
        bUr();
    }

    private void bUr() {
        this.oCW = (LinearLayout) this.mRootView.findViewById(a.f.bd_im_subscribe_dialog_ll);
        this.oCX = (Button) this.mRootView.findViewById(a.f.subscribe_button);
        this.oDb = (LinearLayout) this.mRootView.findViewById(a.f.subscribe_text_root);
        this.oCY = (TextView) this.mRootView.findViewById(a.f.subscribe_text);
        this.hYH = this.mRootView.findViewById(a.f.subscribe_space_line);
        this.oCZ = (ImageView) this.mRootView.findViewById(a.f.subscribe_close);
        this.oCZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.oDc != 1) {
                    if (c.this.oDc == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGK + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGJ + ChatInfo.mPaid + ChatInfo.oyt, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.gC(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.oDc == 1) {
            this.oCY.setText(this.mContext.getString(a.h.bd_im_subscribe_tip_text));
        } else if (this.oDc == 0) {
            this.oCY.setText(this.mContext.getString(a.h.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.oCW != null && this.oCW.getVisibility() != 0) {
            this.oCW.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.oCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.oDc == 1) {
                        k.gD(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.oDc == 0) {
                        k.gD(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.oCX.setClickable(false);
        }
        this.oCN = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.oCW.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0195a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.egT();
            }
        }, this.oDa);
    }

    public void egW() {
        egT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egT() {
        if (this.oCN) {
            this.oCW.setVisibility(8);
        }
        this.oCN = false;
    }

    public boolean egX() {
        return this.oCN;
    }

    public int egY() {
        return this.oDc;
    }
}
