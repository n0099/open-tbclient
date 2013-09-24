package com.baidu.tieba.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.f2042a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ai aiVar;
        ac acVar;
        ai aiVar2;
        r rVar = this.f2042a;
        aiVar = this.f2042a.v;
        rVar.u = aiVar;
        r rVar2 = this.f2042a;
        acVar = this.f2042a.w;
        rVar2.x = acVar;
        this.f2042a.w = null;
        r rVar3 = this.f2042a;
        aiVar2 = this.f2042a.u;
        rVar3.d(aiVar2);
    }
}
