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
    private View iwY;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout pdV;
    private Button pdW;
    private TextView pdX;
    private ImageView pdY;
    private LinearLayout pea;
    private int peb;
    private boolean pdM = false;
    private int pdZ = 300;

    public c(Context context, View view, int i, long j) {
        this.peb = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.peb = i;
        this.mUserId = j;
        bXL();
    }

    private void bXL() {
        this.pdV = (LinearLayout) this.mRootView.findViewById(a.f.bd_im_subscribe_dialog_ll);
        this.pdW = (Button) this.mRootView.findViewById(a.f.subscribe_button);
        this.pea = (LinearLayout) this.mRootView.findViewById(a.f.subscribe_text_root);
        this.pdX = (TextView) this.mRootView.findViewById(a.f.subscribe_text);
        this.iwY = this.mRootView.findViewById(a.f.subscribe_space_line);
        this.pdY = (ImageView) this.mRootView.findViewById(a.f.subscribe_close);
        this.pdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.peb != 1) {
                    if (c.this.peb == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.phM + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.phL + ChatInfo.mPaid + ChatInfo.oZs, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.hB(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.peb == 1) {
            this.pdX.setText(this.mContext.getString(a.h.bd_im_subscribe_tip_text));
        } else if (this.peb == 0) {
            this.pdX.setText(this.mContext.getString(a.h.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.pdV != null && this.pdV.getVisibility() != 0) {
            this.pdV.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.pdW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.peb == 1) {
                        k.hC(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.peb == 0) {
                        k.hC(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.pdW.setClickable(false);
        }
        this.pdM = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.pdV.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0195a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.ell();
            }
        }, this.pdZ);
    }

    public void elo() {
        ell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ell() {
        if (this.pdM) {
            this.pdV.setVisibility(8);
        }
        this.pdM = false;
    }

    public boolean elp() {
        return this.pdM;
    }

    public int elq() {
        return this.peb;
    }
}
