package com.baidu.tieba.yuyinala.liveroom.m;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.ag;
import com.baidu.live.gift.ak;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class a implements ag {
    private AnimatorSet baG;
    private TranslateAnimation baH;
    private boolean baw;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData hLg;
    private int hLi;
    private LinearLayout hLj;
    private TextView hLk;
    private FrameLayout hLl;
    private TextView hLm;
    private TextView hLn;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> hLf = new ArrayList<>();
    private boolean bav = false;
    private boolean hLh = true;
    private Handler mHandler = new Handler();
    protected boolean hsA = false;
    protected boolean hLo = true;
    private boolean isForeground = true;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.m.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.f.confirm) {
                if (a.this.mDialog != null) {
                    a.this.mDialog.dismiss();
                    a.this.mDialog = null;
                }
            } else if (view.getId() == a.f.msg_background) {
                a.this.hLl.setVisibility(4);
                if (a.this.hLg != null) {
                    if (TextUtils.isEmpty(a.this.hLg.url)) {
                        a.this.d(a.this.hLg);
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913172, a.this.hLg.url));
                    }
                }
            }
        }
    };
    private final Runnable hfw = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.m.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.cx(a.this.hLj)) {
                a.this.mHandler.removeCallbacks(a.this.hfw);
                a.this.It();
                return;
            }
            a.this.startCountDown();
        }
    };

    public a(ak akVar) {
        if (akVar != null && akVar.pageContext != null) {
            this.mPageContext = akVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.baw = akVar.aWW;
            this.hLj = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.official_notice_container, (ViewGroup) null);
            this.hLl = (FrameLayout) this.hLj.findViewById(a.f.msg_background);
            this.hLl.setOnClickListener(this.mOnClickListener);
            this.hLl.setVisibility(4);
            this.hLk = (TextView) this.hLj.findViewById(a.f.msg_content);
            this.hLk.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.hLk.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hLk.getLayoutParams();
                layoutParams.width = i;
                this.hLk.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.hLk.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            this.hLi = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            Nu();
        }
    }

    private void Nu() {
        this.baG = new AnimatorSet();
        this.baG.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hLj, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hLj, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hLj, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat3.setDuration(9000L);
        ofFloat3.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.yuyinala.liveroom.m.a.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                if (f <= 0.11111111f) {
                    return 4.5f * f;
                }
                if (f >= 0.7777778f) {
                    return (4.5f * f) - 3.0f;
                }
                return 0.5f;
            }
        });
        this.mAnimators = new ArrayList<>();
        this.mAnimators.add(ofFloat);
        this.mAnimators.add(ofFloat2);
        this.mAnimators.add(ofFloat3);
        this.baG.playTogether(this.mAnimators);
        this.baG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.m.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.bav = true;
                a.this.hLl.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.Iu();
                a.this.It();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void It() {
        if (!this.bav && !ListUtils.isEmpty(this.hLf)) {
            if (cx(this.hLj)) {
                startCountDown();
                return;
            }
            this.hLg = (OfficialNoticeData) ListUtils.getItem(this.hLf, 0);
            ListUtils.remove(this.hLf, 0);
            b(this.hLg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu() {
        this.bav = false;
        this.hLk.clearAnimation();
        this.hLj.clearAnimation();
        this.hLl.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.hLf.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.hLf.add(officialNoticeData);
            It();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a2 = a(officialNoticeData, this.baw);
            if (a2 != null && a2.length() <= 0) {
                Iu();
                It();
                return;
            }
            this.hLk.setText(a2);
            if (a2 != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a2.toString());
                float f = -(((textWidth - this.hLi) * 1.0f) / this.hLi);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hLk.getLayoutParams();
                if (textWidth - this.hLi < 0) {
                    layoutParams.width = -2;
                    this.hLk.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.hLk.setLayoutParams(layoutParams);
                    this.baH = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.baH.setStartOffset(4000L);
                    this.baH.setDuration(1000L);
                    this.baH.setFillAfter(true);
                    this.hLk.startAnimation(this.baH);
                }
            }
            this.baG.start();
            c(officialNoticeData);
            this.hLl.setTag(officialNoticeData);
        }
    }

    private SpannableStringBuilder a(OfficialNoticeData officialNoticeData, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (officialNoticeData != null) {
            spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.official_notice_content), officialNoticeData.subCopyTagContent));
        }
        return spannableStringBuilder;
    }

    private void c(OfficialNoticeData officialNoticeData) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null && !TextUtils.isEmpty(officialNoticeData.subCopyTagContent)) {
            if (this.mDialog == null || !this.mDialog.isShowing()) {
                if (this.mDialog == null) {
                    this.mDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                }
                View inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.official_notice_dailog_view, (ViewGroup) null);
                this.mDialog.setContentViewSize(0);
                this.mDialog.setContentView(inflate);
                this.mDialog.create(this.mPageContext);
                this.hLn = (TextView) inflate.findViewById(a.f.content);
                this.hLm = (TextView) inflate.findViewById(a.f.confirm);
                this.hLm.setOnClickListener(this.mOnClickListener);
                SpannableString spannableString = new SpannableString(officialNoticeData.subCopyTagContent);
                if (!TextUtils.isEmpty(officialNoticeData.copyContent)) {
                    spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.yuyinala.liveroom.m.a.4
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            a.this.copyToClipboard(officialNoticeData.copyContent);
                            BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), "已复制到剪贴板");
                            if (view instanceof TextView) {
                                ((TextView) view).setHighlightColor(a.this.mPageContext.getResources().getColor(17170445));
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(textPaint.linkColor);
                            textPaint.setUnderlineText(false);
                        }
                    }, officialNoticeData.startCopy, officialNoticeData.endCopy - 2, 17);
                    spannableString.setSpan(new ForegroundColorSpan(this.mPageContext.getResources().getColor(a.c.sdk_color_4B78B2)), officialNoticeData.startCopy, officialNoticeData.endCopy - 2, 33);
                    this.hLn.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.hLn.setText(spannableString);
                this.mDialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyToClipboard(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.live.gift.ag
    public void onResume() {
        this.isForeground = true;
    }

    @Override // com.baidu.live.gift.ag
    public void onPause() {
        this.isForeground = false;
    }

    @Override // com.baidu.live.gift.ag
    public void onDestroy() {
        this.bav = false;
        if (this.hLk != null) {
            this.hLk.clearAnimation();
        }
        this.hLf.clear();
        this.mHandler.removeCallbacks(this.hfw);
    }

    @Override // com.baidu.live.gift.ag
    public void bB(boolean z) {
        this.hsA = z;
    }

    @Override // com.baidu.live.gift.ag
    public void bC(boolean z) {
        this.hLo = z;
    }

    @Override // com.baidu.live.gift.ag
    public View Ie() {
        return this.hLj;
    }

    public boolean cx(View view) {
        return ShowUtil.windowCount > 0 || this.hsA || !this.hLo || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.hfw);
        this.mHandler.postDelayed(this.hfw, 1000L);
    }
}
