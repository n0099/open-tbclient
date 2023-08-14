package com.baidu.tieba;

import android.os.Environment;
import java.io.File;
/* loaded from: classes8.dex */
public interface z69 {
    public static final String a = File.separator;
    public static final String b = Environment.getExternalStorageDirectory() + a + "tieba";
    public static final String c = b + a + ".tieba_post_monitor";
    public static final String d = c + a + "v1";
    public static final String e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(d);
        sb.append(a);
        e = sb.toString();
    }
}
