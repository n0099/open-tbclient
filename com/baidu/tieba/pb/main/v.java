package com.baidu.tieba.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.core.util.bj {
    Pattern bzk = Pattern.compile("http://tieba.baidu.com/p/([\\d]+)");
    Pattern bzl = Pattern.compile("http://tieba.baidu.com/f\\?kz=([\\d]+)");

    @Override // com.baidu.tbadk.core.util.bj
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String substring;
        String str;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str2 = strArr[0];
        Matcher matcher = this.bzk.matcher(str2);
        Matcher matcher2 = this.bzl.matcher(str2);
        if (matcher.find()) {
            substring = matcher.group(1);
            str = "allthread";
        } else if (matcher2.find()) {
            substring = matcher2.group(1);
            str = "allthread";
        } else if (!str2.startsWith("pb:")) {
            return false;
        } else {
            substring = str2.substring(3);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            str = strArr.length > 1 ? strArr[1] : null;
        }
        if (tbPageContext != null) {
            tbPageContext.sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(substring, null, str)));
            return true;
        }
        return false;
    }
}
