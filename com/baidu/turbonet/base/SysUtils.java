package com.baidu.turbonet.base;

import android.os.StrictMode;
import android.util.Log;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class SysUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f22286a;

    public static int a() {
        Pattern compile = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                FileReader fileReader = new FileReader("/proc/meminfo");
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            Log.w("SysUtils", "/proc/meminfo lacks a MemTotal entry?");
                            break;
                        }
                        Matcher matcher = compile.matcher(readLine);
                        if (matcher.find()) {
                            int parseInt = Integer.parseInt(matcher.group(1));
                            if (parseInt <= 1024) {
                                Log.w("SysUtils", "Invalid /proc/meminfo total size in kB: " + matcher.group(1));
                            } else {
                                bufferedReader.close();
                                return parseInt;
                            }
                        }
                    }
                    bufferedReader.close();
                } finally {
                    fileReader.close();
                }
            } catch (Exception e2) {
                Log.w("SysUtils", "Cannot get total physical size from /proc/meminfo", e2);
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return 0;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static boolean b() {
        int a2;
        if (CommandLine.a().b("enable-low-end-device-mode")) {
            return true;
        }
        return !CommandLine.a().b("disable-low-end-device-mode") && (a2 = a()) > 0 && a2 / 1024 <= 512;
    }

    @CalledByNative
    public static boolean isLowEndDevice() {
        if (f22286a == null) {
            f22286a = Boolean.valueOf(b());
        }
        return f22286a.booleanValue();
    }
}
