package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hye = File.separator;
        public static final String cWw = Environment.getExternalStorageDirectory() + hye + "tieba";
        public static final String hyl = cWw + hye + ".tieba_post_monitor";
        public static final String hym = hyl + hye + "v1";
        public static final String hyn = hym + hye;
    }
}
