package com.baidu.tieba.l;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a {
        public static final String lmd = File.separator;
        public static final String lme = Environment.getExternalStorageDirectory() + lmd + "tieba";
        public static final String lml = lme + lmd + ".tieba_post_monitor";
        public static final String lmm = lml + lmd + AbstractBceClient.URL_PREFIX;
        public static final String lmn = lmm + lmd;
    }
}
