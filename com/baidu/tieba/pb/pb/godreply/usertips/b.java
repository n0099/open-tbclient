package com.baidu.tieba.pb.pb.godreply.usertips;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b {
    private static AtomicBoolean fLE;

    public static boolean cO(Context context) {
        if (context == null) {
            return false;
        }
        if (fLE == null) {
            fLE = new AtomicBoolean(context.getSharedPreferences("god_reply_user_tips", 0).getBoolean("has_click_leaderboard", false));
        }
        return fLE.get();
    }

    public static void l(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("god_reply_user_tips", 0).edit();
            edit.putBoolean("has_click_leaderboard", z);
            try {
                edit.apply();
            } catch (Throwable th) {
                edit.commit();
            }
        }
        if (fLE == null) {
            fLE = new AtomicBoolean();
        }
        fLE.set(z);
    }
}
