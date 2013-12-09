package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2181a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.f2181a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cr crVar;
        cr crVar2;
        cr crVar3;
        crVar = this.f2181a.y;
        if (!crVar.x()) {
            crVar3 = this.f2181a.y;
            crVar3.b(false);
            return;
        }
        crVar2 = this.f2181a.y;
        crVar2.b(true);
    }
}
