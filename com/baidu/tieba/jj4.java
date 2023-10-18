package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public abstract class jj4<E> extends hj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final Context b;
    public final Handler c;
    public final lj4 d;
    public ak4<String, oj4> e;
    public pj4 f;
    public boolean g;
    public boolean h;

    public abstract void m(Fragment fragment);

    public abstract void n(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract LayoutInflater o();

    public abstract int p();

    public abstract boolean q();

    public abstract void r(@NonNull Fragment fragment, @NonNull String[] strArr, int i);

    public abstract boolean s(Fragment fragment);

    public abstract void t(Fragment fragment, Intent intent, int i);

    public abstract void u();

    public jj4(Activity activity, Context context, Handler handler, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, context, handler, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new lj4();
        this.a = activity;
        this.b = context;
        this.c = handler;
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.h);
            if (this.f != null) {
                printWriter.print(str);
                printWriter.print("Loader Manager ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this.f)));
                printWriter.println(":");
                pj4 pj4Var = this.f;
                pj4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jj4(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.a, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (Context) objArr2[1], (Handler) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void c() {
        pj4 pj4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (pj4Var = this.f) == null) {
            return;
        }
        pj4Var.b();
    }

    public Activity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (Activity) invokeV.objValue;
    }

    public Context h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    public lj4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (lj4) invokeV.objValue;
    }

    public Handler j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (Handler) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.h) {
            return;
        }
        this.h = true;
        pj4 pj4Var = this.f;
        if (pj4Var != null) {
            pj4Var.f();
        } else if (!this.g) {
            pj4 k = k("(root)", true, false);
            this.f = k;
            if (k != null && !k.d) {
                k.f();
            }
        }
        this.g = true;
    }

    public void v() {
        ak4<String, oj4> ak4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (ak4Var = this.e) != null) {
            int size = ak4Var.size();
            pj4[] pj4VarArr = new pj4[size];
            for (int i = size - 1; i >= 0; i--) {
                pj4VarArr[i] = (pj4) this.e.k(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                pj4 pj4Var = pj4VarArr[i2];
                pj4Var.i();
                pj4Var.d();
            }
        }
    }

    public void e(boolean z) {
        pj4 pj4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || (pj4Var = this.f) == null || !this.h) {
            return;
        }
        this.h = false;
        if (z) {
            pj4Var.e();
        } else {
            pj4Var.g();
        }
    }

    public void l(String str) {
        ak4<String, oj4> ak4Var;
        pj4 pj4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && (ak4Var = this.e) != null && (pj4Var = (pj4) ak4Var.get(str)) != null && !pj4Var.e) {
            pj4Var.b();
            this.e.remove(str);
        }
    }

    public void w(ak4<String, oj4> ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, ak4Var) == null) {
            this.e = ak4Var;
        }
    }

    public pj4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.e == null) {
                this.e = new ak4<>();
            }
            pj4 pj4Var = (pj4) this.e.get(str);
            if (pj4Var == null) {
                if (z2) {
                    pj4 pj4Var2 = new pj4(str, this, z);
                    this.e.put(str, pj4Var2);
                    return pj4Var2;
                }
                return pj4Var;
            }
            pj4Var.k(this);
            return pj4Var;
        }
        return (pj4) invokeCommon.objValue;
    }

    public ak4<String, oj4> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ak4<String, oj4> ak4Var = this.e;
            int i = 0;
            if (ak4Var != null) {
                int size = ak4Var.size();
                pj4[] pj4VarArr = new pj4[size];
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    pj4VarArr[i2] = (pj4) this.e.k(i2);
                }
                int i3 = 0;
                while (i < size) {
                    pj4 pj4Var = pj4VarArr[i];
                    if (pj4Var.e) {
                        i3 = 1;
                    } else {
                        pj4Var.b();
                        this.e.remove(pj4Var.c);
                    }
                    i++;
                }
                i = i3;
            }
            if (i != 0) {
                return this.e;
            }
            return null;
        }
        return (ak4) invokeV.objValue;
    }
}
