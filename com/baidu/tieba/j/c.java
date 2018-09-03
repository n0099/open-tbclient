package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fgP = File.separator;
        public static final String blM = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fgQ = blM + fgP + ".tieba_video_monitor";
        public static final String fgR = fgQ + fgP + "v1";
        public static final String fgS = fgR + fgP;
        public static final String fgT = blM + fgP + ".tieba_video_monitor_log";
        public static final String fgU = fgT + fgP + "v1";
        public static final String fgV = fgU + fgP;
    }
}
