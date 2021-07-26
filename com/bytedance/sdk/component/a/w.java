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
/* loaded from: classes5.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Collection<String> f27971a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, v> f27972b;

    /* renamed from: c  reason: collision with root package name */
    public final k f27973c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f27974d;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public v a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!this.f27971a.contains(str) && !TextUtils.equals(str, "host")) {
                throw new IllegalArgumentException("Namespace: " + str + " not registered.");
            }
            return a(str, null);
        }
        return (v) invokeL.objValue;
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f27974d.remove(aVar);
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f27974d.add(aVar);
        }
    }

    private v a(String str, @Nullable JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, this, str, jSONObject)) == null) {
            v vVar = this.f27972b.get(str);
            if (vVar == null) {
                v vVar2 = new v(str, this.f27973c.c(), this.f27973c.a(), this.f27973c.b(), jSONObject);
                this.f27972b.put(str, vVar2);
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
