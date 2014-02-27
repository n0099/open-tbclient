package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
public final class ac {
    public String a;
    public String b;

    public ac(String str, String str2) {
        this.a = "";
        this.b = "";
        this.a = str;
        this.b = str2;
    }

    public final int hashCode() {
        return (((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ac acVar = (ac) obj;
            if (this.a == null) {
                if (acVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(acVar.a)) {
                return false;
            }
            return this.b == null ? acVar.b == null : this.b.equals(acVar.b);
        }
        return false;
    }
}
