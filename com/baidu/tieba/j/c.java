package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String gXK = File.separator;
        public static final String cLM = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String gXL = cLM + gXK + ".tieba_video_monitor";
        public static final String gXM = gXL + gXK + "v1";
        public static final String gXN = gXM + gXK;
        public static final String gXO = cLM + gXK + ".tieba_video_monitor_log";
        public static final String gXP = gXO + gXK + "v1";
        public static final String gXQ = gXP + gXK;
    }
}
