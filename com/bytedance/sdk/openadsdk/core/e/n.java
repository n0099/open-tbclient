package com.bytedance.sdk.openadsdk.core.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f30200a;

    /* renamed from: b  reason: collision with root package name */
    public int f30201b;

    /* renamed from: c  reason: collision with root package name */
    public int f30202c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f30203d;

    /* renamed from: e  reason: collision with root package name */
    public int f30204e;

    /* renamed from: f  reason: collision with root package name */
    public long f30205f;

    /* renamed from: g  reason: collision with root package name */
    public long f30206g;

    /* renamed from: h  reason: collision with root package name */
    public long f30207h;

    /* renamed from: i  reason: collision with root package name */
    public long f30208i;
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
        this.f30200a = com.bytedance.sdk.openadsdk.q.q.c();
        this.f30201b = -1;
        this.f30202c = -1;
        this.f30203d = null;
        this.f30204e = 1;
        this.f30205f = System.currentTimeMillis();
        this.j = null;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = new n();
            nVar.f30201b = this.f30201b;
            nVar.f30202c = this.f30202c;
            nVar.f30203d = this.f30203d;
            nVar.f30204e = this.f30204e;
            nVar.f30205f = this.f30205f;
            nVar.f30206g = this.f30206g;
            nVar.f30207h = this.f30207h;
            nVar.f30208i = this.f30208i;
            return nVar;
        }
        return (n) invokeV.objValue;
    }
}
