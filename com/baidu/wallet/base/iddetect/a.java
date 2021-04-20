package com.baidu.wallet.base.iddetect;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public int f23326a;

    /* renamed from: b  reason: collision with root package name */
    public int f23327b;

    /* renamed from: c  reason: collision with root package name */
    public float f23328c;

    /* renamed from: d  reason: collision with root package name */
    public float f23329d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23330e = false;

    public a(int i, int i2) {
        this.f23326a = i;
        this.f23327b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (this.f23330e) {
            return this.f23329d < aVar.f23329d ? -1 : 1;
        }
        int i = this.f23327b;
        int i2 = aVar.f23327b;
        if (i < i2) {
            return -1;
        }
        return (i <= i2 && this.f23326a < aVar.f23326a) ? -1 : 1;
    }
}
