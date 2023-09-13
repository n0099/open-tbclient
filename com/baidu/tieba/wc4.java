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
import com.baidu.tieba.vc4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wc4 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public ri2 a;
    public p54 b;
    public String c;

    /* loaded from: classes8.dex */
    public class a implements vc4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wc4 a;

        public a(wc4 wc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wc4Var;
        }

        @Override // com.baidu.tieba.vc4.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) {
                return;
            }
            this.a.B(false);
            bc4.j(this.a.c, i, "");
        }

        @Override // com.baidu.tieba.vc4.a
        public void a(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || !this.a.hasEventListener("progressupdate")) {
                return;
            }
            xc4 xc4Var = new xc4();
            xc4Var.progress = i;
            xc4Var.totalBytesWritten = j;
            xc4Var.totalBytesExpectedToWrite = j2;
            JSEvent jSEvent = new JSEvent("progressupdate");
            jSEvent.data = xc4Var;
            if (wc4.d) {
                Log.i("LoadSubpackageTask", "progress :" + i + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
            }
            this.a.dispatchEvent(jSEvent);
        }

        @Override // com.baidu.tieba.vc4.a
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                wc4 wc4Var = this.a;
                this.a.B(wc4Var.C(wc4Var.c));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ wc4 b;

        public b(wc4 wc4Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc4Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wc4Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a) {
                    if (this.b.b != null) {
                        this.b.b.c();
                        if (wc4.d) {
                            Log.i("LoadSubpackageTask", "success call");
                        }
                    }
                } else if (this.b.b != null) {
                    this.b.b.a();
                    if (wc4.d) {
                        Log.i("LoadSubpackageTask", "fail call");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948265761, "Lcom/baidu/tieba/wc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948265761, "Lcom/baidu/tieba/wc4;");
                return;
            }
        }
        d = rr1.a;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = null;
            this.c = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wc4(ri2 ri2Var) {
        super(ri2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var};
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
        this.a = ri2Var;
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
                bc4.j(this.c, 2111, "");
                return;
            }
            vc4.a(this.c, new a(this));
        }
    }

    public final void E(JsObject jsObject) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jsObject) != null) || jsObject == null || (F = o32.F(jsObject)) == null) {
            return;
        }
        this.b = p54.e(F);
        try {
            this.c = F.g("name");
        } catch (JSTypeMismatchException e) {
            if (d) {
                e.printStackTrace();
            }
            td4.d(this.a, e);
            F();
        }
    }

    public final void B(boolean z) {
        ri2 ri2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (ri2Var = this.a) != null) {
            ri2Var.runOnJSThread(new b(this, z));
        }
    }

    public final boolean C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.a == null) {
                return false;
            }
            String str2 = uw2.T().z() + uc4.b().c(str, 2);
            String c = uc4.b().c(str, 3);
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c)) {
                return false;
            }
            this.a.V(str2, c);
            return true;
        }
        return invokeL.booleanValue;
    }
}
