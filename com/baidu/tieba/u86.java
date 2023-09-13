package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u86 extends bl1<q81> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements q81 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.q81
        public int[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new int[]{R.drawable.nad_web_back} : (int[]) invokeV.objValue;
        }

        @Override // com.baidu.tieba.q81
        public int[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new int[]{R.drawable.nad_web_close} : (int[]) invokeV.objValue;
        }

        /* renamed from: com.baidu.tieba.u86$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC0491a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r81 a;

            public View$OnClickListenerC0491a(a aVar, r81 r81Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, r81Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = r81Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                r81 r81Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (r81Var = this.a) != null) {
                    r81Var.i();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r81 a;

            public b(a aVar, r81 r81Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, r81Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = r81Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                r81 r81Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (r81Var = this.a) != null) {
                    r81Var.k();
                }
            }
        }

        public a(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.q81
        public void a(View view2, r81 r81Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, r81Var) == null) {
                int intValue = ((Integer) view2.getTag()).intValue();
                if (intValue == R.drawable.nad_web_back) {
                    view2.setOnClickListener(new View$OnClickListenerC0491a(this, r81Var));
                } else if (intValue == R.drawable.nad_web_close) {
                    view2.setOnClickListener(new b(this, r81Var));
                }
            }
        }
    }

    public u86() {
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
    public q81 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (q81) invokeV.objValue;
    }
}
