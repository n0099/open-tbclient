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
/* loaded from: classes11.dex */
public class c {
    private View ixm;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout peA;
    private int peB;
    private LinearLayout pev;
    private Button pew;
    private TextView pex;
    private ImageView pey;
    private boolean pem = false;
    private int pez = 300;

    public c(Context context, View view, int i, long j) {
        this.peB = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.peB = i;
        this.mUserId = j;
        bXS();
    }

    private void bXS() {
        this.pev = (LinearLayout) this.mRootView.findViewById(a.f.bd_im_subscribe_dialog_ll);
        this.pew = (Button) this.mRootView.findViewById(a.f.subscribe_button);
        this.peA = (LinearLayout) this.mRootView.findViewById(a.f.subscribe_text_root);
        this.pex = (TextView) this.mRootView.findViewById(a.f.subscribe_text);
        this.ixm = this.mRootView.findViewById(a.f.subscribe_space_line);
        this.pey = (ImageView) this.mRootView.findViewById(a.f.subscribe_close);
        this.pey.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.peB != 1) {
                    if (c.this.peB == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pip + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pio + ChatInfo.mPaid + ChatInfo.oZS, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.hB(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.peB == 1) {
            this.pex.setText(this.mContext.getString(a.h.bd_im_subscribe_tip_text));
        } else if (this.peB == 0) {
            this.pex.setText(this.mContext.getString(a.h.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.pev != null && this.pev.getVisibility() != 0) {
            this.pev.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.pew.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.peB == 1) {
                        k.hC(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.peB == 0) {
                        k.hC(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.pew.setClickable(false);
        }
        this.pem = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.pev.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0195a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.elt();
            }
        }, this.pez);
    }

    public void elw() {
        elt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elt() {
        if (this.pem) {
            this.pev.setVisibility(8);
        }
        this.pem = false;
    }

    public boolean elx() {
        return this.pem;
    }

    public int ely() {
        return this.peB;
    }
}
