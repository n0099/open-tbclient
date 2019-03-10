package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String gXY = File.separator;
        public static final String cLN = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String gXZ = cLN + gXY + ".tieba_video_monitor";
        public static final String gYa = gXZ + gXY + "v1";
        public static final String gYb = gYa + gXY;
        public static final String gYc = cLN + gXY + ".tieba_video_monitor_log";
        public static final String gYd = gYc + gXY + "v1";
        public static final String gYe = gYd + gXY;
    }
}
