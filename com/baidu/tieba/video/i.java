package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean cue() {
        return com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void cuf() {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_video_guide_count", 0) + 1);
    }

    public static void cug() {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void cuh() {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_no_behavior_count", 0);
    }
}
