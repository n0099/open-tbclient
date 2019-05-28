package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hpf = File.separator;
        public static final String cTZ = Environment.getExternalStorageDirectory() + hpf + "tieba";
        public static final String hpm = cTZ + hpf + ".tieba_post_monitor";
        public static final String hpn = hpm + hpf + "v1";
        public static final String hpo = hpn + hpf;
    }
}
