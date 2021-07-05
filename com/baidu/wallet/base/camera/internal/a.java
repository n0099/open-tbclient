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
/* loaded from: classes6.dex */
public final class a implements Camera.AutoFocusCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f23872c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f23873a;

    /* renamed from: b  reason: collision with root package name */
    public long f23874b;

    /* renamed from: d  reason: collision with root package name */
    public volatile Handler f23875d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23876e;

    /* renamed from: f  reason: collision with root package name */
    public int f23877f;

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
        f23872c = a.class.getSimpleName();
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
        this.f23873a = 500L;
        this.f23874b = 500L;
        this.f23876e = false;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.f23873a = j;
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f23874b = j;
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, camera) == null) {
            synchronized (this) {
                if (this.f23875d != null) {
                    this.f23875d.sendMessageDelayed(this.f23875d.obtainMessage(this.f23877f, Boolean.valueOf(z)), this.f23876e ? this.f23873a : this.f23874b);
                    this.f23876e = true;
                    this.f23875d = null;
                } else {
                    LogUtil.w(f23872c, "Got auto-focus callback, but no handler for it");
                }
            }
        }
    }

    public synchronized void a(Handler handler, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, handler, i2) == null) {
            synchronized (this) {
                this.f23875d = handler;
                this.f23877f = i2;
            }
        }
    }
}
