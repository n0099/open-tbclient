package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class bg implements com.baidu.tbadk.core.util.bk {
    Pattern bKZ = Pattern.compile("http://tieba.baidu.com/p/([\\d]+)");

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L37;
     */
    @Override // com.baidu.tbadk.core.util.bk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String substring;
        String str;
        boolean z;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return false;
        }
        String lowerCase = strArr[0].toLowerCase();
        Matcher matcher = this.bKZ.matcher(lowerCase);
        if (matcher.find()) {
            substring = matcher.group(1);
            str = "allthread";
            z = false;
        } else if (lowerCase != null && lowerCase.startsWith("http://tieba.baidu.com/f?")) {
            String substring2 = lowerCase.substring("http://tieba.baidu.com/f?".length());
            if (substring2 != null) {
                String[] split = substring2.split("&");
                int i = 0;
                while (true) {
                    if (i < split.length) {
                        if (split[i] == null || !split[i].startsWith("kz=")) {
                            i++;
                        } else {
                            substring = split[i].substring(3);
                            break;
                        }
                    } else {
                        substring = null;
                        break;
                    }
                }
            }
            substring = null;
            str = "allthread";
            z = false;
        } else if (!lowerCase.startsWith("pb:")) {
            if (!lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                return false;
            }
            substring = lowerCase.substring("com.baidu.tieba://?kz=".length());
            str = null;
            z = true;
        } else {
            substring = lowerCase.substring(3);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            if (strArr.length > 1) {
                str = strArr[1];
                z = false;
            } else {
                str = null;
                z = false;
            }
        }
        if (tbPageContext != null) {
            tbPageContext.sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(substring, null, str)));
            return true;
        } else if (!z || TextUtils.isEmpty(substring)) {
            return false;
        } else {
            com.baidu.adp.lib.g.j.f(TbadkCoreApplication.m411getInst(), cg.K(TbadkCoreApplication.m411getInst(), substring));
            return true;
        }
    }
}
