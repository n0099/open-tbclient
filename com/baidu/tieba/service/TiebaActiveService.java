package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.bg;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/* loaded from: classes.dex */
public class TiebaActiveService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private l f2333a = null;
    private int b = 0;
    private Handler c = new Handler();
    private Runnable d = new k(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(TiebaActiveService tiebaActiveService) {
        int i = tiebaActiveService.b;
        tiebaActiveService.b = i + 1;
        return i;
    }

    private String a() {
        return com.baidu.tieba.sharedPref.b.a().a("channel_id", (String) null);
    }

    private void a(String str) {
        if (str != null && str.length() > 0) {
            com.baidu.tieba.sharedPref.b.a().b("channel_id", str);
        }
    }

    private String b() {
        String str = null;
        try {
            File d = af.d("channel.dat");
            if (d != null) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
                str = bufferedReader.readLine();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e) {
            bg.b(getClass().getName(), "getFromByFile", e.getMessage());
        }
        return str;
    }

    private void b(String str) {
        if (str != null && str.length() > 0) {
            try {
                File f = af.f("channel.dat");
                if (f != null) {
                    FileWriter fileWriter = new FileWriter(f);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                bg.b(getClass().getName(), "saveFromToFile", e.getMessage());
            }
        }
    }

    private boolean c() {
        try {
            String a2 = a();
            if (a2 == null) {
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
                b(a2);
            }
        } catch (Exception e) {
            bg.b(getClass().getName(), "getActiveState", e.getMessage());
        }
        bg.a(getClass().getName(), "getActiveState", "channel = ");
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (c() && com.baidu.tieba.sharedPref.b.a().a("active", 2) != 1) {
            stopSelf();
        } else {
            d();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f2333a != null) {
            this.f2333a.cancel();
        }
        this.b = 11;
        this.c.removeCallbacks(this.d);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f2333a != null) {
            this.f2333a.cancel();
        }
        this.f2333a = new l(this, null);
        this.f2333a.execute(new String[0]);
    }
}
