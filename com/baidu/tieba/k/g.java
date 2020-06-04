package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jrL = File.separator;
        public static final String eMr = Environment.getExternalStorageDirectory() + jrL + "tieba";
        public static final String jrS = eMr + jrL + ".tieba_post_monitor";
        public static final String jrT = jrS + jrL + AbstractBceClient.URL_PREFIX;
        public static final String jrU = jrT + jrL;
    }
}
