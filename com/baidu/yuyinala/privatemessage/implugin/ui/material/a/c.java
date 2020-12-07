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
    private View ijE;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout oSc;
    private Button oSd;
    private TextView oSe;
    private ImageView oSf;
    private LinearLayout oSh;
    private int oSi;
    private boolean oRT = false;
    private int oSg = 300;

    public c(Context context, View view, int i, long j) {
        this.oSi = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.oSi = i;
        this.mUserId = j;
        bYa();
    }

    private void bYa() {
        this.oSc = (LinearLayout) this.mRootView.findViewById(a.f.bd_im_subscribe_dialog_ll);
        this.oSd = (Button) this.mRootView.findViewById(a.f.subscribe_button);
        this.oSh = (LinearLayout) this.mRootView.findViewById(a.f.subscribe_text_root);
        this.oSe = (TextView) this.mRootView.findViewById(a.f.subscribe_text);
        this.ijE = this.mRootView.findViewById(a.f.subscribe_space_line);
        this.oSf = (ImageView) this.mRootView.findViewById(a.f.subscribe_close);
        this.oSf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.oSi != 1) {
                    if (c.this.oSi == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVQ + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVP + ChatInfo.mPaid + ChatInfo.oNz, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.hl(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.oSi == 1) {
            this.oSe.setText(this.mContext.getString(a.h.bd_im_subscribe_tip_text));
        } else if (this.oSi == 0) {
            this.oSe.setText(this.mContext.getString(a.h.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.oSc != null && this.oSc.getVisibility() != 0) {
            this.oSc.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.oSd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.oSi == 1) {
                        k.hm(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.oSi == 0) {
                        k.hm(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.oSd.setClickable(false);
        }
        this.oRT = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.oSc.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0205a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.emH();
            }
        }, this.oSg);
    }

    public void emK() {
        emH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emH() {
        if (this.oRT) {
            this.oSc.setVisibility(8);
        }
        this.oRT = false;
    }

    public boolean emL() {
        return this.oRT;
    }

    public int emM() {
        return this.oSi;
    }
}
