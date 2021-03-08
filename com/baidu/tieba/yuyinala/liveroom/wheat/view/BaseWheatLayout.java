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
/* loaded from: classes10.dex */
public class BaseWheatLayout extends SafeFrameLayout {
    public int ZA;
    public View dph;
    public TbPageContext mTbPageContext;
    public View mView;
    public List<AlaWheatInfoData> oLK;
    public List<AlaWheatInfoData> oLL;
    public a oMN;
    public List<BaseWheatItemView> oMO;
    public List<BaseWheatItemView> oMP;
    private AlaWheatInfoData oMQ;
    public int oMR;
    public int oMS;
    public RelativeLayout oMT;

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
        this.ZA = e.d(100.0f, getContext());
        init();
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_container_layout, this);
        this.oMT = (RelativeLayout) this.mView.findViewById(a.f.wheat_view_container);
        this.dph = this.mView.findViewById(a.f.mask);
    }

    private void init() {
        if (UtilHelper.getStatusBarHeight() > 0) {
            this.ZA = UtilHelper.getStatusBarHeight() + e.d(74.0f, getContext());
        }
        this.oMR = e.d(90.0f, getContext());
        this.oMS = e.d(98.0f, getContext());
        this.oMO = new ArrayList();
        this.oMP = new ArrayList();
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public AlaWheatInfoData am(int i, boolean z) {
        AlaWheatInfoData alaWheatInfoData = null;
        if (z) {
            if (!ListUtils.isEmpty(this.oLK) && i >= 0 && i < this.oLK.size() && (alaWheatInfoData = this.oLK.get(i)) != null) {
                alaWheatInfoData.isHost = true;
            }
        } else if (!ListUtils.isEmpty(this.oLL) && i >= 0 && i < this.oLL.size() && (alaWheatInfoData = this.oLL.get(i)) != null) {
            alaWheatInfoData.isHost = false;
        }
        return alaWheatInfoData;
    }

    public void setOnItemClickListener(a aVar) {
        this.oMN = aVar;
    }

    public void WT(String str) {
        View WW = WW(str);
        if (WW != null) {
            AlaWheatInfoData iQ = iQ(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) WW.findViewById(a.f.speeding_lottieAnimationView);
            if (iQ == null || !iQ.isOpenMike()) {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
            } else if (lottieAnimationView.getTag() == null || !(lottieAnimationView.getTag() instanceof String) || !TextUtils.equals(str, (String) lottieAnimationView.getTag()) || lottieAnimationView.getVisibility() != 0 || !lottieAnimationView.isAnimating()) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setRepeatCount(MessageConfig.BASE_SEGMENT_LENGTH);
                lottieAnimationView.setAnimation(iQ.isFemale() ? "connecting_wheat_female.json" : "connecting_wheat_male.json");
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

    public void WU(String str) {
        LottieAnimationView lottieAnimationView;
        View WW = WW(str);
        if (WW != null && (lottieAnimationView = (LottieAnimationView) WW.findViewById(a.f.speeding_lottieAnimationView)) != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void aT(String str, String str2, String str3) {
        AlaEmoticonView alaEmoticonView;
        View WW = WW(str);
        if (WW != null && (alaEmoticonView = (AlaEmoticonView) WW.findViewById(a.f.ala_emoticon_view)) != null) {
            alaEmoticonView.stopLoad();
            alaEmoticonView.aK(str2, str3);
            alaEmoticonView.setVisibility(0);
            alaEmoticonView.setTag(str3);
        }
    }

    private synchronized View WW(String str) {
        View view;
        View view2 = null;
        synchronized (this) {
            this.oMQ = null;
            int i = 0;
            while (true) {
                if (i >= ListUtils.getCount(this.oLK)) {
                    break;
                }
                this.oMQ = this.oLK.get(i);
                if (str == null || this.oMQ == null || !str.equals(this.oMQ.uk)) {
                    i++;
                } else {
                    view2 = (View) ListUtils.getItem(this.oMO, i);
                    break;
                }
            }
            if (view2 == null) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.oLL); i2++) {
                    this.oMQ = this.oLL.get(i2);
                    if (str != null && this.oMQ != null && str.equals(this.oMQ.uk)) {
                        view = (View) ListUtils.getItem(this.oMP, i2);
                        break;
                    }
                }
            }
            view = view2;
        }
        return view;
    }

    public synchronized View WX(String str) {
        View WW;
        WW = WW(str);
        return WW != null ? WW.findViewById(a.f.user_avatar) : null;
    }

    public AlaWheatInfoData iQ(String str) {
        View WX = WX(str);
        if (WX != null) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) this.oMQ.clone();
            int[] iArr = new int[2];
            WX.getLocationOnScreen(iArr);
            alaWheatInfoData.locationCenterX = iArr[0] + (WX.getWidth() / 2);
            alaWheatInfoData.locationCenterY = (WX.getHeight() / 2) + iArr[1];
            return alaWheatInfoData;
        }
        return null;
    }

    public void setMaskBg(boolean z) {
        if (this.dph != null) {
            this.dph.setClickable(z);
            this.dph.setFocusable(z);
            this.dph.setVisibility(z ? 0 : 8);
        }
    }

    public void efb() {
        int[] screenFullSize;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.d(360.0f, getContext())) {
            this.oMR = screenFullSize[0] / 4;
        }
    }

    public boolean efc() {
        int[] screenFullSize;
        return this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.d(360.0f, getContext());
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, ab abVar) {
        efe();
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3, ab abVar) {
        efe();
    }

    public int getWheatHeight() {
        return 0;
    }

    public boolean efd() {
        if (this.mTbPageContext == null) {
            return false;
        }
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        return this.oMT != null && screenFullSize != null && screenFullSize[0] > 0 && this.oMT.getMeasuredWidth() > 0 && this.oMT.getMeasuredWidth() > screenFullSize[0] + 200;
    }

    private void efe() {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (this.oMT != null && efd() && screenFullSize != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oMT.getLayoutParams();
            layoutParams.width = screenFullSize[0];
            layoutParams.height = screenFullSize[1];
            this.oMT.setLayoutParams(layoutParams);
        }
    }
}
