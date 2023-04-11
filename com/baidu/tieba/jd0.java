package com.baidu.tieba;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class jd0 extends ed0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947879315, "Lcom/baidu/tieba/jd0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947879315, "Lcom/baidu/tieba/jd0;");
        }
    }

    public jd0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public Surface k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (Surface) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ed0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.h == 0) {
                this.h = this.e.presentationTimeUs;
                ed0.j = 0L;
            }
            MediaCodec.BufferInfo bufferInfo = this.e;
            long j = bufferInfo.presentationTimeUs - this.h;
            bufferInfo.presentationTimeUs = j;
            ed0.j = j;
            zc0.x().V(ed0.j / 1000);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(gd0 gd0Var, hd0 hd0Var) {
        fd0 fd0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gd0Var, hd0Var) == null) {
            boolean z = true;
            if (gd0Var != null && hd0Var != null) {
                this.c = hd0Var;
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(gd0Var.j(), gd0Var.n(), gd0Var.l());
                createVideoFormat.setInteger("color-format", 2130708361);
                createVideoFormat.setInteger("bitrate", gd0Var.i());
                createVideoFormat.setInteger("frame-rate", gd0Var.k());
                createVideoFormat.setInteger("i-frame-interval", gd0Var.m());
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(gd0Var.j());
                    this.d = createEncoderByType;
                    createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    this.l = this.d.createInputSurface();
                    this.g = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                fd0Var = this.f;
                if (fd0Var == null) {
                    fd0Var.b(z);
                    return;
                }
                return;
            }
            z = false;
            fd0Var = this.f;
            if (fd0Var == null) {
            }
        }
    }
}
