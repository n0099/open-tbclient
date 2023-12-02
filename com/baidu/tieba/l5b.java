package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes7.dex */
public final class l5b {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895280, "Lcom/baidu/tieba/l5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895280, "Lcom/baidu/tieba/l5b;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

        public final Activity a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Activity curGlobalActivity = TbadkCoreApplication.getInst().getCurGlobalActivity();
                if (curGlobalActivity == null) {
                    return BdActivityStack.getInst().currentActivity();
                }
                return curGlobalActivity;
            }
            return (Activity) invokeV.objValue;
        }

        public static /* synthetic */ boolean d(a aVar, Context context, String str, String str2, String str3, boolean z, int i, Object obj) {
            boolean z2;
            if ((i & 16) != 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            return aVar.c(context, str, str2, str3, z2);
        }

        public final TbPageContext<?> b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                if (context == null || !(context instanceof TbPageContextSupport)) {
                    return null;
                }
                return ((TbPageContextSupport) context).getPageContext();
            }
            return (TbPageContext) invokeL.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public final boolean c(Context context, String str, String str2, String str3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z)})) == null) {
                if (context == null || (context instanceof Application)) {
                    context = a();
                }
                boolean f = f(context, str, str3);
                if (!f) {
                    return e(b(context), str2, z);
                }
                return f;
            }
            return invokeCommon.booleanValue;
        }

        public final boolean e(TbPageContext<?> tbPageContext, String str, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, tbPageContext, str, z)) == null) {
                if (StringUtils.isNull(str) || tbPageContext == null) {
                    return false;
                }
                Bundle bundle = new Bundle();
                if (bundle.get(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM) == null) {
                    bundle.putBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, z);
                }
                return UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str}, bundle);
            }
            return invokeLLZ.booleanValue;
        }

        public final boolean f(Context context, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, str2)) == null) {
                if (context == null || StringUtils.isNull(str)) {
                    return false;
                }
                if (StringUtils.isNotNull(str2) && !UtilHelper.isAppAvilible(str2)) {
                    return false;
                }
                Intent intent = UtilHelper.getIntent(str);
                if (!UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                    return false;
                }
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
            return invokeLLL.booleanValue;
        }
    }
}
