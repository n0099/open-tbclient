package com.baidu.tieba.supplementSign;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.TBWebContainerActivity;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.bxa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class NewSupplementSignActivity extends TBWebContainerActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int X;
    public int Y;
    public int Z;
    public int a0;
    public CustomMessageListener b0;
    public bxa c0;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSupplementSignActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewSupplementSignActivity newSupplementSignActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSupplementSignActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSupplementSignActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.a.loadUrl("javascript:TbJsBridge.refreshRemainDay()");
            }
        }
    }

    public NewSupplementSignActivity() {
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
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = new a(this, 2001194);
        this.c0 = new bxa(this) { // from class: com.baidu.tieba.supplementSign.NewSupplementSignActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NewSupplementSignActivity this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.bxa
            public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                InterceptResult invokeLLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
                    if (!"SupplementSignInterface".equalsIgnoreCase(str) || !"signSuccess".equalsIgnoreCase(str2) || StringUtils.isNull(str3)) {
                        return false;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        this.this$0.Y = jSONObject.optInt("all");
                        NewSupplementSignActivity.w1(this.this$0, jSONObject.optInt("signed", 0));
                        NewSupplementSignActivity.x1(this.this$0, jSONObject.optInt("bonus", 0));
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                    if (jsPromptResult != null) {
                        jsPromptResult.confirm();
                        return true;
                    }
                    return true;
                }
                return invokeLLLL.booleanValue;
            }
        };
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = new Intent();
            intent.putExtra(SupplementSignActivityConfig.FORUM_ID, this.X);
            intent.putExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, this.Y);
            intent.putExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, this.Z);
            intent.putExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, this.a0);
            super.finish(-1, intent);
        }
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.O();
        }
    }

    public static /* synthetic */ int w1(NewSupplementSignActivity newSupplementSignActivity, int i) {
        int i2 = newSupplementSignActivity.Z + i;
        newSupplementSignActivity.Z = i2;
        return i2;
    }

    public static /* synthetic */ int x1(NewSupplementSignActivity newSupplementSignActivity, int i) {
        int i2 = newSupplementSignActivity.a0 + i;
        newSupplementSignActivity.a0 = i2;
        return i2;
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent != null) {
                this.X = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
            }
            HybridLog.getInstance().i("resign", "补签页：新浏览框架");
            addJsPromptInterface(this.c0);
            this.mView.C(false);
            registerListener(this.b0);
        }
    }

    @Override // com.baidu.tbadk.browser.TBWebContainerActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            TbWebView tbWebView = this.a;
            if (tbWebView != null) {
                tbWebView.onDestroy();
                this.a = null;
            }
        }
    }
}
