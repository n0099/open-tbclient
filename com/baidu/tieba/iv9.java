package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
/* loaded from: classes5.dex */
public class iv9 extends fv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean B;

    @Override // com.baidu.tieba.ev9, com.baidu.tieba.tv9
    public void a(nv9 nv9Var, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, nv9Var, surfaceTexture) == null) {
            nv9Var.h(this.mFullScreen2D, this.t, GlUtil.IDENTITY_MATRIX);
            nv9Var.f(surfaceTexture);
        }
    }

    public final void i(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7, float[] fArr2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), fArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), fArr2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            GLES20.glBindFramebuffer(36160, i2);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i3, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            if (this.z) {
                if (z) {
                    int i8 = this.j;
                    int i9 = this.k;
                    if (i8 > i9) {
                        int i10 = this.p;
                        float f = (i10 * 1.0f) / i8;
                        GLES20.glViewport(0, (this.q - ((int) (i9 * f))) / 2, i10, (int) (i9 * f));
                    } else {
                        GLES20.glViewport(0, 0, this.p, this.q);
                    }
                    this.o.drawFrame(this.l, fArr2);
                }
                if (z2) {
                    GLES20.glViewport(0, 0, this.p, this.q);
                } else {
                    GLES20.glViewport(i4 + this.w, ((this.q - i7) - i5) - this.x, i6, i7);
                }
                this.mFullScreen2D.drawFrame(i, fArr);
            } else {
                GLES20.glViewport(0, 0, this.p, this.q);
                this.mFullScreen2D.drawFrame(i, fArr);
                if (z) {
                    int i11 = i4 + this.w;
                    int i12 = this.q;
                    int i13 = this.k;
                    GLES20.glViewport(i11, ((i12 - i13) - i5) - this.x, this.j, i13);
                    this.o.drawFrame(this.l, fArr2);
                }
            }
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public boolean j(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? (this.z && d(motionEvent)) || (!this.z && e(motionEvent)) : invokeL.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.B : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(pg0 pg0Var, int i, float[] fArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048580, this, pg0Var, i, fArr) == null) && this.s && this.l != 0) {
            try {
                this.mTextureId = i;
                this.m.updateTexImage();
                this.m.getTransformMatrix(this.n);
                f();
                i(i, fArr, this.v, this.t, this.f, this.g, this.h, this.i, this.n, !this.B, false);
                GLES20.glViewport(0, 0, this.p, this.q);
                this.mFullScreen2D.drawFrame(this.t, GlUtil.IDENTITY_MATRIX);
                i(i, fArr, this.v, this.t, this.f, this.g, this.h, this.i, this.n, false, true);
            } catch (Throwable th) {
                cw9.c("followvideo", th.toString());
            }
        }
    }
}
