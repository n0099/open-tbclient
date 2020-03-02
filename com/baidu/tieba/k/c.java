package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String ipK = File.separator;
        public static final String dXb = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String ipL = dXb + ipK + ".tieba_video_monitor";
        public static final String ipM = ipL + ipK + AbstractBceClient.URL_PREFIX;
        public static final String ipN = ipM + ipK;
        public static final String ipO = dXb + ipK + ".tieba_video_monitor_log";
        public static final String ipP = ipO + ipK + AbstractBceClient.URL_PREFIX;
        public static final String ipQ = ipP + ipK;
    }
}
