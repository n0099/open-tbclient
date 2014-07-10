package com.baidu.tieba.signall;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.e {
    private static q f = new q();
    public boolean a;
    private o c;
    private a e;
    private s b = null;
    private r d = null;

    public static q a() {
        return f;
    }

    private q() {
        this.c = null;
        this.c = new o();
    }

    public void a(r rVar) {
        this.d = rVar;
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
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.b != null) {
            return false;
        }
        String c = c();
        this.b = new s(this);
        this.b.execute(c);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return true;
        }
        return false;
    }
}
