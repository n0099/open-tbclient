package com.baidu.tieba;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
@RequiresApi(api = 16)
/* loaded from: classes6.dex */
public class ola {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public MediaExtractor b;
    public ByteBuffer c;
    public int d;
    public a e;
    public a f;
    public a g;

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaFormat a;
        public int b;
        public long c;
        public MediaCodec.BufferInfo d;
        public long e;

        public a() {
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
            this.a = null;
            this.b = -1;
            this.c = 0L;
            this.d = new MediaCodec.BufferInfo();
            this.e = 0L;
        }
    }

    public ola() {
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
        this.d = 512000;
        this.e = new a();
        this.f = new a();
        this.g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.advance();
        }
        return invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b.getSampleTrackIndex();
        }
        return invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g.c;
        }
        return invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b.getSampleTrackIndex();
        }
        return invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return i(this.c, 0);
        }
        return (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.c = null;
            }
            this.b.release();
        }
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i)) == null) {
            int readSampleData = this.b.readSampleData(byteBuffer, i);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.g;
            aVar.d.size = readSampleData;
            if (aVar == this.f) {
                aVar.c += aVar.e;
            } else {
                aVar.c = this.b.getSampleTime();
            }
            a aVar2 = this.g;
            MediaCodec.BufferInfo bufferInfo = aVar2.d;
            bufferInfo.presentationTimeUs = aVar2.c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.b.getSampleFlags();
            return this.g.d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void k(a aVar) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.g;
            if (aVar2 != null && (i2 = aVar2.b) >= 0) {
                this.b.unselectTrack(i2);
            }
            this.g = aVar;
            if (aVar != null && (i = aVar.b) >= 0) {
                this.b.selectTrack(i);
                a aVar3 = this.g;
                aVar3.a = this.b.getTrackFormat(aVar3.b);
                try {
                    this.g.a.getLong("durationUs");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void m(String str, String str2) throws IOException {
        int integer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.b = mediaExtractor;
            mediaExtractor.setDataSource(this.a);
            int trackCount = this.b.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.b.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f;
                    aVar.a = trackFormat;
                    aVar.b = i;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f.a.getInteger("max-input-size")) > 0) {
                        this.d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.e;
                    aVar2.a = trackFormat;
                    aVar2.b = i;
                }
            }
            if (this.c == null) {
                this.c = ByteBuffer.allocateDirect(this.d);
            }
            MediaFormat mediaFormat = this.f.a;
            if (mediaFormat != null) {
                try {
                    this.f.e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e) {
                    Log.e("VideoExtractor", "frameRate:" + e.getMessage());
                    e.printStackTrace();
                }
                if (this.f.e <= 0) {
                    k(g());
                    this.b.readSampleData(this.c, 0);
                    if (this.b.getSampleFlags() == 1) {
                        this.b.advance();
                    }
                    this.b.readSampleData(this.c, 0);
                    long sampleTime = this.b.getSampleTime();
                    this.b.advance();
                    this.f.e = Math.abs(this.b.getSampleTime() - sampleTime);
                }
            }
            if (FileUtils.VIDEO_FILE_START.equals(str2)) {
                k(g());
            } else if ("audio/".equals(str2)) {
                k(b());
            }
        }
    }
}
