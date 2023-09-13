package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class xz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            switch (i) {
                case 202001:
                case 205001:
                case 309456:
                case CmdConfigHttp.CMD_CHECK_REAL_NAME /* 1003325 */:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xz7.e();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (!BdUtilHelper.isMainThread()) {
                TbadkCoreApplication.getInst().handler.post(new a());
            } else {
                e();
            }
        }
    }

    public static boolean b(NetWork netWork) {
        InterceptResult invokeL;
        int netErrorCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, netWork)) == null) {
            if (netWork == null) {
                return false;
            }
            if (netWork.isNetSuccess()) {
                netErrorCode = netWork.getServerErrorCode();
            } else {
                netErrorCode = netWork.getNetErrorCode();
            }
            if (netErrorCode != 1990055) {
                return false;
            }
            d();
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
            BrowserHelper.startWebActivity(applicationContext, "", UrlSchemaHelper.REAL_NAME_AUTH_URL + "&u=" + URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW), true, true, true, true, true, false);
        }
    }
}
