package com.baidu.tieba.voice;
/* loaded from: classes.dex */
class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f2024a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, String str, int i) {
        this.f2024a = zVar;
        this.b = str;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        r rVar;
        r rVar2;
        rVar = this.f2024a.f2060a;
        rVar.H = 1;
        rVar2 = this.f2024a.f2060a;
        rVar2.f2041a.a(this.b, this.c);
    }
}
