package com.baidu.tieba.write;

import android.app.Activity;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class cb {
    public static void a(Activity activity) {
        try {
            com.baidu.tbadk.motu_gallery.x.a(activity, 12002, null);
        } catch (Exception e) {
            BdLog.e("WriteUtil", "getAlbumImage", "error = " + e.getMessage());
        }
    }
}
