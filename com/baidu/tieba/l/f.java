package com.baidu.tieba.l;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a {
        public static final String lqN = File.separator;
        public static final String lqO = Environment.getExternalStorageDirectory() + lqN + "tieba";
        public static final String lqV = lqO + lqN + ".tieba_post_monitor";
        public static final String lqW = lqV + lqN + AbstractBceClient.URL_PREFIX;
        public static final String lqX = lqW + lqN;
    }
}
