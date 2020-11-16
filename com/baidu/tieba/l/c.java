package com.baidu.tieba.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kXI = File.separator;
        public static final String kXJ = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String kXK = kXJ + kXI + ".tieba_video_monitor";
        public static final String kXL = kXK + kXI + AbstractBceClient.URL_PREFIX;
        public static final String kXM = kXL + kXI;
        public static final String kXN = kXJ + kXI + ".tieba_video_monitor_log";
        public static final String kXO = kXN + kXI + AbstractBceClient.URL_PREFIX;
        public static final String kXP = kXO + kXI;
    }
}
