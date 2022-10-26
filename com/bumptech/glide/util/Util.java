package com.bumptech.glide.util;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
/* loaded from: classes7.dex */
public final class Util {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HASH_ACCUMULATOR = 17;
    public static final int HASH_MULTIPLIER = 31;
    public static final char[] HEX_CHAR_ARRAY;
    public static final char[] SHA_256_CHARS;
    public static volatile Handler mainThreadHandler;
    public transient /* synthetic */ FieldHolder $fh;

    public static int hashCode(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65553, null, i, i2)) == null) ? (i2 * 31) + i : invokeII.intValue;
    }

    public static boolean isValidDimension(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i)) == null) ? i > 0 || i == Integer.MIN_VALUE : invokeI.booleanValue;
    }

    /* renamed from: com.bumptech.glide.util.Util$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(681066450, "Lcom/bumptech/glide/util/Util$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(681066450, "Lcom/bumptech/glide/util/Util$1;");
                    return;
                }
            }
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-919960641, "Lcom/bumptech/glide/util/Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-919960641, "Lcom/bumptech/glide/util/Util;");
                return;
            }
        }
        HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
        SHA_256_CHARS = new char[64];
    }

    public Util() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void assertBackgroundThread() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, null) != null) || isOnBackgroundThread()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on a background thread");
    }

    public static void assertMainThread() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, null) != null) || isOnMainThread()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    public static boolean isOnBackgroundThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return !isOnMainThread();
        }
        return invokeV.booleanValue;
    }

    public static boolean isOnMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean bothModelsNullEquivalentOrEquals(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2)) == null) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            } else if (obj instanceof Model) {
                return ((Model) obj).isEquivalentTo(obj2);
            } else {
                return obj.equals(obj2);
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean bothNullOrEqual(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, obj, obj2)) == null) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            }
            return obj.equals(obj2);
        }
        return invokeLL.booleanValue;
    }

    public static int hashCode(float f, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Float.valueOf(f), Integer.valueOf(i)})) == null) {
            return hashCode(Float.floatToIntBits(f), i);
        }
        return invokeCommon.intValue;
    }

    public static boolean isValidDimensions(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65560, null, i, i2)) == null) {
            if (isValidDimension(i) && isValidDimension(i2)) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static String bytesToHex(byte[] bArr, char[] cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bArr, cArr)) == null) {
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 2;
                char[] cArr2 = HEX_CHAR_ARRAY;
                cArr[i3] = cArr2[i2 >>> 4];
                cArr[i3 + 1] = cArr2[i2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeLL.objValue;
    }

    public static Queue createQueue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            return new ArrayDeque(i);
        }
        return (Queue) invokeI.objValue;
    }

    @Deprecated
    public static int getSize(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bitmap)) == null) {
            return getBitmapByteSize(bitmap);
        }
        return invokeL.intValue;
    }

    public static int hashCode(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65550, null, f)) == null) {
            return hashCode(f, 17);
        }
        return invokeF.intValue;
    }

    public static void postOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, runnable) == null) {
            getUiThreadHandler().post(runnable);
        }
    }

    public static void removeCallbacksOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, runnable) == null) {
            getUiThreadHandler().removeCallbacks(runnable);
        }
    }

    public static String sha256BytesToHex(byte[] bArr) {
        InterceptResult invokeL;
        String bytesToHex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bArr)) == null) {
            synchronized (SHA_256_CHARS) {
                bytesToHex = bytesToHex(bArr, SHA_256_CHARS);
            }
            return bytesToHex;
        }
        return (String) invokeL.objValue;
    }

    public static int getBitmapByteSize(int i, int i2, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65544, null, i, i2, config)) == null) {
            return i * i2 * getBytesPerPixel(config);
        }
        return invokeIIL.intValue;
    }

    public static int getBitmapByteSize(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bitmap)) == null) {
            if (!bitmap.isRecycled()) {
                if (Build.VERSION.SDK_INT >= 19) {
                    try {
                        return bitmap.getAllocationByteCount();
                    } catch (NullPointerException unused) {
                    }
                }
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + PreferencesUtil.LEFT_MOUNT + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
        return invokeL.intValue;
    }

    public static int getBytesPerPixel(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, config)) == null) {
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
            if (i != 1) {
                if (i != 2 && i != 3) {
                    if (i != 4) {
                        return 4;
                    }
                    return 8;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static List getSnapshot(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, collection)) == null) {
            ArrayList arrayList = new ArrayList(collection.size());
            for (Object obj : collection) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Handler getUiThreadHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (mainThreadHandler == null) {
                synchronized (Util.class) {
                    if (mainThreadHandler == null) {
                        mainThreadHandler = new Handler(Looper.getMainLooper());
                    }
                }
            }
            return mainThreadHandler;
        }
        return (Handler) invokeV.objValue;
    }

    public static int hashCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            return hashCode(i, 17);
        }
        return invokeI.intValue;
    }

    public static int hashCode(Object obj, int i) {
        InterceptResult invokeLI;
        int hashCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, obj, i)) == null) {
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return hashCode(hashCode, i);
        }
        return invokeLI.intValue;
    }

    public static int hashCode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65555, null, z)) == null) {
            return hashCode(z, 17);
        }
        return invokeZ.intValue;
    }

    public static int hashCode(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return hashCode(z ? 1 : 0, i);
        }
        return invokeCommon.intValue;
    }
}
