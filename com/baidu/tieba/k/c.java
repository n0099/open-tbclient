package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String ipW = File.separator;
        public static final String dXo = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String ipX = dXo + ipW + ".tieba_video_monitor";
        public static final String ipY = ipX + ipW + AbstractBceClient.URL_PREFIX;
        public static final String ipZ = ipY + ipW;
        public static final String iqa = dXo + ipW + ".tieba_video_monitor_log";
        public static final String iqb = iqa + ipW + AbstractBceClient.URL_PREFIX;
        public static final String iqc = iqb + ipW;
    }
}
