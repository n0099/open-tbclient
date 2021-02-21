package com.baidu.tieba.l;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a {
        public static final String luy = File.separator;
        public static final String luz = Environment.getExternalStorageDirectory() + luy + "tieba";
        public static final String luG = luz + luy + ".tieba_post_monitor";
        public static final String luH = luG + luy + AbstractBceClient.URL_PREFIX;
        public static final String luI = luH + luy;
    }
}
