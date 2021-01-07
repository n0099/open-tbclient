package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class h {
    public static boolean dTI() {
        return com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dTJ() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dTK() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dTL() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_no_behavior_count", 0);
    }
}
