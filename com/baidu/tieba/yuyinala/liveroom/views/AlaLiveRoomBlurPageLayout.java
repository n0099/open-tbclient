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
/* loaded from: classes11.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements e {
    private FrameLayout hRc;
    private View hRe;
    private FrameLayout hRf;
    private TextView hRg;
    Runnable hRh;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private TbImageView oxf;
    private BackgroundVideoView oxg;
    private View oxh;
    private AlaLiveView oxi;
    private Bitmap oxj;
    private String oxk;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.oxf = null;
        this.oxh = null;
        this.oxi = null;
        this.hRe = null;
        this.hRf = null;
        this.hRg = null;
        this.hRh = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oxf.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oxf.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oxf.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oxf.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oxf = null;
        this.oxh = null;
        this.oxi = null;
        this.hRe = null;
        this.hRf = null;
        this.hRg = null;
        this.hRh = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oxf.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oxf.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oxf.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oxf.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oxf = null;
        this.oxh = null;
        this.oxi = null;
        this.hRe = null;
        this.hRf = null;
        this.hRg = null;
        this.hRh = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oxf.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oxf.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oxf.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oxf.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.yuyin_ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.oxf = (TbImageView) findViewById(a.f.ala_liveroom_background_img);
        this.oxj = drawableToBitmap(new ColorDrawable(getResources().getColor(a.c.sdk_color_333333)));
        this.hRc = new FrameLayout(getContext());
        this.hRc.setId(a.f.ala_liveroom_player_container_view);
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
        if (this.oxf != null) {
            ViewGroup.LayoutParams layoutParams = this.oxf.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.oxf.setLayoutParams(layoutParams);
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
            if (this.hRf != null && this.hRf.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hRf.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hRf.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.oxi = alaLiveView;
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
            cnY();
        }
    }

    public void cnV() {
        if (this.oxi != null) {
            this.mRootView.removeView(this.oxi);
        }
        this.oxi = null;
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
        if (this.hRc.getParent() != null) {
            this.mRootView.removeView(this.hRc);
        }
        this.mRootView.addView(this.hRc, 1);
        if (this.oxh != null && this.oxh.getParent() != null) {
            ((ViewGroup) this.oxh.getParent()).removeView(this.oxh);
        }
        this.oxh = view;
        if (this.oxh != null && this.oxh.getParent() != null) {
            ((ViewGroup) this.oxh.getParent()).removeView(this.oxh);
        }
        if (this.oxh != null) {
            if (layoutParams != null) {
                this.hRc.addView(this.oxh, layoutParams);
            } else {
                this.hRc.addView(this.oxh, this.oxh.getLayoutParams());
            }
        }
    }

    public void Zr() {
        if (this.hRc.getParent() != null) {
            ((ViewGroup) this.hRc.getParent()).removeView(this.hRc);
        }
        if (this.oxg != null && this.oxg.getParent() != null) {
            ((ViewGroup) this.oxg.getParent()).removeView(this.oxg);
        }
        this.oxg = null;
    }

    public boolean cD(View view) {
        return (this.hRc == null || this.hRc.getParent() == null || this.hRc.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hRe != null && this.mRootView.indexOfChild(this.hRe) >= 0) {
            this.mRootView.removeView(this.hRe);
        }
        this.hRe = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hRe != null) {
            this.mRootView.addView(this.hRe, childCount, layoutParams);
        }
        cnY();
    }

    public void cnW() {
        if (this.hRe != null) {
            this.mRootView.removeView(this.hRe);
        }
        this.hRe = null;
    }

    public void cnX() {
        this.mHandler.removeCallbacks(this.hRh);
        this.oxf.clearAnimation();
        this.oxf.setAlpha(1.0f);
        this.oxf.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.oxf != null) {
            this.oxf.setImageDrawable(null);
            this.oxf.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
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
                this.oxf.setImageBitmap(this.oxj);
            } else if (TextUtils.isEmpty(str)) {
                this.oxf.setBackgroundResource(a.e.yuyin_sdk_wheat_bg);
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
            if (this.oxg != null && this.oxg.getParent() != null) {
                ((ViewGroup) this.oxg.getParent()).removeView(this.oxg);
                this.oxg.edU();
            }
            try {
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
                dJ(screenFullSize[0], screenFullSize[1]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.oxf.setImageBitmap(bitmap);
        }
    }

    public void edQ() {
        if (this.oxg != null && this.oxg.getParent() != null) {
            ((ViewGroup) this.oxg.getParent()).removeView(this.oxg);
            this.oxg.edU();
        }
    }

    public void setBgVideo(String str) {
        if (!edT() || !TextUtils.equals(this.oxk, str)) {
            this.oxk = str;
            j(ViewCommonUtil.getVisibilityRegion(this.mPageContext.getPageActivity()));
            Wb(str + "/video.mp4");
        }
    }

    public void release() {
        if (this.oxf != null) {
            this.oxf.setImageDrawable(null);
            this.oxf.stopLoad();
        }
        if (this.oxg != null) {
            this.oxg.edU();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.oxi != null && !this.oxi.hRv) {
            z = this.oxi.W(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cnY() {
        if (this.hRf != null && this.hRf.getParent() != null) {
            ((ViewGroup) this.hRf.getParent()).removeView(this.hRf);
        }
        if (this.oxf != null) {
            this.oxf.setVisibility(0);
        }
    }

    public void Wb(String str) {
        if (this.oxg != null && !TextUtils.isEmpty(str)) {
            this.oxg.setVideoPath(str);
            if (!this.oxg.isPlaying()) {
                this.oxg.start();
            }
        }
    }

    public void edR() {
        if (this.oxg != null) {
            this.oxg.pause();
        }
    }

    public void edS() {
        if (this.oxg != null) {
            this.oxg.start();
        }
    }

    public boolean edT() {
        return this.oxg != null && this.oxg.isPlaying();
    }

    private void j(final Rect rect) {
        if (this.oxg != null && this.oxg.getParent() != null) {
            ((ViewGroup) this.oxg.getParent()).removeView(this.oxg);
            this.oxg.edU();
        }
        this.oxg = new BackgroundVideoView(getContext());
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = 1;
        layoutParams.width = 1;
        this.hRc.addView(this.oxg, 0, layoutParams);
        this.oxg.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.3
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
                    AlaLiveRoomBlurPageLayout.this.oxg.setLayoutParams(layoutParams);
                    return false;
                }
                return false;
            }
        });
        this.oxg.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AlaLiveRoomBlurPageLayout.this.oxg.stopPlayback();
                AlaLiveRoomBlurPageLayout.this.oxg.setVisibility(8);
                return true;
            }
        });
    }
}
