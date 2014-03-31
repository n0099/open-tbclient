package com.baidu.tieba.pb.image;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes.dex */
final class j implements InputFilter {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        boolean a;
        a = this.a.a();
        if (a) {
            if (charSequence.length() <= 0 && spanned.length() > 0) {
                return spanned.subSequence(i3, i4 - 1);
            }
            return "";
        }
        return null;
    }
}
