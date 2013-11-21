package com.baidu.tieba.motu_gallery;

import android.net.Uri;
import android.provider.MediaStore;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f2005a;
    public String b;
    public int c;
    public Uri d;

    public c(int i, String str, int i2) {
        this.f2005a = i;
        this.b = str;
        this.c = i2;
        this.d = Uri.parse(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI) + "/" + String.valueOf(this.c));
    }
}
