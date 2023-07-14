package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.dc2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final dc2 a;
    public final mc2 b;
    public final ac2 c;
    public String d;

    /* loaded from: classes8.dex */
    public class a implements dc2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneType a;
        public final /* synthetic */ oc2 b;
        public final /* synthetic */ cc2 c;
        public final /* synthetic */ uc2 d;

        public a(uc2 uc2Var, SceneType sceneType, oc2 oc2Var, cc2 cc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var, sceneType, oc2Var, cc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = uc2Var;
            this.a = sceneType;
            this.b = oc2Var;
            this.c = cc2Var;
        }

        @Override // com.baidu.tieba.dc2.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                ub2.b(this.d.d);
                xb2.i(1);
                wb2.e(this.a.getType(), networkStatus.getStatus(), this.b.e().getStatus(), this.b.g(), this.b.b(), this.b.f(), this.b.a());
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getScene());
                sb.append(this.c.a());
                sb.append(this.b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.b.c());
                xb2.g(sb.toString());
                if (uc2.e) {
                    Log.d("SceneSkeletonTips", ">> " + sb.toString());
                }
                this.d.h(networkStatus, this.c, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements dc2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(uc2 uc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.dc2.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                mc2.d().j();
                ac2.d().j();
                ub2.c();
                xb2.i(0);
                wb2.c("exit_skeleton", networkStatus.getStatus());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948206117, "Lcom/baidu/tieba/uc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948206117, "Lcom/baidu/tieba/uc2;");
                return;
            }
        }
        e = fs1.a;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (e) {
                Log.d("SceneSkeletonTips", ">> trigger skeleton error event.");
            }
            this.a.a(new b(this));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f(SceneType.SCENE_SKELETON_TIMEOUT);
        }
    }

    public uc2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = ac2.d();
        this.a = new dc2();
        this.b = mc2.d();
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public void f(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sceneType) == null) {
            if (pp3.I(this.d) && pp3.H()) {
                if (e) {
                    Log.d("SceneSkeletonTips", ">> trigger skeleton remove event.");
                }
                mc2.d().j();
                ac2.d().j();
                cc2 f = this.c.f();
                this.a.a(new a(this, sceneType, this.b.f(), f));
            } else if (e) {
                Log.d("SceneSkeletonTips", "path is not first page: " + this.d);
            }
        }
    }

    public final void h(@NonNull NetworkStatus networkStatus, @NonNull cc2 cc2Var, @NonNull oc2 oc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, networkStatus, cc2Var, oc2Var) == null) {
            boolean b2 = cc2Var.b();
            int i = R.string.obfuscated_res_0x7f0f1570;
            if (b2) {
                i = R.string.obfuscated_res_0x7f0f1575;
            } else if (oc2Var.e() == RequestStatus.STATUS_SERVER_FAILED) {
                i = R.string.obfuscated_res_0x7f0f1573;
            } else if (oc2Var.e() != RequestStatus.STATUS_FAILED) {
                if (oc2Var.e() == RequestStatus.STATUS_SLOW) {
                    i = (networkStatus == NetworkStatus.NETWORK_BAD || networkStatus == NetworkStatus.NETWORK_OFFLINE) ? R.string.obfuscated_res_0x7f0f1574 : R.string.obfuscated_res_0x7f0f1571;
                } else if (oc2Var.e() != RequestStatus.STATUS_CORE_FAILED) {
                    i = R.string.obfuscated_res_0x7f0f1572;
                }
            }
            vb2.f(i);
        }
    }
}
