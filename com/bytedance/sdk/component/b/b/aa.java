package com.bytedance.sdk.component.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public abstract class aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aa() {
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

    public static aa a(v vVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, vVar, str)) == null) {
            Charset charset = com.bytedance.sdk.component.b.b.a.c.f28319e;
            if (vVar != null && (charset = vVar.a()) == null) {
                charset = com.bytedance.sdk.component.b.b.a.c.f28319e;
                vVar = v.a(vVar + "; charset=utf-8");
            }
            return a(vVar, str.getBytes(charset));
        }
        return (aa) invokeLL.objValue;
    }

    public abstract v a();

    public abstract void a(com.bytedance.sdk.component.b.a.d dVar) throws IOException;

    public long b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1L;
        }
        return invokeV.longValue;
    }

    public static aa a(v vVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, vVar, bArr)) == null) ? a(vVar, bArr, 0, bArr.length) : (aa) invokeLL.objValue;
    }

    public static aa a(v vVar, byte[] bArr, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, vVar, bArr, i2, i3)) == null) {
            if (bArr != null) {
                com.bytedance.sdk.component.b.b.a.c.a(bArr.length, i2, i3);
                return new aa(vVar, i3, bArr, i2) { // from class: com.bytedance.sdk.component.b.b.aa.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ v f28581a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f28582b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ byte[] f28583c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ int f28584d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {vVar, Integer.valueOf(i3), bArr, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f28581a = vVar;
                        this.f28582b = i3;
                        this.f28583c = bArr;
                        this.f28584d = i2;
                    }

                    @Override // com.bytedance.sdk.component.b.b.aa
                    public v a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f28581a : (v) invokeV.objValue;
                    }

                    @Override // com.bytedance.sdk.component.b.b.aa
                    public long b() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28582b : invokeV.longValue;
                    }

                    @Override // com.bytedance.sdk.component.b.b.aa
                    public void a(com.bytedance.sdk.component.b.a.d dVar) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                            dVar.c(this.f28583c, this.f28584d, this.f28582b);
                        }
                    }
                };
            }
            throw new NullPointerException("content == null");
        }
        return (aa) invokeLLII.objValue;
    }
}
