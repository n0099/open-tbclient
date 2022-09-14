package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public abstract class tg4<E> extends rg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final Context b;
    public final Handler c;
    public final int d;
    public final vg4 e;
    public kh4<String, yg4> f;
    public zg4 g;
    public boolean h;
    public boolean i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public tg4(FragmentActivity fragmentActivity) {
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

    @Override // com.baidu.tieba.rg4
    @Nullable
    public View a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return null;
        }
        return (View) invokeI.objValue;
    }

    @Override // com.baidu.tieba.rg4
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        zg4 zg4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (zg4Var = this.g) == null) {
            return;
        }
        zg4Var.b();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.i) {
            return;
        }
        this.i = true;
        zg4 zg4Var = this.g;
        if (zg4Var != null) {
            zg4Var.f();
        } else if (!this.h) {
            zg4 i = i("(root)", true, false);
            this.g = i;
            if (i != null && !i.d) {
                i.f();
            }
        }
        this.h = true;
    }

    public void e(boolean z) {
        zg4 zg4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (zg4Var = this.g) != null && this.i) {
            this.i = false;
            if (z) {
                zg4Var.e();
            } else {
                zg4Var.g();
            }
        }
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.i);
            if (this.g != null) {
                printWriter.print(str);
                printWriter.print("Loader Manager ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this.g)));
                printWriter.println(":");
                zg4 zg4Var = this.g;
                zg4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public vg4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (vg4) invokeV.objValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (Activity) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : (Context) invokeV.objValue;
    }

    public Handler h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (Handler) invokeV.objValue;
    }

    public zg4 i(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f == null) {
                this.f = new kh4<>();
            }
            zg4 zg4Var = (zg4) this.f.get(str);
            if (zg4Var != null) {
                zg4Var.k(this);
                return zg4Var;
            } else if (z2) {
                zg4 zg4Var2 = new zg4(str, this, z);
                this.f.put(str, zg4Var2);
                return zg4Var2;
            } else {
                return zg4Var;
            }
        }
        return (zg4) invokeCommon.objValue;
    }

    public void j(String str) {
        kh4<String, yg4> kh4Var;
        zg4 zg4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (kh4Var = this.f) == null || (zg4Var = (zg4) kh4Var.get(str)) == null || zg4Var.e) {
            return;
        }
        zg4Var.b();
        this.f.remove(str);
    }

    public void k(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fragment) == null) {
        }
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    public LayoutInflater m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (LayoutInflater) this.b.getSystemService("layout_inflater") : (LayoutInflater) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void p(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, fragment, strArr, i) == null) {
        }
    }

    public boolean q(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fragment)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(Fragment fragment, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, fragment, intent, i) == null) {
            if (i == -1) {
                this.b.startActivity(intent);
                return;
            }
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void t() {
        kh4<String, yg4> kh4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (kh4Var = this.f) == null) {
            return;
        }
        int size = kh4Var.size();
        zg4[] zg4VarArr = new zg4[size];
        for (int i = size - 1; i >= 0; i--) {
            zg4VarArr[i] = (zg4) this.f.k(i);
        }
        for (int i2 = 0; i2 < size; i2++) {
            zg4 zg4Var = zg4VarArr[i2];
            zg4Var.i();
            zg4Var.d();
        }
    }

    public void u(kh4<String, yg4> kh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, kh4Var) == null) {
            this.f = kh4Var;
        }
    }

    public kh4<String, yg4> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            kh4<String, yg4> kh4Var = this.f;
            int i = 0;
            if (kh4Var != null) {
                int size = kh4Var.size();
                zg4[] zg4VarArr = new zg4[size];
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    zg4VarArr[i2] = (zg4) this.f.k(i2);
                }
                int i3 = 0;
                while (i < size) {
                    zg4 zg4Var = zg4VarArr[i];
                    if (zg4Var.e) {
                        i3 = 1;
                    } else {
                        zg4Var.b();
                        this.f.remove(zg4Var.c);
                    }
                    i++;
                }
                i = i3;
            }
            if (i != 0) {
                return this.f;
            }
            return null;
        }
        return (kh4) invokeV.objValue;
    }

    public tg4(Activity activity, Context context, Handler handler, int i) {
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
        this.e = new vg4();
        this.a = activity;
        this.b = context;
        this.c = handler;
        this.d = i;
    }
}
