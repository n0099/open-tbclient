package com.baidu.tieba.signall;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.b {
    private static r f = new r();
    public boolean a;
    private p c;
    private a e;
    private t b = null;
    private s d = null;

    public static r a() {
        return f;
    }

    private r() {
        this.c = null;
        this.c = new p();
    }

    public void a(s sVar) {
        this.d = sVar;
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public a b() {
        return this.e;
    }

    private String c() {
        ArrayList<b> m = this.e.m();
        int size = m.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            b bVar = m.get(i);
            if (bVar.j()) {
                if (!bVar.k()) {
                    bVar.c(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(bVar.a());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.b
    public boolean LoadData() {
        if (this.b != null) {
            return false;
        }
        String c = c();
        this.b = new t(this);
        this.b.execute(c);
        return true;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return true;
        }
        return false;
    }
}
