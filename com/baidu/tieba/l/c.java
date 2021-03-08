package com.baidu.tieba.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String lwA = File.separator;
        public static final String lwB = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String lwC = lwB + lwA + ".tieba_video_monitor";
        public static final String lwD = lwC + lwA + AbstractBceClient.URL_PREFIX;
        public static final String lwE = lwD + lwA;
        public static final String lwF = lwB + lwA + ".tieba_video_monitor_log";
        public static final String lwG = lwF + lwA + AbstractBceClient.URL_PREFIX;
        public static final String lwH = lwG + lwA;
    }
}
