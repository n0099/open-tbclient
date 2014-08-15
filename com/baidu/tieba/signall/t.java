package com.baidu.tieba.signall;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.e {
    private static t f;
    public boolean a;
    private v b;
    private r c;
    private u d;
    private b e;

    public static t a(Context context) {
        if (f == null) {
            f = new t(context);
        }
        return f;
    }

    private t(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.c = new r();
    }

    public void a(u uVar) {
        this.d = uVar;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public b a() {
        return this.e;
    }

    private String b() {
        ArrayList<d> l = this.e.l();
        if (l == null) {
            return "";
        }
        if (!this.e.m()) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = l.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.g() < this.e.a()) {
                    arrayList.add(next);
                }
            }
            l.removeAll(arrayList);
        }
        int size = l.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            d dVar = l.get(i);
            if (dVar.k()) {
                if (!dVar.l()) {
                    dVar.c(true);
                }
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(dVar.b());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.b != null) {
            return false;
        }
        String b = b();
        this.b = new v(this);
        this.b.execute(b);
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
