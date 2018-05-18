package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eRD = File.separator;
        public static final String bbr = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String eRE = bbr + eRD + ".tieba_video_monitor";
        public static final String eRF = eRE + eRD + "v1";
        public static final String eRG = eRF + eRD;
        public static final String eRH = bbr + eRD + ".tieba_video_monitor_log";
        public static final String eRI = eRH + eRD + "v1";
        public static final String eRJ = eRI + eRD;
    }
}
