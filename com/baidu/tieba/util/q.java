package com.baidu.tieba.util;
/* loaded from: classes.dex */
class q {
    StringBuffer a;
    final /* synthetic */ o b;

    private q(o oVar) {
        this.b = oVar;
        this.a = new StringBuffer(100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(o oVar, q qVar) {
        this(oVar);
    }

    public void a(int i) {
        if (this.a.length() != 0) {
            this.a.append(",");
        }
        this.a.append(i);
    }

    public void a() {
        this.a.setLength(0);
    }

    public String toString() {
        return this.a.toString();
    }
}
