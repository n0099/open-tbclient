package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.c67;
import com.baidu.tieba.compact.CardPeiWanViewImpl;
import com.baidu.tieba.compact.SocialBarImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lr6 extends bl1<c67.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements c67.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(lr6 lr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c67.b
        @NonNull
        public c67.o a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new SocialBarImpl();
            }
            return (c67.o) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.j b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new rr6();
            }
            return (c67.j) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.q c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new is6();
            }
            return (c67.q) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.h d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new or6();
            }
            return (c67.h) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.e e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return new hr6();
            }
            return (c67.e) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.p f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return new gs6();
            }
            return (c67.p) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.k g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new sr6();
            }
            return (c67.k) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.l h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return new tr6();
            }
            return (c67.l) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.n i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return new es6();
            }
            return (c67.n) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        @NonNull
        public c67.m j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return new vr6();
            }
            return (c67.m) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.f k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return new CardPeiWanViewImpl();
            }
            return (c67.f) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.i l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return new qr6();
            }
            return (c67.i) invokeV.objValue;
        }

        @Override // com.baidu.tieba.c67.b
        public c67.g m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return new jr6();
            }
            return (c67.g) invokeV.objValue;
        }
    }

    public lr6() {
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
    @Override // com.baidu.tieba.bl1
    /* renamed from: a */
    public c67.b createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (c67.b) invokeV.objValue;
    }
}
