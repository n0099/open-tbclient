package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String gXL = File.separator;
        public static final String cLN = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String gXM = cLN + gXL + ".tieba_video_monitor";
        public static final String gXN = gXM + gXL + "v1";
        public static final String gXO = gXN + gXL;
        public static final String gXP = cLN + gXL + ".tieba_video_monitor_log";
        public static final String gXQ = gXP + gXL + "v1";
        public static final String gXR = gXQ + gXL;
    }
}
