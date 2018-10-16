package com.baidu.tieba.j;

import android.os.Environment;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fvS = File.separator;
        public static final String bvI = Environment.getExternalStorageDirectory() + fvS + NgWebViewInitHelper.INIT_BWEBKIT_APPID;
        public static final String fvZ = bvI + fvS + ".tieba_post_monitor";
        public static final String fwa = fvZ + fvS + "v1";
        public static final String fwb = fwa + fvS;
    }
}
