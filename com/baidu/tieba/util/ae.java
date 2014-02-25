package com.baidu.tieba.util;
/* loaded from: classes.dex */
public class ae {
    private StringBuilder a;

    public ae() {
        this.a = null;
        this.a = null;
    }

    public void a(String str, Object obj) {
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
                com.baidu.adp.lib.util.f.b("FieldBuilder", "append", e.getMessage());
            }
        }
    }

    public void a(ae aeVar) {
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

    public String toString() {
        return this.a != null ? this.a.toString() : "";
    }
}
