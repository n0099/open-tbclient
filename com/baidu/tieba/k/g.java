package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jbC = File.separator;
        public static final String exE = Environment.getExternalStorageDirectory() + jbC + "tieba";
        public static final String jbJ = exE + jbC + ".tieba_post_monitor";
        public static final String jbK = jbJ + jbC + AbstractBceClient.URL_PREFIX;
        public static final String jbL = jbK + jbC;
    }
}
