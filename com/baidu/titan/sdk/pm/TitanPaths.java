package com.baidu.titan.sdk.pm;

import com.baidu.searchbox.launch.stats.AppBeforeCreateSpeedStats;
import com.baidu.titan.sdk.initer.TitanIniter;
import com.baidu.titan.sdk.runtime.annotation.DisableIntercept;
import java.io.File;
@DisableIntercept
/* loaded from: classes7.dex */
public class TitanPaths {
    public static final String TITAN_SANDBOX_PROCESS_NAME_SUFFIX = ":titanSandbox";

    public static File getBaseDir() {
        return new File(TitanIniter.getAppContext().getApplicationInfo().dataDir, AppBeforeCreateSpeedStats.TITAN_DETAILS);
    }

    public static File getHeadFile() {
        return new File(getBaseDir(), "head");
    }

    public static File getPatchsDir() {
        return new File(getBaseDir(), "patches");
    }

    public static File getTempBaseDir() {
        return new File(getBaseDir(), "tmp");
    }

    public static File getPatchDir(String str) {
        return new File(getPatchsDir(), str);
    }
}
