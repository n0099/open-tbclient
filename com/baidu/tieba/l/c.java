package com.baidu.tieba.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String lmd = File.separator;
        public static final String lme = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String lmf = lme + lmd + ".tieba_video_monitor";
        public static final String lmg = lmf + lmd + AbstractBceClient.URL_PREFIX;
        public static final String lmh = lmg + lmd;
        public static final String lmi = lme + lmd + ".tieba_video_monitor_log";
        public static final String lmj = lmi + lmd + AbstractBceClient.URL_PREFIX;
        public static final String lmk = lmj + lmd;
    }
}
