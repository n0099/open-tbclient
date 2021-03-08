package com.baidu.tieba.l;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a {
        public static final String lwA = File.separator;
        public static final String lwB = Environment.getExternalStorageDirectory() + lwA + "tieba";
        public static final String lwI = lwB + lwA + ".tieba_post_monitor";
        public static final String lwJ = lwI + lwA + AbstractBceClient.URL_PREFIX;
        public static final String lwK = lwJ + lwA;
    }
}
