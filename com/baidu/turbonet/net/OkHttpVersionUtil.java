package com.baidu.turbonet.net;

import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
public class OkHttpVersionUtil {
    public static String a() {
        if (b()) {
            try {
                return (String) Class.forName("okhttp3.internal.Version").getMethod("userAgent", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return "";
    }

    public static boolean b() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c() throws RuntimeException {
        String a2 = a();
        if (!a2.isEmpty()) {
            String[] split = a2.split("/");
            if (split.length == 2) {
                String[] split2 = split[1].split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                if (split2.length == 3) {
                    try {
                        if (Integer.parseInt(split2[0]) == 3) {
                            if (Integer.parseInt(split2[1]) >= 9) {
                                return true;
                            }
                        }
                        return false;
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", a2));
                    }
                }
                throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", a2));
            }
            throw new IllegalArgumentException(String.format("okhttp version format(%s) is not valid", a2));
        }
        throw new NoSuchElementException();
    }
}
