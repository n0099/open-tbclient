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
    private View iyV;
    private Context mContext;
    private View mRootView;
    private long mUserId;
    private LinearLayout pgA;
    private Button pgB;
    private TextView pgC;
    private ImageView pgD;
    private LinearLayout pgF;
    private int pgG;
    private boolean pgr = false;
    private int pgE = 300;

    public c(Context context, View view, int i, long j) {
        this.pgG = 1;
        this.mUserId = -1L;
        this.mContext = context.getApplicationContext();
        this.mRootView = view;
        this.pgG = i;
        this.mUserId = j;
        bXY();
    }

    private void bXY() {
        this.pgA = (LinearLayout) this.mRootView.findViewById(a.f.bd_im_subscribe_dialog_ll);
        this.pgB = (Button) this.mRootView.findViewById(a.f.subscribe_button);
        this.pgF = (LinearLayout) this.mRootView.findViewById(a.f.subscribe_text_root);
        this.pgC = (TextView) this.mRootView.findViewById(a.f.subscribe_text);
        this.iyV = this.mRootView.findViewById(a.f.subscribe_space_line);
        this.pgD = (ImageView) this.mRootView.findViewById(a.f.subscribe_close);
        this.pgD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                if (c.this.pgG != 1) {
                    if (c.this.pgG == 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pkv + c.this.mUserId, System.currentTimeMillis());
                    }
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(c.this.mContext, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pku + ChatInfo.mPaid + ChatInfo.pbZ, System.currentTimeMillis());
                }
                com.baidu.yuyinala.privatemessage.implugin.e.a.hA(c.this.mContext.getApplicationContext()).add("416", "subscribe_close");
            }
        });
        if (this.pgG == 1) {
            this.pgC.setText(this.mContext.getString(a.h.bd_im_subscribe_tip_text));
        } else if (this.pgG == 0) {
            this.pgC.setText(this.mContext.getString(a.h.bd_im_game_user_sub_tip));
        }
    }

    public void c(final String str, final long j, final IIsSubscribedListener iIsSubscribedListener) {
        if (this.pgA != null && this.pgA.getVisibility() != 0) {
            this.pgA.setVisibility(0);
        }
        if (iIsSubscribedListener != null) {
            this.pgB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.pgG == 1) {
                        k.hB(c.this.mContext).a(str, j, iIsSubscribedListener);
                    } else if (c.this.pgG == 0) {
                        k.hB(c.this.mContext).b(str, j, iIsSubscribedListener);
                    }
                }
            });
        } else {
            this.pgB.setClickable(false);
        }
        this.pgr = true;
    }

    public void dismiss() {
        Handler handler = new Handler();
        this.pgA.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0201a.bd_im_dimiss_tip));
        handler.postDelayed(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.elD();
            }
        }, this.pgE);
    }

    public void elG() {
        elD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elD() {
        if (this.pgr) {
            this.pgA.setVisibility(8);
        }
        this.pgr = false;
    }

    public boolean elH() {
        return this.pgr;
    }

    public int elI() {
        return this.pgG;
    }
}
