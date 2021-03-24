package com.baidu.wallet.base.iddetect;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public int f23640a;

    /* renamed from: b  reason: collision with root package name */
    public int f23641b;

    /* renamed from: c  reason: collision with root package name */
    public float f23642c;

    /* renamed from: d  reason: collision with root package name */
    public float f23643d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23644e = false;

    public a(int i, int i2) {
        this.f23640a = i;
        this.f23641b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (this.f23644e) {
            return this.f23643d < aVar.f23643d ? -1 : 1;
        }
        int i = this.f23641b;
        int i2 = aVar.f23641b;
        if (i < i2) {
            return -1;
        }
        return (i <= i2 && this.f23640a < aVar.f23640a) ? -1 : 1;
    }
}
