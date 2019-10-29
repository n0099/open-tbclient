package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hwS = File.separator;
        public static final String dfR = Environment.getExternalStorageDirectory() + hwS + "tieba";
        public static final String hwZ = dfR + hwS + ".tieba_post_monitor";
        public static final String hxa = hwZ + hwS + "v1";
        public static final String hxb = hxa + hwS;
    }
}
