package com.baidu.ufosdk.b;

import java.io.IOException;
/* loaded from: classes21.dex */
final class c implements Runnable {
    final /* synthetic */ Process a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Process process) {
        this.a = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.a.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
        }
    }
}
