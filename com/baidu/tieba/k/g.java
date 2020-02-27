package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String ipI = File.separator;
        public static final String dXa = Environment.getExternalStorageDirectory() + ipI + "tieba";
        public static final String ipP = dXa + ipI + ".tieba_post_monitor";
        public static final String ipQ = ipP + ipI + AbstractBceClient.URL_PREFIX;
        public static final String ipR = ipQ + ipI;
    }
}
