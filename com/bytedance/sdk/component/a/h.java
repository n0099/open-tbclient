package com.bytedance.sdk.component.a;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l f27645a;

    public h(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27645a = lVar;
    }

    public static h a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lVar)) == null) ? new h(lVar) : (h) invokeL.objValue;
    }

    @NonNull
    public <T> T a(@NonNull String str, @NonNull Type type) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, type)) == null) {
            a(str);
            if (!type.equals(JSONObject.class) && (!(type instanceof Class) || !JSONObject.class.isAssignableFrom((Class) type))) {
                return (T) this.f27645a.a(str, type);
            }
            return (T) new JSONObject(str);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    public <T> String a(T t) {
        InterceptResult invokeL;
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            if (t == null) {
                return StringUtil.EMPTY_ARRAY;
            }
            if (!(t instanceof JSONObject) && !(t instanceof JSONArray)) {
                obj = this.f27645a.a(t);
            } else {
                obj = t.toString();
            }
            a(obj);
            return obj;
        }
        return (String) invokeL.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            if (str.startsWith(StringUtil.ARRAY_START) && str.endsWith("}")) {
                return;
            }
            i.a(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n " + str));
        }
    }
}
