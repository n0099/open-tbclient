package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String ikd = File.separator;
        public static final String dSM = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String ike = dSM + ikd + ".tieba_video_monitor";
        public static final String ikf = ike + ikd + AbstractBceClient.URL_PREFIX;
        public static final String ikg = ikf + ikd;
        public static final String ikh = dSM + ikd + ".tieba_video_monitor_log";
        public static final String iki = ikh + ikd + AbstractBceClient.URL_PREFIX;
        public static final String ikj = iki + ikd;
    }
}
