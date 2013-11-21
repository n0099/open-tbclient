package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    public String f2289a;
    public String b;

    public ad(String str, String str2) {
        this.f2289a = "";
        this.b = "";
        this.f2289a = str;
        this.b = str2;
    }

    public int hashCode() {
        return (((this.f2289a == null ? 0 : this.f2289a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ad adVar = (ad) obj;
            if (this.f2289a == null) {
                if (adVar.f2289a != null) {
                    return false;
                }
            } else if (!this.f2289a.equals(adVar.f2289a)) {
                return false;
            }
            return this.b == null ? adVar.b == null : this.b.equals(adVar.b);
        }
        return false;
    }
}
