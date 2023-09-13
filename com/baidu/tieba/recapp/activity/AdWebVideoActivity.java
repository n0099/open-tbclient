package com.baidu.tieba.recapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity;
import com.baidu.tieba.ad.browser.newstyle.TBAdWebView;
import com.baidu.tieba.o4a;
import com.baidu.tieba.p4a;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.tieba.recapp.view.WebViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class AdWebVideoActivity extends AdWebViewActivity {
    public static /* synthetic */ Interceptable $ic;
    public static b P;
    public transient /* synthetic */ FieldHolder $fh;
    public DistributeVideoView D;
    public WebViewContainer E;
    public String F;
    public String G;
    public float H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public o4a N;
    public WebViewContainer.OnScrollChangedCallback O;

    /* loaded from: classes7.dex */
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
                AdWebVideoActivity.S1(this.a, i2);
                boolean z = false;
                if (this.a.K < this.a.L) {
                    DistributeVideoView distributeVideoView = this.a.D;
                    if (this.a.D.getPlayStatus() != 2) {
                        z = true;
                    }
                    distributeVideoView.stopPlay(z);
                } else if (this.a.D.getPlayStatus() == 2) {
                    this.a.D.autoContinue();
                } else if (this.a.D.getPlayStatus() == -1) {
                    this.a.D.autoPlay(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.O = new a(this);
    }

    public final int X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return BdUtilHelper.getDimens(this, R.dimen.obfuscated_res_0x7f070282);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            DistributeVideoView distributeVideoView = this.D;
            if (distributeVideoView != null) {
                if (distributeVideoView.getPlayStatus() != 2) {
                    z = true;
                } else {
                    z = false;
                }
                distributeVideoView.stopPlay(z);
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        DistributeVideoView distributeVideoView;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.K > 0 && (distributeVideoView = this.D) != null) {
                if (distributeVideoView.getPlayStatus() != 2) {
                    z = true;
                } else {
                    z = false;
                }
                distributeVideoView.stopPlay(z);
            }
            super.onPause();
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.K > this.L && (distributeVideoView = this.D) != null) {
                distributeVideoView.autoPlay(0);
            }
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public void onReceivedError(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || i == -2) {
            return;
        }
        super.onReceivedError(i);
    }

    public static /* synthetic */ int S1(AdWebVideoActivity adWebVideoActivity, int i) {
        int i2 = adWebVideoActivity.K - i;
        adWebVideoActivity.K = i2;
        return i2;
    }

    public final void W1(int i) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (layoutParams = (FrameLayout.LayoutParams) this.t.getLayoutParams()) != null) {
            layoutParams.topMargin = i;
            layoutParams.height = (BdUtilHelper.getEquipmentHeight(getActivity()) - BdUtilHelper.getStatusBarHeight(getActivity())) - X1();
            this.t.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity
    public View createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d070d, (ViewGroup) null, false);
            this.E = (WebViewContainer) frameLayout.findViewById(R.id.obfuscated_res_0x7f092a4b);
            this.t = (TBAdWebView) frameLayout.findViewById(R.id.obfuscated_res_0x7f092a4d);
            E1();
            this.D = (DistributeVideoView) frameLayout.findViewById(R.id.obfuscated_res_0x7f092a4c);
            if (!TextUtils.isEmpty(this.F) && !TextUtils.isEmpty(this.G)) {
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_url = this.F;
                builder.thumbnail_url = this.G;
                builder.video_duration = Integer.valueOf(this.I);
                if (this.M == 14) {
                    Integer valueOf = Integer.valueOf(BdUtilHelper.getEquipmentWidth(getActivity()));
                    builder.video_height = valueOf;
                    builder.video_width = Integer.valueOf(p4a.c(valueOf.intValue()));
                } else {
                    Integer valueOf2 = Integer.valueOf(BdUtilHelper.getEquipmentWidth(getActivity()));
                    builder.video_width = valueOf2;
                    builder.video_height = valueOf2;
                    if (this.H > 0.0f) {
                        builder.video_height = Integer.valueOf((int) (valueOf2.intValue() / this.H));
                    }
                }
                VideoInfo build = builder.build(false);
                int intValue = build.video_height.intValue();
                this.K = intValue;
                this.E.setTopMargin(intValue);
                this.E.setTopLimit(this.K);
                this.E.setOnScrollChangeListener(this.O);
                this.E.setStyle(TbadkCoreApplication.getInst().getAdVideoPageStyle());
                int intValue2 = build.video_height.intValue();
                this.J = intValue2;
                this.L = intValue2 / 2;
                o4a o4aVar = this.N;
                if (o4aVar != null) {
                    this.D.setVideoTailFrameData(o4aVar);
                }
                this.D.setPageContext(getPageContext());
                this.D.setData(build, 2, getPageContext());
                boolean z = true;
                this.D.setTailFrameIsMiddlePage(true);
                DistributeVideoView distributeVideoView = this.D;
                if (this.M != 14) {
                    z = false;
                }
                distributeVideoView.initVideoViewLayout(z);
                b bVar = P;
                if (bVar != null) {
                    this.D.updateTailFrameView(bVar.a);
                    DistributeVideoView distributeVideoView2 = this.D;
                    b bVar2 = P;
                    distributeVideoView2.setStatisticInfo(bVar2.a, bVar2.b, bVar2.c);
                } else {
                    this.D.updateTailFrameView(null);
                }
                this.D.autoPlay(0);
                W1(build.video_height.intValue());
            } else {
                this.D.setVisibility(8);
            }
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ad.browser.newstyle.AdWebViewActivity, com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.F = intent.getStringExtra("video_url");
                this.G = intent.getStringExtra(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
                this.H = intent.getFloatExtra(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
                this.I = intent.getIntExtra(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
                this.M = intent.getIntExtra(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
                String stringExtra = intent.getStringExtra(AdWebVideoActivityConfig.KEY_TAIL_FRAME);
                if (!TextUtils.isEmpty(stringExtra)) {
                    o4a o4aVar = new o4a();
                    this.N = o4aVar;
                    o4aVar.c(stringExtra);
                }
            } else if (bundle != null) {
                this.F = bundle.getString("video_url");
                this.G = bundle.getString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL);
                this.H = bundle.getFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.0f);
                this.I = bundle.getInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0);
                this.M = bundle.getInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
            } else {
                BdLog.e("NewWebVideoActivity: onCreate invalid parameters");
            }
            super.onCreate(bundle);
        }
    }
}
