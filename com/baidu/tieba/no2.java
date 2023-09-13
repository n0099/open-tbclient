package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.la3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class no2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile no2 b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc2 a;

        public a(no2 no2Var, tc2 tc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no2Var, tc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                ai3.e("cancel");
                this.a.a(Boolean.FALSE);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc2 a;

        public b(no2 no2Var, tc2 tc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no2Var, tc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                ai3.e("confirm");
                this.a.a(Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(no2 no2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                ai3.e("show");
            }
        }
    }

    public no2() {
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

    public static no2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (no2.class) {
                    if (b == null) {
                        b = new no2();
                    }
                }
            }
            return b;
        }
        return (no2) invokeV.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, null) != null) || b == null) {
            return;
        }
        if (b.a != null) {
            b.a = null;
        }
        b = null;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !TextUtils.isEmpty(this.a);
        }
        return invokeV.booleanValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = str;
        }
    }

    public void f(Activity activity, tc2<Boolean> tc2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, activity, tc2Var) == null) && activity != null && tc2Var != null) {
            la3.a aVar = new la3.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f0148);
            aVar.x(b().a());
            aVar.n(new pq3());
            aVar.m(true);
            aVar.Q(R.color.obfuscated_res_0x7f060450);
            aVar.O(R.string.obfuscated_res_0x7f0f013f, new a(this, tc2Var));
            aVar.B(R.string.obfuscated_res_0x7f0f0147, new b(this, tc2Var));
            aVar.N(new c(this));
            aVar.X();
        }
    }
}
