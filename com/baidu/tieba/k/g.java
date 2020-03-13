package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String ipW = File.separator;
        public static final String dXo = Environment.getExternalStorageDirectory() + ipW + "tieba";
        public static final String iqd = dXo + ipW + ".tieba_post_monitor";
        public static final String iqe = iqd + ipW + AbstractBceClient.URL_PREFIX;
        public static final String iqf = iqe + ipW;
    }
}
