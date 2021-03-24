package com.baidu.wallet.base.a;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.wallet.core.utils.LogUtil;
import java.net.URLDecoder;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            for (String str3 : str.split("&")) {
                String[] split = str3.split("=");
                if (split != null && !TextUtils.isEmpty(split[0]) && str2.equalsIgnoreCase(split[0]) && split.length > 1) {
                    return URLDecoder.decode(split[1]);
                }
            }
            return "";
        } catch (Exception e2) {
            LogUtil.d(e2.toString());
            return "";
        }
    }

    public static ArrayList<String> a(String str, String... strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            arrayList.add(a(str, PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID));
            arrayList.add(a(str, "order_no"));
            for (int i = 0; i < strArr.length; i++) {
                if (!TextUtils.isEmpty(strArr[i])) {
                    arrayList.add(strArr[i]);
                } else {
                    arrayList.add(SchemeCollecter.CLASSIFY_EMPTY);
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
