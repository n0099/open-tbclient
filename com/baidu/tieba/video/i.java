package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean dIO() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dIP() {
        com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dIQ() {
        com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dIR() {
        com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_no_behavior_count", 0);
    }
}
