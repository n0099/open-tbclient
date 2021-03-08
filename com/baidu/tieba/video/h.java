package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class h {
    public static boolean dSr() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dSs() {
        com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dSt() {
        com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dSu() {
        com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_no_behavior_count", 0);
    }
}
