package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public final class r97 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948076537, "Lcom/baidu/tieba/r97;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948076537, "Lcom/baidu/tieba/r97;");
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

        public final t57 a(String iconUrl) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iconUrl)) == null) {
                Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
                if (TextUtils.isEmpty(iconUrl)) {
                    return null;
                }
                int i = 0;
                if (StringsKt__StringsJVMKt.startsWith$default(iconUrl, "local://icon/", false, 2, null)) {
                    Uri parse = Uri.parse(iconUrl);
                    List<String> pathSegments = parse.getPathSegments();
                    if (pathSegments.size() > 0) {
                        boolean z = true;
                        int identifier = g37.a.getResources().getIdentifier(pathSegments.get(pathSegments.size() - 1), ResourceManager.DRAWABLE, g37.a.getPackageName());
                        String queryParameter = parse.getQueryParameter("type");
                        if (queryParameter == null) {
                            queryParameter = "";
                        }
                        int identifier2 = g37.a.getResources().getIdentifier(parse.getQueryParameter("color"), "color", g37.a.getPackageName());
                        String queryParameter2 = parse.getQueryParameter(CriusAttrConstants.PADDING);
                        if (queryParameter2 != null && queryParameter2.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            i = vi.g(g37.a, g37.a.getResources().getIdentifier(queryParameter2, EMABTest.TYPE_DIMEN, g37.a.getPackageName()));
                        }
                        if (identifier > 0) {
                            return new t57(identifier, queryParameter, identifier2, i);
                        }
                    }
                }
                return null;
            }
            return (t57) invokeL.objValue;
        }

        public final String b(p57 iconData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iconData)) == null) {
                Intrinsics.checkNotNullParameter(iconData, "iconData");
                String b = iconData.b();
                int currentSkinType = SkinManager.getCurrentSkinType();
                if (currentSkinType != 0) {
                    if (currentSkinType == 4) {
                        return iconData.a();
                    }
                    return b;
                }
                return iconData.b();
            }
            return (String) invokeL.objValue;
        }
    }
}
