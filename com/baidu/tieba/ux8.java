package com.baidu.tieba;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.tieba.sx8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.addfilter.InnerAudioProcessor;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes6.dex */
public class ux8 extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public vx8 c;
    public long d;
    public sx8.c e;

    public abstract void k();

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux8 a;

        public a(ux8 ux8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux8Var;
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
    public ux8(Context context, String str, vx8 vx8Var, sx8.c cVar) {
        super("FilterAudioThread");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, vx8Var, cVar};
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
        this.d = -1L;
        this.b = context;
        this.a = str;
        this.c = vx8Var;
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

    public static boolean h(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mediaFormat)) == null) {
            return g(mediaFormat).startsWith("audio/");
        }
        return invokeL.booleanValue;
    }

    public final MediaCodec a(MediaFormat mediaFormat) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(g(mediaFormat));
            createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.start();
            return createDecoderByType;
        }
        return (MediaCodec) invokeL.objValue;
    }

    public final int f(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mediaExtractor)) == null) {
            for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
                if (h(mediaExtractor.getTrackFormat(i))) {
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

    public final MediaCodec b(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaCodecInfo, mediaFormat)) == null) {
            MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
            createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            createByCodecName.start();
            return createByCodecName;
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

    public final MediaExtractor c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(this.a);
            return mediaExtractor;
        }
        return (MediaExtractor) invokeV.objValue;
    }

    public final boolean i() {
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
                if (i()) {
                    ah.a().post(new a(this));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r32v0, resolved type: android.media.MediaCodec */
    /* JADX DEBUG: Multi-variable search result rejected for r33v0, resolved type: android.media.MediaCodec */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01cb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f7 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2) {
        int i;
        ByteBuffer[] byteBufferArr;
        MediaCodec.BufferInfo bufferInfo;
        ?? r11;
        int i2;
        boolean z;
        ByteBuffer[] byteBufferArr2;
        int i3;
        ByteBuffer[] byteBufferArr3;
        MediaCodec.BufferInfo bufferInfo2;
        MediaFormat mediaFormat;
        boolean z2;
        int dequeueInputBuffer;
        int dequeueOutputBuffer;
        int dequeueInputBuffer2;
        int i4;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mediaExtractor, mediaCodec, mediaCodec2) == null) {
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            ByteBuffer[] inputBuffers2 = mediaCodec2.getInputBuffers();
            ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo3 = new MediaCodec.BufferInfo();
            MediaCodec.BufferInfo bufferInfo4 = new MediaCodec.BufferInfo();
            int i5 = -1;
            int i6 = 0;
            ByteBuffer[] byteBufferArr4 = outputBuffers2;
            MediaFormat mediaFormat2 = null;
            boolean z4 = false;
            int i7 = -1;
            int i8 = -1;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            ByteBuffer[] byteBufferArr5 = inputBuffers2;
            while (!z5 && i()) {
                if (!z4 && ((mediaFormat2 == null || this.c.b()) && i() && (dequeueInputBuffer2 = mediaCodec.dequeueInputBuffer(10000L)) != i5)) {
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer2], i6);
                    long sampleTime = mediaExtractor.getSampleTime();
                    if (readSampleData >= 0) {
                        i4 = dequeueInputBuffer2;
                        bufferInfo = bufferInfo4;
                        i2 = i7;
                        i = i8;
                        byteBufferArr = inputBuffers;
                        z3 = false;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer2, 0, readSampleData, sampleTime, mediaExtractor.getSampleFlags());
                    } else {
                        i4 = dequeueInputBuffer2;
                        i = i8;
                        byteBufferArr = inputBuffers;
                        bufferInfo = bufferInfo4;
                        z3 = false;
                        i2 = i7;
                    }
                    z = !mediaExtractor.advance();
                    r11 = z3;
                    if (z) {
                        mediaCodec.queueInputBuffer(i4, 0, 0, 0L, 4);
                        r11 = z3;
                    }
                } else {
                    i = i8;
                    byteBufferArr = inputBuffers;
                    bufferInfo = bufferInfo4;
                    r11 = 0;
                    i2 = i7;
                    z = z4;
                }
                if (!z6 && i2 == -1 && ((mediaFormat2 == null || this.c.b()) && i() && (dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo3, 10000L)) != -1)) {
                    if (dequeueOutputBuffer == -3) {
                        outputBuffers = mediaCodec.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        mediaCodec.getOutputFormat();
                    } else {
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if ((bufferInfo3.flags & 2) != 0) {
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, (boolean) r11);
                        } else {
                            byteBufferArr2 = outputBuffers;
                            i3 = dequeueOutputBuffer;
                            if (i3 == -1 && i() && (dequeueInputBuffer = mediaCodec2.dequeueInputBuffer(10000L)) != -1) {
                                ByteBuffer byteBuffer2 = byteBufferArr5[dequeueInputBuffer];
                                int i9 = bufferInfo3.size;
                                long j = bufferInfo3.presentationTimeUs;
                                if (i9 >= 0) {
                                    ByteBuffer duplicate = byteBufferArr2[i3].duplicate();
                                    duplicate.position(bufferInfo3.offset);
                                    duplicate.limit(bufferInfo3.offset + i9);
                                    byteBuffer2.position(r11);
                                    byteBuffer2.put(duplicate);
                                    mediaCodec2.queueInputBuffer(dequeueInputBuffer, 0, i9, j, bufferInfo3.flags);
                                }
                                mediaCodec.releaseOutputBuffer(i3, (boolean) r11);
                                i7 = -1;
                                if ((bufferInfo3.flags & 4) != 0) {
                                    z6 = true;
                                }
                            } else {
                                i7 = i3;
                            }
                            if (z5 && ((mediaFormat2 == null || this.c.b()) && i())) {
                                bufferInfo2 = bufferInfo;
                                int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo2, 10000L);
                                if (dequeueOutputBuffer2 != -1) {
                                    if (dequeueOutputBuffer2 == -3) {
                                        byteBufferArr4 = mediaCodec2.getOutputBuffers();
                                        byteBufferArr3 = byteBufferArr5;
                                        mediaFormat = mediaFormat2;
                                    } else if (dequeueOutputBuffer2 == -2) {
                                        if (i >= 0) {
                                            return;
                                        }
                                        mediaFormat = mediaCodec2.getOutputFormat();
                                        byteBufferArr3 = byteBufferArr5;
                                    } else {
                                        ByteBuffer byteBuffer3 = byteBufferArr4[dequeueOutputBuffer2];
                                        if ((bufferInfo2.flags & 2) != 0) {
                                            mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, (boolean) r11);
                                        } else {
                                            if (bufferInfo2.size != 0) {
                                                byteBufferArr3 = byteBufferArr5;
                                                if (bufferInfo2.presentationTimeUs > this.d) {
                                                    this.c.g(i, byteBuffer3, bufferInfo2);
                                                    this.d = bufferInfo2.presentationTimeUs;
                                                }
                                            } else {
                                                byteBufferArr3 = byteBufferArr5;
                                            }
                                            if ((bufferInfo2.flags & 4) != 0) {
                                                z2 = false;
                                                z5 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, z2);
                                            mediaFormat = mediaFormat2;
                                            if (mediaFormat != null && !z7) {
                                                j(InnerAudioProcessor.TAG, "muxer: adding audio track.");
                                                i = this.c.a(mediaFormat);
                                                z7 = true;
                                            }
                                            if (!this.c.b() && z7) {
                                                this.c.c();
                                                if (this.c.e()) {
                                                    synchronized (this.c) {
                                                        while (!this.c.b()) {
                                                            try {
                                                                this.c.wait(100L);
                                                            } catch (InterruptedException e) {
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            }
                                            byteBufferArr5 = byteBufferArr3;
                                            mediaFormat2 = mediaFormat;
                                            outputBuffers = byteBufferArr2;
                                            i8 = i;
                                            inputBuffers = byteBufferArr;
                                            i6 = 0;
                                            i5 = -1;
                                            bufferInfo4 = bufferInfo2;
                                            z4 = z;
                                        }
                                    }
                                    if (mediaFormat != null) {
                                        j(InnerAudioProcessor.TAG, "muxer: adding audio track.");
                                        i = this.c.a(mediaFormat);
                                        z7 = true;
                                    }
                                    if (!this.c.b()) {
                                        this.c.c();
                                        if (this.c.e()) {
                                        }
                                    }
                                    byteBufferArr5 = byteBufferArr3;
                                    mediaFormat2 = mediaFormat;
                                    outputBuffers = byteBufferArr2;
                                    i8 = i;
                                    inputBuffers = byteBufferArr;
                                    i6 = 0;
                                    i5 = -1;
                                    bufferInfo4 = bufferInfo2;
                                    z4 = z;
                                }
                                byteBufferArr3 = byteBufferArr5;
                            } else {
                                byteBufferArr3 = byteBufferArr5;
                                bufferInfo2 = bufferInfo;
                            }
                            mediaFormat = mediaFormat2;
                            if (mediaFormat != null) {
                            }
                            if (!this.c.b()) {
                            }
                            byteBufferArr5 = byteBufferArr3;
                            mediaFormat2 = mediaFormat;
                            outputBuffers = byteBufferArr2;
                            i8 = i;
                            inputBuffers = byteBufferArr;
                            i6 = 0;
                            i5 = -1;
                            bufferInfo4 = bufferInfo2;
                            z4 = z;
                        }
                    }
                }
                int i10 = i2;
                byteBufferArr2 = outputBuffers;
                i3 = i10;
                if (i3 == -1) {
                }
                i7 = i3;
                if (z5) {
                }
                byteBufferArr3 = byteBufferArr5;
                bufferInfo2 = bufferInfo;
                mediaFormat = mediaFormat2;
                if (mediaFormat != null) {
                }
                if (!this.c.b()) {
                }
                byteBufferArr5 = byteBufferArr3;
                mediaFormat2 = mediaFormat;
                outputBuffers = byteBufferArr2;
                i8 = i;
                inputBuffers = byteBufferArr;
                i6 = 0;
                i5 = -1;
                bufferInfo4 = bufferInfo2;
                z4 = z;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0159, code lost:
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
        r1.onGenFilterVideoRecordError(233, com.baidu.tieba.hr7.a(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x015f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() throws Exception {
        MediaCodecInfo l;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        MediaExtractor mediaExtractor;
        sx8.c cVar;
        MediaExtractor c;
        int f;
        MediaCodec a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (l = l("audio/mp4a-latm")) == null) {
            return;
        }
        Exception e = null;
        try {
            c = c();
            try {
                f = f(c);
            } catch (Exception e2) {
                e = e2;
                mediaCodec = null;
                mediaExtractor = c;
                mediaCodec2 = null;
            } catch (Throwable th) {
                th = th;
                mediaCodec = null;
                mediaExtractor = c;
                mediaCodec2 = null;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodec = null;
            mediaCodec2 = null;
            mediaExtractor = null;
        } catch (Throwable th2) {
            th = th2;
            mediaCodec = null;
            mediaCodec2 = null;
            mediaExtractor = null;
        }
        if (f < 0 && this.c != null) {
            this.c.c();
            if (c != null) {
                try {
                    c.release();
                    return;
                } catch (Exception e4) {
                    sx8.c cVar2 = this.e;
                    if (cVar2 != null) {
                        cVar2.onGenFilterVideoRecordError(231, hr7.a(e4));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        MediaFormat trackFormat = c.getTrackFormat(f);
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", "audio/mp4a-latm");
        mediaFormat.setInteger("aac-profile", 5);
        mediaFormat.setInteger("max-input-size", 8192);
        m(trackFormat, mediaFormat, "sample-rate", 48000);
        m(trackFormat, mediaFormat, "channel-count", 1);
        m(trackFormat, mediaFormat, "bitrate", EncoderParams.AUDIO_BIT_RATE);
        MediaCodec b = b(l, mediaFormat);
        try {
            a2 = a(trackFormat);
        } catch (Exception e5) {
            mediaExtractor = c;
            mediaCodec2 = null;
            mediaCodec = b;
            e = e5;
        } catch (Throwable th3) {
            mediaExtractor = c;
            mediaCodec2 = null;
            mediaCodec = b;
            th = th3;
        }
        try {
            d(c, a2, b);
            if (c != null) {
                try {
                    c.release();
                } catch (Exception e6) {
                    e = e6;
                    sx8.c cVar3 = this.e;
                    if (cVar3 != null) {
                        cVar3.onGenFilterVideoRecordError(231, hr7.a(e));
                    }
                }
            }
            if (a2 != null) {
                try {
                    a2.stop();
                    a2.release();
                } catch (Exception e7) {
                    if (e == null) {
                        e = e7;
                    }
                    sx8.c cVar4 = this.e;
                    if (cVar4 != null) {
                        cVar4.onGenFilterVideoRecordError(232, hr7.a(e7));
                    }
                }
            }
            if (b != null) {
                try {
                    b.stop();
                    b.release();
                } catch (Exception e8) {
                    e = e8;
                    if (e == null) {
                        e = e;
                    }
                    cVar = this.e;
                }
            }
        } catch (Exception e9) {
            mediaCodec = b;
            e = e9;
            mediaExtractor = c;
            mediaCodec2 = a2;
            try {
                e.printStackTrace();
                if ((Build.VERSION.SDK_INT < 21 || !(e instanceof MediaCodec.CodecException) || xi.isEmpty(e.getMessage()) || !e.getMessage().contains("0xfffffff3")) && this.e != null) {
                    this.e.onGenFilterVideoRecordError(230, hr7.a(e));
                }
                if (mediaExtractor != null) {
                    try {
                        mediaExtractor.release();
                    } catch (Exception e10) {
                        e = e10;
                        sx8.c cVar5 = this.e;
                        if (cVar5 != null) {
                            cVar5.onGenFilterVideoRecordError(231, hr7.a(e));
                        }
                    }
                }
                if (mediaCodec2 != null) {
                    try {
                        mediaCodec2.stop();
                        mediaCodec2.release();
                    } catch (Exception e11) {
                        if (e == null) {
                            e = e11;
                        }
                        sx8.c cVar6 = this.e;
                        if (cVar6 != null) {
                            cVar6.onGenFilterVideoRecordError(232, hr7.a(e11));
                        }
                    }
                }
                if (mediaCodec != null) {
                    try {
                        mediaCodec.stop();
                        mediaCodec.release();
                    } catch (Exception e12) {
                        e = e12;
                        if (e == null) {
                            e = e;
                        }
                        cVar = this.e;
                    }
                }
                if (e != null) {
                }
            } catch (Throwable th4) {
                th = th4;
                if (mediaExtractor != null) {
                    try {
                        mediaExtractor.release();
                    } catch (Exception e13) {
                        e = e13;
                        sx8.c cVar7 = this.e;
                        if (cVar7 != null) {
                            cVar7.onGenFilterVideoRecordError(231, hr7.a(e));
                        }
                    }
                }
                if (mediaCodec2 != null) {
                    try {
                        mediaCodec2.stop();
                        mediaCodec2.release();
                    } catch (Exception e14) {
                        if (e == null) {
                        }
                        sx8.c cVar8 = this.e;
                        if (cVar8 != null) {
                            cVar8.onGenFilterVideoRecordError(232, hr7.a(e14));
                        }
                    }
                }
                if (mediaCodec != null) {
                    try {
                        mediaCodec.stop();
                        mediaCodec.release();
                    } catch (Exception e15) {
                        sx8.c cVar9 = this.e;
                        if (cVar9 != null) {
                            cVar9.onGenFilterVideoRecordError(233, hr7.a(e15));
                        }
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            mediaCodec = b;
            th = th5;
            mediaExtractor = c;
            mediaCodec2 = a2;
            if (mediaExtractor != null) {
            }
            if (mediaCodec2 != null) {
            }
            if (mediaCodec != null) {
            }
            throw th;
        }
        if (e != null) {
            return;
        }
        throw e;
    }
}
