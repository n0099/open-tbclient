package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eQw = File.separator;
        public static final String bbq = Environment.getExternalStorageDirectory() + eQw + "tieba";
        public static final String eQD = bbq + eQw + ".tieba_post_monitor";
        public static final String eQE = eQD + eQw + "v1";
        public static final String eQF = eQE + eQw;
    }
}
