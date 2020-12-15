package com.baidu.tieba.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String lld = File.separator;
        public static final String lle = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String llf = lle + lld + ".tieba_video_monitor";
        public static final String llg = llf + lld + AbstractBceClient.URL_PREFIX;
        public static final String llh = llg + lld;
        public static final String lli = lle + lld + ".tieba_video_monitor_log";
        public static final String llj = lli + lld + AbstractBceClient.URL_PREFIX;
        public static final String llk = llj + lld;
    }
}
