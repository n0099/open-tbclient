package com.baidu.tieba;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.effectmp4.EffectInfo;
/* loaded from: classes6.dex */
public class k3c extends m3c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EffectInfo l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k3c(s3c s3cVar) {
        super(s3cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s3cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((s3c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
    }

    @Override // com.baidu.tieba.m3c
    public void a(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, str, str2, i, i2) == null) {
            super.a(str, str2, i, i2);
            GLES20.glUseProgram(this.a);
            this.m = GLES20.glGetUniformLocation(this.a, "bgRectRGB");
            t3c.c("EffectMP4_uniform_bgRectRGB", this.j);
            this.n = GLES20.glGetUniformLocation(this.a, "bgRectA");
            t3c.c("EffectMP4_uniform_bRectA", this.j);
            this.o = GLES20.glGetUniformLocation(this.a, "maskCount");
            t3c.c("EffectMP4_uniform_maskCount", this.j);
            this.p = GLES20.glGetUniformLocation(this.a, "srcImage");
            t3c.c("EffectMP4_uniform_bRectA", this.j);
            this.q = GLES20.glGetUniformLocation(this.a, "srcRgbRects");
            t3c.c("EffectMP4_uniform_srcRgbRects", this.j);
            this.r = GLES20.glGetUniformLocation(this.a, "maskFrameRects");
            t3c.c("EffectMP4_uniform_maskFrameRects", this.j);
            this.s = GLES20.glGetUniformLocation(this.a, "maskAlphaRects");
            t3c.c("EffectMP4_uniform_maskAlphaRects", this.j);
            this.t = GLES20.glGetUniformLocation(this.a, "rectOffset");
            t3c.c("EffectMP4_uniform_rectOffset", this.j);
            GLES20.glUseProgram(0);
        }
    }

    @Override // com.baidu.tieba.m3c
    public void e(float f, float f2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) != null) || (i = this.t) == -1) {
            return;
        }
        GLES20.glUniform2f(i, f, f2);
    }

    public void k(float[] fArr, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, fArr, i) == null) && (i2 = this.s) != -1 && fArr != null && i > 0) {
            GLES20.glUniform4fv(i2, i, fArr, 0);
        }
    }

    public void m(float[] fArr, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, fArr, i) == null) && (i2 = this.r) != -1 && fArr != null && i > 0) {
            GLES20.glUniform4fv(i2, i, fArr, 0);
        }
    }

    public void o(float[] fArr, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, fArr, i) == null) && (i2 = this.q) != -1 && fArr != null && i > 0) {
            GLES20.glUniform4fv(i2, i, fArr, 0);
        }
    }

    public void l(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (i2 = this.o) == -1) {
            return;
        }
        GLES20.glUniform1i(i2, i);
    }

    public void n(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || (i2 = this.p) == -1) {
            return;
        }
        GLES20.glUniform1i(i2, i);
    }

    public void p(EffectInfo effectInfo) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, effectInfo) == null) && effectInfo != null && this.n != -1 && (i = this.m) != -1 && this.l != effectInfo) {
            this.l = effectInfo;
            GLES20.glUniform4fv(i, 1, effectInfo.f, 0);
            GLES20.glUniform4fv(this.n, 1, effectInfo.g, 0);
        }
    }
}
