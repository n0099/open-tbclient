package com.baidu.tieba;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface;
import com.baidu.ugc.editvideo.faceunity.encoder.MediaCodecHelper;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class r7b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r7b b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> a;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b extends MediaMetadataRetriever implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;
        public String b;
        public boolean c;
        public volatile boolean d;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a8b a;
            public final /* synthetic */ z7b b;
            public final /* synthetic */ b c;

            public a(b bVar, a8b a8bVar, z7b z7bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, a8bVar, z7bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = a8bVar;
                this.b = z7bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<u7b> arrayList = new ArrayList();
                    ArrayList<u7b> arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (u7b u7bVar : this.a.e) {
                        int i = u7bVar.g;
                        if (i == 0) {
                            arrayList.add(u7bVar);
                        } else if (i == 1) {
                            arrayList2.add(u7bVar);
                        }
                    }
                    if (!bsb.e(arrayList)) {
                        for (u7b u7bVar2 : arrayList) {
                            Bitmap d = v7b.f().d(u7bVar2.a);
                            if (d == null || d.isRecycled()) {
                                d = xrb.e(u7bVar2.b, u7bVar2.h, u7bVar2.i, u7bVar2.c);
                                v7b.f().g().b(u7bVar2.a, d);
                                v7b.f().e().c(u7bVar2.a, d);
                            }
                            u7bVar2.e = d;
                            u7bVar2.a();
                        }
                    }
                    if (!bsb.e(arrayList2)) {
                        for (u7b u7bVar3 : arrayList2) {
                            Bitmap d2 = v7b.f().d(u7bVar3.a);
                            if (d2 != null && !d2.isRecycled()) {
                                u7bVar3.e = d2;
                                u7bVar3.a();
                            } else {
                                arrayList3.add(u7bVar3);
                            }
                        }
                    }
                    if (!bsb.e(arrayList3)) {
                        this.a.e = arrayList3;
                        if (!this.c.g()) {
                            this.c.j(this.a);
                        } else {
                            this.c.i(this.a);
                        }
                        this.c.k(this.b);
                        return;
                    }
                    this.c.k(this.b);
                }
            }
        }

        /* renamed from: com.baidu.tieba.r7b$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0466b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z7b a;
            public final /* synthetic */ b b;

            public RunnableC0466b(b bVar, z7b z7bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, z7bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = z7bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                z7b z7bVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (z7bVar = this.a) != null) {
                    z7bVar.a(this.b);
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = true;
        }

        @Override // android.media.MediaMetadataRetriever, java.lang.AutoCloseable, java.io.Closeable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                release();
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.d;
            }
            return invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.c && !qsb.a(this.b)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // android.media.MediaMetadataRetriever
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                super.release();
                this.a = true;
                this.d = false;
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public final void i(a8b a8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, a8bVar) == null) {
                try {
                    e(a8bVar.a, a8bVar.e, a8bVar.c, a8bVar.d, a8bVar.b);
                } catch (Exception e) {
                    e.printStackTrace();
                    j(a8bVar);
                }
            }
        }

        public final void k(z7b z7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z7bVar) == null) {
                this.d = false;
                osb.a().post(new RunnableC0466b(this, z7bVar));
            }
        }

        public void o(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.d = z;
            }
        }

        public void p(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.c = z;
            }
        }

        @Override // android.media.MediaMetadataRetriever
        public void setDataSource(String str) throws IllegalArgumentException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                try {
                    super.setDataSource(str);
                    this.b = str;
                } catch (Exception e) {
                    wrb.g(e);
                }
            }
        }

        public void h(a8b a8bVar, z7b z7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, a8bVar, z7bVar) == null) {
                if (a8bVar != null && !bsb.e(a8bVar.e)) {
                    this.d = true;
                    ThreadPool.b().e(new a(this, a8bVar, z7bVar));
                    return;
                }
                k(z7bVar);
            }
        }

        public final void d(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, BaseOutputSurface baseOutputSurface, List<u7b> list) throws IOException {
            String str;
            int i2;
            long j;
            int i3;
            boolean z;
            boolean z2;
            int dequeueInputBuffer;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaExtractor, Integer.valueOf(i), mediaCodec, baseOutputSurface, list}) == null) {
                ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                long j3 = 0;
                int i4 = 0;
                if (bsb.b(list) == 1) {
                    u7b u7bVar = (u7b) bsb.c(list, 0);
                    if (u7bVar != null) {
                        j2 = u7bVar.d;
                    } else {
                        j2 = 0;
                    }
                    if (j2 <= 0) {
                        j2 = 1;
                    }
                    mediaExtractor.getSampleTime();
                    mediaExtractor.seekTo(j2, 0);
                    if (mediaExtractor.getSampleTime() > j2) {
                        mediaExtractor.seekTo(0L, 2);
                    }
                }
                int i5 = 0;
                boolean z3 = false;
                boolean z4 = false;
                while (!z3 && !this.a) {
                    if (z4 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                        str = "VideoFrameMetadataRetriever";
                        i2 = i5;
                        j = j3;
                    } else {
                        int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i4);
                        if (readSampleData < 0) {
                            str = "VideoFrameMetadataRetriever";
                            i2 = i5;
                            j = j3;
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            z4 = true;
                        } else {
                            str = "VideoFrameMetadataRetriever";
                            i2 = i5;
                            j = j3;
                            if (mediaExtractor.getSampleTrackIndex() != i) {
                                wrb.l(str, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i);
                            }
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            mediaExtractor.advance();
                        }
                    }
                    if (!z3) {
                        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                        if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                            if (dequeueOutputBuffer == -2) {
                                mediaCodec.getOutputFormat();
                            } else if (dequeueOutputBuffer < 0) {
                                wrb.c(str, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                            } else {
                                if ((bufferInfo.flags & 4) != 0) {
                                    z = true;
                                } else {
                                    z = z3;
                                }
                                if (bufferInfo.size != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z2);
                                if (z2) {
                                    i3 = i2;
                                    u7b u7bVar2 = (u7b) bsb.c(list, i3);
                                    baseOutputSurface.awaitNewImage();
                                    baseOutputSurface.drawImage((int) (((float) bufferInfo.presentationTimeUs) / 1000.0f));
                                    if (u7bVar2 != null) {
                                        long j4 = u7bVar2.d;
                                        if (j4 <= j) {
                                            j4 = 1;
                                        } else if (i3 == list.size() - 1) {
                                            j4 -= 800000;
                                        }
                                        if (bufferInfo.presentationTimeUs >= j4) {
                                            u7bVar2.e = baseOutputSurface.getFrameBitmap();
                                            v7b.f().g().b(u7bVar2.a, u7bVar2.e);
                                            u7bVar2.a();
                                            v7b.f().e().c(u7bVar2.a, u7bVar2.e);
                                            if (i3 == list.size() - 1) {
                                                z = true;
                                            }
                                            i5 = i3 + 1;
                                            z3 = z;
                                            j3 = j;
                                            i4 = 0;
                                        }
                                    }
                                } else {
                                    i3 = i2;
                                }
                                z3 = z;
                            }
                        }
                        i5 = i2;
                        j3 = j;
                        i4 = 0;
                    } else {
                        i3 = i2;
                    }
                    i5 = i3;
                    j3 = j;
                    i4 = 0;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(String str, List<u7b> list, int i, int i2, float f) throws IOException {
            MediaExtractor mediaExtractor;
            MediaCodec mediaCodec;
            File file;
            int andSelectVideoTrackIndex;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, list, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
                p7b p7bVar = null;
                try {
                    file = new File(str);
                } catch (Exception e) {
                    e = e;
                    mediaExtractor = null;
                    mediaCodec = null;
                } catch (Throwable th) {
                    th = th;
                    mediaExtractor = null;
                    mediaCodec = null;
                }
                if (file.canRead()) {
                    mediaExtractor = new MediaExtractor();
                    try {
                        mediaExtractor.setDataSource(file.toString());
                        andSelectVideoTrackIndex = MediaCodecHelper.getAndSelectVideoTrackIndex(mediaExtractor);
                    } catch (Exception e2) {
                        e = e2;
                        mediaCodec = null;
                    } catch (Throwable th2) {
                        th = th2;
                        mediaCodec = null;
                    }
                    if (andSelectVideoTrackIndex >= 0) {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(andSelectVideoTrackIndex);
                        int integer = trackFormat.getInteger("width");
                        int integer2 = trackFormat.getInteger("height");
                        if (i == 0 || i2 == 0) {
                            float f2 = f % 360.0f;
                            if (f2 != 90.0f && f2 != 270.0f) {
                                i = integer;
                                i2 = integer2;
                            }
                            i2 = integer;
                            i = integer2;
                        }
                        p7b p7bVar2 = new p7b(i, i2, true, null);
                        try {
                            p7bVar2.a(integer, integer2, f);
                            mediaCodec = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                        } catch (Exception e3) {
                            e = e3;
                            mediaCodec = null;
                        } catch (Throwable th3) {
                            th = th3;
                            mediaCodec = null;
                        }
                        try {
                            mediaCodec.configure(trackFormat, p7bVar2.getSurface(), (MediaCrypto) null, 0);
                            mediaCodec.start();
                            d(mediaExtractor, andSelectVideoTrackIndex, mediaCodec, p7bVar2, list);
                            p7bVar2.release();
                            if (mediaCodec != null) {
                                mediaCodec.stop();
                                mediaCodec.release();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            p7bVar = p7bVar2;
                            try {
                                wrb.g(e);
                                if (p7bVar != null) {
                                    p7bVar.release();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                }
                                if (mediaExtractor == null) {
                                    return;
                                }
                                mediaExtractor.release();
                                return;
                            } catch (Throwable th4) {
                                th = th4;
                                if (p7bVar != null) {
                                    p7bVar.release();
                                }
                                if (mediaCodec != null) {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                }
                                if (mediaExtractor != null) {
                                    mediaExtractor.release();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            p7bVar = p7bVar2;
                            if (p7bVar != null) {
                            }
                            if (mediaCodec != null) {
                            }
                            if (mediaExtractor != null) {
                            }
                            throw th;
                        }
                        mediaExtractor.release();
                        return;
                    }
                    throw new RuntimeException("No video track found in " + file);
                }
                throw new FileNotFoundException("Unable to read " + file);
            }
        }

        public final void j(a8b a8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, a8bVar) == null) {
                try {
                    for (u7b u7bVar : a8bVar.e) {
                        Bitmap frameAtTime = getFrameAtTime(u7bVar.d, 2);
                        if (frameAtTime != null) {
                            if (a8bVar.c != 0 && a8bVar.d != 0) {
                                u7bVar.e = ThumbnailUtils.extractThumbnail(frameAtTime, a8bVar.c, a8bVar.d, 2);
                            }
                            u7bVar.a();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public r7b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(new b(null));
        this.a.add(new b(null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        r2.o(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        r0 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized b b() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                bVar = null;
                Iterator<b> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    if (next != null && !next.f()) {
                        break;
                    }
                }
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static r7b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (r7b.class) {
                    if (b == null) {
                        b = new r7b();
                    }
                }
            }
            return b;
        }
        return (r7b) invokeV.objValue;
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && bVar != null) {
            bVar.o(false);
        }
    }
}
