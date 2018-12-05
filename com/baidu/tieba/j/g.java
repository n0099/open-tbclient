package com.baidu.tieba.j;

import android.os.Environment;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fDY = File.separator;
        public static final String bzQ = Environment.getExternalStorageDirectory() + fDY + NgWebViewInitHelper.INIT_BWEBKIT_APPID;
        public static final String fEf = bzQ + fDY + ".tieba_post_monitor";
        public static final String fEg = fEf + fDY + "v1";
        public static final String fEh = fEg + fDY;
    }
}
