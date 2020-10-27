package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kRu = File.separator;
        public static final String kRv = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String kRw = kRv + kRu + ".tieba_video_monitor";
        public static final String kRx = kRw + kRu + AbstractBceClient.URL_PREFIX;
        public static final String kRy = kRx + kRu;
        public static final String kRz = kRv + kRu + ".tieba_video_monitor_log";
        public static final String kRA = kRz + kRu + AbstractBceClient.URL_PREFIX;
        public static final String kRB = kRA + kRu;
    }
}
