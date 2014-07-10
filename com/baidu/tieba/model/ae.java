package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.e {
    private String a = null;
    private String b = null;
    private String c = null;
    private af d = null;
    private String e;

    public void a(String str) {
        this.e = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    public void a(String str, String str2, String str3) {
        a(str, str2);
        this.c = str3;
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.d == null) {
            this.a = str;
            this.b = str2;
            this.d = new af(this, null);
            this.d.setPriority(2);
            this.d.execute(new Object[0]);
        }
    }

    public boolean b() {
        return this.d != null;
    }
}
