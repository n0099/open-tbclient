package com.baidu.tieba;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.nadcore.player.remote.BDRemotePlayerService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes4.dex */
public class iz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, boolean z, int i, Map map, CyberPlayerManager.InstallListener installListener, CyberPlayerManager.GetNetHandleListener getNetHandleListener) {
        Class<BDRemotePlayerService> cls;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), map, installListener, getNetHandleListener}) != null) || CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        Context b = ar0.b();
        xj0.c("DumediaUtils", "initCyber, pid = " + Process.myPid());
        try {
            if (TextUtils.isEmpty(str)) {
                str = aj0.a().g();
            }
            String str2 = str;
            if (z) {
                cls = BDRemotePlayerService.class;
            } else {
                cls = null;
            }
            CyberPlayerManager.install(b, str2, (String) null, i, cls, map, installListener);
            if (getNetHandleListener != null) {
                CyberPlayerManager.setNetHandleListener(getNetHandleListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
