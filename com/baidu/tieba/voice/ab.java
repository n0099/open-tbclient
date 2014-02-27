package com.baidu.tieba.voice;
/* loaded from: classes.dex */
final class ab implements Runnable {
    final /* synthetic */ z a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, String str, int i) {
        this.a = zVar;
        this.b = str;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.H = 1;
        this.a.a.a.a(this.b, this.c);
    }
}
