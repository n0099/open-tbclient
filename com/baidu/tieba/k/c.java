package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jby = File.separator;
        public static final String exz = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String jbz = exz + jby + ".tieba_video_monitor";
        public static final String jbA = jbz + jby + AbstractBceClient.URL_PREFIX;
        public static final String jbB = jbA + jby;
        public static final String jbC = exz + jby + ".tieba_video_monitor_log";
        public static final String jbD = jbC + jby + AbstractBceClient.URL_PREFIX;
        public static final String jbE = jbD + jby;
    }
}
