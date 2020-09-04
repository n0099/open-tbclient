package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import com.baidu.tieba.keepLive.nativekeepalive.IGuard;
/* loaded from: classes.dex */
public class NativeGuardAbs {
    protected Context mContext;

    public NativeGuardAbs(Context context) {
        this.mContext = context;
    }

    protected void onDaemonDead() {
        IGuard.Fetcher.fetchGuard().onDaemonDead();
    }
}
