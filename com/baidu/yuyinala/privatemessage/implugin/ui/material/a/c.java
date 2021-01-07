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
    private View iwb;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout oYj;
    private Button oYk;
    private TextView oYl;
    private ImageView oYm;
    private LinearLayout oYo;
    private int oYp;
    private boolean oYa = false;
    private int oYn = 300;

    public c(Context context, View view, int i, long j) {
        this.oYp = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.oYp = i;
        this.mUserId = j;
        caH();
    }

    private void caH() {
        this.oYj = (LinearLayout) this.mRootView.findViewById(a.f.bd_im_subscribe_dialog_ll);
        this.oYk = (Button) this.mRootView.findViewById(a.f.subscribe_button);
        this.oYo = (LinearLayout) this.mRootView.findViewById(a.f.subscribe_text_root);
        this.oYl = (TextView) this.mRootView.findViewById(a.f.subscribe_text);
        this.iwb = this.mRootView.findViewById(a.f.subscribe_space_line);
        this.oYm = (ImageView) this.mRootView.findViewById(a.f.subscribe_close);
        this.oYm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.oYp != 1) {
                    if (c.this.oYp == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pcc + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pcb + ChatInfo.mPaid + ChatInfo.oTJ, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.hA(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.oYp == 1) {
            this.oYl.setText(this.mContext.getString(a.h.bd_im_subscribe_tip_text));
        } else if (this.oYp == 0) {
            this.oYl.setText(this.mContext.getString(a.h.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.oYj != null && this.oYj.getVisibility() != 0) {
            this.oYj.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.oYk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.oYp == 1) {
                        k.hB(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.oYp == 0) {
                        k.hB(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.oYk.setClickable(false);
        }
        this.oYa = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.oYj.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0203a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.emL();
            }
        }, this.oYn);
    }

    public void emO() {
        emL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emL() {
        if (this.oYa) {
            this.oYj.setVisibility(8);
        }
        this.oYa = false;
    }

    public boolean emP() {
        return this.oYa;
    }

    public int emQ() {
        return this.oYp;
    }
}
