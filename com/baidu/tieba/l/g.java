package com.baidu.tieba.l;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kXI = File.separator;
        public static final String kXJ = Environment.getExternalStorageDirectory() + kXI + "tieba";
        public static final String kXQ = kXJ + kXI + ".tieba_post_monitor";
        public static final String kXR = kXQ + kXI + AbstractBceClient.URL_PREFIX;
        public static final String kXS = kXR + kXI;
    }
}
