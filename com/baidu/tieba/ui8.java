package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.ri8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ui8<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aj8<T> a;
    public ri8 b;
    public si8 c;
    public T d;
    public b e;

    /* loaded from: classes8.dex */
    public interface b {
        void b();

        void onCancel();
    }

    /* loaded from: classes8.dex */
    public class a implements si8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ui8 b;

        public a(ui8 ui8Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ui8Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.si8
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.b != null) {
                BdUtilHelper.hideSoftKeyPad(this.a, this.b.a.j());
                if (this.b.a != null) {
                    this.b.a.h();
                }
                this.b.b.dismiss();
                if (this.b.e != null) {
                    this.b.e.onCancel();
                }
            }
        }

        @Override // com.baidu.tieba.si8
        public void b(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.b.b != null) {
                BdUtilHelper.hideSoftKeyPad(this.a, this.b.a.j());
                if (this.b.a != null) {
                    this.b.a.h();
                }
                this.b.b.dismiss();
                if (this.b.e != null) {
                    this.b.e.b();
                }
            }
        }
    }

    public ui8(Context context, aj8<T> aj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aj8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e(context);
        f(context, aj8Var);
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.c = new a(this, context);
        }
    }

    public /* synthetic */ void h(Context context) {
        if (g(context, this.b.getWindow().getDecorView().findViewById(16908290))) {
            BdUtilHelper.hideSoftKeyPad(context, this.a.j());
            return;
        }
        aj8<T> aj8Var = this.a;
        if (aj8Var != null) {
            aj8Var.h();
        }
        this.b.dismiss();
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.b != null && d()) {
            this.b.show();
        }
    }

    public final void f(final Context context, aj8<T> aj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, aj8Var) == null) {
            this.a = aj8Var;
            aj8Var.n(this.c);
            ri8 ri8Var = new ri8(context, R.style.obfuscated_res_0x7f10010d);
            this.b = ri8Var;
            ri8Var.setContentView(this.a.j());
            this.b.a(new ri8.a() { // from class: com.baidu.tieba.qi8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ri8.a
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ui8.this.h(context);
                    }
                }
            });
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100424);
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
    }

    public final boolean g(Context context, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            if (iArr[1] >= context.getResources().getDisplayMetrics().heightPixels / 2) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void j(T t, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, t, metaData) == null) {
            this.d = t;
            this.a.o(t, metaData);
        }
    }
}
