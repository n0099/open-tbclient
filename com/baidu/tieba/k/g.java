package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jby = File.separator;
        public static final String exz = Environment.getExternalStorageDirectory() + jby + "tieba";
        public static final String jbF = exz + jby + ".tieba_post_monitor";
        public static final String jbG = jbF + jby + AbstractBceClient.URL_PREFIX;
        public static final String jbH = jbG + jby;
    }
}
