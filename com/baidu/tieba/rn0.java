package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.PaddingType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.w11;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class rn0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a k;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final List<ho0> d;
    public final String e;
    public final String f;
    public String g;
    public final String h;
    public final String i;
    public final String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948127253, "Lcom/baidu/tieba/rn0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948127253, "Lcom/baidu/tieba/rn0;");
                return;
            }
        }
        k = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof rn0) {
                    rn0 rn0Var = (rn0) obj;
                    return Intrinsics.areEqual(this.a, rn0Var.a) && Intrinsics.areEqual(this.b, rn0Var.b) && Intrinsics.areEqual(this.c, rn0Var.c) && Intrinsics.areEqual(this.d, rn0Var.d) && Intrinsics.areEqual(this.e, rn0Var.e) && Intrinsics.areEqual(this.f, rn0Var.f) && Intrinsics.areEqual(this.g, rn0Var.g) && Intrinsics.areEqual(this.h, rn0Var.h) && Intrinsics.areEqual(this.i, rn0Var.i) && Intrinsics.areEqual(this.j, rn0Var.j);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            List<ho0> list = this.d;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            String str4 = this.e;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.g;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.h;
            int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.i;
            int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.j;
            return hashCode9 + (str9 != null ? str9.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "BigCardData(avatar=" + this.a + ", brandName=" + this.b + ", title=" + this.c + ", tagList=" + this.d + ", btnText=" + this.e + ", btnColor=" + this.f + ", btnScheme=" + this.g + ", showTime=" + this.h + ", topPadding=" + this.i + ", bottomPadding=" + this.j + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final rn0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    String optString = jSONObject.optString("avatar");
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(\"avatar\")");
                    String optString2 = jSONObject.optString("brand_name");
                    Intrinsics.checkNotNullExpressionValue(optString2, "jsonObj.optString(\"brand_name\")");
                    String optString3 = jSONObject.optString("title");
                    Intrinsics.checkNotNullExpressionValue(optString3, "jsonObj.optString(\"title\")");
                    List<ho0> c = rn0.k.c(jSONObject.optJSONArray(PushConstants.SUB_TAGS_STATUS_LIST));
                    String optString4 = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                    Intrinsics.checkNotNullExpressionValue(optString4, "jsonObj.optString(\"button_text\")");
                    String optString5 = jSONObject.optString("button_color");
                    Intrinsics.checkNotNullExpressionValue(optString5, "jsonObj.optString(\"button_color\")");
                    String optString6 = jSONObject.optString("button_scheme");
                    Intrinsics.checkNotNullExpressionValue(optString6, "jsonObj.optString(\"button_scheme\")");
                    String optString7 = jSONObject.optString("show_time");
                    Intrinsics.checkNotNullExpressionValue(optString7, "jsonObj.optString(\"show_time\")");
                    return new rn0(optString, optString2, optString3, c, optString4, optString5, optString6, optString7, rn0.k.b(jSONObject, PaddingType.TOP), rn0.k.b(jSONObject, PaddingType.BOTTOM));
                }
                return null;
            }
            return (rn0) invokeL.objValue;
        }

        public final String b(JSONObject jSONObject, PaddingType paddingType) {
            InterceptResult invokeLL;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, paddingType)) == null) {
                int i = qn0.$EnumSwitchMapping$0[paddingType.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        if (w11.c.k()) {
                            str2 = "bottom_padding_full";
                        } else {
                            str2 = "bottom_padding";
                        }
                        String optString = jSONObject.optString(str2);
                        Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(if (De…l\" else \"bottom_padding\")");
                        return optString;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (w11.c.k()) {
                    str = "top_padding_full";
                } else {
                    str = "top_padding";
                }
                String optString2 = jSONObject.optString(str);
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObj.optString(if (De…full\" else \"top_padding\")");
                return optString2;
            }
            return (String) invokeLL.objValue;
        }

        public final List<ho0> c(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
                if (jSONArray != null && jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        ho0 a = ho0.b.a(jSONArray.optJSONObject(i));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                    return arrayList;
                }
                return new ArrayList();
            }
            return (List) invokeL.objValue;
        }
    }

    public rn0(String avatar, String brandName, String title, List<ho0> tagList, String btnText, String btnColor, String btnScheme, String showTime, String topPadding, String bottomPadding) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatar, brandName, title, tagList, btnText, btnColor, btnScheme, showTime, topPadding, bottomPadding};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        Intrinsics.checkNotNullParameter(btnColor, "btnColor");
        Intrinsics.checkNotNullParameter(btnScheme, "btnScheme");
        Intrinsics.checkNotNullParameter(showTime, "showTime");
        Intrinsics.checkNotNullParameter(topPadding, "topPadding");
        Intrinsics.checkNotNullParameter(bottomPadding, "bottomPadding");
        this.a = avatar;
        this.b = brandName;
        this.c = title;
        this.d = tagList;
        this.e = btnText;
        this.f = btnColor;
        this.g = btnScheme;
        this.h = showTime;
        this.i = topPadding;
        this.j = bottomPadding;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.g = str;
        }
    }
}
