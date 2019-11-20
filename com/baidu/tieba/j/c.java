package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hwb = File.separator;
        public static final String dfa = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String hwc = dfa + hwb + ".tieba_video_monitor";
        public static final String hwd = hwc + hwb + "v1";
        public static final String hwe = hwd + hwb;
        public static final String hwf = dfa + hwb + ".tieba_video_monitor_log";
        public static final String hwg = hwf + hwb + "v1";
        public static final String hwh = hwg + hwb;
    }
}
