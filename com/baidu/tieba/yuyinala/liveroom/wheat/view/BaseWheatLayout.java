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
    public List<AlaWheatInfoData> oJf;
    public List<AlaWheatInfoData> oJg;
    public a oKi;
    public List<BaseWheatItemView> oKj;
    public List<BaseWheatItemView> oKk;
    private AlaWheatInfoData oKl;
    public int oKm;
    public int oKn;
    public RelativeLayout oKo;

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
        this.oKo = (RelativeLayout) this.mView.findViewById(a.f.wheat_view_container);
        this.dnE = this.mView.findViewById(a.f.mask);
    }

    private void init() {
        if (UtilHelper.getStatusBarHeight() > 0) {
            this.Yh = UtilHelper.getStatusBarHeight() + e.d(74.0f, getContext());
        }
        this.oKm = e.d(90.0f, getContext());
        this.oKn = e.d(98.0f, getContext());
        this.oKj = new ArrayList();
        this.oKk = new ArrayList();
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public AlaWheatInfoData am(int i, boolean z) {
        AlaWheatInfoData alaWheatInfoData = null;
        if (z) {
            if (!ListUtils.isEmpty(this.oJf) && i >= 0 && i < this.oJf.size() && (alaWheatInfoData = this.oJf.get(i)) != null) {
                alaWheatInfoData.isHost = true;
            }
        } else if (!ListUtils.isEmpty(this.oJg) && i >= 0 && i < this.oJg.size() && (alaWheatInfoData = this.oJg.get(i)) != null) {
            alaWheatInfoData.isHost = false;
        }
        return alaWheatInfoData;
    }

    public void setOnItemClickListener(a aVar) {
        this.oKi = aVar;
    }

    public void WA(String str) {
        View WD = WD(str);
        if (WD != null) {
            AlaWheatInfoData iK = iK(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) WD.findViewById(a.f.speeding_lottieAnimationView);
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

    public void WB(String str) {
        LottieAnimationView lottieAnimationView;
        View WD = WD(str);
        if (WD != null && (lottieAnimationView = (LottieAnimationView) WD.findViewById(a.f.speeding_lottieAnimationView)) != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void aT(String str, String str2, String str3) {
        AlaEmoticonView alaEmoticonView;
        View WD = WD(str);
        if (WD != null && (alaEmoticonView = (AlaEmoticonView) WD.findViewById(a.f.ala_emoticon_view)) != null) {
            alaEmoticonView.stopLoad();
            alaEmoticonView.aK(str2, str3);
            alaEmoticonView.setVisibility(0);
            alaEmoticonView.setTag(str3);
        }
    }

    private synchronized View WD(String str) {
        View view;
        View view2 = null;
        synchronized (this) {
            this.oKl = null;
            int i = 0;
            while (true) {
                if (i >= ListUtils.getCount(this.oJf)) {
                    break;
                }
                this.oKl = this.oJf.get(i);
                if (str == null || this.oKl == null || !str.equals(this.oKl.uk)) {
                    i++;
                } else {
                    view2 = (View) ListUtils.getItem(this.oKj, i);
                    break;
                }
            }
            if (view2 == null) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.oJg); i2++) {
                    this.oKl = this.oJg.get(i2);
                    if (str != null && this.oKl != null && str.equals(this.oKl.uk)) {
                        view = (View) ListUtils.getItem(this.oKk, i2);
                        break;
                    }
                }
            }
            view = view2;
        }
        return view;
    }

    public synchronized View WE(String str) {
        View WD;
        WD = WD(str);
        return WD != null ? WD.findViewById(a.f.user_avatar) : null;
    }

    public AlaWheatInfoData iK(String str) {
        View WE = WE(str);
        if (WE != null) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) this.oKl.clone();
            int[] iArr = new int[2];
            WE.getLocationOnScreen(iArr);
            alaWheatInfoData.locationCenterX = iArr[0] + (WE.getWidth() / 2);
            alaWheatInfoData.locationCenterY = (WE.getHeight() / 2) + iArr[1];
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

    public void eeL() {
        int[] screenFullSize;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.d(360.0f, getContext())) {
            this.oKm = screenFullSize[0] / 4;
        }
    }

    public boolean eeM() {
        int[] screenFullSize;
        return this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.d(360.0f, getContext());
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, ab abVar) {
        eeO();
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3, ab abVar) {
        eeO();
    }

    public int getWheatHeight() {
        return 0;
    }

    public boolean eeN() {
        if (this.mTbPageContext == null) {
            return false;
        }
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        return this.oKo != null && screenFullSize != null && screenFullSize[0] > 0 && this.oKo.getMeasuredWidth() > 0 && this.oKo.getMeasuredWidth() > screenFullSize[0] + 200;
    }

    private void eeO() {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (this.oKo != null && eeN() && screenFullSize != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oKo.getLayoutParams();
            layoutParams.width = screenFullSize[0];
            layoutParams.height = screenFullSize[1];
            this.oKo.setLayoutParams(layoutParams);
        }
    }
}
