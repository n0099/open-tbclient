package com.baidu.tieba.j;

import android.os.Environment;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fxi = File.separator;
        public static final String bwt = Environment.getExternalStorageDirectory() + fxi + NgWebViewInitHelper.INIT_BWEBKIT_APPID;
        public static final String fxp = bwt + fxi + ".tieba_post_monitor";
        public static final String fxq = fxp + fxi + "v1";
        public static final String fxr = fxq + fxi;
    }
}
