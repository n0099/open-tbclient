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
    public View dfT;
    public TbPageContext mTbPageContext;
    public List<AlaWheatInfoData> ogC;
    public List<AlaWheatInfoData> ogD;
    public List<WheatItemView> ohA;
    private AlaWheatInfoData ohB;
    public int ohC;
    public int ohD;
    public a ohy;
    public List<WheatItemView> ohz;

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
        this.ohC = e.c(90.0f, getContext());
        this.ohD = e.c(98.0f, getContext());
        this.ohz = new ArrayList();
        this.ohA = new ArrayList();
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public AlaWheatInfoData ao(int i, boolean z) {
        AlaWheatInfoData alaWheatInfoData = null;
        if (z) {
            if (!ListUtils.isEmpty(this.ogC) && i >= 0 && i < this.ogC.size() && (alaWheatInfoData = this.ogC.get(i)) != null) {
                alaWheatInfoData.isHost = true;
            }
        } else if (!ListUtils.isEmpty(this.ogD) && i >= 0 && i < this.ogD.size() && (alaWheatInfoData = this.ogD.get(i)) != null) {
            alaWheatInfoData.isHost = false;
        }
        return alaWheatInfoData;
    }

    public void setOnItemClickListener(a aVar) {
        this.ohy = aVar;
    }

    public void VY(String str) {
        View Wb = Wb(str);
        if (Wb != null) {
            AlaWheatInfoData iY = iY(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) Wb.findViewById(a.f.speeding_lottieAnimationView);
            if (iY == null || !iY.isOpenMike()) {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
            } else if (lottieAnimationView.getTag() == null || !(lottieAnimationView.getTag() instanceof String) || !TextUtils.equals(str, (String) lottieAnimationView.getTag()) || lottieAnimationView.getVisibility() != 0 || !lottieAnimationView.isAnimating()) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setRepeatCount(MessageConfig.BASE_SEGMENT_LENGTH);
                lottieAnimationView.setAnimation(iY.isFemale() ? "connecting_wheat_female.json" : "connecting_wheat_male.json");
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

    public void VZ(String str) {
        LottieAnimationView lottieAnimationView;
        View Wb = Wb(str);
        if (Wb != null && (lottieAnimationView = (LottieAnimationView) Wb.findViewById(a.f.speeding_lottieAnimationView)) != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void aM(String str, String str2, String str3) {
        AlaEmoticonView alaEmoticonView;
        View Wb = Wb(str);
        if (Wb != null && (alaEmoticonView = (AlaEmoticonView) Wb.findViewById(a.f.ala_emoticon_view)) != null) {
            alaEmoticonView.stopLoad();
            alaEmoticonView.aN(str2, str3);
            alaEmoticonView.setVisibility(0);
            alaEmoticonView.setTag(str3);
        }
    }

    private synchronized View Wb(String str) {
        View view;
        View view2 = null;
        synchronized (this) {
            this.ohB = null;
            int i = 0;
            while (true) {
                if (i >= ListUtils.getCount(this.ogC)) {
                    break;
                }
                this.ohB = this.ogC.get(i);
                if (str == null || this.ohB == null || !str.equals(this.ohB.uk)) {
                    i++;
                } else {
                    view2 = (View) ListUtils.getItem(this.ohz, i);
                    break;
                }
            }
            if (view2 == null) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.ogD); i2++) {
                    this.ohB = this.ogD.get(i2);
                    if (str != null && this.ohB != null && str.equals(this.ohB.uk)) {
                        view = (View) ListUtils.getItem(this.ohA, i2);
                        break;
                    }
                }
            }
            view = view2;
        }
        return view;
    }

    public synchronized View Wc(String str) {
        View Wb;
        Wb = Wb(str);
        return Wb != null ? Wb.findViewById(a.f.user_avatar) : null;
    }

    public AlaWheatInfoData iY(String str) {
        View Wc = Wc(str);
        if (Wc != null) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) this.ohB.clone();
            int[] iArr = new int[2];
            Wc.getLocationOnScreen(iArr);
            alaWheatInfoData.locationCenterX = iArr[0] + (Wc.getWidth() / 2);
            alaWheatInfoData.locationCenterY = (Wc.getHeight() / 2) + iArr[1];
            return alaWheatInfoData;
        }
        return null;
    }

    public void setMaskBg(boolean z) {
        if (this.dfT != null) {
            this.dfT.setClickable(z);
            this.dfT.setFocusable(z);
            this.dfT.setVisibility(z ? 0 : 8);
        }
    }

    public void eav() {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (screenFullSize != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.c(360.0f, getContext())) {
            this.ohC = screenFullSize[0] / 4;
        }
    }

    public boolean eaw() {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        return screenFullSize != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.c(360.0f, getContext());
    }
}
