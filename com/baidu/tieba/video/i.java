package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean dTQ() {
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dTR() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dTS() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dTT() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_no_behavior_count", 0);
    }
}
