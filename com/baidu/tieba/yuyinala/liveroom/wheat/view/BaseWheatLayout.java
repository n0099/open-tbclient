package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tieba.view.AlaEmoticonView;
import com.baidu.live.view.SafeFrameLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class BaseWheatLayout extends SafeFrameLayout {
    public int Yh;
    public View dnE;
    public TbPageContext mTbPageContext;
    public View mView;
    public List<AlaWheatInfoData> oJF;
    public List<AlaWheatInfoData> oJG;
    public a oKI;
    public List<BaseWheatItemView> oKJ;
    public List<BaseWheatItemView> oKK;
    private AlaWheatInfoData oKL;
    public int oKM;
    public int oKN;
    public RelativeLayout oKO;

    /* loaded from: classes11.dex */
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
        this.Yh = e.d(100.0f, getContext());
        init();
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_container_layout, this);
        this.oKO = (RelativeLayout) this.mView.findViewById(a.f.wheat_view_container);
        this.dnE = this.mView.findViewById(a.f.mask);
    }

    private void init() {
        if (UtilHelper.getStatusBarHeight() > 0) {
            this.Yh = UtilHelper.getStatusBarHeight() + e.d(74.0f, getContext());
        }
        this.oKM = e.d(90.0f, getContext());
        this.oKN = e.d(98.0f, getContext());
        this.oKJ = new ArrayList();
        this.oKK = new ArrayList();
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public AlaWheatInfoData am(int i, boolean z) {
        AlaWheatInfoData alaWheatInfoData = null;
        if (z) {
            if (!ListUtils.isEmpty(this.oJF) && i >= 0 && i < this.oJF.size() && (alaWheatInfoData = this.oJF.get(i)) != null) {
                alaWheatInfoData.isHost = true;
            }
        } else if (!ListUtils.isEmpty(this.oJG) && i >= 0 && i < this.oJG.size() && (alaWheatInfoData = this.oJG.get(i)) != null) {
            alaWheatInfoData.isHost = false;
        }
        return alaWheatInfoData;
    }

    public void setOnItemClickListener(a aVar) {
        this.oKI = aVar;
    }

    public void WM(String str) {
        View WP = WP(str);
        if (WP != null) {
            AlaWheatInfoData iK = iK(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) WP.findViewById(a.f.speeding_lottieAnimationView);
            if (iK == null || !iK.isOpenMike()) {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
            } else if (lottieAnimationView.getTag() == null || !(lottieAnimationView.getTag() instanceof String) || !TextUtils.equals(str, (String) lottieAnimationView.getTag()) || lottieAnimationView.getVisibility() != 0 || !lottieAnimationView.isAnimating()) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setRepeatCount(MessageConfig.BASE_SEGMENT_LENGTH);
                lottieAnimationView.setAnimation(iK.isFemale() ? "connecting_wheat_female.json" : "connecting_wheat_male.json");
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

    public void WN(String str) {
        LottieAnimationView lottieAnimationView;
        View WP = WP(str);
        if (WP != null && (lottieAnimationView = (LottieAnimationView) WP.findViewById(a.f.speeding_lottieAnimationView)) != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void aT(String str, String str2, String str3) {
        AlaEmoticonView alaEmoticonView;
        View WP = WP(str);
        if (WP != null && (alaEmoticonView = (AlaEmoticonView) WP.findViewById(a.f.ala_emoticon_view)) != null) {
            alaEmoticonView.stopLoad();
            alaEmoticonView.aK(str2, str3);
            alaEmoticonView.setVisibility(0);
            alaEmoticonView.setTag(str3);
        }
    }

    private synchronized View WP(String str) {
        View view;
        View view2 = null;
        synchronized (this) {
            this.oKL = null;
            int i = 0;
            while (true) {
                if (i >= ListUtils.getCount(this.oJF)) {
                    break;
                }
                this.oKL = this.oJF.get(i);
                if (str == null || this.oKL == null || !str.equals(this.oKL.uk)) {
                    i++;
                } else {
                    view2 = (View) ListUtils.getItem(this.oKJ, i);
                    break;
                }
            }
            if (view2 == null) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.oJG); i2++) {
                    this.oKL = this.oJG.get(i2);
                    if (str != null && this.oKL != null && str.equals(this.oKL.uk)) {
                        view = (View) ListUtils.getItem(this.oKK, i2);
                        break;
                    }
                }
            }
            view = view2;
        }
        return view;
    }

    public synchronized View WQ(String str) {
        View WP;
        WP = WP(str);
        return WP != null ? WP.findViewById(a.f.user_avatar) : null;
    }

    public AlaWheatInfoData iK(String str) {
        View WQ = WQ(str);
        if (WQ != null) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) this.oKL.clone();
            int[] iArr = new int[2];
            WQ.getLocationOnScreen(iArr);
            alaWheatInfoData.locationCenterX = iArr[0] + (WQ.getWidth() / 2);
            alaWheatInfoData.locationCenterY = (WQ.getHeight() / 2) + iArr[1];
            return alaWheatInfoData;
        }
        return null;
    }

    public void setMaskBg(boolean z) {
        if (this.dnE != null) {
            this.dnE.setClickable(z);
            this.dnE.setFocusable(z);
            this.dnE.setVisibility(z ? 0 : 8);
        }
    }

    public void eeT() {
        int[] screenFullSize;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.d(360.0f, getContext())) {
            this.oKM = screenFullSize[0] / 4;
        }
    }

    public boolean eeU() {
        int[] screenFullSize;
        return this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.d(360.0f, getContext());
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, ab abVar) {
        eeW();
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3, ab abVar) {
        eeW();
    }

    public int getWheatHeight() {
        return 0;
    }

    public boolean eeV() {
        if (this.mTbPageContext == null) {
            return false;
        }
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        return this.oKO != null && screenFullSize != null && screenFullSize[0] > 0 && this.oKO.getMeasuredWidth() > 0 && this.oKO.getMeasuredWidth() > screenFullSize[0] + 200;
    }

    private void eeW() {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (this.oKO != null && eeV() && screenFullSize != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oKO.getLayoutParams();
            layoutParams.width = screenFullSize[0];
            layoutParams.height = screenFullSize[1];
            this.oKO.setLayoutParams(layoutParams);
        }
    }
}
