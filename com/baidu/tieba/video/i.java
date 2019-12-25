package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean cMH() {
        return com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void cMI() {
        com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_video_guide_count", 0) + 1);
    }

    public static void cMJ() {
        com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void cMK() {
        com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_no_behavior_count", 0);
    }
}
