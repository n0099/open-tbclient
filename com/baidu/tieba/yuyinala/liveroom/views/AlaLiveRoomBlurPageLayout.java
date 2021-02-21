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
    private FrameLayout hRe;
    private View hRg;
    private FrameLayout hRh;
    private TextView hRi;
    Runnable hRj;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private TbImageView oCK;
    private BackgroundVideoView oCL;
    private View oCM;
    private AlaLiveView oCN;
    private Bitmap oCO;
    private String oCP;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.oCK = null;
        this.oCM = null;
        this.oCN = null;
        this.hRg = null;
        this.hRh = null;
        this.hRi = null;
        this.hRj = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oCK.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oCK.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oCK.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oCK.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oCK = null;
        this.oCM = null;
        this.oCN = null;
        this.hRg = null;
        this.hRh = null;
        this.hRi = null;
        this.hRj = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oCK.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oCK.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oCK.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oCK.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oCK = null;
        this.oCM = null;
        this.oCN = null;
        this.hRg = null;
        this.hRh = null;
        this.hRi = null;
        this.hRj = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oCK.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oCK.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oCK.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oCK.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.yuyin_ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.oCK = (TbImageView) findViewById(a.f.ala_liveroom_background_img);
        this.oCO = drawableToBitmap(new ColorDrawable(getResources().getColor(a.c.sdk_color_333333)));
        this.hRe = new FrameLayout(getContext());
        this.hRe.setId(a.f.ala_liveroom_player_container_view);
        this.mHandler = new Handler();
    }

    public void c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(tbPageContext.getPageActivity());
        dH(screenFullSize[0], screenFullSize[1]);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(10, 10, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, 10, 10);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void dH(int i, int i2) {
        if (this.oCK != null) {
            ViewGroup.LayoutParams layoutParams = this.oCK.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.oCK.setLayoutParams(layoutParams);
        }
    }

    public void C(int i, int i2) {
        dH(i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
            if (this.hRh != null && this.hRh.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hRh.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hRh.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.oCN = alaLiveView;
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
            clm();
        }
    }

    public void clj() {
        if (this.oCN != null) {
            this.mRootView.removeView(this.oCN);
        }
        this.oCN = null;
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
        if (this.hRe.getParent() != null) {
            this.mRootView.removeView(this.hRe);
        }
        this.mRootView.addView(this.hRe, 1);
        if (this.oCM != null && this.oCM.getParent() != null) {
            ((ViewGroup) this.oCM.getParent()).removeView(this.oCM);
        }
        this.oCM = view;
        if (this.oCM != null && this.oCM.getParent() != null) {
            ((ViewGroup) this.oCM.getParent()).removeView(this.oCM);
        }
        if (this.oCM != null) {
            if (layoutParams != null) {
                this.hRe.addView(this.oCM, layoutParams);
            } else {
                this.hRe.addView(this.oCM, this.oCM.getLayoutParams());
            }
        }
    }

    public void Xi() {
        if (this.hRe.getParent() != null) {
            ((ViewGroup) this.hRe.getParent()).removeView(this.hRe);
        }
        if (this.oCL != null && this.oCL.getParent() != null) {
            ((ViewGroup) this.oCL.getParent()).removeView(this.oCL);
        }
        this.oCL = null;
    }

    public boolean cz(View view) {
        return (this.hRe == null || this.hRe.getParent() == null || this.hRe.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hRg != null && this.mRootView.indexOfChild(this.hRg) >= 0) {
            this.mRootView.removeView(this.hRg);
        }
        this.hRg = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hRg != null) {
            this.mRootView.addView(this.hRg, childCount, layoutParams);
        }
        clm();
    }

    public void clk() {
        if (this.hRg != null) {
            this.mRootView.removeView(this.hRg);
        }
        this.hRg = null;
    }

    public void cll() {
        this.mHandler.removeCallbacks(this.hRj);
        this.oCK.clearAnimation();
        this.oCK.setAlpha(1.0f);
        this.oCK.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.oCK != null) {
            this.oCK.setImageDrawable(null);
            this.oCK.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
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
            dH(screenFullSize[0], screenFullSize[1]);
            if (alaLiveInfoData != null && alaLiveInfoData.screen_direction == 2) {
                this.oCK.setImageBitmap(this.oCO);
            } else if (TextUtils.isEmpty(str)) {
                this.oCK.setBackgroundResource(a.e.yuyin_sdk_wheat_bg);
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
            if (this.oCL != null && this.oCL.getParent() != null) {
                ((ViewGroup) this.oCL.getParent()).removeView(this.oCL);
                this.oCL.ecy();
            }
            try {
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
                dH(screenFullSize[0], screenFullSize[1]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.oCK.setImageBitmap(bitmap);
        }
    }

    public void ecu() {
        if (this.oCL != null && this.oCL.getParent() != null) {
            ((ViewGroup) this.oCL.getParent()).removeView(this.oCL);
            this.oCL.ecy();
        }
    }

    public void setBgVideo(String str) {
        if (!ecx() || !TextUtils.equals(this.oCP, str)) {
            this.oCP = str;
            j(ViewCommonUtil.getVisibilityRegion(this.mPageContext.getPageActivity()));
            Wd(str + "/video.mp4");
        }
    }

    public void release() {
        if (this.oCK != null) {
            this.oCK.setImageDrawable(null);
            this.oCK.stopLoad();
        }
        if (this.oCL != null) {
            this.oCL.ecy();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.oCN != null && !this.oCN.hRx) {
            z = this.oCN.X(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void clm() {
        if (this.hRh != null && this.hRh.getParent() != null) {
            ((ViewGroup) this.hRh.getParent()).removeView(this.hRh);
        }
        if (this.oCK != null) {
            this.oCK.setVisibility(0);
        }
    }

    public void Wd(String str) {
        if (this.oCL != null && !TextUtils.isEmpty(str)) {
            this.oCL.setVideoPath(str);
            if (!this.oCL.isPlaying()) {
                this.oCL.start();
            }
        }
    }

    public void ecv() {
        if (this.oCL != null) {
            this.oCL.pause();
        }
    }

    public void ecw() {
        if (this.oCL != null) {
            this.oCL.start();
        }
    }

    public boolean ecx() {
        return this.oCL != null && this.oCL.isPlaying();
    }

    private void j(final Rect rect) {
        if (this.oCL != null && this.oCL.getParent() != null) {
            ((ViewGroup) this.oCL.getParent()).removeView(this.oCL);
            this.oCL.ecy();
        }
        this.oCL = new BackgroundVideoView(getContext());
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = 1;
        layoutParams.width = 1;
        this.hRe.addView(this.oCL, 0, layoutParams);
        this.oCL.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.3
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
                    AlaLiveRoomBlurPageLayout.this.oCL.setLayoutParams(layoutParams);
                    return false;
                }
                return false;
            }
        });
        this.oCL.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AlaLiveRoomBlurPageLayout.this.oCL.stopPlayback();
                AlaLiveRoomBlurPageLayout.this.oCL.setVisibility(8);
                return true;
            }
        });
    }
}
