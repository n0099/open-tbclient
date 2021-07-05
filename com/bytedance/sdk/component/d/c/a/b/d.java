package com.bytedance.sdk.component.d.c.a.b;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.i;
/* loaded from: classes6.dex */
public class d implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final i f28668a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.d.c.a.c f28669b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(i iVar) {
        this(iVar, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((i) objArr2[0], (com.bytedance.sdk.component.d.c.a.c) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d(i iVar, com.bytedance.sdk.component.d.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28668a = iVar;
        this.f28669b = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.d.c.a.a
    @Nullable
    public boolean a(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bitmap)) == null) {
            boolean a2 = this.f28668a.a(str, bitmap);
            com.bytedance.sdk.component.d.c.a.c cVar = this.f28669b;
            if (cVar != null) {
                cVar.a(str, Boolean.valueOf(a2));
            }
            return a2;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.d.c.a.a
    @Nullable
    public Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Bitmap a2 = this.f28668a.a(str);
            com.bytedance.sdk.component.d.c.a.c cVar = this.f28669b;
            if (cVar != null) {
                cVar.b(str, a2);
            }
            return a2;
        }
        return (Bitmap) invokeL.objValue;
    }
}
