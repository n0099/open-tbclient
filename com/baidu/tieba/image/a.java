package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.data.t;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> a;
    private String d;
    private String e;
    private String f;
    private boolean k;
    private String b = null;
    private String c = null;
    private boolean g = false;
    private b h = null;
    private int i = 0;
    private boolean j = false;
    private c l = null;
    private HashMap<String, String> m = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.a = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.k = false;
        this.a = arrayList;
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.a.get(i);
            this.m.put(a(str4), str4);
        }
        this.d = str2;
        this.e = str;
        this.f = str3;
        if (this.f == null) {
            this.k = true;
        }
    }

    public void a() {
        if (!this.g && !this.k) {
            a(this.d, this.f, 10, 0);
        }
    }

    public void b() {
        if (!this.k) {
            if (!this.g) {
                a();
            } else if (this.b != null && this.b.length() > 0) {
                a(this.b, null, 0, 10);
            }
        }
    }

    private void a(String str, String str2, int i, int i2) {
        if (this.h != null) {
            if (str2 == null || !str2.equals(this.h.a())) {
                this.h.cancel();
            } else {
                return;
            }
        }
        this.h = new b(this, str, str2, i, i2);
        this.h.setPriority(3);
        this.h.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.l = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(t tVar) {
        if (tVar.j() != null && tVar.j().length() > 0) {
            return tVar.j();
        }
        StringBuilder sb = new StringBuilder(150);
        if (tVar.g() * tVar.f() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
            double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (tVar.g() * tVar.f()));
            sb.append("width=");
            sb.append(String.valueOf((int) (tVar.f() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * tVar.g())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(tVar.f()));
            sb.append("&height=");
            sb.append(String.valueOf(tVar.g()));
        }
        sb.append("&src=");
        sb.append(bg.d(tVar.b()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        int lastIndexOf;
        int indexOf;
        String e = bg.e(str);
        if (e != null) {
            if (e.indexOf(".baidu.com") != -1 && (lastIndexOf = e.lastIndexOf("/")) != -1 && (indexOf = e.indexOf(".", lastIndexOf)) != -1) {
                return e.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return e;
    }
}
