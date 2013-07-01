package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f1392a;
    public String b;

    public j(String str, String str2) {
        this.f1392a = "";
        this.b = "";
        this.f1392a = str;
        this.b = str2;
    }

    public int hashCode() {
        return (((this.f1392a == null ? 0 : this.f1392a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            j jVar = (j) obj;
            if (this.f1392a == null) {
                if (jVar.f1392a != null) {
                    return false;
                }
            } else if (!this.f1392a.equals(jVar.f1392a)) {
                return false;
            }
            return this.b == null ? jVar.b == null : this.b.equals(jVar.b);
        }
        return false;
    }
}
