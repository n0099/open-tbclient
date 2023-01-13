package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.tieba.sf2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public abstract class vf2<T extends sf2> extends ue2<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public CopyOnWriteArrayList<cj3<Exception>> b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf2 a;

        public a(vf2 vf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j12.k("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                uf2 b = uf2.b(this.a.a);
                pf2 pf2Var = new pf2();
                pf2Var.a = b.a;
                pf2Var.b = b.b;
                pf2Var.c = this.a.a.a();
                vf2 vf2Var = this.a;
                vf2Var.l(vf2Var.g(pf2Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cj3 a;
        public final /* synthetic */ Exception b;

        public b(vf2 vf2Var, cj3 cj3Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf2Var, cj3Var, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cj3Var;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948238791, "Lcom/baidu/tieba/vf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948238791, "Lcom/baidu/tieba/vf2;");
                return;
            }
        }
        c = tk1.a;
    }

    @Override // com.baidu.tieba.ue2
    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new File(super.a(), "preset");
        }
        return (File) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            o("0");
            n(0L);
        }
    }

    @NonNull
    public ExtensionCore h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ExtensionCore extensionCore = new ExtensionCore();
            long i = i();
            extensionCore.extensionCoreVersionCode = i;
            extensionCore.extensionCoreVersionName = j();
            extensionCore.extensionCorePath = b(i).getPath();
            extensionCore.extensionCoreType = 0;
            return extensionCore;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return xc3.a().getLong(this.a.b(), 0L);
        }
        return invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return xc3.a().getString(this.a.e(), "");
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vf2(@NonNull T t) {
        super(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((sf2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new CopyOnWriteArrayList<>();
    }

    public final void l(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            Iterator<cj3<Exception>> it = this.b.iterator();
            while (it.hasNext()) {
                m(it.next(), exc);
            }
            this.b.clear();
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            xc3.a().putLong(this.a.b(), j);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            xc3.a().putString(this.a.e(), str);
        }
    }

    public final void m(@Nullable cj3<Exception> cj3Var, Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cj3Var, exc) == null) && cj3Var != null) {
            di3.e0(new b(this, cj3Var, exc));
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/tieba/pf2;>(TT;)Ljava/lang/Exception; */
    public Exception g(@NonNull pf2 pf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pf2Var)) == null) {
            if (c) {
                Log.d("ExtCore-PresetControl", "doUpdate: preset");
            }
            if (TextUtils.isEmpty(pf2Var.c)) {
                if (c) {
                    Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
                }
                return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
            }
            long j = pf2Var.b;
            if (nk4.V(pf2Var.c, b(j).getPath())) {
                ag2.b(a(), j);
                n(j);
                o(pf2Var.a);
                ag2.i(this.a.c(), false);
                return null;
            }
            Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + pf2Var.c);
            if (c) {
                Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            }
            return exc;
        }
        return (Exception) invokeL.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!h().isAvailable()) {
                if (c) {
                    Log.d("ExtCore-PresetControl", "isNeedUpdate: true, getCurExtensionCore not available.");
                }
                return true;
            } else if (!ag2.h(this.a.c())) {
                if (c) {
                    Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                }
                return false;
            } else {
                uf2 b2 = uf2.b(this.a);
                long i = i();
                long j = b2.b;
                if (c) {
                    Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + i + " newVer: " + j);
                }
                if (i < j) {
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"SwanNewThread"})
    public void p(@Nullable cj3<Exception> cj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cj3Var) == null) {
            j12.k("ExtCore-PresetControl", "tryUpdateAsync: start");
            if (!k()) {
                j12.k("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
                m(cj3Var, null);
                return;
            }
            if (this.b.isEmpty()) {
                new Thread(new a(this), "updateExtensionCoreAsync").start();
            }
            if (cj3Var != null) {
                this.b.add(cj3Var);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !k()) {
            return;
        }
        uf2 b2 = uf2.b(this.a);
        pf2 pf2Var = new pf2();
        pf2Var.a = b2.a;
        pf2Var.b = b2.b;
        pf2Var.c = this.a.a();
        l(g(pf2Var));
    }
}
