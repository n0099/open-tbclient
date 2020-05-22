package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jqF = File.separator;
        public static final String eMg = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String jqG = eMg + jqF + ".tieba_video_monitor";
        public static final String jqH = jqG + jqF + AbstractBceClient.URL_PREFIX;
        public static final String jqI = jqH + jqF;
        public static final String jqJ = eMg + jqF + ".tieba_video_monitor_log";
        public static final String jqK = jqJ + jqF + AbstractBceClient.URL_PREFIX;
        public static final String jqL = jqK + jqF;
    }
}
