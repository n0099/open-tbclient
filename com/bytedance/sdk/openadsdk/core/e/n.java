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
    public final String f30100a;

    /* renamed from: b  reason: collision with root package name */
    public int f30101b;

    /* renamed from: c  reason: collision with root package name */
    public int f30102c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f30103d;

    /* renamed from: e  reason: collision with root package name */
    public int f30104e;

    /* renamed from: f  reason: collision with root package name */
    public long f30105f;

    /* renamed from: g  reason: collision with root package name */
    public long f30106g;

    /* renamed from: h  reason: collision with root package name */
    public long f30107h;

    /* renamed from: i  reason: collision with root package name */
    public long f30108i;
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
        this.f30100a = com.bytedance.sdk.openadsdk.r.o.c();
        this.f30101b = -1;
        this.f30102c = -1;
        this.f30103d = null;
        this.f30104e = 1;
        this.f30105f = System.currentTimeMillis();
        this.j = null;
    }

    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = new n();
            nVar.f30101b = this.f30101b;
            nVar.f30102c = this.f30102c;
            nVar.f30103d = this.f30103d;
            nVar.f30104e = this.f30104e;
            nVar.f30105f = this.f30105f;
            nVar.f30106g = this.f30106g;
            nVar.f30107h = this.f30107h;
            nVar.f30108i = this.f30108i;
            return nVar;
        }
        return (n) invokeV.objValue;
    }
}
