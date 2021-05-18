package com.baidu.wallet.base.widget.textfilter;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes5.dex */
public class NumberEditTextPasteFilter implements IEditTextPasteFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23852a = "NumberEditTextPasteFilter";

    @Override // com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, "[0-9]+");
        if (regxParse == null || regxParse.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : regxParse) {
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
