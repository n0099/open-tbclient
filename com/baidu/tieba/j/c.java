package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hwS = File.separator;
        public static final String dfR = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String hwT = dfR + hwS + ".tieba_video_monitor";
        public static final String hwU = hwT + hwS + "v1";
        public static final String hwV = hwU + hwS;
        public static final String hwW = dfR + hwS + ".tieba_video_monitor_log";
        public static final String hwX = hwW + hwS + "v1";
        public static final String hwY = hwX + hwS;
    }
}
