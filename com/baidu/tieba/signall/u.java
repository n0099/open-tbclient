package com.baidu.tieba.signall;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.e {
    private static String f;
    private static u g;
    public boolean a;
    private w b;
    private s c;
    private v d;
    private b e;

    public static u a(Context context) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (g == null) {
            g = new u(context);
        } else if (!TextUtils.isEmpty(f) && !TextUtils.equals(f, currentAccount)) {
            g = new u(context);
        }
        return g;
    }

    private u(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        f = TbadkApplication.getCurrentAccount();
        this.c = new s();
    }

    public void a(v vVar) {
        this.d = vVar;
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
        this.b = new w(this);
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
