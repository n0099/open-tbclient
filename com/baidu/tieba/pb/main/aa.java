package com.baidu.tieba.pb.main;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.core.util.bk {
    @Override // com.baidu.tbadk.core.util.bk
    public boolean a(Context context, String[] strArr) {
        String str;
        String str2;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str3 = strArr[0];
        if (str3.startsWith("pb:")) {
            String substring = str3.substring(3);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            if (strArr.length > 1) {
                str = strArr[1];
                str2 = substring;
            } else {
                str2 = substring;
                str = null;
            }
        } else if (!str3.startsWith("tieba.baidu.com/p/")) {
            return false;
        } else {
            String substring2 = str3.substring(str3.indexOf("tieba.baidu.com/p/") + "tieba.baidu.com/p/".length());
            if (TextUtils.isEmpty(substring2)) {
                return false;
            }
            str = "allthread";
            str2 = substring2;
        }
        if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).a(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(context).a(str2, null, str)));
            return true;
        } else if (context instanceof BaseActivity) {
            ((BaseActivity) context).sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(context).a(str2, null, str)));
            return true;
        } else {
            return false;
        }
    }
}
