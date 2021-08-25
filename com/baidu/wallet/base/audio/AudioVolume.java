package com.baidu.wallet.base.audio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class AudioVolume {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f60045a = "AudioVolume";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f60046b;

    /* renamed from: c  reason: collision with root package name */
    public int f60047c;

    /* renamed from: d  reason: collision with root package name */
    public long f60048d;

    /* renamed from: e  reason: collision with root package name */
    public double f60049e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(374590426, "Lcom/baidu/wallet/base/audio/AudioVolume;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(374590426, "Lcom/baidu/wallet/base/audio/AudioVolume;");
        }
    }

    public AudioVolume(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60047c = 8000;
        a(i2);
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            this.f60046b = 0;
            this.f60048d = 0;
            if (512 < i2) {
                this.f60047c = i2;
            } else {
                this.f60047c = 8000;
            }
        }
    }

    public void calAccumulatedVolume(ByteBuffer byteBuffer, boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, byteBuffer, z) == null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            if (z) {
                position >>= 1;
                limit >>= 1;
                i2 = this.f60047c >> 1;
                i3 = this.f60046b;
            } else {
                i2 = this.f60047c;
                i3 = this.f60046b;
            }
            int i4 = i2 - i3;
            int i5 = limit - position;
            if (i4 >= i5) {
                while (position < limit) {
                    this.f60048d = (long) (this.f60048d + Math.pow(z ? byteBuffer.getShort(position) : byteBuffer.get(position), 2.0d));
                    position++;
                }
                this.f60046b += i5;
                return;
            }
            int i6 = i4 + position;
            while (position < i6) {
                short s = z ? byteBuffer.getShort(position) : byteBuffer.get(position);
                LogUtil.d(f60045a, "value: " + ((int) s));
                this.f60048d = (long) (((double) this.f60048d) + Math.pow((double) s, 2.0d));
                position++;
            }
            this.f60049e = Math.log10((int) (this.f60048d / this.f60047c)) * 10.0d;
            LogUtil.i(f60045a, "calAccumulatedVolume: " + this.f60049e + "|" + i6 + "|" + this.f60048d);
            this.f60048d = 0L;
            this.f60046b = 0;
            for (int i7 = i6; i7 < limit; i7++) {
                this.f60048d = (long) (this.f60048d + Math.pow(z ? byteBuffer.getShort(i7) : byteBuffer.get(i7), 2.0d));
            }
            this.f60046b += limit - i6;
        }
    }

    public double getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60049e : invokeV.doubleValue;
    }
}
