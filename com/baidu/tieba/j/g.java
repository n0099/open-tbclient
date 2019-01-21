package com.baidu.tieba.j;

import android.os.Environment;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fHL = File.separator;
        public static final String bAH = Environment.getExternalStorageDirectory() + fHL + NgWebViewInitHelper.INIT_BWEBKIT_APPID;
        public static final String fHS = bAH + fHL + ".tieba_post_monitor";
        public static final String fHT = fHS + fHL + "v1";
        public static final String fHU = fHT + fHL;
    }
}
