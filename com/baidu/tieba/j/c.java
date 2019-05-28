package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hpf = File.separator;
        public static final String cTZ = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String hpg = cTZ + hpf + ".tieba_video_monitor";
        public static final String hph = hpg + hpf + "v1";
        public static final String hpi = hph + hpf;
        public static final String hpj = cTZ + hpf + ".tieba_video_monitor_log";
        public static final String hpk = hpj + hpf + "v1";
        public static final String hpl = hpk + hpf;
    }
}
