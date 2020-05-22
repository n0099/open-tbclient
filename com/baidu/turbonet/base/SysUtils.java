package com.baidu.turbonet.base;

import android.os.StrictMode;
import android.util.Log;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class SysUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Boolean mbr;

    static {
        $assertionsDisabled = !SysUtils.class.desiredAssertionStatus();
    }

    private SysUtils() {
    }

    private static int dpX() {
        FileReader fileReader;
        Pattern compile = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileReader = new FileReader("/proc/meminfo");
        } catch (Exception e) {
            Log.w("SysUtils", "Cannot get total physical size from /proc/meminfo", e);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
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
            return 0;
        } finally {
            fileReader.close();
        }
    }

    @CalledByNative
    public static boolean isLowEndDevice() {
        if (mbr == null) {
            mbr = Boolean.valueOf(dpY());
        }
        return mbr.booleanValue();
    }

    private static boolean dpY() {
        if ($assertionsDisabled || CommandLine.isInitialized()) {
            if (CommandLine.dpO().OF("enable-low-end-device-mode")) {
                return true;
            }
            if (CommandLine.dpO().OF("disable-low-end-device-mode")) {
                return false;
            }
            int dpX = dpX();
            return dpX > 0 && dpX / 1024 <= 512;
        }
        throw new AssertionError();
    }
}
