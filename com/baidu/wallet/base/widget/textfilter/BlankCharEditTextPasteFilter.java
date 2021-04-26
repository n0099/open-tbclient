package com.baidu.wallet.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class BlankCharEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24604a = "BlankCharEditTextPasteFilter";

    @Override // com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll("\\s", "") : "";
    }
}
