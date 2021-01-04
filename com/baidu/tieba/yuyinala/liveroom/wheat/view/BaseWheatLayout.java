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
/* loaded from: classes11.dex */
public class BaseWheatLayout extends SafeFrameLayout {
    public int Yn;
    public View dqj;
    public TbPageContext mTbPageContext;
    public View mView;
    public List<AlaWheatInfoData> oEc;
    public List<AlaWheatInfoData> oEd;
    public a oFd;
    public List<WheatItemView> oFe;
    public List<WheatItemView> oFf;
    private AlaWheatInfoData oFg;
    public int oFh;
    public int oFi;
    public RelativeLayout oFj;

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
        this.Yn = e.c(100.0f, getContext());
        init();
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_container_layout, this);
        this.oFj = (RelativeLayout) this.mView.findViewById(a.f.wheat_view_container);
        this.dqj = this.mView.findViewById(a.f.mask);
    }

    private void init() {
        if (UtilHelper.getStatusBarHeight() > 0) {
            this.Yn = UtilHelper.getStatusBarHeight() + e.c(74.0f, getContext());
        }
        this.oFh = e.c(90.0f, getContext());
        this.oFi = e.c(98.0f, getContext());
        this.oFe = new ArrayList();
        this.oFf = new ArrayList();
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public AlaWheatInfoData am(int i, boolean z) {
        AlaWheatInfoData alaWheatInfoData = null;
        if (z) {
            if (!ListUtils.isEmpty(this.oEc) && i >= 0 && i < this.oEc.size() && (alaWheatInfoData = this.oEc.get(i)) != null) {
                alaWheatInfoData.isHost = true;
            }
        } else if (!ListUtils.isEmpty(this.oEd) && i >= 0 && i < this.oEd.size() && (alaWheatInfoData = this.oEd.get(i)) != null) {
            alaWheatInfoData.isHost = false;
        }
        return alaWheatInfoData;
    }

    public void setOnItemClickListener(a aVar) {
        this.oFd = aVar;
    }

    public void WK(String str) {
        View WN = WN(str);
        if (WN != null) {
            AlaWheatInfoData jp = jp(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) WN.findViewById(a.f.speeding_lottieAnimationView);
            if (jp == null || !jp.isOpenMike()) {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
            } else if (lottieAnimationView.getTag() == null || !(lottieAnimationView.getTag() instanceof String) || !TextUtils.equals(str, (String) lottieAnimationView.getTag()) || lottieAnimationView.getVisibility() != 0 || !lottieAnimationView.isAnimating()) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setRepeatCount(MessageConfig.BASE_SEGMENT_LENGTH);
                lottieAnimationView.setAnimation(jp.isFemale() ? "connecting_wheat_female.json" : "connecting_wheat_male.json");
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

    public void WL(String str) {
        LottieAnimationView lottieAnimationView;
        View WN = WN(str);
        if (WN != null && (lottieAnimationView = (LottieAnimationView) WN.findViewById(a.f.speeding_lottieAnimationView)) != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void aT(String str, String str2, String str3) {
        AlaEmoticonView alaEmoticonView;
        View WN = WN(str);
        if (WN != null && (alaEmoticonView = (AlaEmoticonView) WN.findViewById(a.f.ala_emoticon_view)) != null) {
            alaEmoticonView.stopLoad();
            alaEmoticonView.aL(str2, str3);
            alaEmoticonView.setVisibility(0);
            alaEmoticonView.setTag(str3);
        }
    }

    private synchronized View WN(String str) {
        View view;
        View view2 = null;
        synchronized (this) {
            this.oFg = null;
            int i = 0;
            while (true) {
                if (i >= ListUtils.getCount(this.oEc)) {
                    break;
                }
                this.oFg = this.oEc.get(i);
                if (str == null || this.oFg == null || !str.equals(this.oFg.uk)) {
                    i++;
                } else {
                    view2 = (View) ListUtils.getItem(this.oFe, i);
                    break;
                }
            }
            if (view2 == null) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.oEd); i2++) {
                    this.oFg = this.oEd.get(i2);
                    if (str != null && this.oFg != null && str.equals(this.oFg.uk)) {
                        view = (View) ListUtils.getItem(this.oFf, i2);
                        break;
                    }
                }
            }
            view = view2;
        }
        return view;
    }

    public synchronized View WO(String str) {
        View WN;
        WN = WN(str);
        return WN != null ? WN.findViewById(a.f.user_avatar) : null;
    }

    public AlaWheatInfoData jp(String str) {
        View WO = WO(str);
        if (WO != null) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) this.oFg.clone();
            int[] iArr = new int[2];
            WO.getLocationOnScreen(iArr);
            alaWheatInfoData.locationCenterX = iArr[0] + (WO.getWidth() / 2);
            alaWheatInfoData.locationCenterY = (WO.getHeight() / 2) + iArr[1];
            return alaWheatInfoData;
        }
        return null;
    }

    public void setMaskBg(boolean z) {
        if (this.dqj != null) {
            this.dqj.setClickable(z);
            this.dqj.setFocusable(z);
            this.dqj.setVisibility(z ? 0 : 8);
        }
    }

    public void ego() {
        int[] screenFullSize;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.c(360.0f, getContext())) {
            this.oFh = screenFullSize[0] / 4;
        }
    }

    public boolean egp() {
        int[] screenFullSize;
        return this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.c(360.0f, getContext());
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, x xVar) {
        egr();
    }

    public synchronized void a(List<AlaWheatInfoData> list, List<AlaWheatInfoData> list2, List<AlaWheatInfoData> list3, x xVar) {
        egr();
    }

    public int getWheatHeight() {
        return 0;
    }

    public boolean egq() {
        if (this.mTbPageContext == null) {
            return false;
        }
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        return this.oFj != null && screenFullSize != null && screenFullSize[0] > 0 && this.oFj.getMeasuredWidth() > 0 && this.oFj.getMeasuredWidth() > screenFullSize[0] + 200;
    }

    private void egr() {
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (this.oFj != null && egq() && screenFullSize != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oFj.getLayoutParams();
            layoutParams.width = screenFullSize[0];
            layoutParams.height = screenFullSize[1];
            this.oFj.setLayoutParams(layoutParams);
        }
    }
}
