package com.baidu.tieba.k;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String irw = File.separator;
        public static final String dXE = Environment.getExternalStorageDirectory() + irw + "tieba";
        public static final String irD = dXE + irw + ".tieba_post_monitor";
        public static final String irE = irD + irw + AbstractBceClient.URL_PREFIX;
        public static final String irF = irE + irw;
    }
}
