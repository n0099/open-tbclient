package com.baidu.titan.sdk.runtime;

import java.util.logging.Level;
/* loaded from: classes6.dex */
public class Log {
    public static Logging logging;

    /* loaded from: classes6.dex */
    public interface Logging {
        boolean isLoggable(Level level);

        void log(Level level, String str);

        void log(Level level, String str, Throwable th);
    }
}
