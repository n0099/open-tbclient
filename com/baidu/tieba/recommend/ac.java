package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public String f2406a;
    public String b;

    public ac(String str, String str2) {
        this.f2406a = "";
        this.b = "";
        this.f2406a = str;
        this.b = str2;
    }

    public int hashCode() {
        return (((this.f2406a == null ? 0 : this.f2406a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ac acVar = (ac) obj;
            if (this.f2406a == null) {
                if (acVar.f2406a != null) {
                    return false;
                }
            } else if (!this.f2406a.equals(acVar.f2406a)) {
                return false;
            }
            return this.b == null ? acVar.b == null : this.b.equals(acVar.b);
        }
        return false;
    }
}
