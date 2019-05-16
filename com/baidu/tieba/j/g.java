package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hpc = File.separator;
        public static final String cTY = Environment.getExternalStorageDirectory() + hpc + "tieba";
        public static final String hpj = cTY + hpc + ".tieba_post_monitor";
        public static final String hpk = hpj + hpc + "v1";
        public static final String hpl = hpk + hpc;
    }
}
