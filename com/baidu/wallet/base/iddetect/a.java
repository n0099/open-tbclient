package com.baidu.wallet.base.iddetect;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public int f23413a;

    /* renamed from: b  reason: collision with root package name */
    public int f23414b;

    /* renamed from: c  reason: collision with root package name */
    public float f23415c;

    /* renamed from: d  reason: collision with root package name */
    public float f23416d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23417e = false;

    public a(int i2, int i3) {
        this.f23413a = i2;
        this.f23414b = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (this.f23417e) {
            return this.f23416d < aVar.f23416d ? -1 : 1;
        }
        int i2 = this.f23414b;
        int i3 = aVar.f23414b;
        if (i2 < i3) {
            return -1;
        }
        return (i2 <= i3 && this.f23413a < aVar.f23413a) ? -1 : 1;
    }
}
