package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fcV = File.separator;
        public static final String bjC = Environment.getExternalStorageDirectory() + fcV + "tieba";
        public static final String fdc = bjC + fcV + ".tieba_post_monitor";
        public static final String fdd = fdc + fcV + "v1";
        public static final String fde = fdd + fcV;
    }
}
