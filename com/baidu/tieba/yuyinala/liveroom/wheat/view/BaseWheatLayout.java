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
    public View del;
    public TbPageContext mTbPageContext;
    public List<AlaWheatInfoData> oif;
    public List<AlaWheatInfoData> oig;
    public a ojb;
    public List<WheatItemView> ojc;
    public List<WheatItemView> ojd;
    private AlaWheatInfoData oje;
    public int ojf;
    public int ojg;

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
        this.ojf = e.c(90.0f, getContext());
        this.ojg = e.c(98.0f, getContext());
        this.ojc = new ArrayList();
        this.ojd = new ArrayList();
    }

    public void setTbPageContext(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public AlaWheatInfoData ao(int i, boolean z) {
        AlaWheatInfoData alaWheatInfoData = null;
        if (z) {
            if (!ListUtils.isEmpty(this.oif) && i >= 0 && i < this.oif.size() && (alaWheatInfoData = this.oif.get(i)) != null) {
                alaWheatInfoData.isHost = true;
            }
        } else if (!ListUtils.isEmpty(this.oig) && i >= 0 && i < this.oig.size() && (alaWheatInfoData = this.oig.get(i)) != null) {
            alaWheatInfoData.isHost = false;
        }
        return alaWheatInfoData;
    }

    public void setOnItemClickListener(a aVar) {
        this.ojb = aVar;
    }

    public void VJ(String str) {
        View VM = VM(str);
        if (VM != null) {
            AlaWheatInfoData iS = iS(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) VM.findViewById(a.f.speeding_lottieAnimationView);
            if (iS == null || !iS.isOpenMike()) {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
            } else if (lottieAnimationView.getTag() == null || !(lottieAnimationView.getTag() instanceof String) || !TextUtils.equals(str, (String) lottieAnimationView.getTag()) || lottieAnimationView.getVisibility() != 0 || !lottieAnimationView.isAnimating()) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setRepeatCount(MessageConfig.BASE_SEGMENT_LENGTH);
                lottieAnimationView.setAnimation(iS.isFemale() ? "connecting_wheat_female.json" : "connecting_wheat_male.json");
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

    public void VK(String str) {
        LottieAnimationView lottieAnimationView;
        View VM = VM(str);
        if (VM != null && (lottieAnimationView = (LottieAnimationView) VM.findViewById(a.f.speeding_lottieAnimationView)) != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public void aM(String str, String str2, String str3) {
        AlaEmoticonView alaEmoticonView;
        View VM = VM(str);
        if (VM != null && (alaEmoticonView = (AlaEmoticonView) VM.findViewById(a.f.ala_emoticon_view)) != null) {
            alaEmoticonView.stopLoad();
            alaEmoticonView.aM(str2, str3);
            alaEmoticonView.setVisibility(0);
            alaEmoticonView.setTag(str3);
        }
    }

    private synchronized View VM(String str) {
        View view;
        View view2 = null;
        synchronized (this) {
            this.oje = null;
            int i = 0;
            while (true) {
                if (i >= ListUtils.getCount(this.oif)) {
                    break;
                }
                this.oje = this.oif.get(i);
                if (str == null || this.oje == null || !str.equals(this.oje.uk)) {
                    i++;
                } else {
                    view2 = (View) ListUtils.getItem(this.ojc, i);
                    break;
                }
            }
            if (view2 == null) {
                for (int i2 = 0; i2 < ListUtils.getCount(this.oig); i2++) {
                    this.oje = this.oig.get(i2);
                    if (str != null && this.oje != null && str.equals(this.oje.uk)) {
                        view = (View) ListUtils.getItem(this.ojd, i2);
                        break;
                    }
                }
            }
            view = view2;
        }
        return view;
    }

    public synchronized View VN(String str) {
        View VM;
        VM = VM(str);
        return VM != null ? VM.findViewById(a.f.user_avatar) : null;
    }

    public AlaWheatInfoData iS(String str) {
        View VN = VN(str);
        if (VN != null) {
            AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) this.oje.clone();
            int[] iArr = new int[2];
            VN.getLocationOnScreen(iArr);
            alaWheatInfoData.locationCenterX = iArr[0] + (VN.getWidth() / 2);
            alaWheatInfoData.locationCenterY = (VN.getHeight() / 2) + iArr[1];
            return alaWheatInfoData;
        }
        return null;
    }

    public void setMaskBg(boolean z) {
        if (this.del != null) {
            this.del.setClickable(z);
            this.del.setFocusable(z);
            this.del.setVisibility(z ? 0 : 8);
        }
    }

    public void eau() {
        int[] screenFullSize;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.c(360.0f, getContext())) {
            this.ojf = screenFullSize[0] / 4;
        }
    }

    public boolean eav() {
        int[] screenFullSize;
        return this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity())) != null && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] < e.c(360.0f, getContext());
    }
}
