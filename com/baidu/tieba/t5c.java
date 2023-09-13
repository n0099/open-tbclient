package com.baidu.tieba;

import android.media.MediaFormat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.NativeFfmpeg;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public final class t5c extends a6c implements NativeFfmpeg.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.v5c
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public t5c(int i, e5c e5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), e5cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new WeakReference<>(e5cVar);
        this.w = false;
        this.b = i;
        this.A.i(i);
        this.o = 3;
    }

    public void M(MediaInfo mediaInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaInfo) == null) {
            TLog.g(this, mediaInfo.toString());
            if (this.q.e(mediaInfo)) {
                this.q.c(mediaInfo);
            }
            if (this.E == 0 || this.B == null) {
                this.E = 32768;
                this.B = ByteBuffer.allocateDirect(32768);
                this.C = ByteBuffer.allocateDirect(this.E);
            }
            this.p.setInteger("samples", mediaInfo.g);
            this.p.setInteger("channel-count", mediaInfo.h);
            this.p.setInteger("sample-rate", mediaInfo.j);
            synchronized (this.k) {
                if (this.d != null) {
                    this.d.d("setFormat", this.p, this.a, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.v5c
    public void z(MediaFormat mediaFormat, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, mediaFormat, i) == null) {
            TLog.g(this, "[audio][decoder] AudioSwDecodeFilter handleCreateDecoder taskID " + i);
            L();
            this.w = false;
            this.a = i;
            this.A.p(this);
            this.A.h(this.a);
            if (this.A.j(5, mediaFormat) != 0) {
                m(50);
            }
            MediaInfo b = MediaInfo.b(1, mediaFormat.getInteger("sample-rate"), mediaFormat.getInteger("channel-count"));
            if (mediaFormat.containsKey("samples")) {
                b.g = mediaFormat.getInteger("samples");
            }
            this.p = mediaFormat;
            M(b);
        }
    }
}
