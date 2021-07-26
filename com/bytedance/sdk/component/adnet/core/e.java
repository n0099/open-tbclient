package com.bytedance.sdk.component.adnet.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.err.VAdError;
/* loaded from: classes5.dex */
public class e implements com.bytedance.sdk.component.adnet.face.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f28081a;

    /* renamed from: b  reason: collision with root package name */
    public int f28082b;

    /* renamed from: c  reason: collision with root package name */
    public int f28083c;

    /* renamed from: d  reason: collision with root package name */
    public final float f28084d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(2500, 1, 1.0f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Float) objArr[2]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f28081a = i2;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f28083c = i2;
            return this;
        }
        return (e) invokeI.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28082b <= this.f28083c : invokeV.booleanValue;
    }

    public e(int i2, int i3, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28081a = i2;
        this.f28083c = i3;
        this.f28084d = f2;
    }

    @Override // com.bytedance.sdk.component.adnet.face.d
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28081a : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.adnet.face.d
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28082b : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.adnet.face.d
    public void a(VAdError vAdError) throws VAdError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vAdError) == null) {
            this.f28082b++;
            int i2 = this.f28081a;
            this.f28081a = i2 + ((int) (i2 * this.f28084d));
            if (!c()) {
                throw vAdError;
            }
        }
    }
}
