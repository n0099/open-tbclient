package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fgM = File.separator;
        public static final String blb = Environment.getExternalStorageDirectory() + fgM + "tieba";
        public static final String fgT = blb + fgM + ".tieba_post_monitor";
        public static final String fgU = fgT + fgM + "v1";
        public static final String fgV = fgU + fgM;
    }
}
