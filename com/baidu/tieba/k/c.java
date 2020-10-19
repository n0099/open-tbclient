package com.baidu.tieba.k;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kEX = File.separator;
        public static final String kEY = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String kEZ = kEY + kEX + ".tieba_video_monitor";
        public static final String kFa = kEZ + kEX + AbstractBceClient.URL_PREFIX;
        public static final String kFb = kFa + kEX;
        public static final String kFc = kEY + kEX + ".tieba_video_monitor_log";
        public static final String kFd = kFc + kEX + AbstractBceClient.URL_PREFIX;
        public static final String kFe = kFd + kEX;
    }
}
