package com.baidu.wallet.base.iddetect;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public int f24054a;

    /* renamed from: b  reason: collision with root package name */
    public int f24055b;

    /* renamed from: c  reason: collision with root package name */
    public float f24056c;

    /* renamed from: d  reason: collision with root package name */
    public float f24057d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24058e = false;

    public a(int i2, int i3) {
        this.f24054a = i2;
        this.f24055b = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (this.f24058e) {
            return this.f24057d < aVar.f24057d ? -1 : 1;
        }
        int i2 = this.f24055b;
        int i3 = aVar.f24055b;
        if (i2 < i3) {
            return -1;
        }
        return (i2 <= i3 && this.f24054a < aVar.f24054a) ? -1 : 1;
    }
}
