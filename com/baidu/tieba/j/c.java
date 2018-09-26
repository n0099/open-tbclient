package com.baidu.tieba.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fom = File.separator;
        public static final String brA = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fon = brA + fom + ".tieba_video_monitor";
        public static final String foo = fon + fom + "v1";
        public static final String fop = foo + fom;
        public static final String foq = brA + fom + ".tieba_video_monitor_log";

        /* renamed from: for  reason: not valid java name */
        public static final String f0for = foq + fom + "v1";
        public static final String fos = f0for + fom;
    }
}
