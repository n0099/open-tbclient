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
    public final String f66800a;

    /* renamed from: b  reason: collision with root package name */
    public int f66801b;

    /* renamed from: c  reason: collision with root package name */
    public int f66802c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f66803d;

    /* renamed from: e  reason: collision with root package name */
    public int f66804e;

    /* renamed from: f  reason: collision with root package name */
    public long f66805f;

    /* renamed from: g  reason: collision with root package name */
    public long f66806g;

    /* renamed from: h  reason: collision with root package name */
    public long f66807h;

    /* renamed from: i  reason: collision with root package name */
    public long f66808i;

    /* renamed from: j  reason: collision with root package name */
    public JSONObject f66809j;

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
        this.f66800a = com.bytedance.sdk.openadsdk.q.q.c();
        this.f66801b = -1;
        this.f66802c = -1;
        this.f66803d = null;
        this.f66804e = 1;
        this.f66805f = System.currentTimeMillis();
        this.f66809j = null;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = new n();
            nVar.f66801b = this.f66801b;
            nVar.f66802c = this.f66802c;
            nVar.f66803d = this.f66803d;
            nVar.f66804e = this.f66804e;
            nVar.f66805f = this.f66805f;
            nVar.f66806g = this.f66806g;
            nVar.f66807h = this.f66807h;
            nVar.f66808i = this.f66808i;
            return nVar;
        }
        return (n) invokeV.objValue;
    }
}
