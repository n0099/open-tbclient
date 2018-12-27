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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.Random;
/* loaded from: classes3.dex */
public class SignAllForumProgressView extends FrameLayout {
    private int duration;
    private TextView dww;
    private boolean heu;
    private int hgh;
    private TextView hgi;
    private TextView hgj;
    private TbImageView hgk;
    private RelativeLayout hgl;
    private Runnable hgm;
    private Runnable hgn;
    private Runnable hgo;
    private Context mContext;
    private ImageView mIcon;
    private ProgressBar mProgress;
    private Scroller mScroller;

    public SignAllForumProgressView(Context context) {
        super(context);
        this.hgh = 0;
        this.duration = 2000;
        this.hgm = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.hgh == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.hgm, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.hgn, SystemScreenshotManager.DELAY_TIME);
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
        this.hgn = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, SystemScreenshotManager.DELAY_TIME);
            }
        };
        this.hgo = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
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
        this.hgh = 0;
        this.duration = 2000;
        this.hgm = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.hgh == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.hgm, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.hgn, SystemScreenshotManager.DELAY_TIME);
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
        this.hgn = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, SystemScreenshotManager.DELAY_TIME);
            }
        };
        this.hgo = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
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
        this.hgh = 0;
        this.duration = 2000;
        this.hgm = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.hgh == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.hgm, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.hgn, SystemScreenshotManager.DELAY_TIME);
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
        this.hgn = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, SystemScreenshotManager.DELAY_TIME);
            }
        };
        this.hgo = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
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
        LayoutInflater.from(this.mContext).inflate(e.h.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(e.g.signallforum_progress);
        this.mIcon = (ImageView) findViewById(e.g.signallforum_icon);
        this.dww = (TextView) findViewById(e.g.signallforun_status);
        this.hgi = (TextView) findViewById(e.g.signallforun_message1);
        this.hgj = (TextView) findViewById(e.g.signallforun_message2);
        this.hgk = (TbImageView) findViewById(e.g.signallforum_banner_image);
        this.hgl = (RelativeLayout) findViewById(e.g.signallforum_banner_layout);
        updateUI();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), e.f.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void updateUI() {
        removeCallbacks(this.hgm);
        removeCallbacks(this.hgn);
        if (this.heu) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(e.f.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(e.f.singnallforum_progress));
        }
        switch (this.hgh) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.heu) {
                    al.i(this.mProgress, e.f.btn_vip_all_sign);
                    al.c(this.mIcon, e.f.icon_vip_sign);
                } else {
                    al.i(this.mProgress, e.f.btn_all_sign);
                    al.c(this.mIcon, e.f.icon_all_sign);
                }
                this.dww.setText(e.j.signallforum_begin);
                return;
            case 1:
                post(this.hgo);
                this.mProgress.setClickable(false);
                al.i(this.mProgress, e.f.bg_all_sign_conduct);
                if (this.heu) {
                    al.c(this.mIcon, e.f.icon_vip_sign);
                } else {
                    al.c(this.mIcon, e.f.icon_all_sign);
                }
                this.dww.setText(e.j.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.hgm);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.heu) {
                    al.i(this.mProgress, e.f.bg_vip_sign_ok_d);
                    al.c(this.mIcon, e.f.icon_vip_sign_ok);
                } else {
                    al.i(this.mProgress, e.f.bg_all_sign_ok_d);
                    al.c(this.mIcon, e.f.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.dww.setText(e.j.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.heu) {
                    al.c(this.mIcon, e.f.icon_vip_sign);
                } else {
                    al.c(this.mIcon, e.f.icon_all_sign);
                }
                al.i(this.mProgress, e.f.bg_all_sign_conduct);
                this.dww.setText(e.j.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.hgh;
    }

    public void setSigning(int i) {
        if (this.hgh != 1 && this.hgh == 0) {
            this.mProgress.setProgress(i);
            this.hgh = 1;
            updateUI();
        }
    }

    public void setSignBefore(int i) {
        this.mProgress.setProgress(i);
        this.hgh = 0;
        updateUI();
    }

    public void setSignSuccess() {
        if (this.hgh != 2) {
            this.hgh = 2;
            updateUI();
        }
    }

    public void a(final BaseActivity<?> baseActivity, final String str, final String str2) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.hgl.getVisibility() != 0) {
                    TiebaStatic.log("c11822");
                }
                SignAllForumProgressView.this.hgl.setVisibility(0);
                SignAllForumProgressView.this.hgk.startLoad(str, 10, true);
                if (!StringUtils.isNull(str2)) {
                    SignAllForumProgressView.this.hgl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!ay.Ef().a(baseActivity.getPageContext(), "", new String[]{str2}, false, null, true) && !ay.Ef().fT(str2)) {
                                baseActivity.showToast(e.j.pluginstatus_tip_unknown);
                            } else {
                                TiebaStatic.log("c11758");
                            }
                        }
                    });
                }
            }
        }, 3000L);
    }

    public void bAY() {
        this.hgl.setVisibility(8);
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public TextView getMessage1() {
        return this.hgi;
    }

    public TextView getMessage2() {
        return this.hgj;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.hgh = i;
        updateUI();
    }

    public void setHasPrivilege(boolean z) {
        this.heu = z;
        updateUI();
    }
}
