package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fDY = File.separator;
        public static final String bzQ = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fDZ = bzQ + fDY + ".tieba_video_monitor";
        public static final String fEa = fDZ + fDY + "v1";
        public static final String fEb = fEa + fDY;
        public static final String fEc = bzQ + fDY + ".tieba_video_monitor_log";
        public static final String fEd = fEc + fDY + "v1";
        public static final String fEe = fEd + fDY;
    }
}
