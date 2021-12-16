package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes2.dex */
public final class Util {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HASH_ACCUMULATOR = 17;
    public static final int HASH_MULTIPLIER = 31;
    public static final char[] HEX_CHAR_ARRAY;
    public static final char[] SHA_256_CHARS;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bumptech.glide.util.Util$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void assertBackgroundThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !isOnBackgroundThread()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void assertMainThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && !isOnMainThread()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean bothModelsNullEquivalentOrEquals(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2)) == null) {
            if (obj == null) {
                return obj2 == null;
            } else if (obj instanceof Model) {
                return ((Model) obj).isEquivalentTo(obj2);
            } else {
                return obj.equals(obj2);
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean bothNullOrEqual(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, obj, obj2)) == null) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static String bytesToHex(@NonNull byte[] bArr, @NonNull char[] cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bArr, cArr)) == null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = bArr[i2] & 255;
                int i4 = i2 * 2;
                char[] cArr2 = HEX_CHAR_ARRAY;
                cArr[i4] = cArr2[i3 >>> 4];
                cArr[i4 + 1] = cArr2[i3 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public static <T> Queue<T> createQueue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? new ArrayDeque(i2) : (Queue) invokeI.objValue;
    }

    @TargetApi(19)
    public static int getBitmapByteSize(@NonNull Bitmap bitmap) {
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

    public static int getBytesPerPixel(@Nullable Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, config)) == null) {
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            int i2 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    return 2;
                }
                return i2 != 4 ? 4 : 8;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getSize(@NonNull Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bitmap)) == null) ? getBitmapByteSize(bitmap) : invokeL.intValue;
    }

    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, collection)) == null) {
            ArrayList arrayList = new ArrayList(collection.size());
            for (T t : collection) {
                if (t != null) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static int hashCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) ? hashCode(i2, 17) : invokeI.intValue;
    }

    public static int hashCode(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65552, null, i2, i3)) == null) ? (i3 * 31) + i2 : invokeII.intValue;
    }

    public static boolean isOnBackgroundThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? !isOnMainThread() : invokeV.booleanValue;
    }

    public static boolean isOnMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? Looper.myLooper() == Looper.getMainLooper() : invokeV.booleanValue;
    }

    public static boolean isValidDimension(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i2)) == null) ? i2 > 0 || i2 == Integer.MIN_VALUE : invokeI.booleanValue;
    }

    public static boolean isValidDimensions(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65559, null, i2, i3)) == null) ? isValidDimension(i2) && isValidDimension(i3) : invokeII.booleanValue;
    }

    @NonNull
    public static String sha256BytesToHex(@NonNull byte[] bArr) {
        InterceptResult invokeL;
        String bytesToHex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, bArr)) == null) {
            synchronized (SHA_256_CHARS) {
                bytesToHex = bytesToHex(bArr, SHA_256_CHARS);
            }
            return bytesToHex;
        }
        return (String) invokeL.objValue;
    }

    public static int hashCode(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65549, null, f2)) == null) ? hashCode(f2, 17) : invokeF.intValue;
    }

    public static int hashCode(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) ? hashCode(Float.floatToIntBits(f2), i2) : invokeCommon.intValue;
    }

    public static int hashCode(@Nullable Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, obj, i2)) == null) {
            return hashCode(obj == null ? 0 : obj.hashCode(), i2);
        }
        return invokeLI.intValue;
    }

    public static int hashCode(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return hashCode(z ? 1 : 0, i2);
        }
        return invokeCommon.intValue;
    }

    public static int hashCode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65554, null, z)) == null) ? hashCode(z, 17) : invokeZ.intValue;
    }

    public static int getBitmapByteSize(int i2, int i3, @Nullable Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65544, null, i2, i3, config)) == null) ? i2 * i3 * getBytesPerPixel(config) : invokeIIL.intValue;
    }
}
