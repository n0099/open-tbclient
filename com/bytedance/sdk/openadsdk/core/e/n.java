package com.bytedance.sdk.openadsdk.core.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f29990a;

    /* renamed from: b  reason: collision with root package name */
    public int f29991b;

    /* renamed from: c  reason: collision with root package name */
    public int f29992c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f29993d;

    /* renamed from: e  reason: collision with root package name */
    public int f29994e;

    /* renamed from: f  reason: collision with root package name */
    public long f29995f;

    /* renamed from: g  reason: collision with root package name */
    public long f29996g;

    /* renamed from: h  reason: collision with root package name */
    public long f29997h;

    /* renamed from: i  reason: collision with root package name */
    public long f29998i;
    public JSONObject j;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29990a = com.bytedance.sdk.openadsdk.r.o.c();
        this.f29991b = -1;
        this.f29992c = -1;
        this.f29993d = null;
        this.f29994e = 1;
        this.f29995f = System.currentTimeMillis();
        this.j = null;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = new n();
            nVar.f29991b = this.f29991b;
            nVar.f29992c = this.f29992c;
            nVar.f29993d = this.f29993d;
            nVar.f29994e = this.f29994e;
            nVar.f29995f = this.f29995f;
            nVar.f29996g = this.f29996g;
            nVar.f29997h = this.f29997h;
            nVar.f29998i = this.f29998i;
            return nVar;
        }
        return (n) invokeV.objValue;
    }
}
