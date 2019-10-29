package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean csH() {
        return com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void csI() {
        com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_video_guide_count", 0) + 1);
    }

    public static void csJ() {
        com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void csK() {
        com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_no_behavior_count", 0);
    }
}
