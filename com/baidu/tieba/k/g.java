package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes2.dex */
public interface g {

    /* loaded from: classes2.dex */
    public interface a {
        public static final String khe = File.separator;
        public static final String khf = Environment.getExternalStorageDirectory() + khe + "tieba";
        public static final String khm = khf + khe + ".tieba_post_monitor";
        public static final String khn = khm + khe + AbstractBceClient.URL_PREFIX;
        public static final String kho = khn + khe;
    }
}
