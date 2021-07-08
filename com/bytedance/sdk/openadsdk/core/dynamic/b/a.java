package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.r.o;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29942a;

    /* renamed from: b  reason: collision with root package name */
    public String f29943b;

    /* renamed from: c  reason: collision with root package name */
    public String f29944c;

    public a(@NonNull m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (mVar == null) {
            return;
        }
        this.f29942a = mVar.ak();
        this.f29943b = mVar.ao();
        this.f29944c = o.i(mVar);
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.f29942a)) {
                    jSONObject.put(IAdRequestParam.CELL_ID, this.f29942a);
                }
                if (!TextUtils.isEmpty(this.f29943b)) {
                    jSONObject.put("log_extra", this.f29943b);
                }
                if (!TextUtils.isEmpty(this.f29944c)) {
                    jSONObject.put("download_url", this.f29944c);
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
