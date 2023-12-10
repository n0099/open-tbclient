package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment;
import com.baidu.tieba.newinterest.model.InterestSelectionStyleAModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class rs9<V> implements bt9<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterestSelectionStyleAModel a;
    public ks9 b;
    public BaseInterestSelectionFragment c;

    public rs9(BaseInterestSelectionFragment baseInterestSelectionFragment, ks9 ks9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestSelectionFragment, ks9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = baseInterestSelectionFragment;
        this.b = ks9Var;
        this.a = new InterestSelectionStyleAModel(ks9Var, this);
    }

    @Override // com.baidu.tieba.bt9
    public void a(V v) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, v) == null) && (baseInterestSelectionFragment = this.c) != null) {
            baseInterestSelectionFragment.H2();
        }
    }

    public void b() {
        InterestSelectionStyleAModel interestSelectionStyleAModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (interestSelectionStyleAModel = this.a) != null) {
            interestSelectionStyleAModel.onDestroy();
        }
    }

    public void c() {
        InterestSelectionStyleAModel interestSelectionStyleAModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (interestSelectionStyleAModel = this.a) != null) {
            interestSelectionStyleAModel.T();
        }
    }

    @Override // com.baidu.tieba.bt9
    public void onError(int i, String str) {
        BaseInterestSelectionFragment baseInterestSelectionFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (baseInterestSelectionFragment = this.c) != null) {
            baseInterestSelectionFragment.I2(str);
        }
    }
}
