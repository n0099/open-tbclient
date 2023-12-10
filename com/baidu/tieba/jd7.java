package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class jd7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947879532, "Lcom/baidu/tieba/jd7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947879532, "Lcom/baidu/tieba/jd7;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes6.dex */
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

        public final int a(e67 colorData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, colorData)) == null) {
                Intrinsics.checkNotNullParameter(colorData, "colorData");
                int c = colorData.c();
                if (c != 1) {
                    if (c == 2) {
                        return SkinManager.getColor(v27.a.getResources().getIdentifier(colorData.b(), "color", v27.a.getPackageName()));
                    }
                } else {
                    int currentSkinType = SkinManager.getCurrentSkinType();
                    if (currentSkinType != 0) {
                        if (currentSkinType == 4) {
                            return uua.f(colorData.a());
                        }
                    } else {
                        return uua.f(colorData.b());
                    }
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int c(e67 colorData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, colorData)) == null) {
                Intrinsics.checkNotNullParameter(colorData, "colorData");
                int c = colorData.c();
                if (c != 1) {
                    if (c != 2) {
                        return 0;
                    }
                    return SkinManager.getColor(4, v27.a.getResources().getIdentifier(colorData.b(), "color", v27.a.getPackageName()));
                }
                return uua.f(colorData.a());
            }
            return invokeL.intValue;
        }

        public final int b(e67 colorData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, colorData)) == null) {
                Intrinsics.checkNotNullParameter(colorData, "colorData");
                if (colorData.c() == 2) {
                    return v27.a.getResources().getIdentifier(colorData.b(), "color", v27.a.getPackageName());
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int d(e67 colorData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, colorData)) == null) {
                Intrinsics.checkNotNullParameter(colorData, "colorData");
                int c = colorData.c();
                if (c != 1) {
                    if (c != 2) {
                        return 0;
                    }
                    return SkinManager.getColor(0, v27.a.getResources().getIdentifier(colorData.b(), "color", v27.a.getPackageName()));
                }
                return uua.f(colorData.b());
            }
            return invokeL.intValue;
        }
    }
}
