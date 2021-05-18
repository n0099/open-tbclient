package com.baidu.wallet.base.iddetect;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public int f23299a;

    /* renamed from: b  reason: collision with root package name */
    public int f23300b;

    /* renamed from: c  reason: collision with root package name */
    public float f23301c;

    /* renamed from: d  reason: collision with root package name */
    public float f23302d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23303e = false;

    public a(int i2, int i3) {
        this.f23299a = i2;
        this.f23300b = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (this.f23303e) {
            return this.f23302d < aVar.f23302d ? -1 : 1;
        }
        int i2 = this.f23300b;
        int i3 = aVar.f23300b;
        if (i2 < i3) {
            return -1;
        }
        return (i2 <= i3 && this.f23299a < aVar.f23299a) ? -1 : 1;
    }
}
