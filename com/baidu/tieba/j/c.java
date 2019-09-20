package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hye = File.separator;
        public static final String cWw = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String hyf = cWw + hye + ".tieba_video_monitor";
        public static final String hyg = hyf + hye + "v1";
        public static final String hyh = hyg + hye;
        public static final String hyi = cWw + hye + ".tieba_video_monitor_log";
        public static final String hyj = hyi + hye + "v1";
        public static final String hyk = hyj + hye;
    }
}
