package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hvs = File.separator;
        public static final String cVw = Environment.getExternalStorageDirectory() + hvs + "tieba";
        public static final String hvz = cVw + hvs + ".tieba_post_monitor";
        public static final String hvA = hvz + hvs + "v1";
        public static final String hvB = hvA + hvs;
    }
}
