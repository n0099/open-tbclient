package com.baidu.tieba.j;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String hwk = File.separator;
        public static final String cVD = Environment.getExternalStorageDirectory() + hwk + "tieba";
        public static final String hwr = cVD + hwk + ".tieba_post_monitor";
        public static final String hws = hwr + hwk + "v1";
        public static final String hwt = hws + hwk;
    }
}
