package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.d.ae;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
public class TiebaActiveService extends Service {
    private m a = null;
    private int b = 0;
    private Handler c = new Handler();
    private Runnable d = new l(this);

    private String a() {
        return getSharedPreferences("settings", 0).getString("channel_id", null);
    }

    private void a(String str) {
        if (str != null && str.length() > 0) {
            SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
            edit.putString("channel_id", str);
            edit.commit();
        }
    }

    private String b() {
        String str = null;
        try {
            File c = com.baidu.tieba.d.o.c("channel.dat");
            if (c != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(c));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "getFromByFile", e.getMessage());
        }
        return str;
    }

    private void b(String str) {
        if (str != null && str.length() > 0) {
            try {
                File e = com.baidu.tieba.d.o.e("channel.dat");
                if (e != null) {
                    FileWriter fileWriter = new FileWriter(e);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e2) {
                ae.b(getClass().getName(), "saveFromToFile", e2.getMessage());
            }
        }
    }

    private boolean c() {
        try {
            String a = a();
            if (a == null) {
                String b = b();
                if (b != null && b.length() > 0) {
                    a(b);
                } else {
                    if ("aishide" != 0 && "aishide".length() > 0) {
                        a("aishide");
                        b("aishide");
                    }
                    return false;
                }
            } else {
                b(a);
            }
        } catch (Exception e) {
            ae.b(getClass().getName(), "getActiveState", e.getMessage());
        }
        ae.a(getClass().getName(), "getActiveState", "channel = ");
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (c() && getSharedPreferences("settings", 0).getInt("active", 2) != 1) {
            stopSelf();
        } else {
            d();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.a != null) {
            this.a.cancel();
        }
        this.b = 11;
        this.c.removeCallbacks(this.d);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.a != null) {
            this.a.cancel();
        }
        this.a = new m(this, null);
        this.a.execute(new String[0]);
    }
}
