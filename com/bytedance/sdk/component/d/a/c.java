package com.bytedance.sdk.component.d.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f64660a;

    /* renamed from: b  reason: collision with root package name */
    public int f64661b;

    /* renamed from: c  reason: collision with root package name */
    public int f64662c;

    /* renamed from: d  reason: collision with root package name */
    public int f64663d;

    /* renamed from: e  reason: collision with root package name */
    public long f64664e;

    /* renamed from: f  reason: collision with root package name */
    public long f64665f;

    /* renamed from: g  reason: collision with root package name */
    public long f64666g;

    /* renamed from: h  reason: collision with root package name */
    public long f64667h;

    /* renamed from: i  reason: collision with root package name */
    public int f64668i;

    public c(String str, int i2, int i3, long j2, long j3, long j4, long j5, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64661b = 0;
        this.f64662c = 0;
        this.f64664e = 0L;
        this.f64665f = 0L;
        this.f64666g = 0L;
        this.f64667h = 0L;
        this.f64668i = 0;
        this.f64660a = str;
        this.f64661b = i2;
        this.f64662c = i3;
        this.f64664e = j2;
        this.f64665f = j3;
        this.f64666g = j4;
        this.f64667h = j5;
        this.f64668i = i4;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f64668i <= 0) {
                    return null;
                }
                jSONObject.put("poolType", this.f64660a);
                jSONObject.put("corePoolSize", this.f64661b);
                jSONObject.put("maximumPoolSize", this.f64662c);
                jSONObject.put("largestPoolSize", this.f64663d);
                jSONObject.put("waitLargestTime", this.f64664e);
                jSONObject.put("waitAvgTime", (((float) this.f64665f) * 1.0f) / this.f64668i);
                jSONObject.put("taskCostLargestTime", this.f64666g);
                jSONObject.put("taskCostAvgTime", (((float) this.f64667h) * 1.0f) / this.f64668i);
                jSONObject.put("logCount", this.f64668i);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64660a : (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64664e : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f64666g : invokeV.longValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f64668i : invokeV.intValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f64665f += j2;
        }
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.f64666g = j2;
        }
    }

    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.f64667h += j2;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f64663d = i2;
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f64664e = j2;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f64668i += i2;
        }
    }
}
