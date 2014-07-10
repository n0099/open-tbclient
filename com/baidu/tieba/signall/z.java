package com.baidu.tieba.signall;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.e {
    private String a = null;
    private String b = null;
    private ab c = null;
    private aa d;

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
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
            this.c = new ab(this, null);
            this.c.setPriority(2);
            this.c.execute(new Object[0]);
        }
    }

    public void a(aa aaVar) {
        this.d = aaVar;
    }
}
