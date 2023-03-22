package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.xs4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class kv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public xs4 b;
    public b c;
    public MarkData d;
    public final xs4.a e;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public class a implements xs4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv5 a;

        public a(kv5 kv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv5Var;
        }

        @Override // com.baidu.tieba.xs4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (z2) {
                        hi.Q(this.a.a, this.a.a.getString(R.string.add_mark));
                    } else {
                        hi.Q(this.a.a, this.a.a.getString(R.string.remove_mark));
                    }
                    if (this.a.c != null) {
                        this.a.c.a(z2);
                    }
                    if (this.a.d != null) {
                        xb9 xb9Var = new xb9();
                        xb9Var.a = this.a.d.getThreadId();
                        xb9Var.b = z2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, xb9Var));
                        return;
                    }
                    return;
                }
                hi.Q(this.a.a, this.a.a.getString(R.string.update_mark_failed));
            }
        }
    }

    public kv5(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.e = new a(this);
        this.a = context;
        if (context instanceof BaseActivity) {
            this.b = xs4.b((BaseActivity) context);
        } else if (context instanceof BaseFragmentActivity) {
            this.b = xs4.c((BaseFragmentActivity) context);
        }
        xs4 xs4Var = this.b;
        if (xs4Var != null) {
            xs4Var.j(this.e);
        }
    }

    public void g(boolean z) {
        xs4 xs4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (xs4Var = this.b) != null) {
            xs4Var.h(z);
        }
    }

    public void h(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, markData) == null) {
            this.d = markData;
            xs4 xs4Var = this.b;
            if (xs4Var != null) {
                xs4Var.i(markData);
            }
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public void d() {
        xs4 xs4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (xs4Var = this.b) != null) {
            xs4Var.a();
            this.b.h(true);
        }
    }

    public void e() {
        xs4 xs4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (xs4Var = this.b) != null && xs4Var.e()) {
            this.b.d();
            this.b.h(false);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            xs4 xs4Var = this.b;
            if (xs4Var != null) {
                return xs4Var.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
