package com.baidu.tieba.j;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String inJ = File.separator;
        public static final String dSV = Environment.getExternalStorageDirectory() + inJ + "tieba";
        public static final String inQ = dSV + inJ + ".tieba_post_monitor";
        public static final String inR = inQ + inJ + AbstractBceClient.URL_PREFIX;
        public static final String inS = inR + inJ;
    }
}
