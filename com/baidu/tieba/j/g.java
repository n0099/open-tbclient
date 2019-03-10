package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String gXY = File.separator;
        public static final String cLN = Environment.getExternalStorageDirectory() + gXY + "tieba";
        public static final String gYf = cLN + gXY + ".tieba_post_monitor";
        public static final String gYg = gYf + gXY + "v1";
        public static final String gYh = gYg + gXY;
    }
}
