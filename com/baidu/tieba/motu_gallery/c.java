package com.baidu.tieba.motu_gallery;

import android.net.Uri;
import android.provider.MediaStore;
/* loaded from: classes.dex */
public class c {
    public int a;
    public String b;
    public int c;
    public Uri d;

    public c(int i, String str, int i2) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = Uri.parse(String.valueOf(String.valueOf(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)) + "/" + String.valueOf(this.c));
    }
}
