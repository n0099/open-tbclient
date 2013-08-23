package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    public String f1676a;
    public String b;

    public af(String str, String str2) {
        this.f1676a = "";
        this.b = "";
        this.f1676a = str;
        this.b = str2;
    }

    public int hashCode() {
        return (((this.f1676a == null ? 0 : this.f1676a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            af afVar = (af) obj;
            if (this.f1676a == null) {
                if (afVar.f1676a != null) {
                    return false;
                }
            } else if (!this.f1676a.equals(afVar.f1676a)) {
                return false;
            }
            return this.b == null ? afVar.b == null : this.b.equals(afVar.b);
        }
        return false;
    }
}
