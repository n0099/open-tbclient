package com.baidu.wallet.base.widget.textfilter;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class PhoneNumberEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23782a = "PhoneNumberEditTextPasteFilter";

    /* renamed from: b  reason: collision with root package name */
    public static final String f23783b = "86";

    @Override // com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("86") ? str.substring(2) : str;
    }
}
