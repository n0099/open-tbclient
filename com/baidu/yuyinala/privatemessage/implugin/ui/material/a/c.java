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
/* loaded from: classes10.dex */
public class c {
    private View iru;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout oTH;
    private Button oTI;
    private TextView oTJ;
    private ImageView oTK;
    private LinearLayout oTM;
    private int oTN;
    private boolean oTy = false;
    private int oTL = 300;

    public c(Context context, View view, int i, long j) {
        this.oTN = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.oTN = i;
        this.mUserId = j;
        bWP();
    }

    private void bWP() {
        this.oTH = (LinearLayout) this.mRootView.findViewById(a.f.bd_im_subscribe_dialog_ll);
        this.oTI = (Button) this.mRootView.findViewById(a.f.subscribe_button);
        this.oTM = (LinearLayout) this.mRootView.findViewById(a.f.subscribe_text_root);
        this.oTJ = (TextView) this.mRootView.findViewById(a.f.subscribe_text);
        this.iru = this.mRootView.findViewById(a.f.subscribe_space_line);
        this.oTK = (ImageView) this.mRootView.findViewById(a.f.subscribe_close);
        this.oTK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.oTN != 1) {
                    if (c.this.oTN == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXy + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXx + ChatInfo.mPaid + ChatInfo.oPh, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.hy(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.oTN == 1) {
            this.oTJ.setText(this.mContext.getString(a.h.bd_im_subscribe_tip_text));
        } else if (this.oTN == 0) {
            this.oTJ.setText(this.mContext.getString(a.h.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.oTH != null && this.oTH.getVisibility() != 0) {
            this.oTH.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.oTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.oTN == 1) {
                        k.hz(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.oTN == 0) {
                        k.hz(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.oTI.setClickable(false);
        }
        this.oTy = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.oTH.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0194a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.eiR();
            }
        }, this.oTL);
    }

    public void eiU() {
        eiR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eiR() {
        if (this.oTy) {
            this.oTH.setVisibility(8);
        }
        this.oTy = false;
    }

    public boolean eiV() {
        return this.oTy;
    }

    public int eiW() {
        return this.oTN;
    }
}
