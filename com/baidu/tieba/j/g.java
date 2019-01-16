package com.baidu.tieba.j;

import android.os.Environment;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fHK = File.separator;
        public static final String bAG = Environment.getExternalStorageDirectory() + fHK + NgWebViewInitHelper.INIT_BWEBKIT_APPID;
        public static final String fHR = bAG + fHK + ".tieba_post_monitor";
        public static final String fHS = fHR + fHK + "v1";
        public static final String fHT = fHS + fHK;
    }
}
