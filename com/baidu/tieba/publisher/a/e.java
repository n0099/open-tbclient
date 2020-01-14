package com.baidu.tieba.publisher.a;

import android.app.ActivityManager;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.TbConfig;
import com.facebook.imagepipeline.c.q;
/* loaded from: classes12.dex */
public class e implements com.facebook.common.internal.j<q> {
    private static final boolean DEBUG = AppConfig.isDebug();
    private final ActivityManager jAN;

    public e(ActivityManager activityManager) {
        this.jAN = activityManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: czy */
    public q get() {
        return new q(czz(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private int czz() {
        int i = 4194304;
        if (this.jAN != null) {
            int min = Math.min(this.jAN.getMemoryClass() * 1048576, Integer.MAX_VALUE);
            if (min >= 33554432) {
                if (min < 67108864) {
                    i = TbConfig.THREAD_GIF_MIN_USE_MEMORY;
                } else if (min < 134217728) {
                    i = min / 8;
                } else if (min < 268435456) {
                    i = min / 6;
                } else {
                    i = min / 5;
                }
            }
            if (DEBUG) {
                Log.d("FrescoCacheParams", "Fresco max cache size is : " + i + " , and max memory size is " + min);
            }
        }
        return i;
    }
}
