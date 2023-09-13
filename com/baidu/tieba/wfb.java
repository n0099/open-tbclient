package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.egb;
import com.baidu.tieba.xfb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class wfb implements egb.a {
    public static /* synthetic */ Interceptable $ic;
    public static wfb f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, egb> a;
    public vfb b;
    public ExecutorService c;
    public cgb d;
    public Handler e;

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wfb b;

        public a(wfb wfbVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wfbVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wfbVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.containsKey(this.a)) {
                this.b.a.remove(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wfb a;

        public b(wfb wfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wfbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (egb egbVar : this.a.a.values()) {
                    if (egbVar != null && egbVar.isRunning()) {
                        egbVar.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wfb a;

        public c(wfb wfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wfbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (egb egbVar : this.a.a.values()) {
                    if (egbVar != null && egbVar.isRunning()) {
                        egbVar.cancel();
                    }
                }
            }
        }
    }

    public wfb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Handler(Looper.getMainLooper());
        this.a = new LinkedHashMap();
        i(new vfb());
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                egb egbVar = this.a.get(e);
                if (egbVar != null) {
                    egbVar.cancel();
                }
                this.a.remove(e);
            }
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                return String.valueOf(str.hashCode());
            }
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return (String) invokeL.objValue;
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        egb egbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.a.containsKey(str) && (egbVar = this.a.get(str)) != null && egbVar.isRunning()) {
                oib.d("DownloadInfo has been started!");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        egb egbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String e = e(str);
            if (this.a.containsKey(e) && (egbVar = this.a.get(e)) != null) {
                return egbVar.isRunning();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static wfb h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (wfb.class) {
                    if (f == null) {
                        f = new wfb();
                    }
                }
            }
            return f;
        }
        return (wfb) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.post(new c(this));
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.post(new b(this));
        }
    }

    @Override // com.baidu.tieba.egb.a
    public void a(String str, egb egbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, egbVar) == null) {
            this.e.post(new a(this, str));
        }
    }

    public void f(xfb xfbVar, String str, zfb zfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, xfbVar, str, zfbVar) == null) {
            String e = e(str);
            if (!j(e)) {
                kgb kgbVar = new kgb(xfbVar, new hgb(this.d, zfbVar), this.c, e, this.b, this);
                this.a.put(e, kgbVar);
                kgbVar.start();
            }
        }
    }

    public void g(String str, String str2, String str3, zfb zfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, zfbVar) == null) {
            xfb.b bVar = new xfb.b();
            bVar.d(str);
            bVar.b(new File(str2));
            bVar.c(str3);
            f(bVar.a(), str, zfbVar);
        }
    }

    public final void i(@NonNull vfb vfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vfbVar) == null) {
            if (vfbVar.b() <= vfbVar.a()) {
                this.b = vfbVar;
                this.c = Executors.newFixedThreadPool(vfbVar.a());
                this.d = new igb(this.e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            String e = e(str);
            if (this.a.containsKey(e)) {
                egb egbVar = this.a.get(e);
                if (egbVar != null && egbVar.isRunning()) {
                    egbVar.pause();
                }
                this.a.remove(e);
            }
        }
    }
}
