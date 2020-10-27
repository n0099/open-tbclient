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
    private View hSk;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout orZ;
    private Button osa;
    private TextView osb;
    private ImageView osc;
    private LinearLayout ose;
    private int osf;
    private boolean orQ = false;
    private int osd = 300;

    public c(Context context, View view, int i, long j) {
        this.osf = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.osf = i;
        this.mUserId = j;
        bSz();
    }

    private void bSz() {
        this.orZ = (LinearLayout) this.mRootView.findViewById(a.g.bd_im_subscribe_dialog_ll);
        this.osa = (Button) this.mRootView.findViewById(a.g.subscribe_button);
        this.ose = (LinearLayout) this.mRootView.findViewById(a.g.subscribe_text_root);
        this.osb = (TextView) this.mRootView.findViewById(a.g.subscribe_text);
        this.hSk = this.mRootView.findViewById(a.g.subscribe_space_line);
        this.osc = (ImageView) this.mRootView.findViewById(a.g.subscribe_close);
        this.osc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.osf != 1) {
                    if (c.this.osf == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovO + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovN + ChatInfo.mPaid + ChatInfo.onu, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.gE(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.osf == 1) {
            this.osb.setText(this.mContext.getString(a.i.bd_im_subscribe_tip_text));
        } else if (this.osf == 0) {
            this.osb.setText(this.mContext.getString(a.i.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.orZ != null && this.orZ.getVisibility() != 0) {
            this.orZ.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.osa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.osf == 1) {
                        k.gF(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.osf == 0) {
                        k.gF(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.osa.setClickable(false);
        }
        this.orQ = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.orZ.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0195a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.edg();
            }
        }, this.osd);
    }

    public void edj() {
        edg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edg() {
        if (this.orQ) {
            this.orZ.setVisibility(8);
        }
        this.orQ = false;
    }

    public boolean edk() {
        return this.orQ;
    }

    public int edl() {
        return this.osf;
    }
}
