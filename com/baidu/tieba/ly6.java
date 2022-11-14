package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.MtjConfig;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.qu8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ly6 implements qu8.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ly6() {
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
        String version = TbConfig.getVersion();
        if (!TextUtils.isEmpty(version)) {
            StatService.setAppVersionName(TbadkCoreApplication.getInst(), version);
        }
    }

    @Override // com.baidu.tieba.qu8.a
    public void a(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, application) == null) {
            StatService.enableAppList(application, false);
        }
    }

    @Override // com.baidu.tieba.qu8.a
    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            StatService.setFeedTrack(MtjConfig.FeedTrackStrategy.TRACK_NONE);
            StatService.autoTrace(context);
        }
    }

    @Override // com.baidu.tieba.qu8.a
    public void c(Context context, WebView webView, WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, webView, webChromeClient) == null) {
            StatService.trackWebView(context, webView, webChromeClient);
        }
    }

    @Override // com.baidu.tieba.qu8.a
    public void d(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, context, str, z) == null) {
            StatService.setAppChannel(context, str, z);
        }
    }
}
