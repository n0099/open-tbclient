package com.baidu.tieba.recapp.download.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class b {
    public String downloadKey;
    public int installStatus;
    public long lOR;
    public long mUY;
    public int mUZ;
    public String mVa;
    public String mVb;
    public String mVc;
    public String mVd;
    public String mVe;
    public String packageName;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.downloadKey, bVar.downloadKey) && TextUtils.equals(this.packageName, bVar.packageName);
        }
        return false;
    }

    public int hashCode() {
        return (this.downloadKey + this.packageName).hashCode();
    }
}
