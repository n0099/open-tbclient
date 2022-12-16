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
/* loaded from: classes5.dex */
public class kl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Boolean> a;
    public lk0 b;
    public WeakReference<vk0> c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final kl0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-657721028, "Lcom/baidu/tieba/kl0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-657721028, "Lcom/baidu/tieba/kl0$b;");
                    return;
                }
            }
            a = new kl0(null);
        }
    }

    public kl0() {
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

    public static kl0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (kl0) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            lk0 lk0Var = this.b;
            if (lk0Var != null && lk0Var.c != AdDownloadStatus.COMPLETED) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        WeakReference<vk0> weakReference;
        vk0 vk0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (weakReference = this.c) != null && (vk0Var = weakReference.get()) != null) {
            vk0Var.i();
        }
    }

    public /* synthetic */ kl0(a aVar) {
        this();
    }

    public final boolean b(vk0 vk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vk0Var)) == null) {
            WeakReference<vk0> weakReference = new WeakReference<>(vk0Var);
            this.c = weakReference;
            vk0 vk0Var2 = weakReference.get();
            if (vk0Var2 != null && vk0Var2.getData() != null) {
                this.b = vk0Var2.getData();
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
            intent.setClassName(zi0.b().getPackageName(), RetainDialogActivity.class.getName());
            g31.d(zi0.b(), intent);
        }
    }

    public boolean e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (!(obj instanceof vk0) || qm0.b().a().a("key_ad_interrupt_dialog_switch", 1) == 0) {
                return false;
            }
            boolean b2 = b((vk0) obj);
            int a2 = qm0.b().a().a("key_ad_interrupt_dialog_target_percnet", 50);
            if (!b2) {
                return false;
            }
            lk0 lk0Var = this.b;
            if (lk0Var.i * 100.0f < a2 || this.a.get(lk0Var.e()) != null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
