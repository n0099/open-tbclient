package com.baidu.tieba.video;
/* loaded from: classes.dex */
public class i {
    public static boolean dhO() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_video_guide_count", 0) < com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_video_guide_max_count", 0) && com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_no_behavior_count", 0) >= 2;
    }

    public static void dhP() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_video_guide_count", com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_video_guide_count", 0) + 1);
    }

    public static void dhQ() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_no_behavior_count", com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_no_behavior_count", 0) + 1);
    }

    public static void dhR() {
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_no_behavior_count", 0);
    }
}
