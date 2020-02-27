package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String ipI = File.separator;
        public static final String dXa = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String ipJ = dXa + ipI + ".tieba_video_monitor";
        public static final String ipK = ipJ + ipI + AbstractBceClient.URL_PREFIX;
        public static final String ipL = ipK + ipI;
        public static final String ipM = dXa + ipI + ".tieba_video_monitor_log";
        public static final String ipN = ipM + ipI + AbstractBceClient.URL_PREFIX;
        public static final String ipO = ipN + ipI;
    }
}
