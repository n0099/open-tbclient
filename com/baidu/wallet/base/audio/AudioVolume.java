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
/* loaded from: classes10.dex */
public class AudioVolume {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f57299a = "AudioVolume";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f57300b;

    /* renamed from: c  reason: collision with root package name */
    public int f57301c;

    /* renamed from: d  reason: collision with root package name */
    public long f57302d;

    /* renamed from: e  reason: collision with root package name */
    public double f57303e;

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
        this.f57301c = 8000;
        a(i2);
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            this.f57300b = 0;
            this.f57302d = 0;
            if (512 < i2) {
                this.f57301c = i2;
            } else {
                this.f57301c = 8000;
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
                i2 = this.f57301c >> 1;
                i3 = this.f57300b;
            } else {
                i2 = this.f57301c;
                i3 = this.f57300b;
            }
            int i4 = i2 - i3;
            int i5 = limit - position;
            if (i4 >= i5) {
                while (position < limit) {
                    this.f57302d = (long) (this.f57302d + Math.pow(z ? byteBuffer.getShort(position) : byteBuffer.get(position), 2.0d));
                    position++;
                }
                this.f57300b += i5;
                return;
            }
            int i6 = i4 + position;
            while (position < i6) {
                short s = z ? byteBuffer.getShort(position) : byteBuffer.get(position);
                LogUtil.d(f57299a, "value: " + ((int) s));
                this.f57302d = (long) (((double) this.f57302d) + Math.pow((double) s, 2.0d));
                position++;
            }
            this.f57303e = Math.log10((int) (this.f57302d / this.f57301c)) * 10.0d;
            LogUtil.i(f57299a, "calAccumulatedVolume: " + this.f57303e + "|" + i6 + "|" + this.f57302d);
            this.f57302d = 0L;
            this.f57300b = 0;
            for (int i7 = i6; i7 < limit; i7++) {
                this.f57302d = (long) (this.f57302d + Math.pow(z ? byteBuffer.getShort(i7) : byteBuffer.get(i7), 2.0d));
            }
            this.f57300b += limit - i6;
        }
    }

    public double getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57303e : invokeV.doubleValue;
    }
}
