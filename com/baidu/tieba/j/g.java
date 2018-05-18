package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eRD = File.separator;
        public static final String bbr = Environment.getExternalStorageDirectory() + eRD + "tieba";
        public static final String eRK = bbr + eRD + ".tieba_post_monitor";
        public static final String eRL = eRK + eRD + "v1";
        public static final String eRM = eRL + eRD;
    }
}
