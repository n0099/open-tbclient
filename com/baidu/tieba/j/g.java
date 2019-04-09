package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String gXL = File.separator;
        public static final String cLN = Environment.getExternalStorageDirectory() + gXL + "tieba";
        public static final String gXS = cLN + gXL + ".tieba_post_monitor";
        public static final String gXT = gXS + gXL + "v1";
        public static final String gXU = gXT + gXL;
    }
}
