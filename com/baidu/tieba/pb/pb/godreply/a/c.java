package com.baidu.tieba.pb.pb.godreply.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class c {
    private static AtomicBoolean fHg;

    public static boolean bX(Context context) {
        if (context == null) {
            return false;
        }
        if (fHg == null) {
            fHg = new AtomicBoolean(context.getSharedPreferences("god_reply_user_tips", 0).getBoolean("has_click_leaderboard", false));
        }
        return fHg.get();
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
        if (fHg == null) {
            fHg = new AtomicBoolean();
        }
        fHg.set(z);
    }
}
