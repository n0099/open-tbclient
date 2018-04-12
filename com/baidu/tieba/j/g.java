package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eQz = File.separator;
        public static final String bbq = Environment.getExternalStorageDirectory() + eQz + "tieba";
        public static final String eQG = bbq + eQz + ".tieba_post_monitor";
        public static final String eQH = eQG + eQz + "v1";
        public static final String eQI = eQH + eQz;
    }
}
