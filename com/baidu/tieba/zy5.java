package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ac5;
import com.baidu.tieba.ala.alasquare.livetab.SecondFloorFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zy5 implements eg1<ac5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ac5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public SecondFloorFragment b;

        public a(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ac5
        public void d(@Nullable ac5.a aVar) {
            SecondFloorFragment secondFloorFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && (secondFloorFragment = this.b) != null) {
                secondFloorFragment.M1(aVar);
            }
        }

        @Override // com.baidu.tieba.ac5
        @NonNull
        public Fragment f(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (this.b == null) {
                    SecondFloorFragment secondFloorFragment = new SecondFloorFragment();
                    this.b = secondFloorFragment;
                    secondFloorFragment.N1(str);
                }
                return this.b;
            }
            return (Fragment) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ac5
        public void c() {
            SecondFloorFragment secondFloorFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (secondFloorFragment = this.b) != null) {
                secondFloorFragment.H1();
            }
        }

        @Override // com.baidu.tieba.ac5
        public void e() {
            SecondFloorFragment secondFloorFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (secondFloorFragment = this.b) != null) {
                secondFloorFragment.G1();
            }
        }

        @Override // com.baidu.tieba.ac5
        public void hide() {
            SecondFloorFragment secondFloorFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (secondFloorFragment = this.b) != null) {
                secondFloorFragment.K1();
            }
        }

        @Override // com.baidu.tieba.ac5
        public void show() {
            SecondFloorFragment secondFloorFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (secondFloorFragment = this.b) != null) {
                secondFloorFragment.O1();
            }
        }
    }

    public zy5() {
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
    @Override // com.baidu.tieba.eg1
    /* renamed from: a */
    public ac5 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (ac5) invokeV.objValue;
    }
}
