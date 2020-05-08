package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jbC = File.separator;
        public static final String exE = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String jbD = exE + jbC + ".tieba_video_monitor";
        public static final String jbE = jbD + jbC + AbstractBceClient.URL_PREFIX;
        public static final String jbF = jbE + jbC;
        public static final String jbG = exE + jbC + ".tieba_video_monitor_log";
        public static final String jbH = jbG + jbC + AbstractBceClient.URL_PREFIX;
        public static final String jbI = jbH + jbC;
    }
}
