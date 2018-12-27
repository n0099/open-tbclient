package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean bIK() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void bIL() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_guide_count", 0) + 1);
    }

    public static void bIM() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void bIN() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_no_behavior_count", 0);
    }
}
