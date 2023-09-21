package com.baidu.tieba;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
/* loaded from: classes7.dex */
public class r8c extends m8c implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceView K;

    @Override // com.baidu.tieba.j8c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.j8c
    public void d(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceTexture) == null) {
        }
    }

    public r8c(Context context, View view2, int i, int i2, w6c w6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), Integer.valueOf(i2), w6cVar};
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
        A(context, view2, i, i2, w6cVar);
    }

    @Override // com.baidu.tieba.m8c
    public void A(Context context, Object obj, int i, int i2, w6c w6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, obj, Integer.valueOf(i), Integer.valueOf(i2), w6cVar}) == null) {
            super.A(context, obj, i, i2, w6cVar);
            if (obj != null && (obj instanceof SurfaceView)) {
                SurfaceView surfaceView = (SurfaceView) obj;
                this.K = surfaceView;
                surfaceView.getHolder().addCallback(this);
                if (Build.MODEL.equals("OPPO A33t")) {
                    this.K.setLayerType(1, null);
                }
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            X(true);
            synchronized (this.i) {
                if (this.K != null && this.K.getHolder() != null) {
                    this.K.getHolder().setKeepScreenOn(true);
                }
                if (this.d != null) {
                    if (this.a.available()) {
                        this.d.g(2402);
                        this.d.f(2402);
                    }
                    TLog.l(this, "do send surfaceCreated. playerUid " + this.r);
                    this.d.g(2401);
                    this.d.f(2401);
                }
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            X(false);
            SurfaceView surfaceView = this.K;
            if (surfaceView != null && surfaceView.getHolder() != null) {
                this.K.getHolder().setKeepScreenOn(false);
            }
            synchronized (this.i) {
                if (this.d != null && this.a.available()) {
                    this.d.g(2402);
                    this.d.f(2402);
                }
            }
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.finalize();
        }
    }

    @Override // com.baidu.tieba.j8c
    public Object getWindow() {
        InterceptResult invokeV;
        Surface surface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SurfaceView surfaceView = this.K;
            if (surfaceView == null || (surface = surfaceView.getHolder().getSurface()) == null || !surface.isValid()) {
                return null;
            }
            return this.K.getHolder();
        }
        return invokeV.objValue;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048583, this, surfaceHolder, i, i2, i3) == null) {
            TLog.l(this, String.format("surfaceChanged(%d, %d, %d). playerUID %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.r)));
            e6c e6cVar = this.d;
            if (e6cVar != null) {
                e6cVar.g(2404);
                this.d.sendMessage(Message.obtain(null, 2404, i2, i3));
            }
            D();
            this.I.set(true);
            U();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceHolder) == null) {
            TLog.l(this, "surfaceCreated. playerUid " + this.r);
            this.I.set(true);
            Y();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, surfaceHolder) == null) {
            TLog.l(this, "surfaceDestroyed(). playerUid " + this.r);
            D();
            this.I.set(false);
            U();
            Z();
        }
    }
}
