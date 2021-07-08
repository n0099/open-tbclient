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
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Collection<String> f27812a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, u> f27813b;

    /* renamed from: c  reason: collision with root package name */
    public final k f27814c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<a> f27815d;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public u a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!this.f27812a.contains(str) && !TextUtils.equals(str, "host")) {
                throw new IllegalArgumentException("Namespace: " + str + " not registered.");
            }
            return a(str, null);
        }
        return (u) invokeL.objValue;
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f27815d.remove(aVar);
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f27815d.add(aVar);
        }
    }

    private u a(String str, @Nullable JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, this, str, jSONObject)) == null) {
            u uVar = this.f27813b.get(str);
            if (uVar == null) {
                u uVar2 = new u(str, this.f27814c.c(), this.f27814c.a(), this.f27814c.b(), jSONObject);
                this.f27813b.put(str, uVar2);
                return uVar2;
            } else if (jSONObject != null) {
                uVar.a(jSONObject);
                return uVar;
            } else {
                return uVar;
            }
        }
        return (u) invokeLL.objValue;
    }
}
