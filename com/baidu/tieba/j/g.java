package com.baidu.tieba.j;

import android.os.Environment;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fGQ = File.separator;
        public static final String bzT = Environment.getExternalStorageDirectory() + fGQ + NgWebViewInitHelper.INIT_BWEBKIT_APPID;
        public static final String fGX = bzT + fGQ + ".tieba_post_monitor";
        public static final String fGY = fGX + fGQ + "v1";
        public static final String fGZ = fGY + fGQ;
    }
}
