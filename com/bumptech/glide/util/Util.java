package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
/* loaded from: classes6.dex */
public final class Util {
    public static final int HASH_ACCUMULATOR = 17;
    public static final int HASH_MULTIPLIER = 31;
    public static final char[] HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
    public static final char[] SHA_256_CHARS = new char[64];

    /* renamed from: com.bumptech.glide.util.Util$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
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

    public static void assertBackgroundThread() {
        if (!isOnBackgroundThread()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void assertMainThread() {
        if (!isOnMainThread()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean bothModelsNullEquivalentOrEquals(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof Model) {
            return ((Model) obj).isEquivalentTo(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    public static boolean bothNullOrEqual(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @NonNull
    public static String bytesToHex(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = HEX_CHAR_ARRAY;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static <T> Queue<T> createQueue(int i2) {
        return new ArrayDeque(i2);
    }

    @TargetApi(19)
    public static int getBitmapByteSize(@NonNull Bitmap bitmap) {
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

    public static int getBytesPerPixel(@Nullable Bitmap.Config config) {
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

    @Deprecated
    public static int getSize(@NonNull Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }

    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static int hashCode(int i2) {
        return hashCode(i2, 17);
    }

    public static int hashCode(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isValidDimension(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean isValidDimensions(int i2, int i3) {
        return isValidDimension(i2) && isValidDimension(i3);
    }

    @NonNull
    public static String sha256BytesToHex(@NonNull byte[] bArr) {
        String bytesToHex;
        synchronized (SHA_256_CHARS) {
            bytesToHex = bytesToHex(bArr, SHA_256_CHARS);
        }
        return bytesToHex;
    }

    public static int hashCode(float f2) {
        return hashCode(f2, 17);
    }

    public static int hashCode(float f2, int i2) {
        return hashCode(Float.floatToIntBits(f2), i2);
    }

    public static int hashCode(@Nullable Object obj, int i2) {
        return hashCode(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static int hashCode(boolean z, int i2) {
        return hashCode(z ? 1 : 0, i2);
    }

    public static int hashCode(boolean z) {
        return hashCode(z, 17);
    }

    public static int getBitmapByteSize(int i2, int i3, @Nullable Bitmap.Config config) {
        return i2 * i3 * getBytesPerPixel(config);
    }
}
