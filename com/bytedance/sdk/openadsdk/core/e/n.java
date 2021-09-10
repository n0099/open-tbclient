package com.bytedance.sdk.openadsdk.core.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f66489a;

    /* renamed from: b  reason: collision with root package name */
    public int f66490b;

    /* renamed from: c  reason: collision with root package name */
    public int f66491c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f66492d;

    /* renamed from: e  reason: collision with root package name */
    public int f66493e;

    /* renamed from: f  reason: collision with root package name */
    public long f66494f;

    /* renamed from: g  reason: collision with root package name */
    public long f66495g;

    /* renamed from: h  reason: collision with root package name */
    public long f66496h;

    /* renamed from: i  reason: collision with root package name */
    public long f66497i;

    /* renamed from: j  reason: collision with root package name */
    public JSONObject f66498j;

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
        this.f66489a = com.bytedance.sdk.openadsdk.q.q.c();
        this.f66490b = -1;
        this.f66491c = -1;
        this.f66492d = null;
        this.f66493e = 1;
        this.f66494f = System.currentTimeMillis();
        this.f66498j = null;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = new n();
            nVar.f66490b = this.f66490b;
            nVar.f66491c = this.f66491c;
            nVar.f66492d = this.f66492d;
            nVar.f66493e = this.f66493e;
            nVar.f66494f = this.f66494f;
            nVar.f66495g = this.f66495g;
            nVar.f66496h = this.f66496h;
            nVar.f66497i = this.f66497i;
            return nVar;
        }
        return (n) invokeV.objValue;
    }
}
