package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kEX = File.separator;
        public static final String kEY = Environment.getExternalStorageDirectory() + kEX + "tieba";
        public static final String kFf = kEY + kEX + ".tieba_post_monitor";
        public static final String kFg = kFf + kEX + AbstractBceClient.URL_PREFIX;
        public static final String kFh = kFg + kEX;
    }
}
