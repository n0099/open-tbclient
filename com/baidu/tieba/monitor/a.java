package com.baidu.tieba.monitor;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: com.baidu.tieba.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0105a {
        public static final String exm = File.separator;
        public static final String aYf = Environment.getExternalStorageDirectory() + exm + "tieba";
        public static final String exn = aYf + exm + ".tieba_video_monitor";
        public static final String exo = exn + exm + "v1";
        public static final String exp = exo + exm;
        public static final String exq = aYf + exm + ".tieba_video_monitor_log";
        public static final String exr = exq + exm + "v1";
        public static final String exs = exr + exm;
    }
}
