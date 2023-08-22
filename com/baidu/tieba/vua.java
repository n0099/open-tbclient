package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FestivalTipData;
import tbclient.ThemeColorInfo;
/* loaded from: classes8.dex */
public final class vua {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public final ThemeColorInfo a;
    public final ThemeColorInfo b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254663, "Lcom/baidu/tieba/vua;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254663, "Lcom/baidu/tieba/vua;");
                return;
            }
        }
        c = new a(null);
    }

    @JvmStatic
    public static final vua a(FestivalTipData festivalTipData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, festivalTipData)) == null) ? c.a(festivalTipData) : (vua) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof vua) {
                vua vuaVar = (vua) obj;
                return Intrinsics.areEqual(this.a, vuaVar.a) && Intrinsics.areEqual(this.b, vuaVar.b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.a.hashCode() * 31) + this.b.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "FestivalTipViewStyle(backgroundColor=" + this.a + ", textColor=" + this.b + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
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

        @JvmStatic
        public final vua a(FestivalTipData festivalTipData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, festivalTipData)) == null) {
                Intrinsics.checkNotNullParameter(festivalTipData, "festivalTipData");
                ThemeColorInfo themeColorInfo = festivalTipData.background_color;
                Intrinsics.checkNotNullExpressionValue(themeColorInfo, "festivalTipData.background_color");
                ThemeColorInfo themeColorInfo2 = festivalTipData.font_color;
                Intrinsics.checkNotNullExpressionValue(themeColorInfo2, "festivalTipData.font_color");
                return new vua(themeColorInfo, themeColorInfo2);
            }
            return (vua) invokeL.objValue;
        }
    }

    public vua(ThemeColorInfo backgroundColor, ThemeColorInfo textColor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundColor, textColor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        this.a = backgroundColor;
        this.b = textColor;
    }

    public final ThemeColorInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public final ThemeColorInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }
}
