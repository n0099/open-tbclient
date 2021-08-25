package com.bytedance.sdk.component.image;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.b.e;
import com.bytedance.sdk.component.image.c.a;
import java.util.Map;
/* loaded from: classes9.dex */
public class ImageResponse<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f64896a;

    /* renamed from: b  reason: collision with root package name */
    public String f64897b;

    /* renamed from: c  reason: collision with root package name */
    public T f64898c;

    /* renamed from: d  reason: collision with root package name */
    public int f64899d;

    /* renamed from: e  reason: collision with root package name */
    public int f64900e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f64901f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64902g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64903h;

    /* renamed from: i  reason: collision with root package name */
    public e f64904i;

    public ImageResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ImageResponse fromReuqest(a aVar, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, t)) == null) {
            this.f64898c = t;
            this.f64896a = aVar.e();
            this.f64897b = aVar.a();
            this.f64899d = aVar.h();
            this.f64900e = aVar.i();
            this.f64903h = aVar.m();
            this.f64904i = aVar.n();
            return this;
        }
        return (ImageResponse) invokeLL.objValue;
    }

    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64896a : (String) invokeV.objValue;
    }

    @Nullable
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64901f : (Map) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64900e : invokeV.intValue;
    }

    public e getHttpTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64904i : (e) invokeV.objValue;
    }

    public T getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64898c : (T) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64897b : (String) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f64899d : invokeV.intValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f64902g : invokeV.booleanValue;
    }

    public boolean isLocal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f64903h : invokeV.booleanValue;
    }

    public ImageResponse fromReuqest(a aVar, T t, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, t, map, Boolean.valueOf(z)})) == null) {
            this.f64901f = map;
            this.f64902g = z;
            return fromReuqest(aVar, t);
        }
        return (ImageResponse) invokeCommon.objValue;
    }
}
