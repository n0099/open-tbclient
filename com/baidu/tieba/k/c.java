package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String irw = File.separator;
        public static final String dXE = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String irx = dXE + irw + ".tieba_video_monitor";
        public static final String iry = irx + irw + AbstractBceClient.URL_PREFIX;
        public static final String irz = iry + irw;
        public static final String irA = dXE + irw + ".tieba_video_monitor_log";
        public static final String irB = irA + irw + AbstractBceClient.URL_PREFIX;
        public static final String irC = irB + irw;
    }
}
