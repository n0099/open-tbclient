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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f28798a;

    /* renamed from: b  reason: collision with root package name */
    public int f28799b;

    /* renamed from: c  reason: collision with root package name */
    public int f28800c;

    /* renamed from: d  reason: collision with root package name */
    public int f28801d;

    /* renamed from: e  reason: collision with root package name */
    public long f28802e;

    /* renamed from: f  reason: collision with root package name */
    public long f28803f;

    /* renamed from: g  reason: collision with root package name */
    public long f28804g;

    /* renamed from: h  reason: collision with root package name */
    public long f28805h;

    /* renamed from: i  reason: collision with root package name */
    public int f28806i;

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
        this.f28799b = 0;
        this.f28800c = 0;
        this.f28802e = 0L;
        this.f28803f = 0L;
        this.f28804g = 0L;
        this.f28805h = 0L;
        this.f28806i = 0;
        this.f28798a = str;
        this.f28799b = i2;
        this.f28800c = i3;
        this.f28802e = j;
        this.f28803f = j2;
        this.f28804g = j3;
        this.f28805h = j4;
        this.f28806i = i4;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f28806i <= 0) {
                    return null;
                }
                jSONObject.put("poolType", this.f28798a);
                jSONObject.put("corePoolSize", this.f28799b);
                jSONObject.put("maximumPoolSize", this.f28800c);
                jSONObject.put("largestPoolSize", this.f28801d);
                jSONObject.put("waitLargestTime", this.f28802e);
                jSONObject.put("waitAvgTime", (((float) this.f28803f) * 1.0f) / this.f28806i);
                jSONObject.put("taskCostLargestTime", this.f28804g);
                jSONObject.put("taskCostAvgTime", (((float) this.f28805h) * 1.0f) / this.f28806i);
                jSONObject.put("logCount", this.f28806i);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28798a : (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28802e : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28804g : invokeV.longValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28806i : invokeV.intValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f28803f += j;
        }
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f28804g = j;
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.f28805h += j;
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f28801d = i2;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f28802e = j;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f28806i += i2;
        }
    }
}
