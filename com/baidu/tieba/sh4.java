package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes5.dex */
public class sh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public b b;
    public a c;
    public Context d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public interface b {
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            StringBuilder sb = new StringBuilder(64);
            vh4.a(obj, sb);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (this.c == null) {
                this.c = aVar;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            b bVar2 = this.b;
            if (bVar2 != null) {
                if (bVar2 == bVar) {
                    this.b = null;
                    return;
                }
                throw new IllegalArgumentException("Attempting to unregister the wrong listener");
            }
            throw new IllegalStateException("No listener register");
        }
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            a aVar2 = this.c;
            if (aVar2 != null) {
                if (aVar2 == aVar) {
                    this.c = null;
                    return;
                }
                throw new IllegalArgumentException("Attempting to unregister the wrong listener");
            }
            throw new IllegalStateException("No listener register");
        }
    }

    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mListener=");
            printWriter.println(this.b);
            if (this.e || this.h || this.i) {
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.e);
                printWriter.print(" mContentChanged=");
                printWriter.print(this.h);
                printWriter.print(" mProcessingChange=");
                printWriter.println(this.i);
            }
            if (this.f || this.g) {
                printWriter.print(str);
                printWriter.print("mAbandoned=");
                printWriter.print(this.f);
                printWriter.print(" mReset=");
                printWriter.println(this.g);
            }
        }
    }

    public void f(int i, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bVar) == null) {
            if (this.b == null) {
                this.b = bVar;
                this.a = i;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (Context) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c();
            this.g = true;
            this.e = false;
            this.f = false;
            this.h = false;
            this.i = false;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e = true;
            this.g = false;
            this.f = false;
            d();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e = false;
            e();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StringBuilder sb = new StringBuilder(64);
            vh4.a(this, sb);
            sb.append(" id=");
            sb.append(this.a);
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
