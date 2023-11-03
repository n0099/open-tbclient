package com.baidu.tieba;

import android.media.MediaFormat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.AVframe;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class pec extends oec {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean l;
    public MediaFormat m;
    public long n;
    public long o;
    public boolean p;

    @Override // com.baidu.tieba.oec
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public pec(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new AtomicBoolean(false);
        this.m = null;
        this.n = -1L;
        this.o = -1L;
        this.p = false;
        this.b = i;
    }

    @Override // com.baidu.tieba.mec
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TLog.g(this, "MediaInputFilter.setup enter");
            this.l.set(true);
            this.j = false;
        }
    }

    @Override // com.baidu.tieba.oec
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TLog.g(this, "MediaInputFilter.stop enter");
            this.n = -1L;
            this.o = -1L;
            this.m = null;
            this.p = false;
            this.l.set(false);
        }
    }

    @Override // com.baidu.tieba.oec, com.baidu.tieba.mec
    public void d(String str, Object obj, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && !this.j) {
            synchronized (this.k) {
                if (this.d != null) {
                    this.d.d("setFormat", (MediaFormat) obj, i, true);
                }
            }
            this.j = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.oec, com.baidu.tieba.mec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(MediaSample mediaSample) {
        int g;
        MediaFormat mediaFormat;
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaSample) == null) {
            if (this.e.g() != 9) {
                if (!this.l.get()) {
                    TLog.g(this, "render processAVFrame error");
                    return;
                }
                if (mediaSample.f && mediaSample.g != null) {
                    TLog.g(this, "got bForVideoCodecConfigfOnly, playTaskId=" + mediaSample.g.e);
                }
                boolean z = false;
                if (mediaSample.G && mediaSample.d && !this.p) {
                    this.p = true;
                    vec vecVar = (vec) this.d;
                    if (vecVar != null) {
                        vecVar.y();
                    }
                    TLog.g(this, "MediaInputFilter forceToSoftDecode");
                    z = true;
                }
                ByteBuffer byteBuffer2 = null;
                MediaFormat mediaFormat2 = null;
                byteBuffer2 = null;
                if (mediaSample.c) {
                    AVframe aVframe = mediaSample.g;
                    int i = aVframe.f;
                    if (i != this.o) {
                        this.o = i;
                        if (hec.i(i)) {
                            mediaFormat2 = hec.a(aVframe);
                            this.j = true;
                        }
                        MediaFormat mediaFormat3 = this.m;
                        if (mediaFormat3 == null || !mediaFormat3.equals(mediaFormat2)) {
                            this.m = mediaFormat2;
                            synchronized (this.k) {
                                if (this.d != null) {
                                    this.d.d("setFormat", mediaFormat2, aVframe.e, true);
                                    TLog.g(this, "MediaInputFilter audioConfig taskId " + aVframe.e + " netCodec " + aVframe.f);
                                }
                            }
                        }
                        synchronized (this.k) {
                            if (this.d != null) {
                                this.d.f(mediaSample);
                            }
                        }
                        return;
                    }
                }
                if (!mediaSample.c && (mediaSample.g.f != this.n || z)) {
                    AVframe aVframe2 = mediaSample.g;
                    if (aVframe2.f == 2000) {
                        if (aVframe2.a && !aVframe2.b) {
                            byteBuffer = ByteBuffer.wrap(aVframe2.q);
                        } else {
                            byteBuffer = null;
                        }
                        mediaFormat = hec.b((int) aVframe2.j, (int) aVframe2.k, byteBuffer, true);
                        this.n = aVframe2.f;
                    } else {
                        mediaFormat = null;
                    }
                    if (aVframe2.f == 2002) {
                        if (aVframe2.a && !aVframe2.b) {
                            byteBuffer2 = ByteBuffer.wrap(aVframe2.q);
                        }
                        mediaFormat = hec.c((int) aVframe2.j, (int) aVframe2.k, byteBuffer2, true);
                        this.n = aVframe2.f;
                    }
                    synchronized (this.k) {
                        if (this.d != null) {
                            this.d.b(aVframe2.f);
                            this.d.d("setFormat", mediaFormat, aVframe2.e, true);
                            TLog.g(this, "MediaInputFilter videoConfig taskId " + aVframe2.e + " netCodec " + aVframe2.f);
                        }
                    }
                }
                synchronized (this.k) {
                }
            } else {
                mediaSample.g.a();
                TLog.c(this, "fatal error, ignore all frames. mCurrentState:" + jdc.a[g]);
            }
        }
    }
}
