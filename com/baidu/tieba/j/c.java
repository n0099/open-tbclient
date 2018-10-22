package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fvT = File.separator;
        public static final String bvI = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fvU = bvI + fvT + ".tieba_video_monitor";
        public static final String fvV = fvU + fvT + "v1";
        public static final String fvW = fvV + fvT;
        public static final String fvX = bvI + fvT + ".tieba_video_monitor_log";
        public static final String fvY = fvX + fvT + "v1";
        public static final String fvZ = fvY + fvT;
    }
}
