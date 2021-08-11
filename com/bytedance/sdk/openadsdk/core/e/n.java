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
    public final String f66109a;

    /* renamed from: b  reason: collision with root package name */
    public int f66110b;

    /* renamed from: c  reason: collision with root package name */
    public int f66111c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f66112d;

    /* renamed from: e  reason: collision with root package name */
    public int f66113e;

    /* renamed from: f  reason: collision with root package name */
    public long f66114f;

    /* renamed from: g  reason: collision with root package name */
    public long f66115g;

    /* renamed from: h  reason: collision with root package name */
    public long f66116h;

    /* renamed from: i  reason: collision with root package name */
    public long f66117i;

    /* renamed from: j  reason: collision with root package name */
    public JSONObject f66118j;

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
        this.f66109a = com.bytedance.sdk.openadsdk.q.q.c();
        this.f66110b = -1;
        this.f66111c = -1;
        this.f66112d = null;
        this.f66113e = 1;
        this.f66114f = System.currentTimeMillis();
        this.f66118j = null;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = new n();
            nVar.f66110b = this.f66110b;
            nVar.f66111c = this.f66111c;
            nVar.f66112d = this.f66112d;
            nVar.f66113e = this.f66113e;
            nVar.f66114f = this.f66114f;
            nVar.f66115g = this.f66115g;
            nVar.f66116h = this.f66116h;
            nVar.f66117i = this.f66117i;
            return nVar;
        }
        return (n) invokeV.objValue;
    }
}
