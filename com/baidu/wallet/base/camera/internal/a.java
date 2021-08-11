package com.baidu.wallet.base.camera.internal;

import android.hardware.Camera;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes8.dex */
public final class a implements Camera.AutoFocusCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f59887c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f59888a;

    /* renamed from: b  reason: collision with root package name */
    public long f59889b;

    /* renamed from: d  reason: collision with root package name */
    public volatile Handler f59890d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59891e;

    /* renamed from: f  reason: collision with root package name */
    public int f59892f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(817695512, "Lcom/baidu/wallet/base/camera/internal/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(817695512, "Lcom/baidu/wallet/base/camera/internal/a;");
                return;
            }
        }
        f59887c = a.class.getSimpleName();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59888a = 500L;
        this.f59889b = 500L;
        this.f59891e = false;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f59888a = j2;
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f59889b = j2;
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, camera) == null) {
            synchronized (this) {
                if (this.f59890d != null) {
                    this.f59890d.sendMessageDelayed(this.f59890d.obtainMessage(this.f59892f, Boolean.valueOf(z)), this.f59891e ? this.f59888a : this.f59889b);
                    this.f59891e = true;
                    this.f59890d = null;
                } else {
                    LogUtil.w(f59887c, "Got auto-focus callback, but no handler for it");
                }
            }
        }
    }

    public synchronized void a(Handler handler, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, handler, i2) == null) {
            synchronized (this) {
                this.f59890d = handler;
                this.f59892f = i2;
            }
        }
    }
}
