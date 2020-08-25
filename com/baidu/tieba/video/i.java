package com.baidu.tieba.video;
/* loaded from: classes2.dex */
public class i {
    public static boolean dAZ() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dBa() {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dBb() {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dBc() {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_no_behavior_count", 0);
    }
}
