package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean bDd() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void bDe() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_video_guide_count", 0) + 1);
    }

    public static void bDf() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void bDg() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_no_behavior_count", 0);
    }
}
