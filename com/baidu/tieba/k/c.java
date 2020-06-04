package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jrL = File.separator;
        public static final String eMr = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String jrM = eMr + jrL + ".tieba_video_monitor";
        public static final String jrN = jrM + jrL + AbstractBceClient.URL_PREFIX;
        public static final String jrO = jrN + jrL;
        public static final String jrP = eMr + jrL + ".tieba_video_monitor_log";
        public static final String jrQ = jrP + jrL + AbstractBceClient.URL_PREFIX;
        public static final String jrR = jrQ + jrL;
    }
}
