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
import com.repackage.nc8;
import com.repackage.oc8;
import com.repackage.oi;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
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
    public nc8 mVideoTailFrame;
    public String mVideoUrl;
    public DistributeVideoView mVideoView;
    public WebViewContainer mWebContainer;
    public int mWebViewTopMargin;

    /* loaded from: classes3.dex */
    public class a implements WebViewContainer.OnScrollChangedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdWebVideoActivity a;

        public a(AdWebVideoActivity adWebVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adWebVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adWebVideoActivity;
        }

        @Override // com.baidu.tieba.recapp.view.WebViewContainer.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.mWebViewTopMargin -= i2;
                if (this.a.mWebViewTopMargin < this.a.mPausePos) {
                    this.a.mVideoView.stopPlay(this.a.mVideoView.getPlayStatus() != 2);
                } else if (this.a.mVideoView.getPlayStatus() == 2) {
                    this.a.mVideoView.autoContinue();
                } else if (this.a.mVideoView.getPlayStatus() == -1) {
                    this.a.mVideoView.autoPlay(0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdvertAppInfo a;
        public int b;
        public String c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mScrollCallback = new a(this);
    }

    private void configWebviewParams(int i) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65541, this, i) == null) || (layoutParams = (FrameLayout.LayoutParams) this.mWebView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.topMargin = i;
        layoutParams.height = (oi.i(getActivity()) - oi.r(getActivity())) - getToolBarHeight();
        this.mWebView.setLayoutParams(layoutParams);
    }

    private int getToolBarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? oi.f(this, R.dimen.obfuscated_res_0x7f070282) : invokeV.intValue;
    }

    public static void setConfigAndJump(AdWebVideoActivityConfig adWebVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, adWebVideoActivityConfig) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, adWebVideoActivityConfig));
        }
    }

    public static void setStaticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, advertAppInfo, i, str) == null) {
            b bVar = new b();
            STATISTIC_DATA = bVar;
            bVar.a = advertAppInfo;
            bVar.c = str;
            bVar.b = i;
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d05f2, (ViewGroup) null, false);
            this.mWebContainer = (WebViewContainer) frameLayout.findViewById(R.id.obfuscated_res_0x7f092423);
            this.mWebView = (TBAdWebView) frameLayout.findViewById(R.id.obfuscated_res_0x7f092425);
            configWebView();
            this.mVideoView = (DistributeVideoView) frameLayout.findViewById(R.id.obfuscated_res_0x7f092424);
            if (!TextUtils.isEmpty(this.mVideoUrl) && !TextUtils.isEmpty(this.mThumbUrl)) {
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_url = this.mVideoUrl;
                builder.thumbnail_url = this.mThumbUrl;
                builder.video_duration = Integer.valueOf(this.mVideoDuration);
                if (this.mGoodsStyle == 14) {
                    Integer valueOf = Integer.valueOf(oi.k(getActivity()));
                    builder.video_height = valueOf;
                    builder.video_width = Integer.valueOf(oc8.c(valueOf.intValue()));
                } else {
                    Integer valueOf2 = Integer.valueOf(oi.k(getActivity()));
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
                nc8 nc8Var = this.mVideoTailFrame;
                if (nc8Var != null) {
                    this.mVideoView.setVideoTailFrameData(nc8Var);
                }
                this.mVideoView.setPageContext(getPageContext());
                this.mVideoView.setData(build, 2, getPageContext());
                this.mVideoView.setTailFrameIsMiddlePage(true);
                this.mVideoView.initVideoViewLayout(this.mGoodsStyle == 14);
                b bVar = STATISTIC_DATA;
                if (bVar != null) {
                    this.mVideoView.updateTailFrameView(bVar.a);
                    DistributeVideoView distributeVideoView = this.mVideoView;
                    b bVar2 = STATISTIC_DATA;
                    distributeVideoView.setStatisticInfo(bVar2.a, bVar2.b, bVar2.c);
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
                    nc8 nc8Var = new nc8();
                    this.mVideoTailFrame = nc8Var;
                    nc8Var.c(stringExtra);
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
    public void onReceivedError(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || i == -2) {
            return;
        }
        super.onReceivedError(i);
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
