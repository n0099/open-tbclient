package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
/* loaded from: classes5.dex */
public class f extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, ViewGroup viewGroup, m mVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, mVar, str, z, z2, z3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ViewGroup) objArr2[1], (m) objArr2[2], (String) objArr2[3], ((Boolean) objArr2[4]).booleanValue(), ((Boolean) objArr2[5]).booleanValue(), ((Boolean) objArr2[6]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.g
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            super.a(i2, i3);
            i iVar = this.f30848a;
            if (iVar == null || i2 <= 0 || i3 <= 0) {
                return;
            }
            iVar.c(i2, i3);
            this.f30848a.a(i2, i3);
            d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.g
    public com.bytedance.sdk.openadsdk.core.video.renderview.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i iVar = this.f30848a;
            if (iVar != null) {
                return iVar.o();
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.core.video.renderview.b) invokeV.objValue;
    }
}
