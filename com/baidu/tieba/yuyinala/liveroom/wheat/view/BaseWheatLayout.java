package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tieba.view.AlaEmoticonView;
import com.baidu.live.view.SafeFrameLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BaseWheatLayout extends SafeFrameLayout {
    public View dlk;
    public TbPageContext mTbPageContext;
    public List<AlaWheatInfoData> oxh;
    public List<AlaWheatInfoData> oxi;
    public a oye;
    public List<WheatItemView> oyf;
    public List<WheatItemView> oyg;
    private AlaWheatInfoData oyh;
    public int oyi;
    public int oyj;

    /* loaded from: classes4.dex */
    public interface a {
        void a(AlaWheatInfoData alaWheatInfoData, boolean z, int i);
    }

    public BaseWheatLayout(@NonNull Context context) {
        this(context, null);
    }

    public BaseWheatLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseWheatLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.oyi = e.c(90.0f, getContext());
        this.oyj = e.c(98.0f, getContext());
        this.oyf = new ArrayList();
        this.oyg = new ArrayList();
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public AlaWheatInfoData ao(int i, boolean z) {
        AlaWheatInfoData alaWheatInfoData = null;
        if (z) {
            if (!ListUtils.isEmpty(this.oxh) && i >= 0 && i < this.oxh.size() && (alaWheatInfoData = this.oxh.get(i)) != null) {
                alaWheatInfoData.isHost = true;
            }
        } else if (!ListUtils.isEmpty(this.oxi) && i >= 0 && i < this.oxi.size() && (alaWheatInfoData = this.oxi.get(i)) != null) {
            alaWheatInfoData.isHost = false;
        }
        return alaWheatInfoData;
    }

    public void setOnItemClickListener(a aVar) {
        this.oye = aVar;
    }

    public void WY(String str) {
        View Xb = Xb(str);
        if (Xb != null) {
            AlaWheatInfoData jw = jw(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) Xb.findViewById(a.f.speeding_lottieAnimationView);
            if (jw == null || !jw.isOpenMike()) {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
            } else if (lottieAnimationView.getTag() == null || !(lottieAnimationView.getTag() instanceof String) || !TextUtils.equals(str, (String) lottieAnimationView.getTag()) || lottieAnimationView.getVisibility() != 0 || !lottieAnimationView.isAnimating()) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setRepeatCount(MessageConfig.BASE_SEGMENT_LENGTH);
                lottieAnimationView.setAnimation(jw.isFemale() ? "connecting_wheat_female.json" : "connecting_wheat_male.json");
                lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout.1
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

    public void WZ(String str) {
        LottieAnimationView lottieAnimationView;
        View Xb = Xb(str);
        if (Xb != null && (lottieAnimationView = (LottieAnimationView) Xb.findViewById(a.f.speeding_lottieAnimationView)) != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void aP(String str, String str2, String str3) {
        AlaEmoticonView alaEmoticonView;
        View Xb = Xb(str);
        if (Xb != null && (alaEmoticonView = (AlaEmoticonView) Xb.findViewById(a.f.ala_emoticon_view)) != null) {
            alaEmoticonView.stopLoad();
            alaEmoticonView.aQ(str2, str3);
            alaEmoticonView.setVisibility(0);
            alaEmoticonView.setTag(str3);
        }
    }

    private synchronized View Xb(String str) {
        View view;
        View view2 = null;
        synchronized (this) {
            this.oyh = null;
            int i = 0;
            while (true) {
                if (i >= ListUtils.getCount(this.oxh)) {
                    break;
                }
                this.oyh = this.oxh.get(i);
                if (str == null || this.oyh == null || !str.equals(this.oyh.uk)) {
                    i++;
                } else {
                    view2 = (View) ListUtils.getItem(this.oyf, i);
                    break;
                }
            }
            if (view2 == null) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.oxi); i2++) {
                    this.oyh = this.oxi.get(i2);
                    if (str != null && this.oyh != null && str.equals(this.oyh.uk)) {
                        view = (View) ListUtils.getItem(this.oyg, i2);
                        break;
                    }
                }
            }
            view = view2;
        }
        return view;
    }

    public synchronized View Xc(String str) {
        View Xb;
        Xb = Xb(str);
        return Xb != null ? Xb.findViewById(a.f.user_avatar) : null;
    }

    public AlaWheatInfoData jw(String str) {
        View Xc = Xc(str);
        if (Xc != null) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) this.oyh.clone();
            int[] iArr = new int[2];
            Xc.getLocationOnScreen(iArr);
            alaWheatInfoData.locationCenterX = iArr[0] + (Xc.getWidth() / 2);
            alaWheatInfoData.locationCenterY = (Xc.getHeight() / 2) + iArr[1];
            return alaWheatInfoData;
        }
        return null;
    }

    public void setMaskBg(boolean z) {
        if (this.dlk != null) {
            this.dlk.setClickable(z);
            this.dlk.setFocusable(z);
            this.dlk.setVisibility(z ? 0 : 8);
        }
    }

    public void ega() {
        int[] screenFullSize;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.c(360.0f, getContext())) {
            this.oyi = screenFullSize[0] / 4;
        }
    }

    public boolean egb() {
        int[] screenFullSize;
        return this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.c(360.0f, getContext());
    }
}
