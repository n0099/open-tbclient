package com.baidu.tieba.play;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
public class ay {
    public static void a(String str, String str2, boolean z, int i, int i2) {
        com.baidu.tbadk.core.log.b.a("video", -1L, -1, str, 0, "", LoginActivityConfig.ACCOUNT, TbadkCoreApplication.getCurrentAccount(), "origin_url", str2, "is_use_cache", String.valueOf(z ? 1 : 0), "video_size", String.valueOf(i), "video_duration", String.valueOf(i2));
    }

    public static void i(String str, int i, int i2) {
        com.baidu.tbadk.core.log.b.a("video", -1L, -1, "cache_download", 0, "", LoginActivityConfig.ACCOUNT, TbadkCoreApplication.getCurrentAccount(), "origin_url", str, "current_get_size", String.valueOf(i), "video_size", String.valueOf(i2));
    }
}
