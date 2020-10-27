package com.baidu.tieba.yuyinala.liveroom.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.r.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements e {
    private FrameLayout hpS;
    private View hpU;
    private FrameLayout hpV;
    private TextView hpW;
    Runnable hpX;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private TbImageView nTj;
    private View nTk;
    private AlaLiveView nTl;
    private Bitmap nTm;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.nTj = null;
        this.nTk = null;
        this.nTl = null;
        this.hpU = null;
        this.hpV = null;
        this.hpW = null;
        this.hpX = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(400L);
                alphaAnimation.setStartOffset(120L);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        AlaLiveRoomBlurPageLayout.this.nTj.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.nTj.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.nTj.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.nTj.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nTj = null;
        this.nTk = null;
        this.nTl = null;
        this.hpU = null;
        this.hpV = null;
        this.hpW = null;
        this.hpX = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(400L);
                alphaAnimation.setStartOffset(120L);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        AlaLiveRoomBlurPageLayout.this.nTj.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.nTj.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.nTj.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.nTj.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nTj = null;
        this.nTk = null;
        this.nTl = null;
        this.hpU = null;
        this.hpV = null;
        this.hpW = null;
        this.hpX = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(400L);
                alphaAnimation.setStartOffset(120L);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        AlaLiveRoomBlurPageLayout.this.nTj.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.nTj.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.nTj.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.nTj.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.h.yuyin_ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.nTj = (TbImageView) findViewById(a.g.ala_liveroom_background_img);
        this.nTm = drawableToBitmap(new ColorDrawable(getResources().getColor(a.d.sdk_color_333333)));
        this.hpS = new FrameLayout(getContext());
        this.hpS.setId(a.g.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        dG(screenFullSize[0], screenFullSize[1]);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, 10, 10);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void dG(int i, int i2) {
        if (this.nTj != null) {
            ViewGroup.LayoutParams layoutParams = this.nTj.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.nTj.setLayoutParams(layoutParams);
        }
    }

    public void D(int i, int i2) {
        dG(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hpV != null && this.hpV.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hpV.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hpV.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.nTl = alaLiveView;
                int childCount = this.mRootView.getChildCount() - 1;
                int childCount2 = this.mRootView.getChildCount();
                int i = childCount;
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt = this.mRootView.getChildAt(i2);
                    if (childAt.getId() == a.g.ala_liveroom_player_container_view) {
                        i = Math.max(i, i2);
                    } else if (childAt.getId() == a.g.ala_liveroom_audience_end_view) {
                        i = Math.min(i, i2);
                    } else if (childAt.getId() == a.g.ala_live_room_close_btn_layout) {
                        i = Math.min(i, i2);
                    }
                }
                if (layoutParams != null) {
                    this.mRootView.addView(alaLiveView, i, layoutParams);
                } else {
                    this.mRootView.addView(alaLiveView, i, alaLiveView.getLayoutParams());
                }
            }
            cfq();
        }
    }

    public void cfn() {
        if (this.nTl != null) {
            this.mRootView.removeView(this.nTl);
        }
        this.nTl = null;
    }

    @Override // com.baidu.live.r.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hpS.getParent() != null) {
            this.mRootView.removeView(this.hpS);
        }
        this.mRootView.addView(this.hpS, 1);
        if (this.nTk != null && this.nTk.getParent() != null) {
            ((ViewGroup) this.nTk.getParent()).removeView(this.nTk);
        }
        this.nTk = view;
        if (this.nTk != null && this.nTk.getParent() != null) {
            ((ViewGroup) this.nTk.getParent()).removeView(this.nTk);
        }
        if (this.nTk != null) {
            if (layoutParams != null) {
                this.hpS.addView(this.nTk, layoutParams);
            } else {
                this.hpS.addView(this.nTk, this.nTk.getLayoutParams());
            }
        }
    }

    public void TS() {
        if (this.hpS.getParent() != null) {
            ((ViewGroup) this.hpS.getParent()).removeView(this.hpS);
        }
    }

    public boolean cf(View view) {
        return (this.hpS == null || this.hpS.getParent() == null || this.hpS.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hpU != null && this.mRootView.indexOfChild(this.hpU) >= 0) {
            this.mRootView.removeView(this.hpU);
        }
        this.hpU = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.g.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.hpU != null) {
            this.mRootView.addView(this.hpU, i, layoutParams);
        }
        cfq();
    }

    public void cfo() {
        if (this.hpU != null) {
            this.mRootView.removeView(this.hpU);
        }
        this.hpU = null;
    }

    public void cfp() {
        this.mHandler.removeCallbacks(this.hpX);
        this.nTj.clearAnimation();
        this.nTj.setAlpha(1.0f);
        this.nTj.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.nTj != null) {
            this.nTj.setImageDrawable(null);
            this.nTj.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_transparent));
        }
    }

    public void setDefaultBg() {
        setBgImageBitmap(BitmapFactory.decodeResource(getResources(), a.f.yuyin_sdk_defalut_bg));
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, null);
    }

    public void setBgImageUrl(final String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            dG(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.nTj.setImageBitmap(this.nTm);
            } else if (TextUtils.isEmpty(str)) {
                this.nTj.setBackgroundResource(a.f.yuyin_sdk_wheat_bg);
            } else {
                BdResourceLoader.getInstance().loadResource(str, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                    public void onLoaded(BdImage bdImage, String str2, int i2) {
                        super.onLoaded((AnonymousClass2) bdImage, str2, i2);
                        if (bdImage != null && bdImage.getImage() != null && !bdImage.getImage().isRecycled() && str2 != null && str2.equals(str)) {
                            AlaLiveRoomBlurPageLayout.this.setBgImageBitmap(Bitmap.createBitmap(bdImage.getImage()));
                        }
                    }
                }, this.mPageContext.getUniqueId());
            }
        }
    }

    private Bitmap X(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
        if ((width * 1.0f) / height >= (equipmentWidth * 1.0f) / equipmentHeight) {
            return Bitmap.createBitmap(bitmap);
        }
        int i = (int) (((equipmentHeight * width) * 1.0f) / equipmentWidth);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height - i, width, i);
        if (createBitmap != bitmap) {
            bitmap.recycle();
            return createBitmap;
        }
        return createBitmap;
    }

    public void setBgImageBitmap(Bitmap bitmap) {
        Bitmap X = X(bitmap);
        if (this.mPageContext != null && X != null && !X.isRecycled()) {
            try {
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
                dG(screenFullSize[0], screenFullSize[1]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.nTj.setImageBitmap(X);
        }
    }

    public void release() {
        if (this.nTj != null) {
            this.nTj.setImageDrawable(null);
            this.nTj.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.nTl != null && !this.nTl.hqk) {
            z = this.nTl.V(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cfq() {
        if (this.hpV != null && this.hpV.getParent() != null) {
            ((ViewGroup) this.hpV.getParent()).removeView(this.hpV);
        }
        if (this.nTj != null) {
            this.nTj.setVisibility(0);
        }
    }
}
