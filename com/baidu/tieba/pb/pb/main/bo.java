package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.i;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class bo implements az.a {
    Pattern cjY = Pattern.compile("http://tieba.baidu.com/p/([\\d]+)");

    @Override // com.baidu.tbadk.core.util.az.a
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String substring;
        boolean z;
        String str;
        boolean z2;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return false;
        }
        String lowerCase = strArr[0].toLowerCase();
        Matcher matcher = this.cjY.matcher(lowerCase);
        if (matcher.find()) {
            substring = matcher.group(1);
            str = "allthread";
            z2 = false;
            z = true;
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
                            z = true;
                            break;
                        }
                    } else {
                        substring = null;
                        z = false;
                        break;
                    }
                }
                if (!TextUtils.isEmpty(substring) && substring.contains("&")) {
                    substring = substring.split("&")[0];
                }
                if (TextUtils.isEmpty(substring)) {
                    substring = null;
                }
            } else {
                z = false;
                substring = null;
            }
            str = "allthread";
            z2 = false;
        } else if (!lowerCase.startsWith("pb:")) {
            if (!lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                return false;
            }
            substring = lowerCase.substring("com.baidu.tieba://?kz=".length());
            z = false;
            str = null;
            z2 = true;
        } else {
            substring = lowerCase.substring(3);
            if (strArr.length > 1) {
                str = strArr[1];
                z2 = false;
                z = true;
            } else {
                z = true;
                str = null;
                z2 = false;
            }
        }
        if (!StringUtils.isNull(substring, true) && tbPageContext != null) {
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(substring, null, str)));
            return true;
        } else if (z2 && !TextUtils.isEmpty(substring)) {
            com.baidu.adp.lib.g.i.f(TbadkCoreApplication.m411getInst(), cs.L(TbadkCoreApplication.m411getInst(), substring));
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10320").r("obj_locate", 3).r("obj_type", 2));
            return true;
        } else if (z) {
            tbPageContext.showToast(i.h.page_not_found);
            return true;
        } else {
            return false;
        }
    }
}
