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
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class BaseWheatLayout extends SafeFrameLayout {
    public int Yl;
    public View dlt;
    public TbPageContext mTbPageContext;
    public View mView;
    public List<WheatItemView> oAA;
    private AlaWheatInfoData oAB;
    public int oAC;
    public int oAD;
    public RelativeLayout oAE;
    public a oAy;
    public List<WheatItemView> oAz;
    public List<AlaWheatInfoData> ozx;
    public List<AlaWheatInfoData> ozy;

    /* loaded from: classes10.dex */
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
        this.Yl = e.d(100.0f, getContext());
        init();
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_container_layout, this);
        this.oAE = (RelativeLayout) this.mView.findViewById(a.f.wheat_view_container);
        this.dlt = this.mView.findViewById(a.f.mask);
    }

    private void init() {
        if (UtilHelper.getStatusBarHeight() > 0) {
            this.Yl = UtilHelper.getStatusBarHeight() + e.d(74.0f, getContext());
        }
        this.oAC = e.d(90.0f, getContext());
        this.oAD = e.d(98.0f, getContext());
        this.oAz = new ArrayList();
        this.oAA = new ArrayList();
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public AlaWheatInfoData am(int i, boolean z) {
        AlaWheatInfoData alaWheatInfoData = null;
        if (z) {
            if (!ListUtils.isEmpty(this.ozx) && i >= 0 && i < this.ozx.size() && (alaWheatInfoData = this.ozx.get(i)) != null) {
                alaWheatInfoData.isHost = true;
            }
        } else if (!ListUtils.isEmpty(this.ozy) && i >= 0 && i < this.ozy.size() && (alaWheatInfoData = this.ozy.get(i)) != null) {
            alaWheatInfoData.isHost = false;
        }
        return alaWheatInfoData;
    }

    public void setOnItemClickListener(a aVar) {
        this.oAy = aVar;
    }

    public void VC(String str) {
        View VF = VF(str);
        if (VF != null) {
            AlaWheatInfoData ie = ie(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) VF.findViewById(a.f.speeding_lottieAnimationView);
            if (ie == null || !ie.isOpenMike()) {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
            } else if (lottieAnimationView.getTag() == null || !(lottieAnimationView.getTag() instanceof String) || !TextUtils.equals(str, (String) lottieAnimationView.getTag()) || lottieAnimationView.getVisibility() != 0 || !lottieAnimationView.isAnimating()) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setRepeatCount(MessageConfig.BASE_SEGMENT_LENGTH);
                lottieAnimationView.setAnimation(ie.isFemale() ? "connecting_wheat_female.json" : "connecting_wheat_male.json");
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

    public void VD(String str) {
        LottieAnimationView lottieAnimationView;
        View VF = VF(str);
        if (VF != null && (lottieAnimationView = (LottieAnimationView) VF.findViewById(a.f.speeding_lottieAnimationView)) != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void aS(String str, String str2, String str3) {
        AlaEmoticonView alaEmoticonView;
        View VF = VF(str);
        if (VF != null && (alaEmoticonView = (AlaEmoticonView) VF.findViewById(a.f.ala_emoticon_view)) != null) {
            alaEmoticonView.stopLoad();
            alaEmoticonView.aK(str2, str3);
            alaEmoticonView.setVisibility(0);
            alaEmoticonView.setTag(str3);
        }
    }

    private synchronized View VF(String str) {
        View view;
        View view2 = null;
        synchronized (this) {
            this.oAB = null;
            int i = 0;
            while (true) {
                if (i >= ListUtils.getCount(this.ozx)) {
                    break;
                }
                this.oAB = this.ozx.get(i);
                if (str == null || this.oAB == null || !str.equals(this.oAB.uk)) {
                    i++;
                } else {
                    view2 = (View) ListUtils.getItem(this.oAz, i);
                    break;
                }
            }
            if (view2 == null) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.ozy); i2++) {
                    this.oAB = this.ozy.get(i2);
                    if (str != null && this.oAB != null && str.equals(this.oAB.uk)) {
                        view = (View) ListUtils.getItem(this.oAA, i2);
                        break;
                    }
                }
            }
            view = view2;
        }
        return view;
    }

    public synchronized View VG(String str) {
        View VF;
        VF = VF(str);
        return VF != null ? VF.findViewById(a.f.user_avatar) : null;
    }

    public AlaWheatInfoData ie(String str) {
        View VG = VG(str);
        if (VG != null) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) this.oAB.clone();
            int[] iArr = new int[2];
            VG.getLocationOnScreen(iArr);
            alaWheatInfoData.locationCenterX = iArr[0] + (VG.getWidth() / 2);
            alaWheatInfoData.locationCenterY = (VG.getHeight() / 2) + iArr[1];
            return alaWheatInfoData;
        }
        return null;
    }

    public void setMaskBg(boolean z) {
        if (this.dlt != null) {
            this.dlt.setClickable(z);
            this.dlt.setFocusable(z);
            this.dlt.setVisibility(z ? 0 : 8);
        }
    }

    public void ecx() {
        int[] screenFullSize;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.d(360.0f, getContext())) {
            this.oAC = screenFullSize[0] / 4;
        }
    }

    public boolean ecy() {
        int[] screenFullSize;
        return this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.d(360.0f, getContext());
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, x xVar) {
        ecA();
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3, x xVar) {
        ecA();
    }

    public int getWheatHeight() {
        return 0;
    }

    public boolean ecz() {
        if (this.mTbPageContext == null) {
            return false;
        }
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        return this.oAE != null && screenFullSize != null && screenFullSize[0] > 0 && this.oAE.getMeasuredWidth() > 0 && this.oAE.getMeasuredWidth() > screenFullSize[0] + 200;
    }

    private void ecA() {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (this.oAE != null && ecz() && screenFullSize != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oAE.getLayoutParams();
            layoutParams.width = screenFullSize[0];
            layoutParams.height = screenFullSize[1];
            this.oAE.setLayoutParams(layoutParams);
        }
    }
}
