package com.baidu.tieba.pb;

import android.text.InputFilter;
import android.text.Spanned;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ImagePbActivity imagePbActivity) {
        this.f2281a = imagePbActivity;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        boolean g;
        g = this.f2281a.g();
        if (g) {
            if (charSequence.length() <= 0 && spanned.length() > 0) {
                return spanned.subSequence(i3, i4 - 1);
            }
            return "";
        }
        return null;
    }
}
