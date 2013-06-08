package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
public class j {
    public String a;
    public String b;

    public j(String str, String str2) {
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
            j jVar = (j) obj;
            if (this.a == null) {
                if (jVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(jVar.a)) {
                return false;
            }
            return this.b == null ? jVar.b == null : this.b.equals(jVar.b);
        }
        return false;
    }
}
