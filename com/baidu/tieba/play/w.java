package com.baidu.tieba.play;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
/* loaded from: classes.dex */
public class w {
    public static void a(String str, String str2, boolean z, int i, int i2) {
        com.baidu.tbadk.core.d.a.a("video", -1L, -1, str, 0, "", "account", TbadkCoreApplication.getCurrentAccount(), "origin_url", str2, "is_use_cache", String.valueOf(z ? 1 : 0), "video_size", String.valueOf(i), WebVideoActivityConfig.KEY_VIDEO_DURATION, String.valueOf(i2));
    }

    public static void v(String str, int i, int i2) {
        com.baidu.tbadk.core.d.a.a("video", -1L, -1, "cache_download", 0, "", "account", TbadkCoreApplication.getCurrentAccount(), "origin_url", str, "current_get_size", String.valueOf(i), "video_size", String.valueOf(i2));
    }
}
