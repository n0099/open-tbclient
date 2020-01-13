package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean cNM() {
        return com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void cNN() {
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_video_guide_count", 0) + 1);
    }

    public static void cNO() {
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.aDr().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void cNP() {
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_no_behavior_count", 0);
    }
}
