package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean dLW() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dLX() {
        com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dLY() {
        com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dLZ() {
        com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_no_behavior_count", 0);
    }
}
