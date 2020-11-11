package com.baidu.ufosdk.b;

import java.io.IOException;
/* loaded from: classes22.dex */
final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Process f3701a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Process process) {
        this.f3701a = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            do {
            } while (this.f3701a.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
        }
    }
}
