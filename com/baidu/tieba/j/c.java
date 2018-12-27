package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fGQ = File.separator;
        public static final String bzT = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fGR = bzT + fGQ + ".tieba_video_monitor";
        public static final String fGS = fGR + fGQ + "v1";
        public static final String fGT = fGS + fGQ;
        public static final String fGU = bzT + fGQ + ".tieba_video_monitor_log";
        public static final String fGV = fGU + fGQ + "v1";
        public static final String fGW = fGV + fGQ;
    }
}
