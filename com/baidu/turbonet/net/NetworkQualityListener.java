package com.baidu.turbonet.net;

import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public abstract class NetworkQualityListener {
    private final Executor mExecutor;

    public abstract void onNetworkQualityObservation(int i);

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public void WX(String str) {
    }
}
