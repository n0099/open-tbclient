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
public class u3c extends r3c implements y3c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface K;

    @Override // com.baidu.tieba.o3c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.o3c
    public void d(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
        }
    }

    public u3c(Context context, i3c i3cVar, int i, int i2, b2c b2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, i3cVar, Integer.valueOf(i), Integer.valueOf(i2), b2cVar};
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
        A(context, i3cVar, i, i2, b2cVar);
    }

    @Override // com.baidu.tieba.r3c
    public void A(Context context, Object obj, int i, int i2, b2c b2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, obj, Integer.valueOf(i), Integer.valueOf(i2), b2cVar}) == null) {
            super.A(context, obj, i, i2, b2cVar);
            if (obj != null && (obj instanceof i3c)) {
                ((i3c) obj).b(this);
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

    @Override // com.baidu.tieba.y3c
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            this.K = surface;
            this.I.set(true);
            Y();
        }
    }

    @Override // com.baidu.tieba.y3c
    public void b(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i, i2, i3) == null) {
            TLog.h("[OutputExternalSetSurfaceRender]", String.format("surfaceChanged(%d, %d, %d).", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
            D();
            this.I.set(true);
            U();
            j1c j1cVar = this.d;
            if (j1cVar != null) {
                j1cVar.g(2404);
                this.d.sendMessage(Message.obtain(null, 2404, i2, i3));
            }
        }
    }

    @Override // com.baidu.tieba.o3c
    public Object getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.K;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.y3c
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
