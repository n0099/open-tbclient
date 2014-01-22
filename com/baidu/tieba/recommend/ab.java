package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
public class ab {
    public String a;
    public String b;

    public ab(String str, String str2) {
        this.a = "";
        this.b = "";
        this.a = str;
        this.b = str2;
    }

    public int hashCode() {
        return (((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ab abVar = (ab) obj;
            if (this.a == null) {
                if (abVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(abVar.a)) {
                return false;
            }
            return this.b == null ? abVar.b == null : this.b.equals(abVar.b);
        }
        return false;
    }
}
