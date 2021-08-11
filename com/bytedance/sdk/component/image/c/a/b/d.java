package com.bytedance.sdk.component.image.c.a.b;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.IMemoryCache;
/* loaded from: classes9.dex */
public class d implements IMemoryCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final IMemoryCache f64820a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.image.c.a.c f64821b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(IMemoryCache iMemoryCache) {
        this(iMemoryCache, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMemoryCache};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((IMemoryCache) objArr2[0], (com.bytedance.sdk.component.image.c.a.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d(IMemoryCache iMemoryCache, com.bytedance.sdk.component.image.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMemoryCache, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64820a = iMemoryCache;
        this.f64821b = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.image.c.a.a
    @Nullable
    public boolean a(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bitmap)) == null) {
            boolean a2 = this.f64820a.a(str, bitmap);
            com.bytedance.sdk.component.image.c.a.c cVar = this.f64821b;
            if (cVar != null) {
                cVar.a(str, Boolean.valueOf(a2));
            }
            return a2;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.image.c.a.a
    @Nullable
    public Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Bitmap a2 = this.f64820a.a((IMemoryCache) str);
            com.bytedance.sdk.component.image.c.a.c cVar = this.f64821b;
            if (cVar != null) {
                cVar.b(str, a2);
            }
            return a2;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.image.c.a.a
    public void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f64820a.a(d2);
        }
    }
}
