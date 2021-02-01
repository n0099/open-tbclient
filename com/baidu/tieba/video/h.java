package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class h {
    public static boolean dSb() {
        return com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dSc() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dSd() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dSe() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_no_behavior_count", 0);
    }
}
