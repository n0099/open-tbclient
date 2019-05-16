package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hpc = File.separator;
        public static final String cTY = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String hpd = cTY + hpc + ".tieba_video_monitor";
        public static final String hpe = hpd + hpc + "v1";
        public static final String hpf = hpe + hpc;
        public static final String hpg = cTY + hpc + ".tieba_video_monitor_log";
        public static final String hph = hpg + hpc + "v1";
        public static final String hpi = hph + hpc;
    }
}
