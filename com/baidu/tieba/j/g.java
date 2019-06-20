package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hpg = File.separator;
        public static final String cUa = Environment.getExternalStorageDirectory() + hpg + "tieba";
        public static final String hpn = cUa + hpg + ".tieba_post_monitor";
        public static final String hpo = hpn + hpg + "v1";
        public static final String hpp = hpo + hpg;
    }
}
