package com.baidu.tieba.model;
/* loaded from: classes.dex */
public final class af extends com.baidu.adp.a.e {
    private String a = null;
    private String b = null;
    private String c = null;
    private ag d = null;
    private String e;

    public final void a(String str) {
        this.e = str;
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    public final void a(String str, String str2, String str3) {
        a(str, str2);
        this.c = str3;
    }

    public final void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.d == null) {
            this.a = str;
            this.b = str2;
            this.d = new ag(this, (byte) 0);
            this.d.setPriority(2);
            this.d.execute(new Object[0]);
        }
    }

    public final boolean b() {
        return this.d != null;
    }
}
