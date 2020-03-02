package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String ipK = File.separator;
        public static final String dXb = Environment.getExternalStorageDirectory() + ipK + "tieba";
        public static final String ipR = dXb + ipK + ".tieba_post_monitor";
        public static final String ipS = ipR + ipK + AbstractBceClient.URL_PREFIX;
        public static final String ipT = ipS + ipK;
    }
}
