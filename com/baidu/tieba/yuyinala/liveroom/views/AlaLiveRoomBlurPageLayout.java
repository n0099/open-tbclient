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
/* loaded from: classes10.dex */
public class AlaLiveRoomBlurPageLayout extends FrameLayout implements e {
    private FrameLayout hSN;
    private View hSP;
    private FrameLayout hSQ;
    private TextView hSR;
    Runnable hSS;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private ViewGroup mRootView;
    private TbImageView oEP;
    private BackgroundVideoView oEQ;
    private View oER;
    private AlaLiveView oES;
    private Bitmap oET;
    private String oEU;

    public AlaLiveRoomBlurPageLayout(Context context) {
        super(context);
        this.oEP = null;
        this.oER = null;
        this.oES = null;
        this.hSP = null;
        this.hSQ = null;
        this.hSR = null;
        this.hSS = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oEP.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oEP.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oEP.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oEP.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oEP = null;
        this.oER = null;
        this.oES = null;
        this.hSP = null;
        this.hSQ = null;
        this.hSR = null;
        this.hSS = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oEP.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oEP.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oEP.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oEP.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    public AlaLiveRoomBlurPageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oEP = null;
        this.oER = null;
        this.oES = null;
        this.hSP = null;
        this.hSQ = null;
        this.hSR = null;
        this.hSS = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.1
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
                        AlaLiveRoomBlurPageLayout.this.oEP.setAlpha(0.0f);
                        AlaLiveRoomBlurPageLayout.this.oEP.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                AlaLiveRoomBlurPageLayout.this.oEP.clearAnimation();
                AlaLiveRoomBlurPageLayout.this.oEP.startAnimation(alphaAnimation);
            }
        };
        init();
    }

    private void init() {
        Log.i("LiveRoomBlurPageLayout", "@@ context = " + getContext());
        this.mRootView = (ViewGroup) View.inflate(getContext(), a.g.yuyin_ala_liveroom_audience_blur_layout, this);
        setClipChildren(false);
        this.oEP = (TbImageView) findViewById(a.f.ala_liveroom_background_img);
        this.oET = drawableToBitmap(new ColorDrawable(getResources().getColor(a.c.sdk_color_333333)));
        this.hSN = new FrameLayout(getContext());
        this.hSN.setId(a.f.ala_liveroom_player_container_view);
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
        if (this.oEP != null) {
            ViewGroup.LayoutParams layoutParams = this.oEP.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.oEP.setLayoutParams(layoutParams);
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
            if (this.hSQ != null && this.hSQ.getParent() != null) {
                ViewGroup.LayoutParams layoutParams = this.hSQ.getLayoutParams();
                layoutParams.width = screenFullSize[0];
                layoutParams.height = screenFullSize[1] - 0;
                this.hSQ.setLayoutParams(layoutParams);
            }
        }
    }

    public void a(AlaLiveView alaLiveView, ViewGroup.LayoutParams layoutParams) {
        if (alaLiveView != null) {
            if (this.mRootView.indexOfChild(alaLiveView) < 0 && this.mRootView.getChildCount() > 1) {
                this.oES = alaLiveView;
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
            cls();
        }
    }

    public void clp() {
        if (this.oES != null) {
            this.mRootView.removeView(this.oES);
        }
        this.oES = null;
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
        if (this.hSN.getParent() != null) {
            this.mRootView.removeView(this.hSN);
        }
        this.mRootView.addView(this.hSN, 1);
        if (this.oER != null && this.oER.getParent() != null) {
            ((ViewGroup) this.oER.getParent()).removeView(this.oER);
        }
        this.oER = view;
        if (this.oER != null && this.oER.getParent() != null) {
            ((ViewGroup) this.oER.getParent()).removeView(this.oER);
        }
        if (this.oER != null) {
            if (layoutParams != null) {
                this.hSN.addView(this.oER, layoutParams);
            } else {
                this.hSN.addView(this.oER, this.oER.getLayoutParams());
            }
        }
    }

    public void Xl() {
        if (this.hSN.getParent() != null) {
            ((ViewGroup) this.hSN.getParent()).removeView(this.hSN);
        }
        if (this.oEQ != null && this.oEQ.getParent() != null) {
            ((ViewGroup) this.oEQ.getParent()).removeView(this.oEQ);
        }
        this.oEQ = null;
    }

    public boolean cz(View view) {
        return (this.hSN == null || this.hSN.getParent() == null || this.hSN.indexOfChild(view) < 0) ? false : true;
    }

    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.hSP != null && this.mRootView.indexOfChild(this.hSP) >= 0) {
            this.mRootView.removeView(this.hSP);
        }
        this.hSP = view;
        int childCount = this.mRootView.getChildCount() - 1;
        int childCount2 = this.mRootView.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (this.mRootView.getChildAt(i).getId() == a.f.ala_live_room_close_btn_layout) {
                childCount = Math.max(childCount, i);
            }
        }
        if (this.hSP != null) {
            this.mRootView.addView(this.hSP, childCount, layoutParams);
        }
        cls();
    }

    public void clq() {
        if (this.hSP != null) {
            this.mRootView.removeView(this.hSP);
        }
        this.hSP = null;
    }

    public void clr() {
        this.mHandler.removeCallbacks(this.hSS);
        this.oEP.clearAnimation();
        this.oEP.setAlpha(1.0f);
        this.oEP.setVisibility(0);
    }

    public void setBackImageBlack(AlaLiveInfoData alaLiveInfoData) {
        if ((alaLiveInfoData == null || alaLiveInfoData.screen_direction != 2) && this.oEP != null) {
            this.oEP.setImageDrawable(null);
            this.oEP.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_transparent));
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
                this.oEP.setImageBitmap(this.oET);
            } else if (TextUtils.isEmpty(str)) {
                this.oEP.setBackgroundResource(a.e.yuyin_sdk_wheat_bg);
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
            if (this.oEQ != null && this.oEQ.getParent() != null) {
                ((ViewGroup) this.oEQ.getParent()).removeView(this.oEQ);
                this.oEQ.ecG();
            }
            try {
                int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mPageContext.getPageActivity());
                dH(screenFullSize[0], screenFullSize[1]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            this.oEP.setImageBitmap(bitmap);
        }
    }

    public void ecC() {
        if (this.oEQ != null && this.oEQ.getParent() != null) {
            ((ViewGroup) this.oEQ.getParent()).removeView(this.oEQ);
            this.oEQ.ecG();
        }
    }

    public void setBgVideo(String str) {
        if (!ecF() || !TextUtils.equals(this.oEU, str)) {
            this.oEU = str;
            j(ViewCommonUtil.getVisibilityRegion(this.mPageContext.getPageActivity()));
            Wk(str + "/video.mp4");
        }
    }

    public void release() {
        if (this.oEP != null) {
            this.oEP.setImageDrawable(null);
            this.oEP.stopLoad();
        }
        if (this.oEQ != null) {
            this.oEQ.ecG();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.oES != null && !this.oES.hTg) {
            z = this.oES.X(motionEvent);
        }
        if (z || motionEvent.getAction() == 0) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cls() {
        if (this.hSQ != null && this.hSQ.getParent() != null) {
            ((ViewGroup) this.hSQ.getParent()).removeView(this.hSQ);
        }
        if (this.oEP != null) {
            this.oEP.setVisibility(0);
        }
    }

    public void Wk(String str) {
        if (this.oEQ != null && !TextUtils.isEmpty(str)) {
            this.oEQ.setVideoPath(str);
            if (!this.oEQ.isPlaying()) {
                this.oEQ.start();
            }
        }
    }

    public void ecD() {
        if (this.oEQ != null) {
            this.oEQ.pause();
        }
    }

    public void ecE() {
        if (this.oEQ != null) {
            this.oEQ.start();
        }
    }

    public boolean ecF() {
        return this.oEQ != null && this.oEQ.isPlaying();
    }

    private void j(final Rect rect) {
        if (this.oEQ != null && this.oEQ.getParent() != null) {
            ((ViewGroup) this.oEQ.getParent()).removeView(this.oEQ);
            this.oEQ.ecG();
        }
        this.oEQ = new BackgroundVideoView(getContext());
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = 1;
        layoutParams.width = 1;
        this.hSN.addView(this.oEQ, 0, layoutParams);
        this.oEQ.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.3
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
                    AlaLiveRoomBlurPageLayout.this.oEQ.setLayoutParams(layoutParams);
                    return false;
                }
                return false;
            }
        });
        this.oEQ.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AlaLiveRoomBlurPageLayout.this.oEQ.stopPlayback();
                AlaLiveRoomBlurPageLayout.this.oEQ.setVisibility(8);
                return true;
            }
        });
    }
}
