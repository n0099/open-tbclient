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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes8.dex */
public class SignAllForumProgressView extends FrameLayout {
    private int aUb;
    private int duration;
    private ImageView dvq;
    private TextView iVr;
    private Context mContext;
    private ProgressBar mProgress;
    private Scroller mScroller;
    private boolean nnp;
    private TextView npg;
    private TextView nph;
    private TbImageView npi;
    private RelativeLayout npj;
    private Runnable npk;
    private Runnable npl;
    private Runnable npm;

    public SignAllForumProgressView(Context context) {
        super(context);
        this.aUb = 0;
        this.duration = 2000;
        this.npk = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.aUb == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.npk, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.npl, 2000L);
                    return;
                }
                int progress = SignAllForumProgressView.this.mProgress.getProgress();
                int max = (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    SignAllForumProgressView.this.mScroller.startScroll(progress, 0, max - progress, 0, 5000);
                    SignAllForumProgressView.this.post(this);
                }
            }
        };
        this.npl = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.npm = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
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
        this.aUb = 0;
        this.duration = 2000;
        this.npk = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.aUb == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.npk, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.npl, 2000L);
                    return;
                }
                int progress = SignAllForumProgressView.this.mProgress.getProgress();
                int max = (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    SignAllForumProgressView.this.mScroller.startScroll(progress, 0, max - progress, 0, 5000);
                    SignAllForumProgressView.this.post(this);
                }
            }
        };
        this.npl = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.npm = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
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
        this.aUb = 0;
        this.duration = 2000;
        this.npk = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.mScroller.computeScrollOffset()) {
                    int currX = SignAllForumProgressView.this.mScroller.getCurrX();
                    if (currX < (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10 || SignAllForumProgressView.this.aUb == 2) {
                        SignAllForumProgressView.this.mProgress.setProgress(currX);
                        SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.npk, 16L);
                        return;
                    }
                    SignAllForumProgressView.this.mScroller.forceFinished(true);
                    SignAllForumProgressView.this.postDelayed(SignAllForumProgressView.this.npl, 2000L);
                    return;
                }
                int progress = SignAllForumProgressView.this.mProgress.getProgress();
                int max = (SignAllForumProgressView.this.mProgress.getMax() * 9) / 10;
                if (progress < max) {
                    SignAllForumProgressView.this.mScroller.startScroll(progress, 0, max - progress, 0, 5000);
                    SignAllForumProgressView.this.post(this);
                }
            }
        };
        this.npl = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.2
            @Override // java.lang.Runnable
            public void run() {
                SignAllForumProgressView.this.postDelayed(this, 2000L);
            }
        };
        this.npm = new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.3
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
        LayoutInflater.from(this.mContext).inflate(R.layout.signallforum_progress_view, this);
        this.mProgress = (ProgressBar) findViewById(R.id.signallforum_progress);
        this.dvq = (ImageView) findViewById(R.id.signallforum_icon);
        this.iVr = (TextView) findViewById(R.id.signallforun_status);
        this.npg = (TextView) findViewById(R.id.signallforun_message1);
        this.nph = (TextView) findViewById(R.id.signallforun_message2);
        this.npi = (TbImageView) findViewById(R.id.signallforum_banner_image);
        this.npj = (RelativeLayout) findViewById(R.id.signallforum_banner_layout);
        updateUI();
        this.mScroller = new Scroller(this.mContext, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.bg_all_sign));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        setBackgroundDrawable(bitmapDrawable);
        ap.setBackgroundColor(this, R.color.CAM_X0201_1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public void updateUI() {
        removeCallbacks(this.npk);
        removeCallbacks(this.npl);
        if (this.nnp) {
            this.mProgress.setProgressDrawable(getResources().getDrawable(R.drawable.vip_singnallforum_progress));
        } else {
            this.mProgress.setProgressDrawable(getResources().getDrawable(R.drawable.singnallforum_progress));
        }
        switch (this.aUb) {
            case 0:
                this.mProgress.setClickable(true);
                this.mProgress.setProgress(0);
                this.mProgress.setSecondaryProgress(0);
                if (this.nnp) {
                    ap.setBackgroundResource(this.mProgress, R.drawable.btn_vip_all_sign);
                    ap.setImageResource(this.dvq, R.drawable.icon_vip_sign);
                } else {
                    ap.setBackgroundResource(this.mProgress, R.drawable.btn_all_sign);
                    ap.setImageResource(this.dvq, R.drawable.icon_all_sign);
                }
                this.iVr.setText(R.string.signallforum_begin);
                return;
            case 1:
                post(this.npm);
                this.mProgress.setClickable(false);
                ap.setBackgroundResource(this.mProgress, R.drawable.bg_all_sign_conduct);
                if (this.nnp) {
                    ap.setImageResource(this.dvq, R.drawable.icon_vip_sign);
                } else {
                    ap.setImageResource(this.dvq, R.drawable.icon_all_sign);
                }
                this.iVr.setText(R.string.signallforum_ing);
                int nextInt = ((new Random(System.currentTimeMillis()).nextInt(30) + 50) * this.mProgress.getMax()) / 100;
                if (nextInt - this.mProgress.getProgress() < 0) {
                    this.mScroller.startScroll(nextInt, 0, this.mProgress.getProgress() - nextInt, 0, this.duration);
                } else {
                    this.mScroller.startScroll(this.mProgress.getProgress(), 0, nextInt - this.mProgress.getProgress(), 0, this.duration);
                }
                post(this.npk);
                return;
            case 2:
                this.mProgress.setClickable(true);
                if (this.nnp) {
                    ap.setBackgroundResource(this.mProgress, R.drawable.bg_vip_sign_ok_d);
                    ap.setImageResource(this.dvq, R.drawable.icon_vip_sign_ok);
                } else {
                    ap.setBackgroundResource(this.mProgress, R.drawable.bg_all_sign_ok_d);
                    ap.setImageResource(this.dvq, R.drawable.icon_all_sign_ok);
                }
                this.mProgress.setProgress(0);
                this.iVr.setText(R.string.signallforum_success);
                return;
            case 3:
                this.mProgress.setClickable(false);
                if (this.nnp) {
                    ap.setImageResource(this.dvq, R.drawable.icon_vip_sign);
                } else {
                    ap.setImageResource(this.dvq, R.drawable.icon_all_sign);
                }
                ap.setBackgroundResource(this.mProgress, R.drawable.bg_all_sign_conduct);
                this.iVr.setText(R.string.can_not_sign);
                return;
            default:
                return;
        }
    }

    public int getCurrentStatus() {
        return this.aUb;
    }

    public void setSigning(int i) {
        if (this.aUb != 1 && this.aUb == 0) {
            this.mProgress.setProgress(i);
            this.aUb = 1;
            updateUI();
        }
    }

    public void setSignBefore(int i) {
        this.mProgress.setProgress(i);
        this.aUb = 0;
        updateUI();
    }

    public void setSignSuccess() {
        if (this.aUb != 2) {
            this.aUb = 2;
            updateUI();
        }
    }

    public void a(final BaseActivity<?> baseActivity, final String str, final String str2) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4
            @Override // java.lang.Runnable
            public void run() {
                if (SignAllForumProgressView.this.npj.getVisibility() != 0) {
                    TiebaStatic.log("c11822");
                }
                SignAllForumProgressView.this.npj.setVisibility(0);
                SignAllForumProgressView.this.npi.startLoad(str, 10, true);
                if (!StringUtils.isNull(str2)) {
                    SignAllForumProgressView.this.npj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.SignAllForumProgressView.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (!bf.bsV().a(baseActivity.getPageContext(), "", new String[]{str2}, false, null, true) && !bf.bsV().UrlValidated(str2)) {
                                baseActivity.showToast(R.string.pluginstatus_tip_unknown);
                            } else {
                                TiebaStatic.log("c11758");
                            }
                        }
                    });
                }
            }
        }, IMConnection.RETRY_DELAY_TIMES);
    }

    public void dLo() {
        this.npj.setVisibility(8);
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public TextView getMessage1() {
        return this.npg;
    }

    public TextView getMessage2() {
        return this.nph;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setmCurrentStatus(int i) {
        this.aUb = i;
        updateUI();
    }

    public void setHasPrivilege(boolean z) {
        this.nnp = z;
        updateUI();
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201_1);
    }
}
