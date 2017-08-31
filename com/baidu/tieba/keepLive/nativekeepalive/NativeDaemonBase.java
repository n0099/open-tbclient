package com.baidu.tieba.keepLive.nativekeepalive;

import android.content.Context;
import com.baidu.tieba.keepLive.nativekeepalive.IDaemonStrategy;
/* loaded from: classes.dex */
public class NativeDaemonBase {
    protected Context mContext;

    public NativeDaemonBase(Context context) {
        this.mContext = context;
    }

    protected void onDaemonDead() {
        IDaemonStrategy.Fetcher.fetchStrategy().onDaemonDead();
    }
}
