package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String inJ = File.separator;
        public static final String dSV = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String inK = dSV + inJ + ".tieba_video_monitor";
        public static final String inL = inK + inJ + AbstractBceClient.URL_PREFIX;
        public static final String inM = inL + inJ;
        public static final String inN = dSV + inJ + ".tieba_video_monitor_log";
        public static final String inO = inN + inJ + AbstractBceClient.URL_PREFIX;
        public static final String inP = inO + inJ;
    }
}
