package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fcV = File.separator;
        public static final String bjC = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fcW = bjC + fcV + ".tieba_video_monitor";
        public static final String fcX = fcW + fcV + "v1";
        public static final String fcY = fcX + fcV;
        public static final String fcZ = bjC + fcV + ".tieba_video_monitor_log";
        public static final String fda = fcZ + fcV + "v1";
        public static final String fdb = fda + fcV;
    }
}
