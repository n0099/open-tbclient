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
/* loaded from: classes4.dex */
public class jy8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jy8 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> a;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b extends MediaMetadataRetriever implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;
        public String b;
        public boolean c;
        public volatile boolean d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sy8 a;
            public final /* synthetic */ ry8 b;
            public final /* synthetic */ b c;

            public a(b bVar, sy8 sy8Var, ry8 ry8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, sy8Var, ry8Var};
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
                this.a = sy8Var;
                this.b = ry8Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<my8> arrayList = new ArrayList();
                    ArrayList<my8> arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (my8 my8Var : this.a.e) {
                        int i = my8Var.g;
                        if (i == 0) {
                            arrayList.add(my8Var);
                        } else if (i == 1) {
                            arrayList2.add(my8Var);
                        }
                    }
                    if (!fc9.e(arrayList)) {
                        for (my8 my8Var2 : arrayList) {
                            Bitmap d = ny8.f().d(my8Var2.a);
                            if (d == null || d.isRecycled()) {
                                d = bc9.e(my8Var2.b, my8Var2.h, my8Var2.i, my8Var2.c);
                                ny8.f().g().b(my8Var2.a, d);
                                ny8.f().e().c(my8Var2.a, d);
                            }
                            my8Var2.e = d;
                            my8Var2.a();
                        }
                    }
                    if (!fc9.e(arrayList2)) {
                        for (my8 my8Var3 : arrayList2) {
                            Bitmap d2 = ny8.f().d(my8Var3.a);
                            if (d2 != null && !d2.isRecycled()) {
                                my8Var3.e = d2;
                                my8Var3.a();
                            } else {
                                arrayList3.add(my8Var3);
                            }
                        }
                    }
                    if (fc9.e(arrayList3)) {
                        this.c.k(this.b);
                        return;
                    }
                    this.a.e = arrayList3;
                    if (!this.c.g()) {
                        this.c.j(this.a);
                    } else {
                        this.c.i(this.a);
                    }
                    this.c.k(this.b);
                }
            }
        }

        /* renamed from: com.baidu.tieba.jy8$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0307b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ry8 a;
            public final /* synthetic */ b b;

            public RunnableC0307b(b bVar, ry8 ry8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, ry8Var};
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
                this.a = ry8Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                ry8 ry8Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ry8Var = this.a) == null) {
                    return;
                }
                ry8Var.a(this.b);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.media.MediaMetadataRetriever, java.lang.AutoCloseable, java.io.Closeable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                release();
            }
        }

        public final void d(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, BaseOutputSurface baseOutputSurface, List<my8> list) throws IOException {
            String str;
            int i2;
            long j;
            int i3;
            int dequeueInputBuffer;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaExtractor, Integer.valueOf(i), mediaCodec, baseOutputSurface, list}) == null) {
                ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                long j2 = 0;
                int i4 = 0;
                if (fc9.b(list) == 1) {
                    my8 my8Var = (my8) fc9.c(list, 0);
                    long j3 = my8Var != null ? my8Var.d : 0L;
                    if (j3 <= 0) {
                        j3 = 1;
                    }
                    mediaExtractor.getSampleTime();
                    mediaExtractor.seekTo(j3, 0);
                    if (mediaExtractor.getSampleTime() > j3) {
                        mediaExtractor.seekTo(0L, 2);
                    }
                }
                int i5 = 0;
                boolean z = false;
                boolean z2 = false;
                while (!z && !this.a) {
                    if (z2 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                        str = "VideoFrameMetadataRetriever";
                        i2 = i5;
                        j = j2;
                    } else {
                        int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i4);
                        if (readSampleData < 0) {
                            str = "VideoFrameMetadataRetriever";
                            i2 = i5;
                            j = j2;
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            z2 = true;
                        } else {
                            str = "VideoFrameMetadataRetriever";
                            i2 = i5;
                            j = j2;
                            if (mediaExtractor.getSampleTrackIndex() != i) {
                                ac9.l(str, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i);
                            }
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            mediaExtractor.advance();
                        }
                    }
                    if (z) {
                        i3 = i2;
                    } else {
                        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                        if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                            if (dequeueOutputBuffer == -2) {
                                mediaCodec.getOutputFormat();
                            } else if (dequeueOutputBuffer < 0) {
                                ac9.c(str, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                            } else {
                                boolean z3 = (bufferInfo.flags & 4) != 0 ? true : z;
                                boolean z4 = bufferInfo.size != 0;
                                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z4);
                                if (z4) {
                                    i3 = i2;
                                    my8 my8Var2 = (my8) fc9.c(list, i3);
                                    baseOutputSurface.awaitNewImage();
                                    baseOutputSurface.drawImage((int) (((float) bufferInfo.presentationTimeUs) / 1000.0f));
                                    if (my8Var2 != null) {
                                        long j4 = my8Var2.d;
                                        if (j4 <= j) {
                                            j4 = 1;
                                        } else if (i3 == list.size() - 1) {
                                            j4 -= 800000;
                                        }
                                        if (bufferInfo.presentationTimeUs >= j4) {
                                            my8Var2.e = baseOutputSurface.getFrameBitmap();
                                            ny8.f().g().b(my8Var2.a, my8Var2.e);
                                            my8Var2.a();
                                            ny8.f().e().c(my8Var2.a, my8Var2.e);
                                            if (i3 == list.size() - 1) {
                                                z3 = true;
                                            }
                                            i5 = i3 + 1;
                                            z = z3;
                                            j2 = j;
                                            i4 = 0;
                                        }
                                    }
                                } else {
                                    i3 = i2;
                                }
                                z = z3;
                            }
                        }
                        i5 = i2;
                        j2 = j;
                        i4 = 0;
                    }
                    i5 = i3;
                    j2 = j;
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
        public final void e(String str, List<my8> list, int i, int i2, float f) throws IOException {
            MediaExtractor mediaExtractor;
            MediaCodec mediaCodec;
            File file;
            int andSelectVideoTrackIndex;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, list, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
                hy8 hy8Var = null;
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
                        hy8 hy8Var2 = new hy8(i, i2, true, null);
                        try {
                            hy8Var2.a(integer, integer2, f);
                            mediaCodec = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                        } catch (Exception e3) {
                            e = e3;
                            mediaCodec = null;
                        } catch (Throwable th3) {
                            th = th3;
                            mediaCodec = null;
                        }
                        try {
                            mediaCodec.configure(trackFormat, hy8Var2.getSurface(), (MediaCrypto) null, 0);
                            mediaCodec.start();
                            d(mediaExtractor, andSelectVideoTrackIndex, mediaCodec, hy8Var2, list);
                            hy8Var2.release();
                            if (mediaCodec != null) {
                                mediaCodec.stop();
                                mediaCodec.release();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            hy8Var = hy8Var2;
                            try {
                                ac9.g(e);
                                if (hy8Var != null) {
                                    hy8Var.release();
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
                                if (hy8Var != null) {
                                    hy8Var.release();
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
                            hy8Var = hy8Var2;
                            if (hy8Var != null) {
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

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c && !uc9.a(this.b) : invokeV.booleanValue;
        }

        public void h(sy8 sy8Var, ry8 ry8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, sy8Var, ry8Var) == null) {
                if (sy8Var != null && !fc9.e(sy8Var.e)) {
                    this.d = true;
                    ThreadPool.b().e(new a(this, sy8Var, ry8Var));
                    return;
                }
                k(ry8Var);
            }
        }

        public final void i(sy8 sy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, sy8Var) == null) {
                try {
                    e(sy8Var.a, sy8Var.e, sy8Var.c, sy8Var.d, sy8Var.b);
                } catch (Exception e) {
                    e.printStackTrace();
                    j(sy8Var);
                }
            }
        }

        public final void j(sy8 sy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, sy8Var) == null) {
                try {
                    for (my8 my8Var : sy8Var.e) {
                        Bitmap frameAtTime = getFrameAtTime(my8Var.d, 2);
                        if (frameAtTime != null) {
                            if (sy8Var.c != 0 && sy8Var.d != 0) {
                                my8Var.e = ThumbnailUtils.extractThumbnail(frameAtTime, sy8Var.c, sy8Var.d, 2);
                            }
                            my8Var.a();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public final void k(ry8 ry8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ry8Var) == null) {
                this.d = false;
                sc9.a().post(new RunnableC0307b(this, ry8Var));
            }
        }

        public void l(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.d = z;
            }
        }

        public void m(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.c = z;
            }
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

        @Override // android.media.MediaMetadataRetriever
        public void setDataSource(String str) throws IllegalArgumentException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                try {
                    super.setDataSource(str);
                    this.b = str;
                } catch (Exception e) {
                    ac9.g(e);
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
    }

    public jy8() {
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

    public static jy8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (jy8.class) {
                    if (b == null) {
                        b = new jy8();
                    }
                }
            }
            return b;
        }
        return (jy8) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
        r2.l(true);
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

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.l(false);
    }
}
