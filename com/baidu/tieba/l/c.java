package com.baidu.tieba.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String luk = File.separator;
        public static final String lul = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String lum = lul + luk + ".tieba_video_monitor";
        public static final String lun = lum + luk + AbstractBceClient.URL_PREFIX;
        public static final String luo = lun + luk;
        public static final String lup = lul + luk + ".tieba_video_monitor_log";
        public static final String luq = lup + luk + AbstractBceClient.URL_PREFIX;
        public static final String lur = luq + luk;
    }
}
