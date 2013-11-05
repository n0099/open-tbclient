package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    public String f2271a;
    public String b;

    public af(String str, String str2) {
        this.f2271a = "";
        this.b = "";
        this.f2271a = str;
        this.b = str2;
    }

    public int hashCode() {
        return (((this.f2271a == null ? 0 : this.f2271a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            af afVar = (af) obj;
            if (this.f2271a == null) {
                if (afVar.f2271a != null) {
                    return false;
                }
            } else if (!this.f2271a.equals(afVar.f2271a)) {
                return false;
            }
            return this.b == null ? afVar.b == null : this.b.equals(afVar.b);
        }
        return false;
    }
}
