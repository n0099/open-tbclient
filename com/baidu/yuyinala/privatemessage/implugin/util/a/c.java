package com.baidu.yuyinala.privatemessage.implugin.util.a;

import android.os.Environment;
import android.util.Log;
import com.baidu.yuyinala.privatemessage.implugin.util.d;
import java.io.File;
/* loaded from: classes4.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();

    public static File getCacheDir() {
        if (enV()) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + d.oVl);
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            Log.d(TAG, "fail to create directory !");
            return null;
        }
        return null;
    }

    public static boolean enV() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
