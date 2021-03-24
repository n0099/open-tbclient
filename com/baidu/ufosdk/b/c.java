package com.baidu.ufosdk.b;

import java.io.IOException;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Process f22909a;

    public c(Process process) {
        this.f22909a = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.f22909a.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException unused) {
        }
    }
}
