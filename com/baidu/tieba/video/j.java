package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class j {
    public static boolean dmo() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dmp() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dmq() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dmr() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_no_behavior_count", 0);
    }
}
