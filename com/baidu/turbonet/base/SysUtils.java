package com.baidu.turbonet.base;

import android.os.StrictMode;
import android.util.Log;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes17.dex */
public class SysUtils {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Boolean okS;

    static {
        $assertionsDisabled = !SysUtils.class.desiredAssertionStatus();
    }

    private SysUtils() {
    }

    private static int ebo() {
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
        if (okS == null) {
            okS = Boolean.valueOf(ebp());
        }
        return okS.booleanValue();
    }

    private static boolean ebp() {
        if ($assertionsDisabled || CommandLine.isInitialized()) {
            if (CommandLine.ebf().Wh("enable-low-end-device-mode")) {
                return true;
            }
            if (CommandLine.ebf().Wh("disable-low-end-device-mode")) {
                return false;
            }
            int ebo = ebo();
            return ebo > 0 && ebo / 1024 <= 512;
        }
        throw new AssertionError();
    }
}
