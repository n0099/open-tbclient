package com.baidu.titan.sdk.runtime;

import com.baidu.titan.sdk.runtime.annotation.DisableIntercept;
import java.util.logging.Level;
@DisableIntercept
/* loaded from: classes7.dex */
public class Log {
    public static Logging logging;

    /* loaded from: classes7.dex */
    public interface Logging {
        boolean isLoggable(Level level);

        void log(Level level, String str);

        void log(Level level, String str, Throwable th);
    }
}
