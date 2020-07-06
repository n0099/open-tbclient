package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class j {
    public static boolean dms() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dmt() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dmu() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dmv() {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_no_behavior_count", 0);
    }
}
