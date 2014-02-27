package com.baidu.tieba.voice.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Voice implements Parcelable {
    public static final Parcelable.Creator<Voice> CREATOR = new i();
    private String a;
    private int b;

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final int b() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeString(this.a);
    }
}
