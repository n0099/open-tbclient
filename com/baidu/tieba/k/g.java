package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jJc = File.separator;
        public static final String eWD = Environment.getExternalStorageDirectory() + jJc + "tieba";
        public static final String jJj = eWD + jJc + ".tieba_post_monitor";
        public static final String jJk = jJj + jJc + AbstractBceClient.URL_PREFIX;
        public static final String jJl = jJk + jJc;
    }
}
