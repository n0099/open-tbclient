package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fHL = File.separator;
        public static final String bAH = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fHM = bAH + fHL + ".tieba_video_monitor";
        public static final String fHN = fHM + fHL + "v1";
        public static final String fHO = fHN + fHL;
        public static final String fHP = bAH + fHL + ".tieba_video_monitor_log";
        public static final String fHQ = fHP + fHL + "v1";
        public static final String fHR = fHQ + fHL;
    }
}
