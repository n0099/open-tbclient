package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jJc = File.separator;
        public static final String eWD = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String jJd = eWD + jJc + ".tieba_video_monitor";
        public static final String jJe = jJd + jJc + AbstractBceClient.URL_PREFIX;
        public static final String jJf = jJe + jJc;
        public static final String jJg = eWD + jJc + ".tieba_video_monitor_log";
        public static final String jJh = jJg + jJc + AbstractBceClient.URL_PREFIX;
        public static final String jJi = jJh + jJc;
    }
}
