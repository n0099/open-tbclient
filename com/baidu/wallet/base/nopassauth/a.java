package com.baidu.wallet.base.nopassauth;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ABTestConstants;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes8.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f60442g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f60443c;

    /* renamed from: d  reason: collision with root package name */
    public long f60444d;

    /* renamed from: e  reason: collision with root package name */
    public int f60445e;

    /* renamed from: f  reason: collision with root package name */
    public long f60446f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1897256967, "Lcom/baidu/wallet/base/nopassauth/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1897256967, "Lcom/baidu/wallet/base/nopassauth/a;");
                return;
            }
        }
        f60442g = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, 100000000};
    }

    public a(String str, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60443c = str;
        this.f60444d = j2;
        this.f60445e = i2;
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f60446f = j2;
        }
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f60446f : invokeV.longValue;
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f60443c : (String) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f60444d : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f60445e : invokeV.intValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f60443c = str;
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.f60444d = j2;
            String str = "+++++++++HotpToken movingFactor is " + this.f60444d;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f60445e = i2;
        }
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            byte[] bArr = new byte[8];
            long j2 = this.f60444d;
            for (int i2 = 7; i2 >= 0; i2--) {
                bArr[i2] = (byte) (255 & j2);
                j2 >>= 8;
            }
            SafePay safePay = SafePay.getInstance();
            byte[] b2 = b(this.f60443c);
            int[] iArr = f60442g;
            int i3 = this.f60445e;
            return safePay.getDyKey(b2, bArr, iArr[i3], i3);
        }
        return (String) invokeL.objValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        MessageDigest messageDigest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            long timeInMillis = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
            byte[] bytes = ("" + timeInMillis).getBytes();
            try {
                if (i2 == 128) {
                    messageDigest = MessageDigest.getInstance("MD5");
                } else {
                    messageDigest = MessageDigest.getInstance("SHA1");
                }
                messageDigest.reset();
                messageDigest.update(bytes);
                return a(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return (String) invokeI.objValue;
    }

    private byte[] a(byte[] bArr, byte[] bArr2) {
        Mac mac;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, bArr, bArr2)) == null) {
            try {
                try {
                    mac = Mac.getInstance("HmacSHA1");
                } catch (NoSuchAlgorithmException unused) {
                    mac = Mac.getInstance("HMAC-SHA-1");
                }
                mac.init(new SecretKeySpec(bArr, "RAW"));
                return mac.doFinal(bArr2);
            } catch (GeneralSecurityException e2) {
                throw new UndeclaredThrowableException(e2);
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
