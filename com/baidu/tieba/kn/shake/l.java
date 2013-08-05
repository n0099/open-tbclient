package com.baidu.tieba.kn.shake;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public float f1257a;
    public float b;
    public float c;

    public l() {
        this.f1257a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
    }

    public l(float f, float f2, float f3) {
        this.f1257a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.f1257a = f;
        this.b = f2;
        this.c = f3;
    }

    public float a(l lVar) {
        return 0.0f + (lVar.f1257a * this.f1257a) + (lVar.b * this.b) + (lVar.c * this.c);
    }

    public float a() {
        return (float) Math.sqrt((this.f1257a * this.f1257a) + (this.b * this.b) + (this.c * this.c));
    }

    public String toString() {
        return String.valueOf(String.valueOf(this.f1257a)) + " " + String.valueOf(this.b) + " " + String.valueOf(this.c) + " " + String.valueOf(a()) + "\n";
    }

    public float b(l lVar) {
        if (lVar == null) {
            return 0.0f;
        }
        float a2 = a(lVar);
        float a3 = a() * lVar.a();
        if (a3 > 0.01f) {
            return (float) Math.acos(a2 / a3);
        }
        return 0.0f;
    }
}
