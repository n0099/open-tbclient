package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fgM = File.separator;
        public static final String blb = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fgN = blb + fgM + ".tieba_video_monitor";
        public static final String fgO = fgN + fgM + "v1";
        public static final String fgP = fgO + fgM;
        public static final String fgQ = blb + fgM + ".tieba_video_monitor_log";
        public static final String fgR = fgQ + fgM + "v1";
        public static final String fgS = fgR + fgM;
    }
}
