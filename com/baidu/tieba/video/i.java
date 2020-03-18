package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean cPG() {
        return com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void cPH() {
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_video_guide_count", 0) + 1);
    }

    public static void cPI() {
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void cPJ() {
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_no_behavior_count", 0);
    }
}
