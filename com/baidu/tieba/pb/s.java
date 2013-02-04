package com.baidu.tieba.pb;

import android.text.InputFilter;
import android.text.Spanned;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements InputFilter {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        boolean m;
        m = this.a.m();
        if (m) {
            return (charSequence.length() > 0 || spanned.length() <= 0) ? "" : spanned.subSequence(i3, i4 - 1);
        }
        return null;
    }
}
