package com.baidu.zeus;

import android.content.Context;
import android.util.Log;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class L10nUtils {
    private static Context mApplicationContext;
    private static int[] mIdsArray = new int[0];
    private static Map<Integer, SoftReference<String>> mStrings;

    public static void setApplicationContext(Context context) {
        mApplicationContext = context.getApplicationContext();
    }

    private static String loadString(int i) {
        if (mStrings == null) {
            mStrings = new HashMap(mIdsArray.length);
        }
        String string = mApplicationContext.getResources().getString(mIdsArray[i]);
        mStrings.put(Integer.valueOf(i), new SoftReference<>(string));
        return string;
    }

    public static String getLocalisedString(int i) {
        Log.e("L10nUtils", "getLocalisedString call error");
        return null;
    }
}
