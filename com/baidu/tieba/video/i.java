package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean dFc() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dFd() {
        com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dFe() {
        com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dFf() {
        com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_no_behavior_count", 0);
    }
}
