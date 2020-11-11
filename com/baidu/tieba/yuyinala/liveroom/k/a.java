package com.baidu.tieba.yuyinala.liveroom.k;

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
import com.baidu.live.gift.ae;
import com.baidu.live.gift.ai;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a implements ae {
    private boolean aXp;
    private AnimatorSet aXy;
    private TranslateAnimation aXz;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData hpV;
    private int hpX;
    private LinearLayout hpY;
    private TextView hpZ;
    private FrameLayout hqa;
    private TextView hqb;
    private TextView hqc;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> hpU = new ArrayList<>();
    private boolean aXo = false;
    private boolean hpW = true;
    private Handler mHandler = new Handler();
    protected boolean gXy = false;
    protected boolean hqd = true;
    private boolean isForeground = true;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.f.confirm) {
                if (a.this.mDialog != null) {
                    a.this.mDialog.dismiss();
                    a.this.mDialog = null;
                }
            } else if (view.getId() == a.f.msg_background) {
                a.this.hqa.setVisibility(4);
                if (a.this.hpV != null) {
                    if (TextUtils.isEmpty(a.this.hpV.url)) {
                        a.this.d(a.this.hpV);
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913172, a.this.hpV.url));
                    }
                }
            }
        }
    };
    private final Runnable gKO = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.ce(a.this.hpY)) {
                a.this.mHandler.removeCallbacks(a.this.gKO);
                a.this.HL();
                return;
            }
            a.this.startCountDown();
        }
    };

    public a(ai aiVar) {
        if (aiVar != null && aiVar.pageContext != null) {
            this.mPageContext = aiVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.aXp = aiVar.aUa;
            this.hpY = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.official_notice_container, (ViewGroup) null);
            this.hqa = (FrameLayout) this.hpY.findViewById(a.f.msg_background);
            this.hqa.setOnClickListener(this.mOnClickListener);
            this.hqa.setVisibility(4);
            this.hpZ = (TextView) this.hpY.findViewById(a.f.msg_content);
            this.hpZ.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.hpZ.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpZ.getLayoutParams();
                layoutParams.width = i;
                this.hpZ.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.hpZ.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            this.hpX = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            HK();
        }
    }

    private void HK() {
        this.aXy = new AnimatorSet();
        this.aXy.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hpY, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hpY, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hpY, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat3.setDuration(9000L);
        ofFloat3.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.1
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
        this.aXy.playTogether(this.mAnimators);
        this.aXy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aXo = true;
                a.this.hqa.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.HM();
                a.this.HL();
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
    public void HL() {
        if (!this.aXo && !ListUtils.isEmpty(this.hpU)) {
            if (ce(this.hpY)) {
                startCountDown();
                return;
            }
            this.hpV = (OfficialNoticeData) ListUtils.getItem(this.hpU, 0);
            ListUtils.remove(this.hpU, 0);
            b(this.hpV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        this.aXo = false;
        this.hpZ.clearAnimation();
        this.hpY.clearAnimation();
        this.hqa.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.hpU.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.hpU.add(officialNoticeData);
            HL();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a2 = a(officialNoticeData, this.aXp);
            if (a2 != null && a2.length() <= 0) {
                HM();
                HL();
                return;
            }
            this.hpZ.setText(a2);
            if (a2 != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a2.toString());
                float f = -(((textWidth - this.hpX) * 1.0f) / this.hpX);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpZ.getLayoutParams();
                if (textWidth - this.hpX < 0) {
                    layoutParams.width = -2;
                    this.hpZ.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.hpZ.setLayoutParams(layoutParams);
                    this.aXz = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aXz.setStartOffset(4000L);
                    this.aXz.setDuration(1000L);
                    this.aXz.setFillAfter(true);
                    this.hpZ.startAnimation(this.aXz);
                }
            }
            this.aXy.start();
            c(officialNoticeData);
            this.hqa.setTag(officialNoticeData);
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
                this.hqc = (TextView) inflate.findViewById(a.f.content);
                this.hqb = (TextView) inflate.findViewById(a.f.confirm);
                this.hqb.setOnClickListener(this.mOnClickListener);
                SpannableString spannableString = new SpannableString(officialNoticeData.subCopyTagContent);
                if (!TextUtils.isEmpty(officialNoticeData.copyContent)) {
                    spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.yuyinala.liveroom.k.a.4
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
                    this.hqc.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.hqc.setText(spannableString);
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

    @Override // com.baidu.live.gift.ae
    public void onResume() {
        this.isForeground = true;
    }

    @Override // com.baidu.live.gift.ae
    public void onPause() {
        this.isForeground = false;
    }

    @Override // com.baidu.live.gift.ae
    public void onDestroy() {
        this.aXo = false;
        if (this.hpZ != null) {
            this.hpZ.clearAnimation();
        }
        this.hpU.clear();
        this.mHandler.removeCallbacks(this.gKO);
    }

    @Override // com.baidu.live.gift.ae
    public void bs(boolean z) {
        this.gXy = z;
    }

    @Override // com.baidu.live.gift.ae
    public void bt(boolean z) {
        this.hqd = z;
    }

    @Override // com.baidu.live.gift.ae
    public View Hu() {
        return this.hpY;
    }

    public boolean ce(View view) {
        return ShowUtil.windowCount > 0 || this.gXy || !this.hqd || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gKO);
        this.mHandler.postDelayed(this.gKO, 1000L);
    }
}
