package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eQw = File.separator;
        public static final String bbq = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String eQx = bbq + eQw + ".tieba_video_monitor";
        public static final String eQy = eQx + eQw + "v1";
        public static final String eQz = eQy + eQw;
        public static final String eQA = bbq + eQw + ".tieba_video_monitor_log";
        public static final String eQB = eQA + eQw + "v1";
        public static final String eQC = eQB + eQw;
    }
}
