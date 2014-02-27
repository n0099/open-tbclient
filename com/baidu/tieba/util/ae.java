package com.baidu.tieba.util;
/* loaded from: classes.dex */
public final class ae {
    private StringBuilder a;

    public ae() {
        this.a = null;
        this.a = null;
    }

    public final void a(String str, Object obj) {
        if (!bs.c(str) && obj != null) {
            try {
                if (this.a == null) {
                    this.a = new StringBuilder();
                    this.a.append(str);
                    this.a.append("=");
                    this.a.append(obj.toString());
                } else {
                    this.a.append("|");
                    this.a.append(str);
                    this.a.append("=");
                    this.a.append(obj.toString());
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("FieldBuilder", "append", e.getMessage());
            }
        }
    }

    public final void a(ae aeVar) {
        if (aeVar != null) {
            if (this.a == null) {
                this.a = new StringBuilder();
                this.a.append(aeVar.toString());
                return;
            }
            this.a.append("|");
            this.a.append(aeVar.toString());
        }
    }

    public final String toString() {
        return this.a != null ? this.a.toString() : "";
    }
}
