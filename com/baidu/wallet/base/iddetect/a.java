package com.baidu.wallet.base.iddetect;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public int f23641a;

    /* renamed from: b  reason: collision with root package name */
    public int f23642b;

    /* renamed from: c  reason: collision with root package name */
    public float f23643c;

    /* renamed from: d  reason: collision with root package name */
    public float f23644d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23645e = false;

    public a(int i, int i2) {
        this.f23641a = i;
        this.f23642b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (this.f23645e) {
            return this.f23644d < aVar.f23644d ? -1 : 1;
        }
        int i = this.f23642b;
        int i2 = aVar.f23642b;
        if (i < i2) {
            return -1;
        }
        return (i <= i2 && this.f23641a < aVar.f23641a) ? -1 : 1;
    }
}
