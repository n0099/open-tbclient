package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hpg = File.separator;
        public static final String cUa = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String hph = cUa + hpg + ".tieba_video_monitor";
        public static final String hpi = hph + hpg + "v1";
        public static final String hpj = hpi + hpg;
        public static final String hpk = cUa + hpg + ".tieba_video_monitor_log";
        public static final String hpl = hpk + hpg + "v1";
        public static final String hpm = hpl + hpg;
    }
}
