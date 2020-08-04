package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean dpE() {
        return com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dpF() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dpG() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dpH() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_no_behavior_count", 0);
    }
}
