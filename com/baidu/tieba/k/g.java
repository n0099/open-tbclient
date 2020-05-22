package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String jqF = File.separator;
        public static final String eMg = Environment.getExternalStorageDirectory() + jqF + "tieba";
        public static final String jqM = eMg + jqF + ".tieba_post_monitor";
        public static final String jqN = jqM + jqF + AbstractBceClient.URL_PREFIX;
        public static final String jqO = jqN + jqF;
    }
}
