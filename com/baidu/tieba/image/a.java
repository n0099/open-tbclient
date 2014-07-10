package com.baidu.tieba.image;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.data.v;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> a;
    private String d;
    private String e;
    private String f;
    private boolean l;
    private String b = null;
    private String c = null;
    private boolean g = false;
    private boolean h = true;
    private b i = null;
    private int j = 0;
    private boolean k = false;
    private c m = null;
    private HashMap<String, String> n = new HashMap<>();

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.a = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.l = false;
        this.a = arrayList;
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.a.get(i);
            this.n.put(a(str4), str4);
        }
        this.d = str2;
        this.e = str;
        this.f = str3;
        if (this.f == null) {
            this.l = true;
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a() {
        if (!this.g && !this.l) {
            a(this.d, this.f, 10, 0);
        }
    }

    public void b() {
        if (!this.l) {
            if (!this.g) {
                a();
            } else if (this.b != null && this.b.length() > 0) {
                this.h = true;
                a(this.b, null, 0, 10);
            }
        }
    }

    private void a(String str, String str2, int i, int i2) {
        if (this.i != null) {
            if (str2 == null || !str2.equals(this.i.a())) {
                this.i.cancel();
            } else {
                return;
            }
        }
        this.i = new b(this, str, str2, i, i2);
        this.i.setPriority(3);
        this.i.execute(new Object[0]);
    }

    public void a(c cVar) {
        this.m = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(v vVar) {
        if (vVar.j() != null && vVar.j().length() > 0) {
            return vVar.j();
        }
        StringBuilder sb = new StringBuilder(150);
        if (vVar.g() * vVar.f() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
            double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (vVar.g() * vVar.f()));
            sb.append("width=");
            sb.append(String.valueOf((int) (vVar.f() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * vVar.g())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(vVar.f()));
            sb.append("&height=");
            sb.append(String.valueOf(vVar.g()));
        }
        sb.append("&src=");
        sb.append(bm.d(vVar.b()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        int lastIndexOf;
        int indexOf;
        String e = bm.e(str);
        if (e != null) {
            if (e.indexOf(".baidu.com") != -1 && (lastIndexOf = e.lastIndexOf("/")) != -1 && (indexOf = e.indexOf(".", lastIndexOf)) != -1) {
                return e.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return e;
    }
}
