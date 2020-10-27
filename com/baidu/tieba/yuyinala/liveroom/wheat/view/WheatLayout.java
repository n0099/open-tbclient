package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tieba.view.AlaEmoticonView;
import com.baidu.live.view.SafeFrameLayout;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class WheatLayout extends SafeFrameLayout {
    private View cZW;
    private View mView;
    private List<AlaWheatInfoData> nXa;
    private List<AlaWheatInfoData> nXb;
    private LinearLayout nZs;
    private LinearLayout nZt;
    private LinearLayout nZu;
    private List<RelativeLayout> nZv;
    private List<RelativeLayout> nZw;
    private a nZx;
    private AlaWheatInfoData nZy;

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i);
    }

    public WheatLayout(@NonNull Context context) {
        this(context, null);
    }

    public WheatLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheatLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.yuyinala_liveroom_wheat_layout, this);
        this.nZs = (LinearLayout) this.mView.findViewById(a.g.ll_host_wheat);
        this.nZt = (LinearLayout) this.mView.findViewById(a.g.ll_common_wheat_1);
        this.nZu = (LinearLayout) this.mView.findViewById(a.g.ll_common_wheat_2);
        this.cZW = this.mView.findViewById(a.g.mask);
        this.nZv = new ArrayList();
        this.nZw = new ArrayList();
    }

    public synchronized void E(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2) {
        int vs;
        synchronized (this) {
            this.nXa = list;
            this.nXb = list2;
            int size = list2 != null ? list2.size() : 0;
            if (size == 4) {
                vs = vs(180);
            } else {
                vs = size == 6 ? vs(120) : vs(90);
            }
            if (this.nZs.getChildCount() != ListUtils.getCount(list)) {
                this.nZv.clear();
                this.nZs.removeAllViews();
                if (!ListUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        a(this.nZs, list.size() <= 2 ? vs(180) : vs(90), true);
                    }
                }
            }
            if (this.nZt.getChildCount() != ListUtils.getCount(list2) / 2 || this.nZu.getChildCount() != ListUtils.getCount(list2) / 2) {
                this.nZw.clear();
                this.nZt.removeAllViews();
                this.nZu.removeAllViews();
                if (!ListUtils.isEmpty(list2)) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (size == 4) {
                            if (i2 < 2) {
                                a(this.nZt, vs, false);
                            } else {
                                a(this.nZu, vs, false);
                            }
                        } else if (size == 6) {
                            if (i2 < 3) {
                                a(this.nZt, vs, false);
                            } else {
                                a(this.nZu, vs, false);
                            }
                        } else if (size == 8) {
                            if (i2 < 4) {
                                a(this.nZt, vs, false);
                            } else {
                                a(this.nZu, vs, false);
                            }
                        }
                    }
                }
            }
            if (!ListUtils.isEmpty(this.nZv)) {
                for (int i3 = 0; i3 < this.nZv.size(); i3++) {
                    addView((View) this.nZv.get(i3), i3, true);
                }
            }
            if (!ListUtils.isEmpty(this.nZw)) {
                for (int i4 = 0; i4 < this.nZw.size(); i4++) {
                    addView((View) this.nZw.get(i4), i4, false);
                }
            }
        }
    }

    private void addView(View view, int i, final boolean z) {
        HeadImageView headImageView = (HeadImageView) view.findViewById(a.g.user_avatar);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a.g.user_avatar_container);
        final AlaEmoticonView alaEmoticonView = (AlaEmoticonView) view.findViewById(a.g.ala_emoticon_view);
        TextView textView = (TextView) view.findViewById(a.g.anchor_name);
        ImageView imageView = (ImageView) view.findViewById(a.g.iv_user_gender);
        TextView textView2 = (TextView) view.findViewById(a.g.tv_charm_value);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(a.g.anchor_name_container);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(a.g.user_label);
        TextView textView3 = (TextView) view.findViewById(a.g.tv_host_label);
        TextView textView4 = (TextView) view.findViewById(a.g.tv_anchor_label);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(a.g.charm_container);
        ImageView imageView2 = (ImageView) view.findViewById(a.g.iv_mute);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(a.g.speeding_lottieAnimationView);
        AlaWheatInfoData ap = ap(i, z);
        textView.setText("");
        textView2.setText("");
        if (ap == null) {
            relativeLayout3.setVisibility(8);
            if (lottieAnimationView.getVisibility() == 0) {
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setVisibility(8);
            }
            imageView.setSelected(false);
            imageView.setVisibility(8);
            headImageView.setIsRound(false);
            headImageView.setDrawBorder(false);
            headImageView.setAutoChangeStyle(false);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            headImageView.setImageResource(a.f.yuyin_sdk_wheat_empty_wheat);
            headImageView.setBackgroundResource(a.f.yuyin_sdk_connection_wheat_empty);
            if (z) {
                textView.setText(getContext().getResources().getString(a.i.yuyin_ala_connection_wheat_host_wheat_text));
            } else {
                textView.setText((i + 1) + getContext().getResources().getString(a.i.yuyin_ala_connection_wheat_num_text));
            }
            textView.setTextColor(getContext().getResources().getColor(a.d.sdk_white_alpha70));
            linearLayout.setVisibility(8);
            relativeLayout.setTag(Integer.valueOf(i));
            imageView2.setVisibility(8);
        } else {
            relativeLayout3.setVisibility(0);
            textView.setTextColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
            imageView.setVisibility(0);
            imageView.setSelected(ap.isFemale());
            headImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            headImageView.setImageResource(0);
            headImageView.setBackgroundResource(0);
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(false);
            headImageView.setAutoChangeStyle(false);
            headImageView.setDefaultResource(a.f.yuyin_sdk_wheat_empty_wheat);
            headImageView.setDefaultBgResource(a.f.yuyin_sdk_connection_wheat_empty);
            headImageView.setUrl(ap.portrait);
            headImageView.startLoad(ap.portrait, 12, false, false);
            if (ap.isOpenMike()) {
                imageView2.setVisibility(8);
            } else {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
                imageView2.setVisibility(0);
                imageView2.setImageResource(ap.isFemale() ? a.f.yuyin_sdk_wheat_mute_female : a.f.yuyin_sdk_wheat_mute_male);
            }
            linearLayout.setVisibility(0);
            textView2.setText(ap.charmCount);
            if (z) {
                textView3.setVisibility(0);
                textView4.setVisibility(8);
                textView.setText(ap.userName);
            } else {
                textView3.setVisibility(8);
                textView4.setVisibility(0);
                textView4.setText(Integer.toString(i + 1));
                textView.setText(ap.userName);
            }
            relativeLayout.setTag(Integer.valueOf(i));
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int intValue = ((Integer) view2.getTag()).intValue();
                if (WheatLayout.this.nZx != null) {
                    WheatLayout.this.nZx.a(WheatLayout.this.ap(intValue, z), z, intValue);
                }
            }
        });
        alaEmoticonView.setEmoticonListener(new AlaEmoticonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatLayout.2
            @Override // com.baidu.live.tieba.view.AlaEmoticonView.a
            public void QN() {
                int i2;
                if (!(alaEmoticonView.getTag() instanceof String) || StringUtils.isNull((String) alaEmoticonView.getTag(), true)) {
                    i2 = 0;
                } else {
                    i2 = 1000;
                }
                alaEmoticonView.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatLayout.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        alaEmoticonView.setVisibility(8);
                        alaEmoticonView.setTag(null);
                    }
                }, i2);
            }
        });
        view.requestLayout();
        view.postInvalidate();
    }

    private void a(LinearLayout linearLayout, int i, boolean z) {
        View inflate = LayoutInflater.from(getContext()).inflate(a.h.yuyinala_liveroom_wheat_item_layout, (ViewGroup) null, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(i, -1));
        linearLayout.addView(inflate);
        if (z) {
            this.nZv.add((RelativeLayout) inflate);
        } else {
            this.nZw.add((RelativeLayout) inflate);
        }
    }

    protected int vs(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlaWheatInfoData ap(int i, boolean z) {
        AlaWheatInfoData alaWheatInfoData = null;
        if (z) {
            if (!ListUtils.isEmpty(this.nXa) && i >= 0 && i < this.nXa.size() && (alaWheatInfoData = this.nXa.get(i)) != null) {
                alaWheatInfoData.isHost = true;
            }
        } else if (!ListUtils.isEmpty(this.nXb) && i >= 0 && i < this.nXb.size() && (alaWheatInfoData = this.nXb.get(i)) != null) {
            alaWheatInfoData.isHost = false;
        }
        return alaWheatInfoData;
    }

    public void setOnItemClickListener(a aVar) {
        this.nZx = aVar;
    }

    public void Vy(String str) {
        View VA = VA(str);
        if (VA != null) {
            AlaWheatInfoData iL = iL(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) VA.findViewById(a.g.speeding_lottieAnimationView);
            if (iL == null || !iL.isOpenMike()) {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
            } else if (lottieAnimationView.getTag() == null || !(lottieAnimationView.getTag() instanceof String) || !TextUtils.equals(str, (String) lottieAnimationView.getTag()) || lottieAnimationView.getVisibility() != 0 || !lottieAnimationView.isAnimating()) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setRepeatCount(MessageConfig.BASE_SEGMENT_LENGTH);
                lottieAnimationView.setAnimation(iL.isFemale() ? "connecting_wheat_female.json" : "connecting_wheat_male.json");
                lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatLayout.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                lottieAnimationView.playAnimation();
                lottieAnimationView.setTag(str);
            }
        }
    }

    public void Vz(String str) {
        LottieAnimationView lottieAnimationView;
        View VA = VA(str);
        if (VA != null && (lottieAnimationView = (LottieAnimationView) VA.findViewById(a.g.speeding_lottieAnimationView)) != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void aM(String str, String str2, String str3) {
        AlaEmoticonView alaEmoticonView;
        View VA = VA(str);
        if (VA != null && (alaEmoticonView = (AlaEmoticonView) VA.findViewById(a.g.ala_emoticon_view)) != null) {
            alaEmoticonView.stopLoad();
            alaEmoticonView.aM(str2, str3);
            alaEmoticonView.setVisibility(0);
            alaEmoticonView.setTag(str3);
        }
    }

    private synchronized View VA(String str) {
        View view;
        View view2 = null;
        synchronized (this) {
            this.nZy = null;
            int i = 0;
            while (true) {
                if (i >= ListUtils.getCount(this.nXa)) {
                    break;
                }
                this.nZy = this.nXa.get(i);
                if (str == null || this.nZy == null || !str.equals(this.nZy.uk)) {
                    i++;
                } else {
                    view2 = (View) ListUtils.getItem(this.nZv, i);
                    break;
                }
            }
            if (view2 == null) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.nXb); i2++) {
                    this.nZy = this.nXb.get(i2);
                    if (str != null && this.nZy != null && str.equals(this.nZy.uk)) {
                        view = (View) ListUtils.getItem(this.nZw, i2);
                        break;
                    }
                }
            }
            view = view2;
        }
        return view;
    }

    private synchronized View VB(String str) {
        View VA;
        VA = VA(str);
        return VA != null ? VA.findViewById(a.g.user_avatar) : null;
    }

    public AlaWheatInfoData Vu(String str) {
        if (VB(str) != null) {
            return this.nZy;
        }
        return null;
    }

    public AlaWheatInfoData iL(String str) {
        View VB = VB(str);
        if (VB != null) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) this.nZy.clone();
            int[] iArr = new int[2];
            VB.getLocationOnScreen(iArr);
            alaWheatInfoData.locationCenterX = iArr[0] + (VB.getWidth() / 2);
            alaWheatInfoData.locationCenterY = (VB.getHeight() / 2) + iArr[1];
            return alaWheatInfoData;
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        if (statusBarHeight > 0 && this.nZs != null) {
            int dimensionPixelOffset = this.nZs.getResources().getDimensionPixelOffset(a.e.sdk_ds168) + statusBarHeight;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nZs.getLayoutParams();
            if (dimensionPixelOffset != layoutParams.topMargin) {
                layoutParams.topMargin = dimensionPixelOffset;
                this.nZs.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setMaskBg(boolean z) {
        if (this.cZW != null) {
            this.cZW.setClickable(z);
            this.cZW.setFocusable(z);
            this.cZW.setVisibility(z ? 0 : 8);
        }
    }
}
