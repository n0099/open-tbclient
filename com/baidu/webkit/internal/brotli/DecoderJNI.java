package com.baidu.webkit.internal.brotli;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class DecoderJNI implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class Wrapper implements INoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long[] context;
        public boolean fresh;
        public final ByteBuffer inputBuffer;
        public a lastStatus;

        public Wrapper(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = r0;
            this.lastStatus = a.f54849c;
            this.fresh = true;
            long[] jArr = {0, i2};
            this.inputBuffer = WebSettingsGlobalBlink.kernelBrotliCreate(jArr);
            if (this.context[0] == 0) {
                throw new IOException("failed to initialize native brotli decoder");
            }
        }

        private void parseStatus() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                long j2 = this.context[1];
                this.lastStatus = j2 == 1 ? a.f54848b : j2 == 2 ? a.f54849c : j2 == 3 ? a.f54850d : j2 == 4 ? a.f54851e : a.a;
            }
        }

        public void destroy() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long[] jArr = this.context;
                if (jArr[0] == 0) {
                    throw new IOException("brotli decoder is already destroyed");
                }
                WebSettingsGlobalBlink.kernelBrotliDestroy(jArr);
                this.context[0] = 0;
            }
        }

        public void finalize() throws Throwable {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.context[0] != 0) {
                    destroy();
                }
                super.finalize();
            }
        }

        public ByteBuffer getInputBuffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.inputBuffer : (ByteBuffer) invokeV.objValue;
        }

        public a getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lastStatus : (a) invokeV.objValue;
        }

        public boolean hasOutput() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.context[2] != 0 : invokeV.booleanValue;
        }

        public ByteBuffer pull() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.context[0] != 0) {
                    if (this.lastStatus == a.f54850d || hasOutput()) {
                        this.fresh = false;
                        ByteBuffer kernelBrotliPull = WebSettingsGlobalBlink.kernelBrotliPull(this.context);
                        parseStatus();
                        return kernelBrotliPull;
                    }
                    throw new IOException("pulling output from decoder in " + this.lastStatus + " state");
                }
                throw new IOException("brotli decoder is already destroyed");
            }
            return (ByteBuffer) invokeV.objValue;
        }

        public void push(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                if (i2 < 0) {
                    throw new IOException("negative block length");
                }
                if (this.context[0] == 0) {
                    throw new IOException("brotli decoder is already destroyed");
                }
                a aVar = this.lastStatus;
                if (aVar != a.f54849c && aVar != a.f54851e) {
                    throw new IOException("pushing input to decoder in " + this.lastStatus + " state");
                } else if (this.lastStatus == a.f54851e && i2 != 0) {
                    throw new IOException("pushing input to decoder in OK state");
                } else {
                    this.fresh = false;
                    WebSettingsGlobalBlink.kernelBrotliPush(this.context, i2);
                    parseStatus();
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f54848b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f54849c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f54850d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f54851e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ a[] f54852f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(344616851, "Lcom/baidu/webkit/internal/brotli/DecoderJNI$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(344616851, "Lcom/baidu/webkit/internal/brotli/DecoderJNI$a;");
                    return;
                }
            }
            a = new a("ERROR", 0);
            f54848b = new a("DONE", 1);
            f54849c = new a("NEEDS_MORE_INPUT", 2);
            f54850d = new a("NEEDS_MORE_OUTPUT", 3);
            a aVar = new a(StatHelper.SENSOR_OK, 4);
            f54851e = aVar;
            f54852f = new a[]{a, f54848b, f54849c, f54850d, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f54852f.clone() : (a[]) invokeV.objValue;
        }
    }

    public DecoderJNI() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
