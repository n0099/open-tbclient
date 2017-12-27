package com.baidu.tieba.pb.pb.godreply.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class c {
    private static AtomicBoolean fFl;

    public static boolean ca(Context context) {
        if (context == null) {
            return false;
        }
        if (fFl == null) {
            fFl = new AtomicBoolean(context.getSharedPreferences("god_reply_user_tips", 0).getBoolean("has_click_leaderboard", false));
        }
        return fFl.get();
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
        if (fFl == null) {
            fFl = new AtomicBoolean();
        }
        fFl.set(z);
    }
}
