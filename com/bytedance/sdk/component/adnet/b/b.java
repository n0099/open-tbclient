package com.bytedance.sdk.component.adnet.b;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.i;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.err.e;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends c<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(int i2, String str, @Nullable JSONObject jSONObject, @Nullable m.a<JSONObject> aVar) {
        this(i2, str, jSONObject == null ? null : jSONObject.toString(), aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, jSONObject, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2], (m.a) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.b.c, com.bytedance.sdk.component.adnet.core.Request
    public m<JSONObject> a(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iVar)) == null) {
            try {
                return m.a(new JSONObject(new String(iVar.f64155b, com.bytedance.sdk.component.adnet.d.b.a(iVar.f64156c, "utf-8"))), com.bytedance.sdk.component.adnet.d.b.a(iVar));
            } catch (UnsupportedEncodingException e2) {
                return m.a(new e(e2, 604));
            } catch (JSONException e3) {
                return m.a(new e(e3, 605));
            }
        }
        return (m) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i2, String str, @Nullable String str2, @Nullable m.a<JSONObject> aVar) {
        super(i2, str, str2, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2], (m.a) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
