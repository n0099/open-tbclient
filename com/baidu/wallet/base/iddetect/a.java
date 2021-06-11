package com.baidu.wallet.base.iddetect;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public int f23331a;

    /* renamed from: b  reason: collision with root package name */
    public int f23332b;

    /* renamed from: c  reason: collision with root package name */
    public float f23333c;

    /* renamed from: d  reason: collision with root package name */
    public float f23334d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23335e = false;

    public a(int i2, int i3) {
        this.f23331a = i2;
        this.f23332b = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (this.f23335e) {
            return this.f23334d < aVar.f23334d ? -1 : 1;
        }
        int i2 = this.f23332b;
        int i3 = aVar.f23332b;
        if (i2 < i3) {
            return -1;
        }
        return (i2 <= i3 && this.f23331a < aVar.f23331a) ? -1 : 1;
    }
}
