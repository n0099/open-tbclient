package com.baidu.tieba;

import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.lib.a.a {
    ArrayList a;
    final /* synthetic */ LabelActivity b;
    private String d;
    private boolean f;
    private com.baidu.tieba.d.t c = null;
    private int e = 1;

    public w(LabelActivity labelActivity, String str, boolean z, ArrayList arrayList) {
        this.b = labelActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        this.b.b(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        com.baidu.tieba.c.ac acVar;
        com.baidu.tieba.c.ac acVar2;
        com.baidu.tieba.c.ac acVar3;
        com.baidu.tieba.c.ac acVar4;
        com.baidu.tieba.c.ac acVar5;
        com.baidu.tieba.c.ac acVar6;
        try {
            this.c = new com.baidu.tieba.d.t(this.d);
            this.c.a(this.a);
            acVar = this.b.q;
            if (acVar != null) {
                acVar5 = this.b.q;
                if (acVar5.h().size() != 0) {
                    acVar6 = this.b.q;
                    this.c.a("tag_info", acVar6.g());
                }
            }
            com.baidu.tieba.d.ae.b("begin to get label data...url is " + this.d);
            String i = this.c.i();
            com.baidu.tieba.d.ae.b("end to get label data...");
            if (this.c.b()) {
                acVar2 = this.b.q;
                if (acVar2 == null) {
                    this.b.q = new com.baidu.tieba.c.ac();
                }
                acVar3 = this.b.q;
                acVar3.a(i);
                if (this.f) {
                    acVar4 = this.b.q;
                    acVar4.b(com.baidu.tieba.d.k.b(12));
                }
                com.baidu.tieba.d.ae.a(getClass().getName(), "doInBackground", i);
                System.gc();
            }
            if (this.c.c()) {
                this.e = 0;
            } else {
                this.e = 1;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "LabelAsyncTask.doInBackground error = " + e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        this.b.b(false);
        if (bool.booleanValue() && this.e != 1) {
            this.b.o();
            this.b.c(false);
        } else {
            e();
        }
        this.b.M = null;
        System.gc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }

    private void e() {
        this.b.a(this.c.f());
    }
}
