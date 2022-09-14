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
import com.baidu.tieba.m44;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n44 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public ia2 a;
    public gx3 b;
    public String c;

    /* loaded from: classes5.dex */
    public class a implements m44.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n44 a;

        public a(n44 n44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n44Var;
        }

        @Override // com.baidu.tieba.m44.a
        public void a(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) && this.a.hasEventListener("progressupdate")) {
                o44 o44Var = new o44();
                o44Var.progress = i;
                o44Var.totalBytesWritten = j;
                o44Var.totalBytesExpectedToWrite = j2;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = o44Var;
                if (n44.d) {
                    Log.i("LoadSubpackageTask", "progress :" + i + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                }
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.baidu.tieba.m44.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.C(false);
                s34.j(this.a.c, i, "");
            }
        }

        @Override // com.baidu.tieba.m44.a
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                n44 n44Var = this.a;
                this.a.C(n44Var.D(n44Var.c));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ n44 b;

        public b(n44 n44Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n44Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n44Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a) {
                    if (this.b.b != null) {
                        this.b.b.c();
                        if (n44.d) {
                            Log.i("LoadSubpackageTask", "success call");
                        }
                    }
                } else if (this.b.b != null) {
                    this.b.b.a();
                    if (n44.d) {
                        Log.i("LoadSubpackageTask", "fail call");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947952475, "Lcom/baidu/tieba/n44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947952475, "Lcom/baidu/tieba/n44;");
                return;
            }
        }
        d = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n44(ia2 ia2Var) {
        super(ia2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ia2Var};
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
        this.a = ia2Var;
    }

    public final void C(boolean z) {
        ia2 ia2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (ia2Var = this.a) == null) {
            return;
        }
        ia2Var.runOnJSThread(new b(this, z));
    }

    public final boolean D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.a == null) {
                return false;
            }
            String str2 = lo2.U().z() + l44.b().c(str, 2);
            String c = l44.b().c(str, 3);
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c)) {
                return false;
            }
            this.a.Z(str2, c);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            G();
            F(jsObject);
            if (TextUtils.isEmpty(this.c)) {
                if (d) {
                    Log.i("LoadSubpackageTask", IActiveUploadListener.PARAM_ERR_MSG);
                }
                s34.j(this.c, 2111, "");
                return;
            }
            m44.a(this.c, new a(this));
        }
    }

    public final void F(JsObject jsObject) {
        fv1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) || jsObject == null || (F = fv1.F(jsObject)) == null) {
            return;
        }
        this.b = gx3.e(F);
        try {
            this.c = F.g("name");
        } catch (JSTypeMismatchException e) {
            if (d) {
                e.printStackTrace();
            }
            k54.d(this.a, e);
            G();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = null;
            this.c = null;
        }
    }
}
