package com.baidu.tieba.recapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity;
import com.baidu.tieba.ad.browser.newstyle.TBAdWebView;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.w2.f0.b.f;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class AdWebVideoActivity extends AdWebViewActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static b STATISTIC_DATA = null;
    public static final String TAG = "NewWebVideoActivity: ";
    public transient /* synthetic */ FieldHolder $fh;
    public int mGoodsStyle;
    public int mPausePos;
    public WebViewContainer.OnScrollChangedCallback mScrollCallback;
    public String mThumbUrl;
    public int mVideoDuration;
    public int mVideoHeight;
    public float mVideoRatio;
    public f mVideoTailFrame;
    public String mVideoUrl;
    public DistributeVideoView mVideoView;
    public WebViewContainer mWebContainer;
    public int mWebViewTopMargin;

    /* loaded from: classes4.dex */
    public class a implements WebViewContainer.OnScrollChangedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdWebVideoActivity f20608a;

        public a(AdWebVideoActivity adWebVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20608a = adWebVideoActivity;
        }

        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f20608a.mWebViewTopMargin -= i3;
                if (this.f20608a.mWebViewTopMargin <= 0) {
                    this.f20608a.mVideoView.stopPlay(this.f20608a.mVideoView.getPlayStatus() != 2);
                } else if (this.f20608a.mWebViewTopMargin < this.f20608a.mPausePos) {
                    this.f20608a.mVideoView.pausePlay(1);
                } else if (this.f20608a.mVideoView.getPlayStatus() == 2) {
                    this.f20608a.mVideoView.autoContinue();
                } else if (this.f20608a.mVideoView.getPlayStatus() == -1) {
                    this.f20608a.mVideoView.autoPlay(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AdvertAppInfo f20609a;

        /* renamed from: b  reason: collision with root package name */
        public int f20610b;

        /* renamed from: c  reason: collision with root package name */
        public String f20611c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public AdWebVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mScrollCallback = new a(this);
    }

    private void configWebviewParams(int i2) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) || (layoutParams = (FrameLayout.LayoutParams) this.mWebView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.topMargin = i2;
        layoutParams.height = (l.i(getActivity()) - l.r(getActivity())) - getToolBarHeight();
        this.mWebView.setLayoutParams(layoutParams);
    }

    private int getToolBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? l.g(this, R.dimen.ds98) : invokeV.intValue;
    }

    public static void setConfigAndJump(AdWebVideoActivityConfig adWebVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, adWebVideoActivityConfig) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, adWebVideoActivityConfig));
        }
    }

    public static void setStaticInfo(AdvertAppInfo advertAppInfo, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, advertAppInfo, i2, str) == null) {
            b bVar = new b();
            STATISTIC_DATA = bVar;
            bVar.f20609a = advertAppInfo;
            bVar.f20611c = str;
            bVar.f20610b = i2;
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.new_ad_web_video_view, (ViewGroup) null, false);
            this.mWebContainer = (WebViewContainer) frameLayout.findViewById(R.id.web_scroll);
            this.mWebView = (TBAdWebView) frameLayout.findViewById(R.id.web_web);
            configWebView();
            this.mVideoView = (DistributeVideoView) frameLayout.findViewById(R.id.web_video);
            if (!TextUtils.isEmpty(this.mVideoUrl) && !TextUtils.isEmpty(this.mThumbUrl)) {
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_url = this.mVideoUrl;
                builder.thumbnail_url = this.mThumbUrl;
                builder.video_duration = Integer.valueOf(this.mVideoDuration);
                if (this.mGoodsStyle == 14) {
                    Integer valueOf = Integer.valueOf(l.k(getActivity()));
                    builder.video_height = valueOf;
                    builder.video_width = Integer.valueOf(d.a.q0.w2.f0.c.a.c(valueOf.intValue()));
                } else {
                    Integer valueOf2 = Integer.valueOf(l.k(getActivity()));
                    builder.video_width = valueOf2;
                    builder.video_height = valueOf2;
                    if (this.mVideoRatio > 0.0f) {
                        builder.video_height = Integer.valueOf((int) (valueOf2.intValue() / this.mVideoRatio));
                    }
                }
                VideoInfo build = builder.build(false);
                int intValue = build.video_height.intValue();
                this.mWebViewTopMargin = intValue;
                this.mWebContainer.setTopMargin(intValue);
                this.mWebContainer.setTopLimit(this.mWebViewTopMargin);
                this.mWebContainer.setOnScrollChangeListener(this.mScrollCallback);
                this.mWebContainer.setStyle(TbadkCoreApplication.getInst().getAdVideoPageStyle());
                int intValue2 = build.video_height.intValue();
                this.mVideoHeight = intValue2;
                this.mPausePos = intValue2 / 2;
                f fVar = this.mVideoTailFrame;
                if (fVar != null) {
                    this.mVideoView.setVideoTailFrameData(fVar);
                }
                this.mVideoView.setPageContext(getPageContext());
                this.mVideoView.setData(build, 2, getPageContext());
                this.mVideoView.setTailFrameIsMiddlePage(true);
                this.mVideoView.initVideoViewLayout(this.mGoodsStyle == 14);
                b bVar = STATISTIC_DATA;
                if (bVar != null) {
                    this.mVideoView.updateTailFrameView(bVar.f20609a);
                    DistributeVideoView distributeVideoView = this.mVideoView;
                    b bVar2 = STATISTIC_DATA;
                    distributeVideoView.setStatisticInfo(bVar2.f20609a, bVar2.f20610b, bVar2.f20611c);
                } else {
                    this.mVideoView.updateTailFrameView(null);
                }
                this.mVideoView.autoPlay(0);
                configWebviewParams(build.video_height.intValue());
            } else {
                this.mVideoView.setVisibility(8);
            }
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.mVideoUrl = intent.getStringExtra("video_url");
                this.mThumbUrl = intent.getStringExtra(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
                this.mVideoRatio = intent.getFloatExtra(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
                this.mVideoDuration = intent.getIntExtra(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
                this.mGoodsStyle = intent.getIntExtra(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
                String stringExtra = intent.getStringExtra(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
                if (!TextUtils.isEmpty(stringExtra)) {
                    f fVar = new f();
                    this.mVideoTailFrame = fVar;
                    fVar.c(stringExtra);
                }
            } else if (bundle != null) {
                this.mVideoUrl = bundle.getString("video_url");
                this.mThumbUrl = bundle.getString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
                this.mVideoRatio = bundle.getFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
                this.mVideoDuration = bundle.getInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
                this.mGoodsStyle = bundle.getInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
            } else {
                BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
            }
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            DistributeVideoView distributeVideoView = this.mVideoView;
            if (distributeVideoView != null) {
                distributeVideoView.stopPlay(distributeVideoView.getPlayStatus() != 2);
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mWebViewTopMargin > 0 && (distributeVideoView = this.mVideoView) != null) {
                distributeVideoView.stopPlay(distributeVideoView.getPlayStatus() != 2);
            }
            super.onPause();
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 == -2) {
            return;
        }
        super.onReceivedError(i2);
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.mWebViewTopMargin > this.mPausePos && (distributeVideoView = this.mVideoView) != null) {
                distributeVideoView.autoPlay(0);
            }
            super.onResume();
        }
    }
}
