package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.t32;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final t32 a;
    public final c42 b;
    public final q32 c;
    public String d;

    /* loaded from: classes4.dex */
    public class a implements t32.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneType a;
        public final /* synthetic */ e42 b;
        public final /* synthetic */ s32 c;
        public final /* synthetic */ k42 d;

        public a(k42 k42Var, SceneType sceneType, e42 e42Var, s32 s32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k42Var, sceneType, e42Var, s32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = k42Var;
            this.a = sceneType;
            this.b = e42Var;
            this.c = s32Var;
        }

        @Override // com.baidu.tieba.t32.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                k32.b(this.d.d);
                n32.i(1);
                m32.e(this.a.getType(), networkStatus.getStatus(), this.b.e().getStatus(), this.b.g(), this.b.b(), this.b.f(), this.b.a());
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getScene());
                sb.append(this.c.a());
                sb.append(this.b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.b.c());
                n32.g(sb.toString());
                if (k42.e) {
                    Log.d("SceneSkeletonTips", ">> " + sb.toString());
                }
                this.d.h(networkStatus, this.c, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements t32.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(k42 k42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.t32.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c42.d().j();
                q32.d().j();
                k32.c();
                n32.i(0);
                m32.c("exit_skeleton", networkStatus.getStatus());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947863040, "Lcom/baidu/tieba/k42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947863040, "Lcom/baidu/tieba/k42;");
                return;
            }
        }
        e = vj1.a;
    }

    public k42() {
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
        this.c = q32.d();
        this.a = new t32();
        this.b = c42.d();
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

    public void f(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sceneType) == null) {
            if (fh3.I(this.d) && fh3.H()) {
                if (e) {
                    Log.d("SceneSkeletonTips", ">> trigger skeleton remove event.");
                }
                c42.d().j();
                q32.d().j();
                s32 f = this.c.f();
                this.a.a(new a(this, sceneType, this.b.f(), f));
            } else if (e) {
                Log.d("SceneSkeletonTips", "path is not first page: " + this.d);
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public final void h(@NonNull NetworkStatus networkStatus, @NonNull s32 s32Var, @NonNull e42 e42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, networkStatus, s32Var, e42Var) == null) {
            boolean b2 = s32Var.b();
            int i = R.string.obfuscated_res_0x7f0f132d;
            if (b2) {
                i = R.string.obfuscated_res_0x7f0f1332;
            } else if (e42Var.e() == RequestStatus.STATUS_SERVER_FAILED) {
                i = R.string.obfuscated_res_0x7f0f1330;
            } else if (e42Var.e() != RequestStatus.STATUS_FAILED) {
                if (e42Var.e() == RequestStatus.STATUS_SLOW) {
                    i = (networkStatus == NetworkStatus.NETWORK_BAD || networkStatus == NetworkStatus.NETWORK_OFFLINE) ? R.string.obfuscated_res_0x7f0f1331 : R.string.obfuscated_res_0x7f0f132e;
                } else if (e42Var.e() != RequestStatus.STATUS_CORE_FAILED) {
                    i = R.string.obfuscated_res_0x7f0f132f;
                }
            }
            l32.f(i);
        }
    }
}
