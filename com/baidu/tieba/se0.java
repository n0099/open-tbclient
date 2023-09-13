package com.baidu.tieba;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.mediainfo.MediaInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class se0 extends ne0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948148395, "Lcom/baidu/tieba/se0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948148395, "Lcom/baidu/tieba/se0;");
        }
    }

    public se0() {
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

    @Override // com.baidu.tieba.ne0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.h == 0) {
                this.h = this.e.presentationTimeUs;
                ne0.j = 0L;
            }
            MediaCodec.BufferInfo bufferInfo = this.e;
            long j = bufferInfo.presentationTimeUs - this.h;
            bufferInfo.presentationTimeUs = j;
            ne0.j = j;
            ie0.x().V(ne0.j / 1000);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(pe0 pe0Var, qe0 qe0Var) {
        oe0 oe0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pe0Var, qe0Var) == null) {
            boolean z = true;
            if (pe0Var != null && qe0Var != null) {
                this.c = qe0Var;
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(pe0Var.j(), pe0Var.n(), pe0Var.l());
                createVideoFormat.setInteger("color-format", 2130708361);
                createVideoFormat.setInteger(MediaInfo.DPM_KEY_BITRATE, pe0Var.i());
                createVideoFormat.setInteger("frame-rate", pe0Var.k());
                createVideoFormat.setInteger("i-frame-interval", pe0Var.m());
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(pe0Var.j());
                    this.d = createEncoderByType;
                    createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    this.l = this.d.createInputSurface();
                    this.g = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                oe0Var = this.f;
                if (oe0Var == null) {
                    oe0Var.b(z);
                    return;
                }
                return;
            }
            z = false;
            oe0Var = this.f;
            if (oe0Var == null) {
            }
        }
    }
}
