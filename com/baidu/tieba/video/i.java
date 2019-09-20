package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean cuS() {
        return com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void cuT() {
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_video_guide_count", 0) + 1);
    }

    public static void cuU() {
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void cuV() {
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_no_behavior_count", 0);
    }
}
