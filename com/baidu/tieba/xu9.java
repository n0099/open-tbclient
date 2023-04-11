package com.baidu.tieba;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tu9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.addfilter.InnerVideoProcessor;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes7.dex */
public class xu9 extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public wu9 d;
    public tu9.c e;

    public abstract void k();

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu9 a;

        public a(xu9 xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xu9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xu9(Context context, String str, String str2, wu9 wu9Var, tu9.c cVar) {
        super("FilterVideoThread");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, wu9Var, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = wu9Var;
        this.e = cVar;
    }

    public static String g(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mediaFormat)) == null) {
            return mediaFormat.getString("mime");
        }
        return (String) invokeL.objValue;
    }

    public static boolean i(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mediaFormat)) == null) {
            return g(mediaFormat).startsWith(FileUtils.VIDEO_FILE_START);
        }
        return invokeL.booleanValue;
    }

    public final int f(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mediaExtractor)) == null) {
            for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
                if (i(mediaExtractor.getTrackFormat(i))) {
                    mediaExtractor.selectTrack(i);
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && !TextUtils.isEmpty(str2)) {
            BdLog.i(str2);
        }
    }

    public final MediaCodec b(MediaFormat mediaFormat, Surface surface) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaFormat, surface)) == null) {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(g(mediaFormat));
            createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            createDecoderByType.start();
            return createDecoderByType;
        }
        return (MediaCodec) invokeLL.objValue;
    }

    public static MediaCodecInfo l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    public static void m(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65541, null, mediaFormat, mediaFormat2, str, i) == null) {
            if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
                i = mediaFormat.getInteger(str);
            }
            if (mediaFormat2 != null) {
                mediaFormat2.setInteger(str, i);
            }
        }
    }

    public final MediaExtractor a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(this.b);
            return mediaExtractor;
        }
        return (MediaExtractor) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return !Thread.currentThread().isInterrupted();
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                e();
                if (h()) {
                    jg.a().post(new a(this));
                }
            } catch (Exception unused) {
            }
        }
    }

    public final MediaCodec c(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mediaCodecInfo, mediaFormat, atomicReference)) == null) {
            MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
            createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            atomicReference.set(createByCodecName.createInputSurface());
            createByCodecName.start();
            return createByCodecName;
        }
        return (MediaCodec) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0106 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0186 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2, yu9 yu9Var, zu9 zu9Var) {
        long j;
        int i;
        ByteBuffer[] byteBufferArr;
        int i2;
        MediaFormat mediaFormat;
        MediaFormat mediaFormat2;
        MediaFormat mediaFormat3;
        boolean z;
        int dequeueOutputBuffer;
        boolean z2;
        int dequeueInputBuffer;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, mediaExtractor, mediaCodec, mediaCodec2, yu9Var, zu9Var) == null) {
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            int i4 = -1;
            int i5 = 0;
            ByteBuffer[] byteBufferArr2 = outputBuffers2;
            MediaFormat mediaFormat4 = null;
            boolean z3 = false;
            int i6 = -1;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            while (!z4 && h()) {
                if (!z3 && ((mediaFormat4 == null || this.d.b()) && h() && (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) != i4)) {
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i5);
                    long sampleTime = mediaExtractor.getSampleTime();
                    if (readSampleData >= 0) {
                        i3 = dequeueInputBuffer;
                        j = 10000;
                        i = i6;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, mediaExtractor.getSampleFlags());
                    } else {
                        i3 = dequeueInputBuffer;
                        j = 10000;
                        i = i6;
                    }
                    boolean z7 = !mediaExtractor.advance();
                    if (z7) {
                        mediaCodec.queueInputBuffer(i3, 0, 0, 0L, 4);
                    }
                    z3 = z7;
                } else {
                    j = 10000;
                    i = i6;
                }
                if (!z5 && ((mediaFormat4 == null || this.d.b()) && h() && (dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, j)) != -1)) {
                    if (dequeueOutputBuffer == -3) {
                        outputBuffers = mediaCodec.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        mediaCodec.getOutputFormat();
                    } else {
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if ((bufferInfo.flags & 2) != 0) {
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            if (bufferInfo.size != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z2);
                            if (z2) {
                                zu9Var.a();
                                zu9Var.c();
                                yu9Var.e(bufferInfo.presentationTimeUs * 1000);
                                yu9Var.f();
                            }
                            if ((bufferInfo.flags & 4) != 0) {
                                mediaCodec2.signalEndOfInputStream();
                                byteBufferArr = outputBuffers;
                                z5 = true;
                                if (z4 && ((mediaFormat4 == null || this.d.b()) && h())) {
                                    int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo2, j);
                                    if (dequeueOutputBuffer2 == -1) {
                                        i2 = i;
                                    } else {
                                        if (dequeueOutputBuffer2 == -3) {
                                            byteBufferArr2 = mediaCodec2.getOutputBuffers();
                                            mediaFormat = mediaFormat4;
                                            i2 = i;
                                        } else if (dequeueOutputBuffer2 == -2) {
                                            i2 = i;
                                            if (i2 >= 0) {
                                                return;
                                            }
                                            mediaFormat = mediaCodec2.getOutputFormat();
                                        } else {
                                            i2 = i;
                                            ByteBuffer byteBuffer2 = byteBufferArr2[dequeueOutputBuffer2];
                                            if ((bufferInfo2.flags & 2) != 0) {
                                                mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, false);
                                            } else {
                                                if (bufferInfo2.size != 0) {
                                                    this.d.g(i2, byteBuffer2, bufferInfo2);
                                                }
                                                if ((bufferInfo2.flags & 4) != 0) {
                                                    z = false;
                                                    z4 = true;
                                                } else {
                                                    z = false;
                                                }
                                                mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, z);
                                            }
                                        }
                                        if (mediaFormat == null && !z6) {
                                            j(InnerVideoProcessor.TAG, "muxer: adding video track.");
                                            i6 = this.d.a(mediaFormat);
                                            z6 = true;
                                        } else {
                                            i6 = i2;
                                        }
                                        if (!this.d.b() && z6) {
                                            this.d.d();
                                            if (!this.d.e()) {
                                                synchronized (this.d) {
                                                    while (!this.d.b()) {
                                                        try {
                                                            mediaFormat3 = mediaFormat;
                                                        } catch (InterruptedException e) {
                                                            e = e;
                                                            mediaFormat3 = mediaFormat;
                                                        }
                                                        try {
                                                            this.d.wait(100L);
                                                        } catch (InterruptedException e2) {
                                                            e = e2;
                                                            e.printStackTrace();
                                                            mediaFormat = mediaFormat3;
                                                        }
                                                        mediaFormat = mediaFormat3;
                                                    }
                                                    mediaFormat2 = mediaFormat;
                                                }
                                                outputBuffers = byteBufferArr;
                                                mediaFormat4 = mediaFormat2;
                                                i4 = -1;
                                                i5 = 0;
                                            }
                                        }
                                        mediaFormat2 = mediaFormat;
                                        outputBuffers = byteBufferArr;
                                        mediaFormat4 = mediaFormat2;
                                        i4 = -1;
                                        i5 = 0;
                                    }
                                } else {
                                    i2 = i;
                                }
                                mediaFormat = mediaFormat4;
                                if (mediaFormat == null) {
                                }
                                i6 = i2;
                                if (!this.d.b()) {
                                    this.d.d();
                                    if (!this.d.e()) {
                                    }
                                }
                                mediaFormat2 = mediaFormat;
                                outputBuffers = byteBufferArr;
                                mediaFormat4 = mediaFormat2;
                                i4 = -1;
                                i5 = 0;
                            }
                            byteBufferArr = outputBuffers;
                            if (z4) {
                            }
                            i2 = i;
                            mediaFormat = mediaFormat4;
                            if (mediaFormat == null) {
                            }
                            i6 = i2;
                            if (!this.d.b()) {
                            }
                            mediaFormat2 = mediaFormat;
                            outputBuffers = byteBufferArr;
                            mediaFormat4 = mediaFormat2;
                            i4 = -1;
                            i5 = 0;
                        }
                    }
                }
                byteBufferArr = outputBuffers;
                if (z4) {
                }
                i2 = i;
                mediaFormat = mediaFormat4;
                if (mediaFormat == null) {
                }
                i6 = i2;
                if (!this.d.b()) {
                }
                mediaFormat2 = mediaFormat;
                outputBuffers = byteBufferArr;
                mediaFormat4 = mediaFormat2;
                i4 = -1;
                i5 = 0;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x0209, code lost:
        if (r0 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010a, code lost:
        if (r0 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010c, code lost:
        r0.onGenFilterVideoRecordError(229, com.baidu.tieba.zm8.a(r1));
     */
    /* JADX WARN: Removed duplicated region for block: B:144:0x020f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0228 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x026e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0256 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x01d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0240 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() throws Exception {
        MediaCodecInfo l;
        Throwable th;
        zu9 zu9Var;
        yu9 yu9Var;
        MediaExtractor mediaExtractor;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        Exception exc;
        tu9.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (l = l("video/avc")) == null) {
            return;
        }
        Exception exc2 = null;
        try {
            mediaExtractor = a();
        } catch (Exception e) {
            e = e;
            zu9Var = null;
            yu9Var = null;
            mediaExtractor = null;
            mediaCodec = null;
        } catch (Throwable th2) {
            th = th2;
            zu9Var = null;
            yu9Var = null;
            mediaExtractor = null;
            mediaCodec = null;
        }
        try {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(f(mediaExtractor));
            int integer = trackFormat.getInteger("width");
            int integer2 = trackFormat.getInteger("height");
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.b);
            if (TextUtils.equals(mediaMetadataRetriever.extractMetadata(24), "90")) {
                integer2 = integer;
                integer = integer2;
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", integer, integer2);
            createVideoFormat.setInteger("color-format", 2130708361);
            m(trackFormat, createVideoFormat, "bitrate", 2097152);
            m(trackFormat, createVideoFormat, "frame-rate", 20);
            m(trackFormat, createVideoFormat, "i-frame-interval", 1);
            AtomicReference<Surface> atomicReference = new AtomicReference<>();
            mediaCodec = c(l, createVideoFormat, atomicReference);
            try {
                yu9Var = new yu9(atomicReference.get());
                try {
                    yu9Var.c();
                    zu9Var = new zu9(this.a, this.c, integer, integer2);
                    try {
                        mediaCodec2 = b(trackFormat, zu9Var.d());
                    } catch (Exception e2) {
                        e = e2;
                        mediaCodec2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        mediaCodec2 = null;
                    }
                    try {
                        d(mediaExtractor, mediaCodec2, mediaCodec, yu9Var, zu9Var);
                        if (mediaExtractor != null) {
                            try {
                                mediaExtractor.release();
                            } catch (Exception e3) {
                                exc2 = e3;
                                tu9.c cVar2 = this.e;
                                if (cVar2 != null) {
                                    cVar2.onGenFilterVideoRecordError(225, zm8.a(exc2));
                                }
                            }
                        }
                        if (mediaCodec2 != null) {
                            try {
                                mediaCodec2.stop();
                                mediaCodec2.release();
                            } catch (Exception e4) {
                                if (exc2 == null) {
                                    exc2 = e4;
                                }
                                tu9.c cVar3 = this.e;
                                if (cVar3 != null) {
                                    cVar3.onGenFilterVideoRecordError(Constants.METHOD_MEDIA_NOTIFY, zm8.a(e4));
                                }
                            }
                        }
                        try {
                            zu9Var.e();
                        } catch (Exception e5) {
                            if (exc2 == null) {
                                exc2 = e5;
                            }
                            tu9.c cVar4 = this.e;
                            if (cVar4 != null) {
                                cVar4.onGenFilterVideoRecordError(227, zm8.a(e5));
                            }
                        }
                        if (mediaCodec != null) {
                            try {
                                mediaCodec.stop();
                                mediaCodec.release();
                            } catch (Exception e6) {
                                if (exc2 == null) {
                                    exc2 = e6;
                                }
                                tu9.c cVar5 = this.e;
                                if (cVar5 != null) {
                                    cVar5.onGenFilterVideoRecordError(228, zm8.a(e6));
                                }
                            }
                        }
                        try {
                            yu9Var.d();
                        } catch (Exception e7) {
                            exc = e7;
                            if (exc2 == null) {
                                exc2 = exc;
                            }
                            cVar = this.e;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        zu9Var = zu9Var;
                        yu9Var = yu9Var;
                        try {
                            e.printStackTrace();
                            if ((Build.VERSION.SDK_INT >= 21 || !(e instanceof MediaCodec.CodecException) || hi.isEmpty(e.getMessage()) || !e.getMessage().contains("0xfffffff3")) && this.e != null) {
                                this.e.onGenFilterVideoRecordError(224, zm8.a(e));
                            }
                            if (mediaExtractor != null) {
                                try {
                                    mediaExtractor.release();
                                } catch (Exception e9) {
                                    exc2 = e9;
                                    tu9.c cVar6 = this.e;
                                    if (cVar6 != null) {
                                        cVar6.onGenFilterVideoRecordError(225, zm8.a(exc2));
                                    }
                                }
                            }
                            if (mediaCodec2 != null) {
                                try {
                                    mediaCodec2.stop();
                                    mediaCodec2.release();
                                } catch (Exception e10) {
                                    if (exc2 == null) {
                                        exc2 = e10;
                                    }
                                    tu9.c cVar7 = this.e;
                                    if (cVar7 != null) {
                                        cVar7.onGenFilterVideoRecordError(Constants.METHOD_MEDIA_NOTIFY, zm8.a(e10));
                                    }
                                }
                            }
                            if (zu9Var != null) {
                                try {
                                    zu9Var.e();
                                } catch (Exception e11) {
                                    if (exc2 == null) {
                                        exc2 = e11;
                                    }
                                    tu9.c cVar8 = this.e;
                                    if (cVar8 != null) {
                                        cVar8.onGenFilterVideoRecordError(227, zm8.a(e11));
                                    }
                                }
                            }
                            if (mediaCodec != null) {
                                try {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                } catch (Exception e12) {
                                    if (exc2 == null) {
                                        exc2 = e12;
                                    }
                                    tu9.c cVar9 = this.e;
                                    if (cVar9 != null) {
                                        cVar9.onGenFilterVideoRecordError(228, zm8.a(e12));
                                    }
                                }
                            }
                            if (yu9Var != null) {
                                try {
                                    yu9Var.d();
                                } catch (Exception e13) {
                                    exc = e13;
                                    if (exc2 == null) {
                                        exc2 = exc;
                                    }
                                    cVar = this.e;
                                }
                            }
                            if (exc2 == null) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (mediaExtractor != null) {
                                try {
                                    mediaExtractor.release();
                                } catch (Exception e14) {
                                    exc2 = e14;
                                    tu9.c cVar10 = this.e;
                                    if (cVar10 != null) {
                                        cVar10.onGenFilterVideoRecordError(225, zm8.a(exc2));
                                    }
                                }
                            }
                            if (mediaCodec2 != null) {
                                try {
                                    mediaCodec2.stop();
                                    mediaCodec2.release();
                                } catch (Exception e15) {
                                    if (exc2 == null) {
                                        exc2 = e15;
                                    }
                                    tu9.c cVar11 = this.e;
                                    if (cVar11 != null) {
                                        cVar11.onGenFilterVideoRecordError(Constants.METHOD_MEDIA_NOTIFY, zm8.a(e15));
                                    }
                                }
                            }
                            if (zu9Var != null) {
                                try {
                                    zu9Var.e();
                                } catch (Exception e16) {
                                    if (exc2 == null) {
                                        exc2 = e16;
                                    }
                                    tu9.c cVar12 = this.e;
                                    if (cVar12 != null) {
                                        cVar12.onGenFilterVideoRecordError(227, zm8.a(e16));
                                    }
                                }
                            }
                            if (mediaCodec != null) {
                                try {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                } catch (Exception e17) {
                                    if (exc2 == null) {
                                    }
                                    tu9.c cVar13 = this.e;
                                    if (cVar13 != null) {
                                        cVar13.onGenFilterVideoRecordError(228, zm8.a(e17));
                                    }
                                }
                            }
                            if (yu9Var != null) {
                                try {
                                    yu9Var.d();
                                } catch (Exception e18) {
                                    tu9.c cVar14 = this.e;
                                    if (cVar14 != null) {
                                        cVar14.onGenFilterVideoRecordError(229, zm8.a(e18));
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        zu9Var = zu9Var;
                        yu9Var = yu9Var;
                        if (mediaExtractor != null) {
                        }
                        if (mediaCodec2 != null) {
                        }
                        if (zu9Var != null) {
                        }
                        if (mediaCodec != null) {
                        }
                        if (yu9Var != null) {
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                    zu9Var = null;
                    mediaCodec2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    zu9Var = null;
                    mediaCodec2 = null;
                }
            } catch (Exception e20) {
                e = e20;
                zu9Var = null;
                yu9Var = null;
                mediaCodec2 = null;
            } catch (Throwable th7) {
                th = th7;
                zu9Var = null;
                yu9Var = null;
                mediaCodec2 = null;
            }
        } catch (Exception e21) {
            e = e21;
            zu9Var = null;
            yu9Var = null;
            mediaCodec = null;
            mediaCodec2 = mediaCodec;
            e.printStackTrace();
            if (Build.VERSION.SDK_INT >= 21) {
            }
            this.e.onGenFilterVideoRecordError(224, zm8.a(e));
            if (mediaExtractor != null) {
            }
            if (mediaCodec2 != null) {
            }
            if (zu9Var != null) {
            }
            if (mediaCodec != null) {
            }
            if (yu9Var != null) {
            }
            if (exc2 == null) {
            }
        } catch (Throwable th8) {
            th = th8;
            zu9Var = null;
            yu9Var = null;
            mediaCodec = null;
            mediaCodec2 = mediaCodec;
            if (mediaExtractor != null) {
            }
            if (mediaCodec2 != null) {
            }
            if (zu9Var != null) {
            }
            if (mediaCodec != null) {
            }
            if (yu9Var != null) {
            }
            throw th;
        }
        if (exc2 == null) {
            return;
        }
        throw exc2;
    }
}
