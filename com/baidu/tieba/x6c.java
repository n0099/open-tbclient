package com.baidu.tieba;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Message;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
/* loaded from: classes8.dex */
public class x6c extends u6c implements b7c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface K;

    @Override // com.baidu.tieba.r6c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.r6c
    public void d(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
        }
    }

    public x6c(Context context, l6c l6cVar, int i, int i2, e5c e5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, l6cVar, Integer.valueOf(i), Integer.valueOf(i2), e5cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.K = null;
        A(context, l6cVar, i, i2, e5cVar);
    }

    @Override // com.baidu.tieba.u6c
    public void A(Context context, Object obj, int i, int i2, e5c e5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, obj, Integer.valueOf(i), Integer.valueOf(i2), e5cVar}) == null) {
            super.A(context, obj, i, i2, e5cVar);
            if (obj != null && (obj instanceof l6c)) {
                ((l6c) obj).b(this);
            }
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            X(true);
            if (this.d != null) {
                if (this.a.available()) {
                    this.d.g(2402);
                    this.d.f(2402);
                }
                TLog.h("[OutputExternalSetSurfaceRender]", "do send surfaceCreated.");
                this.d.g(2401);
                this.d.f(2401);
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            X(false);
            if (this.d != null && this.a.available()) {
                TLog.h("[OutputExternalSetSurfaceRender]", "do send surfaceDestroyed.");
                this.d.g(2402);
                this.d.f(2402);
            }
        }
    }

    @Override // com.baidu.tieba.b7c
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            this.K = surface;
            this.I.set(true);
            Y();
        }
    }

    @Override // com.baidu.tieba.b7c
    public void b(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i, i2, i3) == null) {
            TLog.h("[OutputExternalSetSurfaceRender]", String.format("surfaceChanged(%d, %d, %d).", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
            D();
            this.I.set(true);
            U();
            m4c m4cVar = this.d;
            if (m4cVar != null) {
                m4cVar.g(2404);
                this.d.sendMessage(Message.obtain(null, 2404, i2, i3));
            }
        }
    }

    @Override // com.baidu.tieba.r6c
    public Object getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.K;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.b7c
    public void surfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Z();
            D();
            this.I.set(false);
            U();
            this.K = null;
        }
    }
}
