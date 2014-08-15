package com.baidu.tieba.pb.main;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.core.util.bi {
    Pattern a = Pattern.compile("http://tieba.baidu.com/p/([\\d]+)");
    Pattern b = Pattern.compile("http://tieba.baidu.com/f\\?kz=([\\d]+)");

    @Override // com.baidu.tbadk.core.util.bi
    public boolean a(Context context, String[] strArr) {
        String str;
        String str2;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str3 = strArr[0];
        Matcher matcher = this.a.matcher(str3);
        Matcher matcher2 = this.b.matcher(str3);
        if (matcher.find()) {
            str2 = "allthread";
            str = matcher.group(1);
        } else if (matcher2.find()) {
            String group = matcher2.group(1);
            str2 = "allthread";
            str = group;
        } else if (!str3.startsWith("pb:")) {
            return false;
        } else {
            String substring = str3.substring(3);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            if (strArr.length > 1) {
                str2 = strArr[1];
                str = substring;
            } else {
                str = substring;
                str2 = null;
            }
        }
        if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).a(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bb(context).a(str, null, str2)));
            return true;
        } else if (context instanceof BaseActivity) {
            ((BaseActivity) context).sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bb(context).a(str, null, str2)));
            return true;
        } else {
            return false;
        }
    }
}
