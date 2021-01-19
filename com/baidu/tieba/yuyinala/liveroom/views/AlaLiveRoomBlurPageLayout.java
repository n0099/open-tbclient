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
import com.baidu.live.v.e;
/* loaded from: classes10.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements e {
    private TextView hMA;
    Runnable hMB;
    private FrameLayout hMw;
    private View hMy;
    private FrameLayout hMz;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private BackgroundVideoView osA;
    private View osB;
    private AlaLiveView osC;
    private Bitmap osD;
    private String osE;
    private TbImageView osz;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.osz = null;
        this.osB = null;
        this.osC = null;
        this.hMy = null;
        this.hMz = null;
        this.hMA = null;
        this.hMB = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.osz.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.osz.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.osz.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.osz.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.osz = null;
        this.osB = null;
        this.osC = null;
        this.hMy = null;
        this.hMz = null;
        this.hMA = null;
        this.hMB = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.osz.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.osz.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.osz.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.osz.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osz = null;
        this.osB = null;
        this.osC = null;
        this.hMy = null;
        this.hMz = null;
        this.hMA = null;
        this.hMB = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.osz.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.osz.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.osz.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.osz.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.yuyin_ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.osz = (TbImageView) findViewById(a.f.ala_liveroom_background_img);
        this.osD = drawableToBitmap(new ColorDrawable(getResources().getColor(a.c.sdk_color_333333)));
        this.hMw = new FrameLayout(getContext());
        this.hMw.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        dJ(screenFullSize[0], screenFullSize[1]);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, 10, 10);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void dJ(int i, int i2) {
        if (this.osz != null) {
            ViewGroup.LayoutParams layoutParams = this.osz.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.osz.setLayoutParams(layoutParams);
        }
    }

    public void C(int i, int i2) {
        dJ(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hMz != null && this.hMz.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hMz.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hMz.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.osC = alaLiveView;
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
            ckh();
        }
    }

    public void cke() {
        if (this.osC != null) {
            this.mRootView.removeView(this.osC);
        }
        this.osC = null;
    }

    @Override // com.baidu.live.v.e
    public ViewGroup getLiveContainerView() {
        return this;
    }

    @Override // com.baidu.live.v.e
    public FrameLayout getMastView() {
        return null;
    }

    public void f(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hMw.getParent() != null) {
            this.mRootView.removeView(this.hMw);
        }
        this.mRootView.addView(this.hMw, 1);
        if (this.osB != null && this.osB.getParent() != null) {
            ((ViewGroup) this.osB.getParent()).removeView(this.osB);
        }
        this.osB = view;
        if (this.osB != null && this.osB.getParent() != null) {
            ((ViewGroup) this.osB.getParent()).removeView(this.osB);
        }
        if (this.osB != null) {
            if (layoutParams != null) {
                this.hMw.addView(this.osB, layoutParams);
            } else {
                this.hMw.addView(this.osB, this.osB.getLayoutParams());
            }
        }
    }

    public void Vz() {
        if (this.hMw.getParent() != null) {
            ((ViewGroup) this.hMw.getParent()).removeView(this.hMw);
        }
        if (this.osA != null && this.osA.getParent() != null) {
            ((ViewGroup) this.osA.getParent()).removeView(this.osA);
        }
        this.osA = null;
    }

    public boolean cD(View view) {
        return (this.hMw == null || this.hMw.getParent() == null || this.hMw.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hMy != null && this.mRootView.indexOfChild(this.hMy) >= 0) {
            this.mRootView.removeView(this.hMy);
        }
        this.hMy = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hMy != null) {
            this.mRootView.addView(this.hMy, childCount, layoutParams);
        }
        ckh();
    }

    public void ckf() {
        if (this.hMy != null) {
            this.mRootView.removeView(this.hMy);
        }
        this.hMy = null;
    }

    public void ckg() {
        this.mHandler.removeCallbacks(this.hMB);
        this.osz.clearAnimation();
        this.osz.setAlpha(1.0f);
        this.osz.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.osz != null) {
            this.osz.setImageDrawable(null);
            this.osz.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
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
            dJ(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.osz.setImageBitmap(this.osD);
            } else if (TextUtils.isEmpty(str)) {
                this.osz.setBackgroundResource(a.e.yuyin_sdk_wheat_bg);
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
            if (this.osA != null && this.osA.getParent() != null) {
                ((ViewGroup) this.osA.getParent()).removeView(this.osA);
                this.osA.ead();
            }
            try {
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
                dJ(screenFullSize[0], screenFullSize[1]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.osz.setImageBitmap(bitmap);
        }
    }

    public void dZZ() {
        if (this.osA != null && this.osA.getParent() != null) {
            ((ViewGroup) this.osA.getParent()).removeView(this.osA);
            this.osA.ead();
        }
    }

    public void setBgVideo(String str) {
        if (!eac() || !TextUtils.equals(this.osE, str)) {
            this.osE = str;
            j(ViewCommonUtil.getVisibilityRegion(this.mPageContext.getPageActivity()));
            UT(str + "/video.mp4");
        }
    }

    public void release() {
        if (this.osz != null) {
            this.osz.setImageDrawable(null);
            this.osz.stopLoad();
        }
        if (this.osA != null) {
            this.osA.ead();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.osC != null && !this.osC.hMP) {
            z = this.osC.X(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void ckh() {
        if (this.hMz != null && this.hMz.getParent() != null) {
            ((ViewGroup) this.hMz.getParent()).removeView(this.hMz);
        }
        if (this.osz != null) {
            this.osz.setVisibility(0);
        }
    }

    public void UT(String str) {
        if (this.osA != null && !TextUtils.isEmpty(str)) {
            this.osA.setVideoPath(str);
            if (!this.osA.isPlaying()) {
                this.osA.start();
            }
        }
    }

    public void eaa() {
        if (this.osA != null) {
            this.osA.pause();
        }
    }

    public void eab() {
        if (this.osA != null) {
            this.osA.start();
        }
    }

    public boolean eac() {
        return this.osA != null && this.osA.isPlaying();
    }

    private void j(final Rect rect) {
        if (this.osA != null && this.osA.getParent() != null) {
            ((ViewGroup) this.osA.getParent()).removeView(this.osA);
            this.osA.ead();
        }
        this.osA = new BackgroundVideoView(getContext());
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = 1;
        layoutParams.width = 1;
        this.hMw.addView(this.osA, 0, layoutParams);
        this.osA.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.3
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
                    AlaLiveRoomBlurPageLayout.this.osA.setLayoutParams(layoutParams);
                    return false;
                }
                return false;
            }
        });
        this.osA.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AlaLiveRoomBlurPageLayout.this.osA.stopPlayback();
                AlaLiveRoomBlurPageLayout.this.osA.setVisibility(8);
                return true;
            }
        });
    }
}
