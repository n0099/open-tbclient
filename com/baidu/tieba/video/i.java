package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean csF() {
        return com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void csG() {
        com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_video_guide_count", 0) + 1);
    }

    public static void csH() {
        com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void csI() {
        com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_no_behavior_count", 0);
    }
}
