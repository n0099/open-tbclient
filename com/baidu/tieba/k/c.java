package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jRG = File.separator;
        public static final String jRH = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String jRI = jRH + jRG + ".tieba_video_monitor";
        public static final String jRJ = jRI + jRG + AbstractBceClient.URL_PREFIX;
        public static final String jRK = jRJ + jRG;
        public static final String jRL = jRH + jRG + ".tieba_video_monitor_log";
        public static final String jRM = jRL + jRG + AbstractBceClient.URL_PREFIX;
        public static final String jRN = jRM + jRG;
    }
}
