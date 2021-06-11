package com.baidu.wallet.base.widget.textfilter;

import java.util.List;
/* loaded from: classes5.dex */
public class IDCardEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23883a = "IDCardEditTextPasteFilter";

    @Override // com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, "[0-9xX]+");
        StringBuilder sb = new StringBuilder();
        if (regxParse != null && regxParse.size() > 0) {
            for (String str2 : regxParse) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
