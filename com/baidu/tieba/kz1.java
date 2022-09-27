package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class kz1 extends az1<CameraPreview, fw1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz1(@NonNull Context context, @NonNull fw1 fw1Var) {
        super(context, fw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fw1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (bz1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.az1
    @NonNull
    /* renamed from: F */
    public CameraPreview v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new CameraPreview(context, n()) : (CameraPreview) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.az1
    /* renamed from: G */
    public void C(@NonNull CameraPreview cameraPreview, @NonNull fw1 fw1Var, @NonNull d02 d02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cameraPreview, fw1Var, d02Var) == null) {
            super.C(cameraPreview, fw1Var, d02Var);
            if (t()) {
                cameraPreview.p(fw1Var);
            }
        }
    }

    @Override // com.baidu.tieba.az1
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.z();
            CameraPreview q = q();
            if (q != null) {
                q.h();
            }
        }
    }
}
