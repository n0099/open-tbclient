package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fHK = File.separator;
        public static final String bAG = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fHL = bAG + fHK + ".tieba_video_monitor";
        public static final String fHM = fHL + fHK + "v1";
        public static final String fHN = fHM + fHK;
        public static final String fHO = bAG + fHK + ".tieba_video_monitor_log";
        public static final String fHP = fHO + fHK + "v1";
        public static final String fHQ = fHP + fHK;
    }
}
