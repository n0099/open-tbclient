package com.baidu.tieba.voice.service;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class i implements Parcelable.Creator<Voice> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Voice[] newArray(int i) {
        return new Voice[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Voice createFromParcel(Parcel parcel) {
        Voice voice = new Voice();
        voice.a((int) parcel.readLong());
        voice.a(parcel.readString());
        return voice;
    }
}
