package com.baidu.tieba.model;
/* loaded from: classes.dex */
public class cc extends com.baidu.adp.a.d {
    private String a = null;
    private String b = null;
    private ce c = null;

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
            this.a = str;
            this.b = str2;
            this.c = new ce(this);
            this.c.setPriority(2);
            this.c.execute(new Object[0]);
        }
    }
}
