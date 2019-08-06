package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hwk = File.separator;
        public static final String cVD = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String hwl = cVD + hwk + ".tieba_video_monitor";
        public static final String hwm = hwl + hwk + "v1";
        public static final String hwn = hwm + hwk;
        public static final String hwo = cVD + hwk + ".tieba_video_monitor_log";
        public static final String hwp = hwo + hwk + "v1";
        public static final String hwq = hwp + hwk;
    }
}
