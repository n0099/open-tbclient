package com.baidu.tieba.tbean;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbean.message.GetBigTbeanWalletH5ResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiHttpResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiResponseMessage;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad5;
import com.repackage.ig8;
import com.repackage.n75;
import com.repackage.s75;
/* loaded from: classes4.dex */
public class BuyTBeanActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.tbean.BuyTBeanActivityStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0231a implements n75 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0231a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.n75
            public void a(s75 s75Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s75Var) == null) {
                    TbWebViewActivity.YYPayResultCallback4CallJs.j();
                }
            }

            @Override // com.repackage.n75
            public void onFail(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    TbWebViewActivity.YYPayResultCallback4CallJs.j();
                }
            }
        }

        public a() {
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

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (StringUtils.isNull(str)) {
                        return 3;
                    }
                    if (str.contains("tdoudiscount:")) {
                        CurrencyJumpHelper.gotoBuyTBeanPage(tbPageContext.getPageActivity(), 0.0f, ad5.d(str, MemberPayStatistic.REFER_PAGE), ad5.d(str, MemberPayStatistic.CLICK_ZONE), new C0231a(this));
                        return 0;
                    }
                    Bundle i = ad5.i(str);
                    if (i != null && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && UrlSchemaHelper.PAY_TBEAN_PAGE.equalsIgnoreCase(i.getString("path"))) {
                        CurrencyJumpHelper.gotoBuyTBeanPage(tbPageContext.getPageActivity(), 0.0f, ad5.d(str, MemberPayStatistic.REFER_PAGE), ad5.d(str, MemberPayStatistic.CLICK_ZONE));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-667288537, "Lcom/baidu/tieba/tbean/BuyTBeanActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-667288537, "Lcom/baidu/tieba/tbean/BuyTBeanActivityStatic;");
                return;
            }
        }
        TbadkApplication.getInst().RegisterIntent(BuyTBeanActivityConfig.class, BuyTBeanActivity.class);
        ig8.f(306001, GetYinJiResponseMessage.class, false);
        c();
        a();
        b();
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

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            UrlManager.getInstance().addListener(new a());
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_BIG_TBEAN_URL, TbConfig.SERVER_ADDRESS + BuyTBeanModel.GET_BIG_TBEAN_WALLET_H5);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setResponsedClass(GetBigTbeanWalletH5ResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_YINJI, ig8.a(BuyTBeanModel.GET_ICON_URL, 306001));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(GetYinJiHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
