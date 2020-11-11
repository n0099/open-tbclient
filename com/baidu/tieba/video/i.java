package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean dOy() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dOz() {
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dOA() {
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dOB() {
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_no_behavior_count", 0);
    }
}
