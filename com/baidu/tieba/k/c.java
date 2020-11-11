package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kXq = File.separator;
        public static final String kXr = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String kXs = kXr + kXq + ".tieba_video_monitor";
        public static final String kXt = kXs + kXq + AbstractBceClient.URL_PREFIX;
        public static final String kXu = kXt + kXq;
        public static final String kXv = kXr + kXq + ".tieba_video_monitor_log";
        public static final String kXw = kXv + kXq + AbstractBceClient.URL_PREFIX;
        public static final String kXx = kXw + kXq;
    }
}
