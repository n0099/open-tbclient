package com.baidu.tieba.monitor;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: com.baidu.tieba.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0105a {
        public static final String exi = File.separator;
        public static final String aXW = Environment.getExternalStorageDirectory() + exi + "tieba";
        public static final String aXX = aXW + exi + ".tieba_video_monitor";
        public static final String aXY = aXX + exi + "v1";
        public static final String aXZ = aXY + exi;
    }
}
