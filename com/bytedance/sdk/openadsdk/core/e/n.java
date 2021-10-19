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
    public final String f66835a;

    /* renamed from: b  reason: collision with root package name */
    public int f66836b;

    /* renamed from: c  reason: collision with root package name */
    public int f66837c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f66838d;

    /* renamed from: e  reason: collision with root package name */
    public int f66839e;

    /* renamed from: f  reason: collision with root package name */
    public long f66840f;

    /* renamed from: g  reason: collision with root package name */
    public long f66841g;

    /* renamed from: h  reason: collision with root package name */
    public long f66842h;

    /* renamed from: i  reason: collision with root package name */
    public long f66843i;

    /* renamed from: j  reason: collision with root package name */
    public JSONObject f66844j;

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
        this.f66835a = com.bytedance.sdk.openadsdk.q.q.c();
        this.f66836b = -1;
        this.f66837c = -1;
        this.f66838d = null;
        this.f66839e = 1;
        this.f66840f = System.currentTimeMillis();
        this.f66844j = null;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = new n();
            nVar.f66836b = this.f66836b;
            nVar.f66837c = this.f66837c;
            nVar.f66838d = this.f66838d;
            nVar.f66839e = this.f66839e;
            nVar.f66840f = this.f66840f;
            nVar.f66841g = this.f66841g;
            nVar.f66842h = this.f66842h;
            nVar.f66843i = this.f66843i;
            return nVar;
        }
        return (n) invokeV.objValue;
    }
}
