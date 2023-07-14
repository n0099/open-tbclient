package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.ax4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ax4 b;
    public b c;
    public MarkData d;
    public final ax4.a e;

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public class a implements ax4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u46 a;

        public a(u46 u46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u46Var;
        }

        @Override // com.baidu.tieba.ax4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (z2) {
                        yi.R(this.a.a, this.a.a.getString(R.string.add_mark));
                    } else {
                        yi.R(this.a.a, this.a.a.getString(R.string.remove_mark));
                    }
                    if (this.a.c != null) {
                        this.a.c.a(z2);
                    }
                    if (this.a.d != null) {
                        uca ucaVar = new uca();
                        ucaVar.a = this.a.d.getThreadId();
                        ucaVar.b = z2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921603, ucaVar));
                        return;
                    }
                    return;
                }
                yi.R(this.a.a, this.a.a.getString(R.string.update_mark_failed));
            }
        }
    }

    public u46(Context context) {
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
            this.b = ax4.b((BaseActivity) context);
        } else if (context instanceof BaseFragmentActivity) {
            this.b = ax4.c((BaseFragmentActivity) context);
        }
        ax4 ax4Var = this.b;
        if (ax4Var != null) {
            ax4Var.j(this.e);
        }
    }

    public void g(boolean z) {
        ax4 ax4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (ax4Var = this.b) != null) {
            ax4Var.h(z);
        }
    }

    public void h(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, markData) == null) {
            this.d = markData;
            ax4 ax4Var = this.b;
            if (ax4Var != null) {
                ax4Var.i(markData);
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
        ax4 ax4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ax4Var = this.b) != null) {
            ax4Var.a();
            this.b.h(true);
        }
    }

    public void e() {
        ax4 ax4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ax4Var = this.b) != null && ax4Var.e()) {
            this.b.d();
            this.b.h(false);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ax4 ax4Var = this.b;
            if (ax4Var != null) {
                return ax4Var.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
