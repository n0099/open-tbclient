package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kXq = File.separator;
        public static final String kXr = Environment.getExternalStorageDirectory() + kXq + "tieba";
        public static final String kXy = kXr + kXq + ".tieba_post_monitor";
        public static final String kXz = kXy + kXq + AbstractBceClient.URL_PREFIX;
        public static final String kXA = kXz + kXq;
    }
}
