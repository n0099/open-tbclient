package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eQz = File.separator;
        public static final String bbq = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String eQA = bbq + eQz + ".tieba_video_monitor";
        public static final String eQB = eQA + eQz + "v1";
        public static final String eQC = eQB + eQz;
        public static final String eQD = bbq + eQz + ".tieba_video_monitor_log";
        public static final String eQE = eQD + eQz + "v1";
        public static final String eQF = eQE + eQz;
    }
}
