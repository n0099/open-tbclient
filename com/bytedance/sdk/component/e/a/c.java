package com.bytedance.sdk.component.e.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f28862a;

    /* renamed from: b  reason: collision with root package name */
    public int f28863b;

    /* renamed from: c  reason: collision with root package name */
    public int f28864c;

    /* renamed from: d  reason: collision with root package name */
    public int f28865d;

    /* renamed from: e  reason: collision with root package name */
    public long f28866e;

    /* renamed from: f  reason: collision with root package name */
    public long f28867f;

    /* renamed from: g  reason: collision with root package name */
    public long f28868g;

    /* renamed from: h  reason: collision with root package name */
    public long f28869h;

    /* renamed from: i  reason: collision with root package name */
    public int f28870i;

    public c(String str, int i2, int i3, long j, long j2, long j3, long j4, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28863b = 0;
        this.f28864c = 0;
        this.f28866e = 0L;
        this.f28867f = 0L;
        this.f28868g = 0L;
        this.f28869h = 0L;
        this.f28870i = 0;
        this.f28862a = str;
        this.f28863b = i2;
        this.f28864c = i3;
        this.f28866e = j;
        this.f28867f = j2;
        this.f28868g = j3;
        this.f28869h = j4;
        this.f28870i = i4;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f28870i <= 0) {
                    return null;
                }
                jSONObject.put("poolType", this.f28862a);
                jSONObject.put("corePoolSize", this.f28863b);
                jSONObject.put("maximumPoolSize", this.f28864c);
                jSONObject.put("largestPoolSize", this.f28865d);
                jSONObject.put("waitLargestTime", this.f28866e);
                jSONObject.put("waitAvgTime", (((float) this.f28867f) * 1.0f) / this.f28870i);
                jSONObject.put("taskCostLargestTime", this.f28868g);
                jSONObject.put("taskCostAvgTime", (((float) this.f28869h) * 1.0f) / this.f28870i);
                jSONObject.put("logCount", this.f28870i);
                return jSONObject;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28862a : (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28866e : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28868g : invokeV.longValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28870i : invokeV.intValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f28867f += j;
        }
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f28868g = j;
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.f28869h += j;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f28865d = i2;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f28866e = j;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f28870i += i2;
        }
    }
}
