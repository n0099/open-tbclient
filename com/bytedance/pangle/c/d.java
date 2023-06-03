package com.bytedance.pangle.c;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public final class d {
    public static String a;
    public static List<String> b = new CopyOnWriteArrayList();

    public static String a() {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName)) {
                    a = processName;
                }
                return a;
            }
        } catch (Throwable unused) {
        }
        try {
            Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) invokeStaticMethod)) {
                a = (String) invokeStaticMethod;
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            String b2 = b();
            a = b2;
            return b2;
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(":")) {
            return str.split(":")[1];
        }
        return "main";
    }

    public static boolean a(Context context) {
        String a2 = a();
        if ((a2 != null && a2.contains(":")) || a2 == null || !a2.equals(context.getPackageName())) {
            return false;
        }
        return true;
    }

    public static String b() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            if (ZeusLogger.isDebug()) {
                ZeusLogger.d("Process", "get processName = " + sb.toString());
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return sb2;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        }
    }
}
