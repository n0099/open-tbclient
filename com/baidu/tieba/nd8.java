package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class nd8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ float c;

        public a(TbImageView tbImageView, int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView, Integer.valueOf(i), Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
            this.b = i;
            this.c = f;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            ViewGroup.LayoutParams layoutParams;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || (layoutParams = this.a.getLayoutParams()) == null) {
                return;
            }
            layoutParams.height = this.b;
            float f = this.c;
            if (f <= 0.0f) {
                f = 2.0f;
            }
            layoutParams.width = (int) (layoutParams.height * f);
            this.a.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.a.setAlpha(0.8f);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947998727, "Lcom/baidu/tieba/nd8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947998727, "Lcom/baidu/tieba/nd8;");
        }
    }

    public static int a(Context context, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, str, str2, str3, str4)) == null) {
            if (TextUtils.isEmpty(str4) || !qo5.a(str4)) {
                Bundle bundle = new Bundle();
                bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str2);
                bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, str3);
                if (str.startsWith("tieba://deeplink?")) {
                    Uri parse = Uri.parse(str);
                    int m = m(parse, context);
                    if (m != 1000) {
                        if (e(context, parse.getQueryParameter("wap"), bundle)) {
                            return m;
                        }
                        return 0;
                    }
                    return 1000;
                }
                return e(context, str, bundle) ? 1 : 0;
            }
            return 1;
        }
        return invokeLLLLL.intValue;
    }

    public static int b(TbPageContext tbPageContext, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, tbPageContext, str, str2, str3, str4)) == null) {
            if (tbPageContext == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            return a(tbPageContext.getPageActivity(), str, str2, str3, str4);
        }
        return invokeLLLLL.intValue;
    }

    public static int c(Context context, String str, AdvertAppInfo advertAppInfo, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, str, advertAppInfo, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return 0;
            }
            md8.l().j(advertAppInfo);
            return qo5.a(str2) ? 1 : 0;
        }
        return invokeLLLL.intValue;
    }

    public static boolean d(Context context, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, hashMap)) == null) {
            if (context == null || hashMap == null) {
                return false;
            }
            md8.l().k(hashMap, context);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean e(@NonNull Context context, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, str, bundle)) == null) {
            String[] strArr = {str};
            ad8 c = md8.l().c();
            if (c == null) {
                return false;
            }
            if (c.a(str)) {
                c.b(context, strArr, true, bundle);
                return true;
            }
            return c.c(context, strArr, bundle);
        }
        return invokeLLL.booleanValue;
    }

    public static void f(String str, TbImageView tbImageView, float f, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, tbImageView, Float.valueOf(f), Integer.valueOf(i)}) == null) || tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tbImageView.setVisibility(8);
            return;
        }
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.K(str, 10, false);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            if (f <= 0.0f) {
                f = 2.0f;
            }
            layoutParams.width = (int) (layoutParams.height * f);
            tbImageView.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                tbImageView.setAlpha(0.8f);
            }
        }
        tbImageView.setVisibility(0);
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("tieba://deeplink?");
        }
        return invokeL.booleanValue;
    }

    public static boolean h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            switch (i) {
                case 1000:
                case 1001:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case 1006:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TbadkCoreApplication.getInst().getPackageManager().getApplicationInfo(str, 8192) != null;
        }
        return invokeL.booleanValue;
    }

    public static int j(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, uri)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    return 1004;
                }
                context.startActivity(intent);
                return 1000;
            } catch (Exception unused) {
                return 1006;
            }
        }
        return invokeLL.intValue;
    }

    public static void k(String str, TbImageView tbImageView, float f, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, tbImageView, Float.valueOf(f), Integer.valueOf(i)}) == null) || tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            tbImageView.setVisibility(8);
            return;
        }
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.K(str, 10, false);
        tbImageView.setEvent(new a(tbImageView, i, f));
    }

    public static boolean l(String str, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, context)) == null) ? (TextUtils.isEmpty(str) || UrlSchemaJumpHelper.isHitBlackList(str) || j(context, Uri.parse(str)) != 1000) ? false : true : invokeLL.booleanValue;
    }

    public static int m(Uri uri, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, uri, context)) == null) {
            try {
                String queryParameter = uri.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                if (TextUtils.isEmpty(queryParameter)) {
                    return 1003;
                }
                return j(context, Uri.parse(queryParameter));
            } catch (Exception unused) {
                return 1003;
            }
        }
        return invokeLL.intValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || gm5.a().o() || a) {
            return;
        }
        AdvertAppInfo.v.set(true);
        a = true;
        String[] strArr = {"com.baidu.tieba.recapp.RecAppStatic", "com.baidu.tieba.lego.activity.LegoListActivityStatic"};
        for (int i = 0; i < 2; i++) {
            try {
                Class.forName(strArr[i]);
            } catch (Throwable unused) {
            }
        }
    }
}
