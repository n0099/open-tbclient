package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class j16 extends qj1<uj0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements uj0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.uj0
        public boolean a(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.uj0
        public ViewGroup b(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
                return null;
            }
            return (ViewGroup) invokeL.objValue;
        }

        @Override // com.baidu.tieba.uj0
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.uj0
        public void e(Activity activity, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048580, this, activity, j) == null) {
            }
        }

        @Override // com.baidu.tieba.uj0
        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.drawable.tb_launcher_icon : invokeV.intValue;
        }

        public a(j16 j16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.uj0
        public yk0 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                yk0 yk0Var = new yk0();
                yk0Var.a = R.layout.obfuscated_res_0x7f0d006e;
                yk0Var.b = R.id.obfuscated_res_0x7f0900e9;
                yk0Var.c = R.id.obfuscated_res_0x7f0900e7;
                yk0Var.d = R.id.obfuscated_res_0x7f0900ea;
                yk0Var.e = R.id.obfuscated_res_0x7f0900e8;
                return yk0Var;
            }
            return (yk0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.uj0
        public boolean isMainActivity(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
                if (activity == null || TextUtils.isEmpty(activity.getClass().getSimpleName()) || !"MainTabActivity".equals(activity.getClass().getSimpleName())) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public j16() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qj1
    /* renamed from: a */
    public uj0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (uj0) invokeV.objValue;
    }
}
