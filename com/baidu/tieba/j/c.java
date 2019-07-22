package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hvs = File.separator;
        public static final String cVw = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String hvt = cVw + hvs + ".tieba_video_monitor";
        public static final String hvu = hvt + hvs + "v1";
        public static final String hvv = hvu + hvs;
        public static final String hvw = cVw + hvs + ".tieba_video_monitor_log";
        public static final String hvx = hvw + hvs + "v1";
        public static final String hvy = hvx + hvs;
    }
}
