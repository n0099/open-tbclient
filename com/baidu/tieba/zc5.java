package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class zc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public List<String> b;
    public List<String> c;
    public List<String> d;
    public String e;
    public long f;
    public int g;
    public int h;
    public long i;
    public int j;

    public zc5() {
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
        this.a = CollectionsKt__CollectionsKt.emptyList();
        this.b = CollectionsKt__CollectionsKt.emptyList();
        this.c = CollectionsKt__CollectionsKt.emptyList();
        this.d = CollectionsKt__CollectionsKt.emptyList();
        this.e = "";
        this.i = 10000L;
        this.j = 500;
    }

    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return invokeV.longValue;
    }

    public final List<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public final List<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final List<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final List<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final String i(List<String> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return "";
            }
            return (String) CollectionsKt___CollectionsKt.random(list, Random.Default);
        }
        return (String) invokeL.objValue;
    }

    public final List<String> l(JSONArray jSONArray) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jSONArray)) == null) {
            if (jSONArray != null) {
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String guideText = jSONArray.optString(i);
                    if (guideText != null && guideText.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        Intrinsics.checkNotNullExpressionValue(guideText, "guideText");
                        arrayList.add(guideText);
                    }
                }
                return arrayList;
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return (List) invokeL.objValue;
    }

    public final void m(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            this.a = l(json.optJSONArray("uninput_show_panel_guide"));
            this.b = l(json.optJSONArray("uninput_hide_panel_guide"));
            this.c = l(json.optJSONArray("input_show_panel_guide"));
            this.d = l(json.optJSONArray("input_hide_panel_guide"));
            String optString = json.optString("change_batch_text");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"change_batch_text\")");
            this.e = optString;
            this.f = json.optLong("auto_expand_panel_interval");
            this.g = json.optInt("auto_expand_panel_times");
            this.h = json.optInt("generate_result_loop_interval");
            this.j = json.optInt("input_query_delay", 500);
            this.i = json.optLong("generate_result_loop_timeout", 10000L);
        }
    }
}
