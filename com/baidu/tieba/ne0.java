package com.baidu.tieba;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public abstract class ne0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String i = "ne0";
    public static long j = 0;
    public static int k = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public qe0 c;
    public MediaCodec d;
    public MediaCodec.BufferInfo e;
    public oe0 f;
    public boolean g;
    public long h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947999440, "Lcom/baidu/tieba/ne0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947999440, "Lcom/baidu/tieba/ne0;");
        }
    }

    public abstract void j();

    public ne0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = false;
        this.h = 0L;
        this.e = new MediaCodec.BufferInfo();
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.b && this.a == -1) {
                return;
            }
            int dequeueInputBuffer = this.d.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                if (z) {
                    Log.d(i, "drainBuffer sending EOS to drainBufferEncoder");
                    this.d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
                    return;
                } else {
                    MediaCodec mediaCodec = this.d;
                    MediaCodec.BufferInfo bufferInfo = this.e;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
                }
            } else {
                Log.d(i, "drainBuffer encode input buffer not available");
            }
            b(z, k);
        }
    }

    public final void b(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            ByteBuffer[] outputBuffers = this.d.getOutputBuffers();
            while (true) {
                try {
                    int dequeueOutputBuffer = this.d.dequeueOutputBuffer(this.e, i2);
                    if (dequeueOutputBuffer == -1) {
                        if (z) {
                            Log.d(i, "no output available, spinning to await EOS");
                        } else {
                            return;
                        }
                    } else if (dequeueOutputBuffer == -3) {
                        outputBuffers = this.d.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        if (this.c.c()) {
                            Log.e(i, "format changed twice!!!!");
                            return;
                        }
                        MediaFormat outputFormat = this.d.getOutputFormat();
                        String str = i;
                        Log.d(str, "encoder output format changed: " + outputFormat);
                        this.a = this.c.a(outputFormat);
                        this.b = true;
                        oe0 oe0Var = this.f;
                        if (oe0Var != null) {
                            oe0Var.c(true);
                        }
                        if (this.g) {
                            this.c.e();
                        }
                    } else if (dequeueOutputBuffer < 0) {
                        String str2 = i;
                        Log.w(str2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                    } else {
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer != null) {
                            if ((this.e.flags & 2) != 0) {
                                Log.d(i, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                                this.e.size = 0;
                            }
                            if (this.e.size != 0) {
                                if (this.c.c()) {
                                    byteBuffer.position(this.e.offset);
                                    MediaCodec.BufferInfo bufferInfo = this.e;
                                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                    j();
                                    this.c.g(this.a, byteBuffer, this.e);
                                } else {
                                    Log.d(i, "drainEncoder wait for mMuxer start !!!");
                                }
                            }
                            this.d.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if ((this.e.flags & 4) != 0) {
                                if (z) {
                                    if (this.g) {
                                        this.c.f();
                                    }
                                    oe0 oe0Var2 = this.f;
                                    if (oe0Var2 != null) {
                                        oe0Var2.a(true);
                                        return;
                                    }
                                    return;
                                }
                                Log.e(i, "reached end of stream unexpectedly");
                                return;
                            }
                        } else {
                            throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                        }
                    }
                } catch (IllegalStateException unused) {
                    System.getProperty("ro.board.platform");
                    String str3 = i;
                    Log.i(str3, "mEncoder.dequeueOutputBuffer IllegalStateException error hard:" + System.getProperty("ro.board.platform"));
                    return;
                }
            }
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                qe0 qe0Var = this.c;
                if (qe0Var != null && qe0Var.c()) {
                    this.d.signalEndOfInputStream();
                } else {
                    oe0 oe0Var = this.f;
                    if (oe0Var != null) {
                        oe0Var.a(true);
                        return;
                    }
                    return;
                }
            }
            b(z, 10000);
        }
    }

    public void f(oe0 oe0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, oe0Var) == null) {
            this.f = oe0Var;
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h * 1000;
        }
        return invokeV.longValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.release();
            this.d = null;
            this.c = null;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.start();
            oe0 oe0Var = this.f;
            if (oe0Var != null) {
                oe0Var.d(true);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.d.stop();
            } catch (Exception unused) {
                Log.e(i, "MediaCodec IllegalStateException Exception ");
            }
        }
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            ByteBuffer byteBuffer2 = this.d.getInputBuffers()[i2];
            if (byteBuffer2.capacity() < byteBuffer.capacity()) {
                return false;
            }
            byteBuffer2.position(0);
            byteBuffer2.put(byteBuffer);
            byteBuffer2.flip();
            MediaCodec.BufferInfo bufferInfo = this.e;
            bufferInfo.offset = 0;
            bufferInfo.size = i3;
            bufferInfo.presentationTimeUs = j2 / 1000;
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
