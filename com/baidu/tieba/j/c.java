package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fxi = File.separator;
        public static final String bwt = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fxj = bwt + fxi + ".tieba_video_monitor";
        public static final String fxk = fxj + fxi + "v1";
        public static final String fxl = fxk + fxi;
        public static final String fxm = bwt + fxi + ".tieba_video_monitor_log";
        public static final String fxn = fxm + fxi + "v1";
        public static final String fxo = fxn + fxi;
    }
}
