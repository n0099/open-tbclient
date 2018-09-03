package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fgP = File.separator;
        public static final String blM = Environment.getExternalStorageDirectory() + fgP + "tieba";
        public static final String fgW = blM + fgP + ".tieba_post_monitor";
        public static final String fgX = fgW + fgP + "v1";
        public static final String fgY = fgX + fgP;
    }
}
