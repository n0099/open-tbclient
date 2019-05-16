package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean cqU() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void cqV() {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_video_guide_count", 0) + 1);
    }

    public static void cqW() {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void cqX() {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_no_behavior_count", 0);
    }
}
