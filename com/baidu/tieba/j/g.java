package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fgV = File.separator;
        public static final String blH = Environment.getExternalStorageDirectory() + fgV + "tieba";
        public static final String fhc = blH + fgV + ".tieba_post_monitor";
        public static final String fhd = fhc + fgV + "v1";
        public static final String fhe = fhd + fgV;
    }
}
