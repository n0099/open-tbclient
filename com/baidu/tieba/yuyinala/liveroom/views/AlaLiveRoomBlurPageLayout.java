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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.e;
/* loaded from: classes4.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements e {
    private FrameLayout hFc;
    private View hFe;
    private FrameLayout hFf;
    private TextView hFg;
    Runnable hFh;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private TbImageView orc;
    private View ord;
    private AlaLiveView ore;
    private Bitmap orf;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.orc = null;
        this.ord = null;
        this.ore = null;
        this.hFe = null;
        this.hFf = null;
        this.hFg = null;
        this.hFh = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.orc.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.orc.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.orc.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.orc.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orc = null;
        this.ord = null;
        this.ore = null;
        this.hFe = null;
        this.hFf = null;
        this.hFg = null;
        this.hFh = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.orc.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.orc.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.orc.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.orc.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.orc = null;
        this.ord = null;
        this.ore = null;
        this.hFe = null;
        this.hFf = null;
        this.hFg = null;
        this.hFh = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.orc.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.orc.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.orc.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.orc.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.yuyin_ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.orc = (TbImageView) findViewById(a.f.ala_liveroom_background_img);
        this.orf = drawableToBitmap(new ColorDrawable(getResources().getColor(a.c.sdk_color_333333)));
        this.hFc = new FrameLayout(getContext());
        this.hFc.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        dO(screenFullSize[0], screenFullSize[1]);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, 10, 10);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void dO(int i, int i2) {
        if (this.orc != null) {
            ViewGroup.LayoutParams layoutParams = this.orc.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.orc.setLayoutParams(layoutParams);
        }
    }

    public void C(int i, int i2) {
        dO(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hFf != null && this.hFf.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hFf.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hFf.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.ore = alaLiveView;
                int childCount = this.mRootView.getChildCount() - 1;
                int childCount2 = this.mRootView.getChildCount();
                int i = childCount;
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt = this.mRootView.getChildAt(i2);
                    if (childAt.getId() == a.f.ala_liveroom_player_container_view) {
                        i = Math.max(i, i2);
                    } else if (childAt.getId() == a.f.ala_liveroom_audience_end_view) {
                        i = Math.min(i, i2);
                    } else if (childAt.getId() == a.f.ala_live_room_close_btn_layout) {
                        i = Math.min(i, i2);
                    }
                }
                if (layoutParams != null) {
                    this.mRootView.addView(alaLiveView, i, layoutParams);
                } else {
                    this.mRootView.addView(alaLiveView, i, alaLiveView.getLayoutParams());
                }
            }
            clh();
        }
    }

    public void cle() {
        if (this.ore != null) {
            this.mRootView.removeView(this.ore);
        }
        this.ore = null;
    }

    @Override // com.baidu.live.u.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.u.e
    public FrameLayout getMastView() {
        return null;
    }

    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hFc.getParent() != null) {
            this.mRootView.removeView(this.hFc);
        }
        this.mRootView.addView(this.hFc, 1);
        if (this.ord != null && this.ord.getParent() != null) {
            ((ViewGroup) this.ord.getParent()).removeView(this.ord);
        }
        this.ord = view;
        if (this.ord != null && this.ord.getParent() != null) {
            ((ViewGroup) this.ord.getParent()).removeView(this.ord);
        }
        if (this.ord != null) {
            if (layoutParams != null) {
                this.hFc.addView(this.ord, layoutParams);
            } else {
                this.hFc.addView(this.ord, this.ord.getLayoutParams());
            }
        }
    }

    public void Yj() {
        if (this.hFc.getParent() != null) {
            ((ViewGroup) this.hFc.getParent()).removeView(this.hFc);
        }
    }

    public boolean cu(View view) {
        return (this.hFc == null || this.hFc.getParent() == null || this.hFc.indexOfChild(view) < 0) ? false : true;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hFe != null && this.mRootView.indexOfChild(this.hFe) >= 0) {
            this.mRootView.removeView(this.hFe);
        }
        this.hFe = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        int i = childCount;
        for (int i2 = 0; i2 < childCount2; i2++) {
            if (this.mRootView.getChildAt(i2).getId() == a.f.ala_live_room_close_btn_layout) {
                i = Math.max(i, i2);
            }
        }
        if (this.hFe != null) {
            this.mRootView.addView(this.hFe, i, layoutParams);
        }
        clh();
    }

    public void clf() {
        if (this.hFe != null) {
            this.mRootView.removeView(this.hFe);
        }
        this.hFe = null;
    }

    public void clg() {
        this.mHandler.removeCallbacks(this.hFh);
        this.orc.clearAnimation();
        this.orc.setAlpha(1.0f);
        this.orc.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.orc != null) {
            this.orc.setImageDrawable(null);
            this.orc.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
        }
    }

    public void setDefaultBg() {
        setBgImageBitmap(BitmapFactory.decodeResource(getResources(), a.e.yuyin_sdk_defalut_bg));
    }

    public void setBgImageUrl(String str, AlaLiveInfoData alaLiveInfoData) {
        setBgImageUrl(str, 10, null);
    }

    public void setBgImageUrl(final String str, int i, AlaLiveInfoData alaLiveInfoData) {
        if (this.mPageContext != null && !TextUtils.isEmpty(str)) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            dO(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.orc.setImageBitmap(this.orf);
            } else if (TextUtils.isEmpty(str)) {
                this.orc.setBackgroundResource(a.e.yuyin_sdk_wheat_bg);
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
                dO(screenFullSize[0], screenFullSize[1]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.orc.setImageBitmap(X);
        }
    }

    public void release() {
        if (this.orc != null) {
            this.orc.setImageDrawable(null);
            this.orc.stopLoad();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.ore != null && !this.ore.hFv) {
            z = this.ore.W(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void clh() {
        if (this.hFf != null && this.hFf.getParent() != null) {
            ((ViewGroup) this.hFf.getParent()).removeView(this.hFf);
        }
        if (this.orc != null) {
            this.orc.setVisibility(0);
        }
    }
}
