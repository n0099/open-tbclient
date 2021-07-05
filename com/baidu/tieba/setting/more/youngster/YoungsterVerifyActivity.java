package com.baidu.tieba.setting.more.youngster;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.l.e;
/* loaded from: classes5.dex */
public class YoungsterVerifyActivity extends TbWebViewActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int from;
    public YoungsterVerifyModel youngsterVerifyModel;

    /* loaded from: classes5.dex */
    public class a implements YoungsterVerifyModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YoungsterVerifyActivity f20785a;

        public a(YoungsterVerifyActivity youngsterVerifyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterVerifyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20785a = youngsterVerifyActivity;
        }

        @Override // com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel.b
        public void onError(ErrorData errorData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, errorData) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921489));
                this.f20785a.getPageContext().getPageActivity().finish();
            }
        }

        @Override // com.baidu.tieba.setting.more.youngster.model.YoungsterVerifyModel.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f20785a.getPageContext().getPageActivity());
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(4);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.f20785a.from);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                this.f20785a.getPageContext().getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends TbWebViewActivity.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ YoungsterVerifyActivity f20786c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(YoungsterVerifyActivity youngsterVerifyActivity) {
            super(youngsterVerifyActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterVerifyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((TbWebViewActivity) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20786c = youngsterVerifyActivity;
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.t, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                TbSingleton.getInstance().setCanWebViewActivityShowProgress(true);
            }
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.t, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // com.baidu.tbadk.browser.TbWebViewActivity.t, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                if (!StringUtils.isNull(str) && str.contains(TbConfig.URL_YOUNGSTER_VERIFY_AUTHID)) {
                    this.f20786c.youngsterVerifyModel.B(UrlUtil.getUrlField(str, YoungsterVerifyActivityConfig.PARAMA_AUTH_ID));
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    public YoungsterVerifyActivity() {
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

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            e eVar = this.mView;
            if (eVar != null) {
                eVar.E();
            }
        }
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            e eVar = this.mView;
            if (eVar != null) {
                eVar.E();
            }
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                bridgeWebView.setWebViewClient(new b(this));
            }
            TbSingleton.getInstance().setCanWebViewActivityShowProgress(false);
            this.youngsterVerifyModel = new YoungsterVerifyModel(getPageContext(), new a(this));
            Intent intent = getIntent();
            if (intent != null) {
                this.from = intent.getIntExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, 0);
            }
        }
    }
}
