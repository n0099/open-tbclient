package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fvS = File.separator;
        public static final String bvI = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fvT = bvI + fvS + ".tieba_video_monitor";
        public static final String fvU = fvT + fvS + "v1";
        public static final String fvV = fvU + fvS;
        public static final String fvW = bvI + fvS + ".tieba_video_monitor_log";
        public static final String fvX = fvW + fvS + "v1";
        public static final String fvY = fvX + fvS;
    }
}
