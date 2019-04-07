package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String gXK = File.separator;
        public static final String cLM = Environment.getExternalStorageDirectory() + gXK + "tieba";
        public static final String gXR = cLM + gXK + ".tieba_post_monitor";
        public static final String gXS = gXR + gXK + "v1";
        public static final String gXT = gXS + gXK;
    }
}
