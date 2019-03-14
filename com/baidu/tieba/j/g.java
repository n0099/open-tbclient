package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String gXX = File.separator;
        public static final String cLK = Environment.getExternalStorageDirectory() + gXX + "tieba";
        public static final String gYe = cLK + gXX + ".tieba_post_monitor";
        public static final String gYf = gYe + gXX + "v1";
        public static final String gYg = gYf + gXX;
    }
}
