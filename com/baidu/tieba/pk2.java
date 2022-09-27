package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes5.dex */
public final class pk2 extends gh2<wl2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final wl2.a h;

    /* loaded from: classes5.dex */
    public class a implements wl2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pk2 a;

        public a(pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pk2Var;
        }

        @Override // com.baidu.tieba.wl2.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onStateChange", Integer.valueOf(i));
        }

        @Override // com.baidu.tieba.wl2.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onInfo", Integer.valueOf(i));
        }

        @Override // com.baidu.tieba.wl2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                cu1.e().l(str, false);
            }
        }

        @Override // com.baidu.tieba.wl2.a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onNetStatus", str);
        }

        @Override // com.baidu.tieba.wl2.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPlayed", null);
                }
                cu1.e().l(str, true);
            }
        }

        @Override // com.baidu.tieba.wl2.a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onVideoSizeChanged", null);
        }

        @Override // com.baidu.tieba.wl2.a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onEnded", null);
        }

        @Override // com.baidu.tieba.wl2.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onError", Integer.valueOf(i));
        }

        @Override // com.baidu.tieba.wl2.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onPrepared", null);
        }

        @Override // com.baidu.tieba.wl2.a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                cu1.e().q(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948064850, "Lcom/baidu/tieba/pk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948064850, "Lcom/baidu/tieba/pk2;");
                return;
            }
        }
        i = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pk2(@NonNull wl2 wl2Var) {
        super(wl2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wl2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ih2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        wl2Var.h0(aVar);
        cu1.e().b(wl2Var);
        this.a.a(new tk2());
        this.a.a(new uk2());
        this.a.a(new vk2());
        this.a.a(new yk2());
        this.a.a(new xk2());
        this.a.a(new wk2());
        this.a.a(new zk2());
        this.a.a(new al2());
        this.a.a(new bl2());
        this.a.a(new cl2());
        this.a.a(new el2());
        this.a.a(new fl2());
        this.a.a(new gl2());
        this.a.a(new hl2());
        this.a.a(new jl2());
        this.a.a(new kl2());
        this.a.a(new nl2());
        this.a.a(new ol2());
        this.a.a(new il2());
        this.a.a(new dl2());
        this.a.a(new ml2());
    }

    @Override // com.baidu.tieba.gh2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (w(command)) {
                if (i) {
                    Log.d("LiveInlineController", "reject command => " + command.what);
                    return;
                }
                return;
            }
            super.sendCommand(command);
        }
    }

    public final boolean w(ZeusPlugin.Command command) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command)) == null) {
            if (command != null && TextUtils.equals(command.what, fl2.b)) {
                if (i) {
                    Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                }
                return false;
            }
            int a2 = ((wl2) this.c).a();
            if (i && a2 != 1) {
                String str = command == null ? "" : command.what;
                Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((wl2) this.c).a() + " command=> " + str);
            }
            return a2 == 2;
        }
        return invokeL.booleanValue;
    }
}
