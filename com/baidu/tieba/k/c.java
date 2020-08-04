package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jRI = File.separator;
        public static final String jRJ = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String jRK = jRJ + jRI + ".tieba_video_monitor";
        public static final String jRL = jRK + jRI + AbstractBceClient.URL_PREFIX;
        public static final String jRM = jRL + jRI;
        public static final String jRN = jRJ + jRI + ".tieba_video_monitor_log";
        public static final String jRO = jRN + jRI + AbstractBceClient.URL_PREFIX;
        public static final String jRP = jRO + jRI;
    }
}
