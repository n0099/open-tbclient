package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f2555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.f2555a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        this.f2555a.f = true;
        ba.a(this.f2555a, 30);
        i = this.f2555a.i;
        if (i > 360) {
            ba baVar = this.f2555a;
            i2 = this.f2555a.i;
            baVar.i = i2 - 360;
        }
        this.f2555a.invalidate(this.f2555a.getRotateInvalidRect());
        this.f2555a.postDelayed(this.f2555a.e, 50L);
    }
}
