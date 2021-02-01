package com.baidu.ufosdk.b;

import java.io.IOException;
/* loaded from: classes8.dex */
final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Process f5359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Process process) {
        this.f5359a = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.f5359a.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
        }
    }
}
