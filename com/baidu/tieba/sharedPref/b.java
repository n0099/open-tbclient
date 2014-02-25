package com.baidu.tieba.sharedPref;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import com.baidu.adp.lib.util.f;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.data.i;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b a = null;
    private static ContentResolver b = null;
    private static HashMap<String, String> f = null;
    private String c = null;
    private SharedPreferences d = null;
    private String e = null;

    private b() {
        f = new HashMap<>();
        f.put(a.a, "settings");
        f.put(a.b, "remote_settings");
        f.put(a.c, "bdservice_settings");
        b = TiebaApplication.g().b().getContentResolver();
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public boolean a(String str, boolean z) {
        if (b(str)) {
            String c = c(str);
            if (c != null) {
                try {
                    return Boolean.parseBoolean(c);
                } catch (NumberFormatException e) {
                    f.b("SharedPrefHelper", "getBoolean", "Convert error:" + c);
                    return z;
                }
            }
            return z;
        }
        this.d = c();
        return this.d.getBoolean(str, z);
    }

    public int a(String str, int i) {
        if (b(str)) {
            String c = c(str);
            if (c != null) {
                try {
                    return Integer.parseInt(c);
                } catch (NumberFormatException e) {
                    f.b("SharedPrefHelper", "getInt", "Convert error:" + c);
                    return i;
                }
            }
            return i;
        }
        this.d = c();
        return this.d.getInt(str, i);
    }

    public long a(String str, long j) {
        if (b(str)) {
            String c = c(str);
            if (c != null) {
                try {
                    return Long.parseLong(c);
                } catch (NumberFormatException e) {
                    f.b("SharedPrefHelper", "getLong", "Convert error:" + c);
                    return j;
                }
            }
            return j;
        }
        this.d = c();
        return this.d.getLong(str, j);
    }

    public String a(String str, String str2) {
        if (b(str)) {
            String c = c(str);
            return c != null ? c : str2;
        }
        this.d = c();
        return this.d.getString(str, str2);
    }

    public void b(String str, boolean z) {
        if (b(str)) {
            c(str, z);
            return;
        }
        this.d = c();
        EditorHelper.putBoolean(this.d, str, z);
    }

    public void b(String str, String str2) {
        if (b(str)) {
            c(str, str2);
            return;
        }
        this.d = c();
        EditorHelper.putString(this.d, str, str2);
    }

    public void b(String str, int i) {
        if (b(str)) {
            c(str, i);
            return;
        }
        this.d = c();
        EditorHelper.putInt(this.d, str, i);
    }

    public void b(String str, long j) {
        if (b(str)) {
            c(str, j);
            return;
        }
        this.d = c();
        EditorHelper.putLong(this.d, str, j);
    }

    public void a(String str) {
        if (b(str)) {
            d(str);
            return;
        }
        this.d = c();
        EditorHelper.remove(this.d, str);
    }

    private boolean b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = a.d.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(a.d[i])) {
                return true;
            }
        }
        return false;
    }

    private String c(String str) {
        return b.getType(Uri.parse("content://com.baidu.tieba.sharedPref.MainSharedPrefProvider/" + str));
    }

    private void c(String str, String str2) {
        Uri parse = Uri.parse("content://com.baidu.tieba.sharedPref.MainSharedPrefProvider/" + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        b.insert(parse, contentValues);
    }

    private void c(String str, int i) {
        Uri parse = Uri.parse("content://com.baidu.tieba.sharedPref.MainSharedPrefProvider/" + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        b.insert(parse, contentValues);
    }

    private void c(String str, long j) {
        Uri parse = Uri.parse("content://com.baidu.tieba.sharedPref.MainSharedPrefProvider/" + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        b.insert(parse, contentValues);
    }

    private void c(String str, boolean z) {
        Uri parse = Uri.parse("content://com.baidu.tieba.sharedPref.MainSharedPrefProvider/" + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        b.insert(parse, contentValues);
    }

    private void d(String str) {
        b.delete(Uri.parse("content://com.baidu.tieba.sharedPref.MainSharedPrefProvider/" + str), null, null);
    }

    private synchronized SharedPreferences c() {
        if (this.e == null || this.e.length() == 0) {
            if (this.c == null || this.c.length() == 0) {
                this.c = d();
            }
            if (f.containsKey(this.c)) {
                this.e = f.get(this.c);
            } else {
                this.e = "settings";
            }
        }
        return TiebaApplication.g().b().getSharedPreferences(this.e, 0);
    }

    private String d() {
        ActivityManager activityManager = (ActivityManager) TiebaApplication.g().b().getSystemService("activity");
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            int myPid = Process.myPid();
            if (runningAppProcesses != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= runningAppProcesses.size()) {
                        break;
                    } else if (runningAppProcesses.get(i2).pid != myPid) {
                        i = i2 + 1;
                    } else {
                        return runningAppProcesses.get(i2).processName;
                    }
                }
            }
        }
        return a.a;
    }

    public void b() {
        SharedPreferences sharedPreferences = TiebaApplication.g().b().getSharedPreferences("settings", 0);
        String string = sharedPreferences.getString("lase_version", "");
        String u = i.u();
        if (string != null && string.length() != 0 && u != null && u.length() != 0 && !string.equals(u) && "4.5.0".compareTo(string) > 0 && "4.5.0".compareTo(u) <= 0) {
            a().b("skin", sharedPreferences.getInt("skin", 0));
            String string2 = sharedPreferences.getString("from_id", null);
            if (string2 != null && string2.length() > 0) {
                a().b("from_id", string2);
            }
            String string3 = sharedPreferences.getString("install_other_app_file_name", null);
            if (string3 != null && string3.length() > 0) {
                a().b("install_other_app_file_name", string3);
            }
            String string4 = sharedPreferences.getString(SocialConstants.PARAM_CUID, null);
            if (string4 != null && string4.length() > 0) {
                a().b(SocialConstants.PARAM_CUID, string4);
            }
            String string5 = sharedPreferences.getString(SocialConstants.PARAM_CLIENT_ID, null);
            if (string5 != null && string5.length() > 0) {
                a().b(SocialConstants.PARAM_CLIENT_ID, string5);
            }
        }
    }
}
