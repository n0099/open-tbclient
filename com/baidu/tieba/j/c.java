package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fgV = File.separator;
        public static final String blH = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fgW = blH + fgV + ".tieba_video_monitor";
        public static final String fgX = fgW + fgV + "v1";
        public static final String fgY = fgX + fgV;
        public static final String fgZ = blH + fgV + ".tieba_video_monitor_log";
        public static final String fha = fgZ + fgV + "v1";
        public static final String fhb = fha + fgV;
    }
}
