package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class bi implements com.baidu.tbadk.core.util.bm {
    Pattern bIE = Pattern.compile("http://tieba.baidu.com/p/([\\d]+)");

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L25;
     */
    @Override // com.baidu.tbadk.core.util.bm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String substring;
        String str;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return false;
        }
        String lowerCase = strArr[0].toLowerCase();
        Matcher matcher = this.bIE.matcher(lowerCase);
        if (matcher.find()) {
            substring = matcher.group(1);
            str = "allthread";
        } else if (lowerCase != null && lowerCase.startsWith("http://tieba.baidu.com/f?")) {
            String substring2 = lowerCase.substring("http://tieba.baidu.com/f?".length());
            if (substring2 != null) {
                String[] split = substring2.split("&");
                if (!substring2.startsWith("kz=")) {
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
                } else {
                    substring = substring2.substring(3);
                }
            }
            substring = null;
            str = "allthread";
        } else if (!lowerCase.startsWith("pb:")) {
            return false;
        } else {
            substring = lowerCase.substring(3);
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
