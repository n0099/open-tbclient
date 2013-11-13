package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f2572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.f2572a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        this.f2572a.f = true;
        ba.a(this.f2572a, 30);
        i = this.f2572a.i;
        if (i > 360) {
            ba baVar = this.f2572a;
            i2 = this.f2572a.i;
            baVar.i = i2 - 360;
        }
        this.f2572a.invalidate(this.f2572a.getRotateInvalidRect());
        this.f2572a.postDelayed(this.f2572a.e, 50L);
    }
}
