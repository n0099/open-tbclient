package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class og7 extends yf1<sb5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements sb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public sg7 b;

        public a(og7 og7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.sb5
        public void onChangeSkinType(int i) {
            sg7 sg7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (sg7Var = this.b) != null) {
                sg7Var.N(i);
            }
        }

        @Override // com.baidu.tieba.xb5
        public void a(@NonNull TbPageContext tbPageContext, @Nullable List<Long> list, long j, String str, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, list, Long.valueOf(j), str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                sg7 sg7Var = this.b;
                if (sg7Var == null) {
                    this.b = new sg7(tbPageContext, j, str, j2, list, z);
                } else {
                    sg7Var.T(j, str, j2, list, z);
                }
                this.b.V();
            }
        }

        @Override // com.baidu.tieba.sb5
        public void onDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                sg7 sg7Var = this.b;
                if (sg7Var != null) {
                    sg7Var.O();
                }
                this.b = null;
            }
        }

        @Override // com.baidu.tieba.sb5
        public void onPause() {
            sg7 sg7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (sg7Var = this.b) != null) {
                sg7Var.Q();
            }
        }

        @Override // com.baidu.tieba.sb5
        public void onResume() {
            sg7 sg7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (sg7Var = this.b) != null) {
                sg7Var.R();
            }
        }
    }

    public og7() {
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
    @Override // com.baidu.tieba.yf1
    /* renamed from: a */
    public sb5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (sb5) invokeV.objValue;
    }
}
