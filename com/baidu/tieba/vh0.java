package com.baidu.tieba;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.retain.RetainDialogActivity;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class vh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Boolean> a;
    public wg0 b;
    public WeakReference<gh0> c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final vh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-346494451, "Lcom/baidu/tieba/vh0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-346494451, "Lcom/baidu/tieba/vh0$b;");
                    return;
                }
            }
            a = new vh0(null);
        }
    }

    public vh0() {
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
        this.a = new HashMap<>();
    }

    public static vh0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (vh0) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wg0 wg0Var = this.b;
            if (wg0Var != null && wg0Var.c != AdDownloadStatus.COMPLETED) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        WeakReference<gh0> weakReference;
        gh0 gh0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (weakReference = this.c) != null && (gh0Var = weakReference.get()) != null) {
            gh0Var.h();
        }
    }

    public /* synthetic */ vh0(a aVar) {
        this();
    }

    public final boolean b(gh0 gh0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gh0Var)) == null) {
            WeakReference<gh0> weakReference = new WeakReference<>(gh0Var);
            this.c = weakReference;
            gh0 gh0Var2 = weakReference.get();
            if (gh0Var2 != null && gh0Var2.getData() != null) {
                this.b = gh0Var2.getData();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.put(this.b.e(), Boolean.TRUE);
            Intent intent = new Intent();
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtra("ext", this.b.p.a);
            intent.putExtra("alsPage", ClogBuilder.Page.AD_DIALOG);
            intent.putExtra("percent", (int) (this.b.i * 100.0f));
            intent.setClassName(hf0.b().getPackageName(), RetainDialogActivity.class.getName());
            o11.d(hf0.b(), intent);
        }
    }

    public boolean e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (!(obj instanceof gh0) || ij0.b().a().a("key_ad_interrupt_dialog_switch", 1) == 0) {
                return false;
            }
            boolean b2 = b((gh0) obj);
            int a2 = ij0.b().a().a("key_ad_interrupt_dialog_target_percnet", 50);
            if (!b2) {
                return false;
            }
            wg0 wg0Var = this.b;
            if (wg0Var.i * 100.0f < a2 || this.a.get(wg0Var.e()) != null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
