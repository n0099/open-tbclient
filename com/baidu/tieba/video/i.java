package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean cPj() {
        return com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void cPk() {
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_video_guide_count", 0) + 1);
    }

    public static void cPl() {
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void cPm() {
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt("key_no_behavior_count", 0);
    }
}
