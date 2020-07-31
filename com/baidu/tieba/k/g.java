package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jRG = File.separator;
        public static final String jRH = Environment.getExternalStorageDirectory() + jRG + "tieba";
        public static final String jRO = jRH + jRG + ".tieba_post_monitor";
        public static final String jRP = jRO + jRG + AbstractBceClient.URL_PREFIX;
        public static final String jRQ = jRP + jRG;
    }
}
