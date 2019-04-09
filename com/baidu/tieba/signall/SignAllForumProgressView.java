package com.baidu.tieba.signall;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes6.dex */
public class SignAllForumProgressView extends FrameLayout {
    private int duration;
    private TextView eKi;
    private boolean iwU;
    private int iyH;
    private TextView iyI;
    private TextView iyJ;
    private TbImageView iyK;
    private RelativeLayout iyL;
    private Runnable iyM;
    private Runnable iyN;
    private Runnable iyO;
    private Context mContext;
    private ImageView mIcon;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public SignAllForumProgressView(Context context) {
        super(context);
        this.iyH = 0;
        this.duration = 2000;
        this.iyM = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.iyH == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.iyM, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.iyN, 2000L);
                    return;
                }
                int progress = SignAllForumProgressView.this.mProgress.getProgress();
                int max = (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    SignAllForumProgressView.this.mScroller.startScroll(progress, 0, max - progress, 0, UIMsg.m_AppUI.MSG_APP_GPS);
                    SignAllForumProgressView.this.post(this);
                }
            }
        };
        this.iyN = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.iyO = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
            @Override // java.lang.Runnable
            public void run() {
                int dip2px = l.dip2px(SignAllForumProgressView.this.mContext, 6.0f);
                int dip2px2 = l.dip2px(SignAllForumProgressView.this.mContext, 100.0f);
                int i = dip2px2 - (dip2px * 2);
                int i2 = (dip2px2 - i) / 2;
                SignAllForumProgressView.this.mProgress.getProgressDrawable().setBounds(i2, i2, i2 + i, i + i2);
            }
        };
        init();
    }

    public SignAllForumProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iyH = 0;
        this.duration = 2000;
        this.iyM = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.iyH == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.iyM, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.iyN, 2000L);
                    return;
                }
                int progress = SignAllForumProgressView.this.mProgress.getProgress();
                int max = (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    SignAllForumProgressView.this.mScroller.startScroll(progress, 0, max - progress, 0, UIMsg.m_AppUI.MSG_APP_GPS);
                    SignAllForumProgressView.this.post(this);
                }
            }
        };
        this.iyN = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.iyO = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
            @Override // java.lang.Runnable
            public void run() {
                int dip2px = l.dip2px(SignAllForumProgressView.this.mContext, 6.0f);
                int dip2px2 = l.dip2px(SignAllForumProgressView.this.mContext, 100.0f);
                int i2 = dip2px2 - (dip2px * 2);
                int i22 = (dip2px2 - i2) / 2;
                SignAllForumProgressView.this.mProgress.getProgressDrawable().setBounds(i22, i22, i22 + i2, i2 + i22);
            }
        };
        init();
    }

    public SignAllForumProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iyH = 0;
        this.duration = 2000;
        this.iyM = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.iyH == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.iyM, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.iyN, 2000L);
                    return;
                }
                int progress = SignAllForumProgressView.this.mProgress.getProgress();
                int max = (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    SignAllForumProgressView.this.mScroller.startScroll(progress, 0, max - progress, 0, UIMsg.m_AppUI.MSG_APP_GPS);
                    SignAllForumProgressView.this.post(this);
                }
            }
        };
        this.iyN = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.iyO = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
            @Override // java.lang.Runnable
            public void run() {
                int dip2px = l.dip2px(SignAllForumProgressView.this.mContext, 6.0f);
                int dip2px2 = l.dip2px(SignAllForumProgressView.this.mContext, 100.0f);
                int i2 = dip2px2 - (dip2px * 2);
                int i22 = (dip2px2 - i2) / 2;
                SignAllForumProgressView.this.mProgress.getProgressDrawable().setBounds(i22, i22, i22 + i2, i2 + i22);
            }
        };
        init();
    }

    private void init() {
        this.mContext = getContext();
        LayoutInflater.from(this.mContext).inflate(d.h.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(d.g.signallforum_progress);
        this.mIcon = (ImageView) findViewById(d.g.signallforum_icon);
        this.eKi = (TextView) findViewById(d.g.signallforun_status);
        this.iyI = (TextView) findViewById(d.g.signallforun_message1);
        this.iyJ = (TextView) findViewById(d.g.signallforun_message2);
        this.iyK = (TbImageView) findViewById(d.g.signallforum_banner_image);
        this.iyL = (RelativeLayout) findViewById(d.g.signallforum_banner_layout);
        GP();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), d.f.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void GP() {
        removeCallbacks(this.iyM);
        removeCallbacks(this.iyN);
        if (this.iwU) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(d.f.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(d.f.singnallforum_progress));
        }
        switch (this.iyH) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.iwU) {
                    al.k(this.mProgress, d.f.btn_vip_all_sign);
                    al.c(this.mIcon, d.f.icon_vip_sign);
                } else {
                    al.k(this.mProgress, d.f.btn_all_sign);
                    al.c(this.mIcon, d.f.icon_all_sign);
                }
                this.eKi.setText(d.j.signallforum_begin);
                return;
            case 1:
                post(this.iyO);
                this.mProgress.setClickable(false);
                al.k(this.mProgress, d.f.bg_all_sign_conduct);
                if (this.iwU) {
                    al.c(this.mIcon, d.f.icon_vip_sign);
                } else {
                    al.c(this.mIcon, d.f.icon_all_sign);
                }
                this.eKi.setText(d.j.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.iyM);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.iwU) {
                    al.k(this.mProgress, d.f.bg_vip_sign_ok_d);
                    al.c(this.mIcon, d.f.icon_vip_sign_ok);
                } else {
                    al.k(this.mProgress, d.f.bg_all_sign_ok_d);
                    al.c(this.mIcon, d.f.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.eKi.setText(d.j.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.iwU) {
                    al.c(this.mIcon, d.f.icon_vip_sign);
                } else {
                    al.c(this.mIcon, d.f.icon_all_sign);
                }
                al.k(this.mProgress, d.f.bg_all_sign_conduct);
                this.eKi.setText(d.j.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.iyH;
    }

    public void setSigning(int i) {
        if (this.iyH != 1 && this.iyH == 0) {
            this.mProgress.setProgress(i);
            this.iyH = 1;
            GP();
        }
    }

    public void setSignBefore(int i) {
        this.mProgress.setProgress(i);
        this.iyH = 0;
        GP();
    }

    public void setSignSuccess() {
        if (this.iyH != 2) {
            this.iyH = 2;
            GP();
        }
    }

    public void a(final BaseActivity<?> baseActivity, final String str, final String str2) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.iyL.getVisibility() != 0) {
                    TiebaStatic.log("c11822");
                }
                SignAllForumProgressView.this.iyL.setVisibility(0);
                SignAllForumProgressView.this.iyK.startLoad(str, 10, true);
                if (!StringUtils.isNull(str2)) {
                    SignAllForumProgressView.this.iyL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!ba.adA().a(baseActivity.getPageContext(), "", new String[]{str2}, false, null, true) && !ba.adA().mT(str2)) {
                                baseActivity.showToast(d.j.pluginstatus_tip_unknown);
                            } else {
                                TiebaStatic.log("c11758");
                            }
                        }
                    });
                }
            }
        }, 3000L);
    }

    public void ccu() {
        this.iyL.setVisibility(8);
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public TextView getMessage1() {
        return this.iyI;
    }

    public TextView getMessage2() {
        return this.iyJ;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.iyH = i;
        GP();
    }

    public void setHasPrivilege(boolean z) {
        this.iwU = z;
        GP();
    }
}
