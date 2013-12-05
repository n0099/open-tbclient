package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private String f1998a = null;
    private String b = null;
    private az c = null;
    private String d;

    public void a(String str) {
        this.d = str;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
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
            this.f1998a = str;
            this.b = str2;
            this.c = new az(this);
            this.c.setPriority(2);
            this.c.execute(new Object[0]);
        }
    }

    public boolean b() {
        return this.c != null;
    }
}
