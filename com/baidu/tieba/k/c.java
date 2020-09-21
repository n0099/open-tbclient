package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kpL = File.separator;
        public static final String kpM = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String kpN = kpM + kpL + ".tieba_video_monitor";
        public static final String kpO = kpN + kpL + AbstractBceClient.URL_PREFIX;
        public static final String kpP = kpO + kpL;
        public static final String kpQ = kpM + kpL + ".tieba_video_monitor_log";
        public static final String kpR = kpQ + kpL + AbstractBceClient.URL_PREFIX;
        public static final String kpS = kpR + kpL;
    }
}
