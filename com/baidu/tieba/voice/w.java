package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar) {
        this.f2057a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Boolean bool;
        Boolean bool2;
        bool = this.f2057a.A;
        if (bool != null) {
            bool2 = this.f2057a.A;
            if (bool2.booleanValue()) {
                this.f2057a.h();
            } else {
                this.f2057a.i();
            }
        }
    }
}
