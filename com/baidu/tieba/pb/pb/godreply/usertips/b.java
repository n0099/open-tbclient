package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class b {
    private static AtomicBoolean fuH;

    public static boolean bZ(Context context) {
        if (context == null) {
            return false;
        }
        if (fuH == null) {
            fuH = new AtomicBoolean(context.getSharedPreferences("god_reply_user_tips", 0).getBoolean("has_click_leaderboard", false));
        }
        return fuH.get();
    }

    public static void u(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("god_reply_user_tips", 0).edit();
            edit.putBoolean("has_click_leaderboard", z);
            try {
                edit.apply();
            } catch (Throwable th) {
                edit.commit();
            }
        }
        if (fuH == null) {
            fuH = new AtomicBoolean();
        }
        fuH.set(z);
    }
}
