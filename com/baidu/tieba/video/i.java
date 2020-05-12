package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean daA() {
        return com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void daB() {
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_video_guide_count", 0) + 1);
    }

    public static void daC() {
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void daD() {
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_no_behavior_count", 0);
    }
}
