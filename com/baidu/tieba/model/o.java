package com.baidu.tieba.model;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private int f1376a = 1;
    private p b = null;
    private q c = null;
    private s d = null;
    private com.baidu.tieba.data.ae e = null;
    private com.baidu.tieba.data.ac f = null;
    private r g = null;
    private int h = 1;

    public void a(r rVar) {
        this.g = rVar;
    }

    public com.baidu.tieba.data.ae a() {
        String str;
        String[] split;
        com.baidu.adp.lib.cache.q bm = TiebaApplication.f().bm();
        if (bm == null || (str = (String) bm.a("home_tag")) == null || str.length() <= 0 || (split = str.split(",")) == null || split.length <= 1) {
            return null;
        }
        com.baidu.tieba.data.bl blVar = new com.baidu.tieba.data.bl();
        blVar.a(split[0]);
        blVar.b(split[1]);
        com.baidu.tieba.data.ae aeVar = new com.baidu.tieba.data.ae();
        aeVar.a().add(blVar);
        return aeVar;
    }

    public com.baidu.tieba.data.ac b() {
        com.baidu.adp.lib.cache.q bm = TiebaApplication.f().bm();
        if (bm != null) {
            com.baidu.tieba.data.ac acVar = new com.baidu.tieba.data.ac();
            acVar.a((String) bm.a("home_interest"));
            return acVar;
        }
        return null;
    }

    public void a(String str, String str2, int i) {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.f1376a = i;
        if (i == 1) {
            this.h = 1;
        } else if (i == 2) {
            this.h++;
        }
        this.b = new p(this, str, str2, String.valueOf(this.h));
        this.b.setPriority(3);
        this.b.execute(new Object[0]);
    }

    public void c() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.c = new q(this);
        this.c.setPriority(3);
        this.c.execute(new Object[0]);
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str) {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        this.d = new s(this, str);
        this.d.setPriority(3);
        this.d.execute(new String[0]);
    }
}
