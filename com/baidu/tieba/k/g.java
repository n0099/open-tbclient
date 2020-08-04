package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jRI = File.separator;
        public static final String jRJ = Environment.getExternalStorageDirectory() + jRI + "tieba";
        public static final String jRQ = jRJ + jRI + ".tieba_post_monitor";
        public static final String jRR = jRQ + jRI + AbstractBceClient.URL_PREFIX;
        public static final String jRS = jRR + jRI;
    }
}
