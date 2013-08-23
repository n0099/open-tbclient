package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private String f1368a = null;
    private String b = null;
    private ar c = null;
    private String d;

    public void a(String str) {
        this.d = str;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }

    public void a() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.c == null) {
            this.f1368a = str;
            this.b = str2;
            this.c = new ar(this, null);
            this.c.setPriority(2);
            this.c.execute(new Object[0]);
        }
    }

    public boolean b() {
        return this.c != null;
    }
}
