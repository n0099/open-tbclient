package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class og0 implements wg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final eg0 a;
    public long b;
    public vg0 c;
    public tg0 d;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-547822060, "Lcom/baidu/tieba/og0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-547822060, "Lcom/baidu/tieba/og0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            b = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[AdDownloadStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[AdDownloadStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[AdDownloadStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[AdDownloadStatus.COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[AdDownloadStatus.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[AdDownloadAction.values().length];
            a = iArr2;
            try {
                iArr2[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[AdDownloadAction.PROGRESS_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[AdDownloadAction.COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[AdDownloadAction.FAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[AdDownloadAction.FAIL_PERMISSION_DENY.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public og0(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eg0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0L;
        this.c = null;
        this.a = eg0Var;
        d();
    }

    public void m(@Nullable vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, vg0Var) == null) {
            this.c = vg0Var;
            if (f()) {
                b(AdDownloadCode.ERROR_FAST_CLICK);
            } else if (this.a.f()) {
                b(AdDownloadCode.ERROR_INVALID_DATA);
            } else {
                g();
                b(AdDownloadCode.SUCCESS);
            }
        }
    }

    @Override // com.baidu.tieba.wg0
    public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, eg0Var) == null) {
            switch (a.a[adDownloadAction.ordinal()]) {
                case 1:
                    o();
                    break;
                case 2:
                    p();
                    break;
                case 3:
                    o();
                    break;
                case 4:
                    this.a.i = Math.max(eg0Var.i, eg0Var.j);
                    if (this.a.q.w) {
                        ng0.f().l(this.a);
                        break;
                    }
                    break;
                case 5:
                    p();
                    break;
                case 6:
                    p();
                    break;
                case 7:
                    p();
                    b(AdDownloadCode.ERROR_OTHERS);
                    return;
                case 8:
                    if (oh0.f(eg0Var)) {
                        b(AdDownloadCode.ERROR_PERMISSION_DENIED);
                        return;
                    }
                    break;
            }
            b(AdDownloadCode.SUCCESS);
        }
    }

    public final void b(AdDownloadCode adDownloadCode) {
        vg0 vg0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) != null) || (vg0Var = this.c) == null) {
            return;
        }
        if (adDownloadCode == AdDownloadCode.SUCCESS) {
            vg0Var.a(this.a.c);
        } else {
            vg0Var.b(adDownloadCode);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            rf0.c().a(this.a);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            q();
            i();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.b;
            this.b = currentTimeMillis;
            if (j > 0 && j < 1000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wg0
    public eg0 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (eg0) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (dh0.c().e(this)) {
                dh0.c().d();
                return;
            }
            rf0.c().j(this.a);
            p();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            rf0.c().k(this.a.e(), this);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            rf0.c().p(this.a.e(), this);
            sg0.b(this.a);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            rf0.c().l(this.a);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m(this.c);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            rf0.c().n(this.a);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.d == null && this.a.b()) {
                this.d = sg0.a(this.a);
            }
            tg0 tg0Var = this.d;
            if (tg0Var != null) {
                tg0Var.a();
            }
        }
    }

    public final void p() {
        tg0 tg0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (tg0Var = this.d) != null) {
            tg0Var.d();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.i(vf0.b().d(this.a.e()));
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!oh0.g(this.a.h)) {
                rf0.c().a(this.a);
                this.a.g();
                return false;
            }
            AdAppStateManager.instance().register(this.a);
            eg0 eg0Var = this.a;
            return oh0.e(eg0Var.h, eg0Var.a());
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            switch (a.b[this.a.c.ordinal()]) {
                case 1:
                    n();
                    break;
                case 2:
                    rf0.e(AdDownloadAction.FAIL_RETRY, this.a);
                    n();
                    break;
                case 3:
                    h();
                    break;
                case 4:
                    k();
                    break;
                case 5:
                    if (e()) {
                        rf0.e(AdDownloadAction.INSTALL_START, this.a);
                        break;
                    } else {
                        boolean z = false;
                        if (qi0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                            z = true;
                        }
                        if (z) {
                            eg0 eg0Var = this.a;
                            if (eg0Var.c == AdDownloadStatus.PAUSE) {
                                k();
                            } else {
                                eg0Var.i = 0.0f;
                                eg0Var.j = 0.0f;
                                n();
                            }
                            vf0.b().f(this.a);
                            break;
                        }
                    }
                    break;
                case 6:
                    if (oh0.c(this.a.d)) {
                        rf0.d(this.a);
                        break;
                    } else {
                        this.a.c = AdDownloadStatus.NONE;
                        n();
                        break;
                    }
            }
            if (!TextUtils.isEmpty(this.a.f)) {
                yd0.b(this.a.f);
            }
        }
    }
}
