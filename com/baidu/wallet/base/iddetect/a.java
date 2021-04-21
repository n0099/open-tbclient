package com.baidu.wallet.base.iddetect;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public int f23334a;

    /* renamed from: b  reason: collision with root package name */
    public int f23335b;

    /* renamed from: c  reason: collision with root package name */
    public float f23336c;

    /* renamed from: d  reason: collision with root package name */
    public float f23337d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23338e = false;

    public a(int i, int i2) {
        this.f23334a = i;
        this.f23335b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (this.f23338e) {
            return this.f23337d < aVar.f23337d ? -1 : 1;
        }
        int i = this.f23335b;
        int i2 = aVar.f23335b;
        if (i < i2) {
            return -1;
        }
        return (i <= i2 && this.f23334a < aVar.f23334a) ? -1 : 1;
    }
}
