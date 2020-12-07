package com.baidu.tieba.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String llb = File.separator;
        public static final String llc = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String lld = llc + llb + ".tieba_video_monitor";
        public static final String lle = lld + llb + AbstractBceClient.URL_PREFIX;
        public static final String llf = lle + llb;
        public static final String llg = llc + llb + ".tieba_video_monitor_log";
        public static final String llh = llg + llb + AbstractBceClient.URL_PREFIX;
        public static final String lli = llh + llb;
    }
}
