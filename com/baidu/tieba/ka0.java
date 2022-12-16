package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes5.dex */
public final class ka0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> a;
    public final String b;

    public ka0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = str;
    }

    public final Map<String, String> a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> map = this.a;
            if (map != null) {
                if (map != null) {
                    return TypeIntrinsics.asMutableMap(map);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            }
            this.a = new HashMap();
            if (StringsKt__StringsKt.indexOf$default((CharSequence) this.b, '?', 0, false, 6, (Object) null) < 0) {
                Map<String, String> map2 = this.a;
                if (map2 != null) {
                    return (HashMap) map2;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
            }
            Object[] array = new Regex("\\?").split(this.b, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length < 2) {
                    Map<String, String> map3 = this.a;
                    if (map3 != null) {
                        return (HashMap) map3;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
                }
                Object[] array2 = new Regex("&").split(strArr[1], 0).toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr2 = (String[]) array2;
                    if (strArr2.length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        Map<String, String> map4 = this.a;
                        if (map4 != null) {
                            return (HashMap) map4;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
                    }
                    for (String str : strArr2) {
                        Object[] array3 = new Regex("=").split(str, 0).toArray(new String[0]);
                        if (array3 != null) {
                            String[] strArr3 = (String[]) array3;
                            if (strArr3.length >= 2) {
                                Map<String, String> map5 = this.a;
                                if (map5 != null) {
                                    ((HashMap) map5).put(strArr3[0], strArr3[1]);
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
                                }
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    Map<String, String> map6 = this.a;
                    if (map6 != null) {
                        return (HashMap) map6;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return (Map) invokeV.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(str)) {
                String str2 = null;
                try {
                    str2 = Uri.parse(this.b).getQueryParameter(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(str2)) {
                    return a().get(str);
                }
                return str2;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
