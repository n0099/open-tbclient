package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.qd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class td8<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zd8<T> a;
    public qd8 b;
    public rd8 c;
    public T d;
    public b e;

    /* loaded from: classes8.dex */
    public interface b {
        void b();

        void onCancel();
    }

    /* loaded from: classes8.dex */
    public class a implements rd8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ td8 b;

        public a(td8 td8Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = td8Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.rd8
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

        @Override // com.baidu.tieba.rd8
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

    public td8(Context context, zd8<T> zd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, zd8Var};
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
        f(context, zd8Var);
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
        zd8<T> zd8Var = this.a;
        if (zd8Var != null) {
            zd8Var.h();
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

    public final void f(final Context context, zd8<T> zd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, zd8Var) == null) {
            this.a = zd8Var;
            zd8Var.n(this.c);
            qd8 qd8Var = new qd8(context, R.style.obfuscated_res_0x7f10010d);
            this.b = qd8Var;
            qd8Var.setContentView(this.a.j());
            this.b.a(new qd8.a() { // from class: com.baidu.tieba.pd8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.qd8.a
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        td8.this.h(context);
                    }
                }
            });
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f10041b);
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
