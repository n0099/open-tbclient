package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class b {
    private static AtomicBoolean hKz;

    public static boolean dS(Context context) {
        if (context == null) {
            return false;
        }
        if (hKz == null) {
            hKz = new AtomicBoolean(context.getSharedPreferences("god_reply_user_tips", 0).getBoolean("has_click_leaderboard", false));
        }
        return hKz.get();
    }

    public static void j(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("god_reply_user_tips", 0).edit();
            edit.putBoolean("has_click_leaderboard", z);
            try {
                edit.apply();
            } catch (Throwable th) {
                edit.commit();
            }
        }
        if (hKz == null) {
            hKz = new AtomicBoolean();
        }
        hKz.set(z);
    }
}
