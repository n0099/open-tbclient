package com.baidu.tieba.l;

import android.os.Environment;
import com.baidubce.AbstractBceClient;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String lld = File.separator;
        public static final String lle = Environment.getExternalStorageDirectory() + lld + "tieba";
        public static final String lll = lle + lld + ".tieba_post_monitor";
        public static final String llm = lll + lld + AbstractBceClient.URL_PREFIX;
        public static final String lln = llm + lld;
    }
}
