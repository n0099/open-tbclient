package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String khl = File.separator;
        public static final String khm = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String khn = khm + khl + ".tieba_video_monitor";
        public static final String kho = khn + khl + AbstractBceClient.URL_PREFIX;
        public static final String khp = kho + khl;
        public static final String khq = khm + khl + ".tieba_video_monitor_log";
        public static final String khr = khq + khl + AbstractBceClient.URL_PREFIX;
        public static final String khs = khr + khl;
    }
}
