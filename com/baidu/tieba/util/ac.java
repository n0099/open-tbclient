package com.baidu.tieba.util;
/* loaded from: classes.dex */
public class ac {
    private StringBuilder a;

    public ac() {
        this.a = null;
        this.a = null;
    }

    public void a(String str, Object obj) {
        if (!bu.c(str) && obj != null) {
            if (this.a == null) {
                this.a = new StringBuilder();
                this.a.append(str);
                this.a.append("=");
                this.a.append(obj.toString());
                return;
            }
            this.a.append("|");
            this.a.append(str);
            this.a.append("=");
            this.a.append(obj.toString());
        }
    }

    public void a(ac acVar) {
        if (acVar != null) {
            if (this.a == null) {
                this.a = new StringBuilder();
                this.a.append(acVar.toString());
                return;
            }
            this.a.append("|");
            this.a.append(acVar.toString());
        }
    }

    public String toString() {
        return this.a != null ? this.a.toString() : "";
    }
}
