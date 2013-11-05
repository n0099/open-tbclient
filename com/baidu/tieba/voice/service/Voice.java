package com.baidu.tieba.voice.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Voice implements Parcelable {
    public static final Parcelable.Creator<Voice> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private String f2585a;
    private int b;

    public String a() {
        return this.f2585a;
    }

    public void a(String str) {
        this.f2585a = str;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeString(this.f2585a);
    }
}
