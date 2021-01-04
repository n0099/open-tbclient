package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class h {
    public static boolean dTH() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dTI() {
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dTJ() {
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dTK() {
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_no_behavior_count", 0);
    }
}
