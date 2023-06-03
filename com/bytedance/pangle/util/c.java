package com.bytedance.pangle.util;

import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public final class c {
    public static <T> boolean a(@Nullable T[] tArr) {
        if (tArr != null && tArr.length != 0) {
            return false;
        }
        return true;
    }

    public static <T> boolean a(@Nullable T[] tArr, T t) {
        int i;
        if (tArr != null) {
            i = 0;
            while (i < tArr.length) {
                if (tArr[i] == t || (tArr[i] != null && tArr[i].equals(t))) {
                    break;
                }
                i++;
            }
        }
        i = -1;
        if (i == -1) {
            return false;
        }
        return true;
    }

    public static <T> boolean a(@Nullable T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!a(tArr, t)) {
                return false;
            }
        }
        return true;
    }
}
