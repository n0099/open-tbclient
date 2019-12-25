package com.baidu.tieba.j;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String ikd = File.separator;
        public static final String dSM = Environment.getExternalStorageDirectory() + ikd + "tieba";
        public static final String ikk = dSM + ikd + ".tieba_post_monitor";
        public static final String ikl = ikk + ikd + AbstractBceClient.URL_PREFIX;
        public static final String ikm = ikl + ikd;
    }
}
