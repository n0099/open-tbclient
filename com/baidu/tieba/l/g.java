package com.baidu.tieba.l;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String llb = File.separator;
        public static final String llc = Environment.getExternalStorageDirectory() + llb + "tieba";
        public static final String llj = llc + llb + ".tieba_post_monitor";
        public static final String llk = llj + llb + AbstractBceClient.URL_PREFIX;
        public static final String lll = llk + llb;
    }
}
