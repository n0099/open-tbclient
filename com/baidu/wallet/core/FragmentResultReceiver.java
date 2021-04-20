package com.baidu.wallet.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* loaded from: classes5.dex */
public class FragmentResultReceiver extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public a f23900a;

    /* loaded from: classes5.dex */
    public interface a {
        void onReceiveResult(int i, Bundle bundle);
    }

    public FragmentResultReceiver(Handler handler) {
        super(handler);
    }

    public void a() {
        this.f23900a = null;
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        a aVar = this.f23900a;
        if (aVar != null) {
            aVar.onReceiveResult(i, bundle);
        }
    }

    public void a(a aVar) {
        this.f23900a = aVar;
    }
}
