package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.tieba.y74;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class z74 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public ud2 a;
    public s04 b;
    public String c;

    /* loaded from: classes9.dex */
    public class a implements y74.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z74 a;

        public a(z74 z74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z74Var;
        }

        @Override // com.baidu.tieba.y74.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) {
                return;
            }
            this.a.B(false);
            e74.j(this.a.c, i, "");
        }

        @Override // com.baidu.tieba.y74.a
        public void a(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || !this.a.hasEventListener("progressupdate")) {
                return;
            }
            a84 a84Var = new a84();
            a84Var.progress = i;
            a84Var.totalBytesWritten = j;
            a84Var.totalBytesExpectedToWrite = j2;
            JSEvent jSEvent = new JSEvent("progressupdate");
            jSEvent.data = a84Var;
            if (z74.d) {
                Log.i("LoadSubpackageTask", "progress :" + i + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
            }
            this.a.dispatchEvent(jSEvent);
        }

        @Override // com.baidu.tieba.y74.a
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                z74 z74Var = this.a;
                this.a.B(z74Var.C(z74Var.c));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ z74 b;

        public b(z74 z74Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z74Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z74Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a) {
                    if (this.b.b != null) {
                        this.b.b.c();
                        if (z74.d) {
                            Log.i("LoadSubpackageTask", "success call");
                        }
                    }
                } else if (this.b.b != null) {
                    this.b.b.a();
                    if (z74.d) {
                        Log.i("LoadSubpackageTask", "fail call");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948312850, "Lcom/baidu/tieba/z74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948312850, "Lcom/baidu/tieba/z74;");
                return;
            }
        }
        d = vm1.a;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = null;
            this.c = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z74(ud2 ud2Var) {
        super(ud2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ud2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ud2Var;
    }

    public void D(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            F();
            E(jsObject);
            if (TextUtils.isEmpty(this.c)) {
                if (d) {
                    Log.i("LoadSubpackageTask", IActiveUploadListener.PARAM_ERR_MSG);
                }
                e74.j(this.c, 2111, "");
                return;
            }
            y74.a(this.c, new a(this));
        }
    }

    public final void E(JsObject jsObject) {
        sy1 G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jsObject) != null) || jsObject == null || (G = sy1.G(jsObject)) == null) {
            return;
        }
        this.b = s04.e(G);
        try {
            this.c = G.g("name");
        } catch (JSTypeMismatchException e) {
            if (d) {
                e.printStackTrace();
            }
            w84.e(this.a, e);
            F();
        }
    }

    public final void B(boolean z) {
        ud2 ud2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (ud2Var = this.a) != null) {
            ud2Var.runOnJSThread(new b(this, z));
        }
    }

    public final boolean C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.a == null) {
                return false;
            }
            String str2 = xr2.V().A() + x74.b().c(str, 2);
            String c = x74.b().c(str, 3);
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c)) {
                return false;
            }
            this.a.X(str2, c);
            return true;
        }
        return invokeL.booleanValue;
    }
}
