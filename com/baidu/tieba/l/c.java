package com.baidu.tieba.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String lqN = File.separator;
        public static final String lqO = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String lqP = lqO + lqN + ".tieba_video_monitor";
        public static final String lqQ = lqP + lqN + AbstractBceClient.URL_PREFIX;
        public static final String lqR = lqQ + lqN;
        public static final String lqS = lqO + lqN + ".tieba_video_monitor_log";
        public static final String lqT = lqS + lqN + AbstractBceClient.URL_PREFIX;
        public static final String lqU = lqT + lqN;
    }
}
