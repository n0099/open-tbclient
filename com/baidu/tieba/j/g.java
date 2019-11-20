package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hwb = File.separator;
        public static final String dfa = Environment.getExternalStorageDirectory() + hwb + "tieba";
        public static final String hwi = dfa + hwb + ".tieba_post_monitor";
        public static final String hwj = hwi + hwb + "v1";
        public static final String hwk = hwj + hwb;
    }
}
