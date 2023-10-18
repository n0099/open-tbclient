package com.baidu.tieba;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
/* loaded from: classes7.dex */
public class n2c extends j2c implements TextureView.SurfaceTextureListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface K;
    public int L;

    public n2c(Context context, b2c b2cVar, int i, int i2, t0c t0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, b2cVar, Integer.valueOf(i), Integer.valueOf(i2), t0cVar};
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
        this.L = 0;
        A(context, b2cVar, i, i2, t0cVar);
    }

    @Override // com.baidu.tieba.j2c
    public void A(Context context, Object obj, int i, int i2, t0c t0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, obj, Integer.valueOf(i), Integer.valueOf(i2), t0cVar}) == null) {
            super.A(context, obj, i, i2, t0cVar);
            if (obj != null && (obj instanceof b2c)) {
                ((b2c) obj).a(this);
            }
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            X(false);
            if (this.d != null && this.a.available()) {
                this.d.g(2402);
                this.d.f(2402);
            }
        }
    }

    @Override // com.baidu.tieba.g2c
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.c != null) {
            TLog.g(this, "OutputExternalSurfaceRender destroyWindow");
        }
    }

    @Override // com.baidu.tieba.g2c
    public Object getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.K;
        }
        return invokeV.objValue;
    }

    public final void Z(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
            X(true);
            if (this.d != null) {
                if (this.a.available()) {
                    this.d.g(2402);
                    this.d.f(2402);
                }
                TLog.g(this, "do send surfaceCreated, playerUID:" + this.r);
                this.d.g(2401);
                this.d.sendMessage(Message.obtain(null, 2401, surfaceTexture));
            }
        }
    }

    public final void a0(SurfaceTexture surfaceTexture, int i, int i2) {
        b0c b0cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048579, this, surfaceTexture, i, i2) == null) && (b0cVar = this.d) != null) {
            b0cVar.g(2404);
            this.d.sendMessage(Message.obtain(null, 2404, i, i2, surfaceTexture));
            TLog.g(this, "onSurfaceTextureSizeChanged() width:" + i + ", height:" + i2 + ", playerUID:" + this.r);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, surfaceTexture, i, i2) == null) {
            if (this.L % 100 == 0) {
                TLog.g(this, "onSurfaceTextureSizeChanged() width:" + i + ", height:" + i2 + ", playerUID:" + this.r);
            }
            this.L++;
            D();
            this.I.set(true);
            U();
            a0(surfaceTexture, i, i2);
        }
    }

    @Override // com.baidu.tieba.g2c
    public void d(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, surfaceTexture) == null) {
            this.K = new Surface(surfaceTexture);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, surfaceTexture) == null) && this.d != null && this.a.available()) {
            this.d.g(2405);
            this.d.f(2405);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, surfaceTexture, i, i2) == null) {
            TLog.g(this, "onSurfaceTextureAvailable() width:" + i + ", height:" + i2 + ", playerUID:" + this.r);
            this.I.set(true);
            Z(surfaceTexture);
            if (i > 0 && i2 > 0) {
                a0(surfaceTexture, i, i2);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceTexture)) == null) {
            TLog.g(this, "onSurfaceTextureDestroyed playerUID:" + this.r);
            D();
            this.I.set(false);
            U();
            Y();
            return false;
        }
        return invokeL.booleanValue;
    }
}
