package com.baidu.tieba.recommend;

import com.baidu.tieba.c.w;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, String str) {
        this.a = gVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        new w(this.b).k();
    }
}
