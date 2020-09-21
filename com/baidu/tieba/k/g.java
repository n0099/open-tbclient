package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kpL = File.separator;
        public static final String kpM = Environment.getExternalStorageDirectory() + kpL + "tieba";
        public static final String kpT = kpM + kpL + ".tieba_post_monitor";
        public static final String kpU = kpT + kpL + AbstractBceClient.URL_PREFIX;
        public static final String kpV = kpU + kpL;
    }
}
