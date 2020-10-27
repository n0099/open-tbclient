package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String kRu = File.separator;
        public static final String kRv = Environment.getExternalStorageDirectory() + kRu + "tieba";
        public static final String kRC = kRv + kRu + ".tieba_post_monitor";
        public static final String kRD = kRC + kRu + AbstractBceClient.URL_PREFIX;
        public static final String kRE = kRD + kRu;
    }
}
