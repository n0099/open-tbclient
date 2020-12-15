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
    private View ijG;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout oSe;
    private Button oSf;
    private TextView oSg;
    private ImageView oSh;
    private LinearLayout oSj;
    private int oSk;
    private boolean oRV = false;
    private int oSi = 300;

    public c(Context context, View view, int i, long j) {
        this.oSk = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.oSk = i;
        this.mUserId = j;
        bYb();
    }

    private void bYb() {
        this.oSe = (LinearLayout) this.mRootView.findViewById(a.f.bd_im_subscribe_dialog_ll);
        this.oSf = (Button) this.mRootView.findViewById(a.f.subscribe_button);
        this.oSj = (LinearLayout) this.mRootView.findViewById(a.f.subscribe_text_root);
        this.oSg = (TextView) this.mRootView.findViewById(a.f.subscribe_text);
        this.ijG = this.mRootView.findViewById(a.f.subscribe_space_line);
        this.oSh = (ImageView) this.mRootView.findViewById(a.f.subscribe_close);
        this.oSh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.oSk != 1) {
                    if (c.this.oSk == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVS + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVR + ChatInfo.mPaid + ChatInfo.oNB, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.hl(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.oSk == 1) {
            this.oSg.setText(this.mContext.getString(a.h.bd_im_subscribe_tip_text));
        } else if (this.oSk == 0) {
            this.oSg.setText(this.mContext.getString(a.h.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.oSe != null && this.oSe.getVisibility() != 0) {
            this.oSe.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.oSf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.oSk == 1) {
                        k.hm(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.oSk == 0) {
                        k.hm(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.oSf.setClickable(false);
        }
        this.oRV = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.oSe.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0205a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.emI();
            }
        }, this.oSi);
    }

    public void emL() {
        emI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emI() {
        if (this.oRV) {
            this.oSe.setVisibility(8);
        }
        this.oRV = false;
    }

    public boolean emM() {
        return this.oRV;
    }

    public int emN() {
        return this.oSk;
    }
}
