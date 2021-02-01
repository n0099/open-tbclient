package com.baidu.tieba.yuyinala.liveroom.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
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
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.e;
/* loaded from: classes11.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements e {
    private FrameLayout hQQ;
    private View hQS;
    private FrameLayout hQT;
    private TextView hQU;
    Runnable hQV;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private TbImageView oCk;
    private BackgroundVideoView oCl;
    private View oCm;
    private AlaLiveView oCn;
    private Bitmap oCo;
    private String oCp;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.oCk = null;
        this.oCm = null;
        this.oCn = null;
        this.hQS = null;
        this.hQT = null;
        this.hQU = null;
        this.hQV = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oCk.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oCk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oCk.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oCk.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oCk = null;
        this.oCm = null;
        this.oCn = null;
        this.hQS = null;
        this.hQT = null;
        this.hQU = null;
        this.hQV = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oCk.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oCk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oCk.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oCk.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oCk = null;
        this.oCm = null;
        this.oCn = null;
        this.hQS = null;
        this.hQT = null;
        this.hQU = null;
        this.hQV = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oCk.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oCk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oCk.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oCk.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.yuyin_ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.oCk = (TbImageView) findViewById(a.f.ala_liveroom_background_img);
        this.oCo = drawableToBitmap(new ColorDrawable(getResources().getColor(a.c.sdk_color_333333)));
        this.hQQ = new FrameLayout(getContext());
        this.hQQ.setId(a.f.ala_liveroom_player_container_view);
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
        if (this.oCk != null) {
            ViewGroup.LayoutParams layoutParams = this.oCk.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.oCk.setLayoutParams(layoutParams);
        }
    }

    public void C(int i, int i2) {
        dG(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hQT != null && this.hQT.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hQT.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hQT.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.oCn = alaLiveView;
                int childCount = this.mRootView.getChildCount() - 1;
                int childCount2 = this.mRootView.getChildCount();
                for (int i = 0; i < childCount2; i++) {
                    View childAt = this.mRootView.getChildAt(i);
                    if (childAt.getId() == a.f.ala_liveroom_player_container_view) {
                        childCount = Math.max(childCount, i);
                    } else if (childAt.getId() == a.f.ala_liveroom_audience_end_view) {
                        childCount = Math.min(childCount, i);
                    } else if (childAt.getId() == a.f.ala_live_room_close_btn_layout) {
                        childCount = Math.min(childCount, i);
                    }
                }
                if (layoutParams != null) {
                    this.mRootView.addView(alaLiveView, childCount, layoutParams);
                } else {
                    this.mRootView.addView(alaLiveView, childCount, alaLiveView.getLayoutParams());
                }
            }
            clf();
        }
    }

    public void clc() {
        if (this.oCn != null) {
            this.mRootView.removeView(this.oCn);
        }
        this.oCn = null;
    }

    @Override // com.baidu.live.u.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.u.e
    public FrameLayout getMastView() {
        return null;
    }

    public void f(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hQQ.getParent() != null) {
            this.mRootView.removeView(this.hQQ);
        }
        this.mRootView.addView(this.hQQ, 1);
        if (this.oCm != null && this.oCm.getParent() != null) {
            ((ViewGroup) this.oCm.getParent()).removeView(this.oCm);
        }
        this.oCm = view;
        if (this.oCm != null && this.oCm.getParent() != null) {
            ((ViewGroup) this.oCm.getParent()).removeView(this.oCm);
        }
        if (this.oCm != null) {
            if (layoutParams != null) {
                this.hQQ.addView(this.oCm, layoutParams);
            } else {
                this.hQQ.addView(this.oCm, this.oCm.getLayoutParams());
            }
        }
    }

    public void Xi() {
        if (this.hQQ.getParent() != null) {
            ((ViewGroup) this.hQQ.getParent()).removeView(this.hQQ);
        }
        if (this.oCl != null && this.oCl.getParent() != null) {
            ((ViewGroup) this.oCl.getParent()).removeView(this.oCl);
        }
        this.oCl = null;
    }

    public boolean cz(View view) {
        return (this.hQQ == null || this.hQQ.getParent() == null || this.hQQ.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hQS != null && this.mRootView.indexOfChild(this.hQS) >= 0) {
            this.mRootView.removeView(this.hQS);
        }
        this.hQS = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hQS != null) {
            this.mRootView.addView(this.hQS, childCount, layoutParams);
        }
        clf();
    }

    public void cld() {
        if (this.hQS != null) {
            this.mRootView.removeView(this.hQS);
        }
        this.hQS = null;
    }

    public void cle() {
        this.mHandler.removeCallbacks(this.hQV);
        this.oCk.clearAnimation();
        this.oCk.setAlpha(1.0f);
        this.oCk.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.oCk != null) {
            this.oCk.setImageDrawable(null);
            this.oCk.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
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
            dG(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.oCk.setImageBitmap(this.oCo);
            } else if (TextUtils.isEmpty(str)) {
                this.oCk.setBackgroundResource(a.e.yuyin_sdk_wheat_bg);
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

    public void setBgImageBitmap(Bitmap bitmap) {
        if (this.mPageContext != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.oCl != null && this.oCl.getParent() != null) {
                ((ViewGroup) this.oCl.getParent()).removeView(this.oCl);
                this.oCl.ecq();
            }
            try {
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
                dG(screenFullSize[0], screenFullSize[1]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.oCk.setImageBitmap(bitmap);
        }
    }

    public void ecm() {
        if (this.oCl != null && this.oCl.getParent() != null) {
            ((ViewGroup) this.oCl.getParent()).removeView(this.oCl);
            this.oCl.ecq();
        }
    }

    public void setBgVideo(String str) {
        if (!ecp() || !TextUtils.equals(this.oCp, str)) {
            this.oCp = str;
            j(ViewCommonUtil.getVisibilityRegion(this.mPageContext.getPageActivity()));
            VR(str + "/video.mp4");
        }
    }

    public void release() {
        if (this.oCk != null) {
            this.oCk.setImageDrawable(null);
            this.oCk.stopLoad();
        }
        if (this.oCl != null) {
            this.oCl.ecq();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.oCn != null && !this.oCn.hRj) {
            z = this.oCn.X(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void clf() {
        if (this.hQT != null && this.hQT.getParent() != null) {
            ((ViewGroup) this.hQT.getParent()).removeView(this.hQT);
        }
        if (this.oCk != null) {
            this.oCk.setVisibility(0);
        }
    }

    public void VR(String str) {
        if (this.oCl != null && !TextUtils.isEmpty(str)) {
            this.oCl.setVideoPath(str);
            if (!this.oCl.isPlaying()) {
                this.oCl.start();
            }
        }
    }

    public void ecn() {
        if (this.oCl != null) {
            this.oCl.pause();
        }
    }

    public void eco() {
        if (this.oCl != null) {
            this.oCl.start();
        }
    }

    public boolean ecp() {
        return this.oCl != null && this.oCl.isPlaying();
    }

    private void j(final Rect rect) {
        if (this.oCl != null && this.oCl.getParent() != null) {
            ((ViewGroup) this.oCl.getParent()).removeView(this.oCl);
            this.oCl.ecq();
        }
        this.oCl = new BackgroundVideoView(getContext());
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = 1;
        layoutParams.width = 1;
        this.hQQ.addView(this.oCl, 0, layoutParams);
        this.oCl.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.3
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (i == 3) {
                    float videoHeight = mediaPlayer.getVideoHeight() / mediaPlayer.getVideoWidth();
                    if (videoHeight < rect.height() / rect.width()) {
                        layoutParams.height = rect.height();
                        layoutParams.width = (int) (rect.height() / videoHeight);
                    } else {
                        layoutParams.width = rect.width();
                        layoutParams.height = (int) (videoHeight * rect.width());
                    }
                    AlaLiveRoomBlurPageLayout.this.oCl.setLayoutParams(layoutParams);
                    return false;
                }
                return false;
            }
        });
        this.oCl.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AlaLiveRoomBlurPageLayout.this.oCl.stopPlayback();
                AlaLiveRoomBlurPageLayout.this.oCl.setVisibility(8);
                return true;
            }
        });
    }
}
