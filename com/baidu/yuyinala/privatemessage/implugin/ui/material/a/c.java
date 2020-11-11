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
    private View hYh;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout oBs;
    private Button oBt;
    private TextView oBu;
    private ImageView oBv;
    private LinearLayout oBx;
    private int oBy;
    private boolean oBj = false;
    private int oBw = 300;

    public c(Context context, View view, int i, long j) {
        this.oBy = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.oBy = i;
        this.mUserId = j;
        bUY();
    }

    private void bUY() {
        this.oBs = (LinearLayout) this.mRootView.findViewById(a.f.bd_im_subscribe_dialog_ll);
        this.oBt = (Button) this.mRootView.findViewById(a.f.subscribe_button);
        this.oBx = (LinearLayout) this.mRootView.findViewById(a.f.subscribe_text_root);
        this.oBu = (TextView) this.mRootView.findViewById(a.f.subscribe_text);
        this.hYh = this.mRootView.findViewById(a.f.subscribe_space_line);
        this.oBv = (ImageView) this.mRootView.findViewById(a.f.subscribe_close);
        this.oBv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.oBy != 1) {
                    if (c.this.oBy == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFg + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFf + ChatInfo.mPaid + ChatInfo.owP, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.gE(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.oBy == 1) {
            this.oBu.setText(this.mContext.getString(a.h.bd_im_subscribe_tip_text));
        } else if (this.oBy == 0) {
            this.oBu.setText(this.mContext.getString(a.h.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.oBs != null && this.oBs.getVisibility() != 0) {
            this.oBs.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.oBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.oBy == 1) {
                        k.gF(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.oBy == 0) {
                        k.gF(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.oBt.setClickable(false);
        }
        this.oBj = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.oBs.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0197a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.egV();
            }
        }, this.oBw);
    }

    public void egY() {
        egV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egV() {
        if (this.oBj) {
            this.oBs.setVisibility(8);
        }
        this.oBj = false;
    }

    public boolean egZ() {
        return this.oBj;
    }

    public int eha() {
        return this.oBy;
    }
}
