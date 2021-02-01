package com.baidu.tieba.l;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a {
        public static final String luk = File.separator;
        public static final String lul = Environment.getExternalStorageDirectory() + luk + "tieba";
        public static final String lus = lul + luk + ".tieba_post_monitor";
        public static final String lut = lus + luk + AbstractBceClient.URL_PREFIX;
        public static final String luu = lut + luk;
    }
}
