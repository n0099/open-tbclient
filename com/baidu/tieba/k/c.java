package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes2.dex */
public interface c {

    /* loaded from: classes2.dex */
    public interface a {
        public static final String khe = File.separator;
        public static final String khf = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String khg = khf + khe + ".tieba_video_monitor";
        public static final String khh = khg + khe + AbstractBceClient.URL_PREFIX;
        public static final String khi = khh + khe;
        public static final String khj = khf + khe + ".tieba_video_monitor_log";
        public static final String khk = khj + khe + AbstractBceClient.URL_PREFIX;
        public static final String khl = khk + khe;
    }
}
