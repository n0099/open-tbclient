package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
public class bg {

    /* renamed from: a  reason: collision with root package name */
    public String f1659a;
    public String b;

    public bg(String str, String str2) {
        this.f1659a = "";
        this.b = "";
        this.f1659a = str;
        this.b = str2;
    }

    public int hashCode() {
        return (((this.f1659a == null ? 0 : this.f1659a.hashCode()) + 31) * 31) + (this.b != null ? this.b.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            bg bgVar = (bg) obj;
            if (this.f1659a == null) {
                if (bgVar.f1659a != null) {
                    return false;
                }
            } else if (!this.f1659a.equals(bgVar.f1659a)) {
                return false;
            }
            return this.b == null ? bgVar.b == null : this.b.equals(bgVar.b);
        }
        return false;
    }
}
