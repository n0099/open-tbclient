package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fom = File.separator;
        public static final String brA = Environment.getExternalStorageDirectory() + fom + "tieba";
        public static final String fot = brA + fom + ".tieba_post_monitor";
        public static final String fou = fot + fom + "v1";
        public static final String fov = fou + fom;
    }
}
