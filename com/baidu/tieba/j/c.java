package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String gXX = File.separator;
        public static final String cLN = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String gXY = cLN + gXX + ".tieba_video_monitor";
        public static final String gXZ = gXY + gXX + "v1";
        public static final String gYa = gXZ + gXX;
        public static final String gYb = cLN + gXX + ".tieba_video_monitor_log";
        public static final String gYc = gYb + gXX + "v1";
        public static final String gYd = gYc + gXX;
    }
}
