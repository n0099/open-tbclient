package com.bytedance.sdk.openadsdk.core.nativeexpress.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.e.m;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdSlot f66656a;

    /* renamed from: b  reason: collision with root package name */
    public m f66657b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f66658c;

    /* renamed from: d  reason: collision with root package name */
    public String f66659d;

    /* renamed from: e  reason: collision with root package name */
    public d f66660e;

    /* renamed from: f  reason: collision with root package name */
    public int f66661f;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AdSlot f66662a;

        /* renamed from: b  reason: collision with root package name */
        public m f66663b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f66664c;

        /* renamed from: d  reason: collision with root package name */
        public String f66665d;

        /* renamed from: e  reason: collision with root package name */
        public d f66666e;

        /* renamed from: f  reason: collision with root package name */
        public int f66667f;

        public a() {
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

        public a a(AdSlot adSlot) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot)) == null) {
                this.f66662a = adSlot;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(m mVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar)) == null) {
                this.f66663b = mVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
                this.f66664c = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f66665d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
                this.f66666e = dVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f66667f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new g(this) : (g) invokeV.objValue;
        }
    }

    public g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66656a = aVar.f66662a;
        this.f66657b = aVar.f66663b;
        this.f66658c = aVar.f66664c;
        this.f66659d = aVar.f66665d;
        this.f66660e = aVar.f66666e;
        this.f66661f = aVar.f66667f;
    }

    public m a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66657b : (m) invokeV.objValue;
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66658c : (JSONObject) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66659d : (String) invokeV.objValue;
    }

    public d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66660e : (d) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66661f : invokeV.intValue;
    }
}
