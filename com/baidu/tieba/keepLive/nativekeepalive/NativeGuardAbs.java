package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import com.baidu.tieba.keepLive.nativekeepalive.IGuard;
/* loaded from: classes3.dex */
public class NativeGuardAbs {
    public Context mContext;

    public NativeGuardAbs(Context context) {
        this.mContext = context;
    }

    public void onDaemonDead() {
        IGuard.Fetcher.fetchGuard().onDaemonDead();
    }
}
