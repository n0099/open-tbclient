package com.baidu.tieba.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String luy = File.separator;
        public static final String luz = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String luA = luz + luy + ".tieba_video_monitor";
        public static final String luB = luA + luy + AbstractBceClient.URL_PREFIX;
        public static final String luC = luB + luy;
        public static final String luD = luz + luy + ".tieba_video_monitor_log";
        public static final String luE = luD + luy + AbstractBceClient.URL_PREFIX;
        public static final String luF = luE + luy;
    }
}
