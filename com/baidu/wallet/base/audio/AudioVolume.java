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
    public static final String f60225a = "AudioVolume";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f60226b;

    /* renamed from: c  reason: collision with root package name */
    public int f60227c;

    /* renamed from: d  reason: collision with root package name */
    public long f60228d;

    /* renamed from: e  reason: collision with root package name */
    public double f60229e;

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
        this.f60227c = 8000;
        a(i2);
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            this.f60226b = 0;
            this.f60228d = 0;
            if (512 < i2) {
                this.f60227c = i2;
            } else {
                this.f60227c = 8000;
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
                i2 = this.f60227c >> 1;
                i3 = this.f60226b;
            } else {
                i2 = this.f60227c;
                i3 = this.f60226b;
            }
            int i4 = i2 - i3;
            int i5 = limit - position;
            if (i4 >= i5) {
                while (position < limit) {
                    this.f60228d = (long) (this.f60228d + Math.pow(z ? byteBuffer.getShort(position) : byteBuffer.get(position), 2.0d));
                    position++;
                }
                this.f60226b += i5;
                return;
            }
            int i6 = i4 + position;
            while (position < i6) {
                short s = z ? byteBuffer.getShort(position) : byteBuffer.get(position);
                LogUtil.d(f60225a, "value: " + ((int) s));
                this.f60228d = (long) (((double) this.f60228d) + Math.pow((double) s, 2.0d));
                position++;
            }
            this.f60229e = Math.log10((int) (this.f60228d / this.f60227c)) * 10.0d;
            LogUtil.i(f60225a, "calAccumulatedVolume: " + this.f60229e + "|" + i6 + "|" + this.f60228d);
            this.f60228d = 0L;
            this.f60226b = 0;
            for (int i7 = i6; i7 < limit; i7++) {
                this.f60228d = (long) (this.f60228d + Math.pow(z ? byteBuffer.getShort(i7) : byteBuffer.get(i7), 2.0d));
            }
            this.f60226b += limit - i6;
        }
    }

    public double getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60229e : invokeV.doubleValue;
    }
}
