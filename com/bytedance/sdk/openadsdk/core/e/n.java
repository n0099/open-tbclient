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
    public final String f66309a;

    /* renamed from: b  reason: collision with root package name */
    public int f66310b;

    /* renamed from: c  reason: collision with root package name */
    public int f66311c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f66312d;

    /* renamed from: e  reason: collision with root package name */
    public int f66313e;

    /* renamed from: f  reason: collision with root package name */
    public long f66314f;

    /* renamed from: g  reason: collision with root package name */
    public long f66315g;

    /* renamed from: h  reason: collision with root package name */
    public long f66316h;

    /* renamed from: i  reason: collision with root package name */
    public long f66317i;

    /* renamed from: j  reason: collision with root package name */
    public JSONObject f66318j;

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
        this.f66309a = com.bytedance.sdk.openadsdk.q.q.c();
        this.f66310b = -1;
        this.f66311c = -1;
        this.f66312d = null;
        this.f66313e = 1;
        this.f66314f = System.currentTimeMillis();
        this.f66318j = null;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = new n();
            nVar.f66310b = this.f66310b;
            nVar.f66311c = this.f66311c;
            nVar.f66312d = this.f66312d;
            nVar.f66313e = this.f66313e;
            nVar.f66314f = this.f66314f;
            nVar.f66315g = this.f66315g;
            nVar.f66316h = this.f66316h;
            nVar.f66317i = this.f66317i;
            return nVar;
        }
        return (n) invokeV.objValue;
    }
}
