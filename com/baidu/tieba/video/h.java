package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class h {
    public static boolean dPQ() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dPR() {
        com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dPS() {
        com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dPT() {
        com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_no_behavior_count", 0);
    }
}
