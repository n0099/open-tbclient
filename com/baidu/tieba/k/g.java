package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String khl = File.separator;
        public static final String khm = Environment.getExternalStorageDirectory() + khl + "tieba";
        public static final String kht = khm + khl + ".tieba_post_monitor";
        public static final String khu = kht + khl + AbstractBceClient.URL_PREFIX;
        public static final String khv = khu + khl;
    }
}
