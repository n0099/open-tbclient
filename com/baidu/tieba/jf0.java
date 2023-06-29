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
/* loaded from: classes6.dex */
public class jf0 extends kf0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947881237, "Lcom/baidu/tieba/jf0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947881237, "Lcom/baidu/tieba/jf0;");
        }
    }

    public jf0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 0L;
    }

    @Override // com.baidu.tieba.kf0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.h == 0) {
                this.h = this.e.presentationTimeUs;
            }
            MediaCodec.BufferInfo bufferInfo = this.e;
            long j = bufferInfo.presentationTimeUs - this.h;
            bufferInfo.presentationTimeUs = j;
            long j2 = this.l;
            if (j < j2) {
                long j3 = j2 + 10000;
                this.l = j3;
                bufferInfo.presentationTimeUs = j3;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.e;
            long j4 = bufferInfo2.presentationTimeUs;
            long j5 = kf0.j;
            if (j4 > j5 + 500000) {
                long j6 = this.l;
                if (j5 > j6) {
                    bufferInfo2.presentationTimeUs = j5 + 5000;
                } else {
                    bufferInfo2.presentationTimeUs = j6 + 5000;
                }
            }
            if (kf0.j > this.e.presentationTimeUs + 500000) {
                kf0.k = 1200;
            }
            this.l = this.e.presentationTimeUs;
        }
    }

    public void k(mf0 mf0Var, nf0 nf0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mf0Var, nf0Var) == null) {
            boolean z = false;
            if (mf0Var != null && nf0Var != null) {
                this.c = nf0Var;
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString("mime", mf0Var.c());
                mediaFormat.setInteger("aac-profile", 2);
                mediaFormat.setInteger("sample-rate", mf0Var.e());
                mediaFormat.setInteger("channel-count", mf0Var.b());
                mediaFormat.setInteger("bitrate", mf0Var.a());
                mediaFormat.setInteger("max-input-size", mf0Var.d());
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(mf0Var.c());
                    this.d = createEncoderByType;
                    createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                    if (!mf0Var.p()) {
                        this.g = true;
                    } else {
                        this.g = false;
                    }
                    z = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lf0 lf0Var = this.f;
            if (lf0Var != null) {
                lf0Var.b(z);
            }
        }
    }
}
