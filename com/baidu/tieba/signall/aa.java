package com.baidu.tieba.signall;
/* loaded from: classes.dex */
public final class aa extends com.baidu.adp.a.e {
    private String a = null;
    private String b = null;
    private ac c = null;
    private ab d;

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public final void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.c == null) {
            this.a = str;
            this.b = str2;
            this.c = new ac(this, (byte) 0);
            this.c.setPriority(2);
            this.c.execute(new Object[0]);
        }
    }

    public final void a(ab abVar) {
        this.d = abVar;
    }
}
