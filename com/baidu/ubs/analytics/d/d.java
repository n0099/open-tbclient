package com.baidu.ubs.analytics.d;
/* loaded from: classes6.dex */
public abstract class d implements Runnable {
    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Exception e) {
            j.b(e);
            if (e.getMessage() != null) {
                b.yU(e.getMessage());
            }
        }
    }
}
