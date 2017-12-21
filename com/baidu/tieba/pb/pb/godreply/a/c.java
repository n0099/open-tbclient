package com.baidu.tieba.pb.pb.godreply.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class c {
    private static AtomicBoolean eSK;

    public static boolean bP(Context context) {
        if (context == null) {
            return false;
        }
        if (eSK == null) {
            eSK = new AtomicBoolean(context.getSharedPreferences("god_reply_user_tips", 0).getBoolean("has_click_leaderboard", false));
        }
        return eSK.get();
    }

    public static void t(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("god_reply_user_tips", 0).edit();
            edit.putBoolean("has_click_leaderboard", z);
            try {
                edit.apply();
            } catch (Throwable th) {
                edit.commit();
            }
        }
        if (eSK == null) {
            eSK = new AtomicBoolean();
        }
        eSK.set(z);
    }
}
