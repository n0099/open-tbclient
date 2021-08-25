package com.bytedance.sdk.component.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Collection<String> f64008a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, v> f64009b;

    /* renamed from: c  reason: collision with root package name */
    public final k f64010c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f64011d;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public v a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!this.f64008a.contains(str) && !TextUtils.equals(str, "host")) {
                throw new IllegalArgumentException("Namespace: " + str + " not registered.");
            }
            return a(str, null);
        }
        return (v) invokeL.objValue;
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f64011d.remove(aVar);
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f64011d.add(aVar);
        }
    }

    private v a(String str, @Nullable JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, this, str, jSONObject)) == null) {
            v vVar = this.f64009b.get(str);
            if (vVar == null) {
                v vVar2 = new v(str, this.f64010c.c(), this.f64010c.a(), this.f64010c.b(), jSONObject);
                this.f64009b.put(str, vVar2);
                return vVar2;
            } else if (jSONObject != null) {
                vVar.a(jSONObject);
                return vVar;
            } else {
                return vVar;
            }
        }
        return (v) invokeLL.objValue;
    }
}
