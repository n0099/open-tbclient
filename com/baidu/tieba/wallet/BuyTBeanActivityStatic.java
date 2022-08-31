package com.baidu.tieba.wallet;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.ha5;
import com.baidu.tieba.la5;
import com.baidu.tieba.wf5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BuyTBeanActivityStatic {
    public static /* synthetic */ Interceptable $ic = null;
    public static String Tag = "tag";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2092348248, "Lcom/baidu/tieba/wallet/BuyTBeanActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2092348248, "Lcom/baidu/tieba/wallet/BuyTBeanActivityStatic;");
                return;
            }
        }
        registerBuyTbeanJump();
    }

    public BuyTBeanActivityStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void registerBuyTbeanJump() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.wallet.BuyTBeanActivityStatic.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
                public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                        if (tbPageContext != null && strArr != null && strArr.length != 0) {
                            String str = strArr[0];
                            if (StringUtils.isNull(str)) {
                                return 3;
                            }
                            if (str.contains("tdoudiscount:")) {
                                CurrencyJumpHelper.gotoBuyTBeanPage(tbPageContext.getPageActivity(), 0.0f, wf5.d(str, MemberPayStatistic.REFER_PAGE), wf5.d(str, MemberPayStatistic.CLICK_ZONE), new ha5(this) { // from class: com.baidu.tieba.wallet.BuyTBeanActivityStatic.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$0;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                    }

                                    @Override // com.baidu.tieba.ha5
                                    public void onFail(int i, String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i, str2) == null) {
                                            TbWebViewActivity.YYPayResultCallback4CallJs.i();
                                        }
                                    }

                                    @Override // com.baidu.tieba.ha5
                                    public void onSuccess(la5 la5Var) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, la5Var) == null) {
                                            TbWebViewActivity.YYPayResultCallback4CallJs.i();
                                        }
                                    }
                                });
                                return 0;
                            }
                            Bundle i = wf5.i(str);
                            if (i != null && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && UrlSchemaHelper.PAY_TBEAN_PAGE.equalsIgnoreCase(i.getString("path"))) {
                                CurrencyJumpHelper.gotoBuyTBeanPage(tbPageContext.getPageActivity(), 0.0f, wf5.d(str, MemberPayStatistic.REFER_PAGE), wf5.d(str, MemberPayStatistic.CLICK_ZONE));
                                return 0;
                            }
                        }
                        return 3;
                    }
                    return invokeLL.intValue;
                }
            });
        }
    }
}
