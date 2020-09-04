package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean dBi() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dBj() {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dBk() {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dBl() {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_no_behavior_count", 0);
    }
}
