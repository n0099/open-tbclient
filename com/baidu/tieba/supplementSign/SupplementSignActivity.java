package com.baidu.tieba.supplementSign;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JsPromptResult;
import c.a.q0.i3.m0.b;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SupplementSignActivity extends TbWebViewActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String INTERFACE_NAME;
    public final String JS_SIGN_SUCCESS;
    public int continuousSignAllDays;
    public int forumId;
    public CustomMessageListener mBuyMemberListener;
    public b mSupplementSignInterface;
    public int signBonusPoint;
    public int supplementSignDays;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SupplementSignActivity f56869a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SupplementSignActivity supplementSignActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {supplementSignActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56869a = supplementSignActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.f56869a.mWebView.loadUrl("javascript:TbJsBridge.refreshRemainDay()");
            }
        }
    }

    public SupplementSignActivity() {
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
        this.JS_SIGN_SUCCESS = "signSuccess";
        this.INTERFACE_NAME = "SupplementSignInterface";
        this.continuousSignAllDays = 0;
        this.supplementSignDays = 0;
        this.signBonusPoint = 0;
        this.mBuyMemberListener = new a(this, 2001194);
        this.mSupplementSignInterface = new b(this) { // from class: com.baidu.tieba.supplementSign.SupplementSignActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SupplementSignActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.q0.i3.m0.b
            public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
                    if ("SupplementSignInterface".equalsIgnoreCase(str) && "signSuccess".equalsIgnoreCase(str2)) {
                        if (!StringUtils.isNull(str3)) {
                            try {
                                JSONObject jSONObject = new JSONObject(str3);
                                this.this$0.continuousSignAllDays = jSONObject.optInt("all");
                                this.this$0.supplementSignDays += jSONObject.optInt("signed", 0);
                                this.this$0.signBonusPoint += jSONObject.optInt("bonus", 0);
                            } catch (Throwable th) {
                                BdLog.e(th);
                            }
                        }
                        jsPromptResult.confirm();
                        return true;
                    }
                    return false;
                }
                return invokeLLLL.booleanValue;
            }
        };
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = new Intent();
            intent.putExtra(SupplementSignActivityConfig.FORUM_ID, this.forumId);
            intent.putExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, this.continuousSignAllDays);
            intent.putExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, this.supplementSignDays);
            intent.putExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, this.signBonusPoint);
            super.finish(-1, intent);
        }
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.E();
        }
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent != null) {
                this.forumId = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
            }
            addJsPromptInterface(this.mSupplementSignInterface);
            this.mView.s(false);
            registerListener(this.mBuyMemberListener);
        }
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            BridgeWebView bridgeWebView = this.mWebView;
            if (bridgeWebView != null) {
                bridgeWebView.destroy();
                this.mWebView = null;
            }
        }
    }
}
