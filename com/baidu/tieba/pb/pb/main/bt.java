package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.n;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class bt implements bf.a {
    Pattern cGi = Pattern.compile("http://tieba.baidu.com/p/([\\d]+)");

    @Override // com.baidu.tbadk.core.util.bf.a
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String substring;
        boolean z;
        String str;
        boolean z2;
        String str2;
        boolean z3 = false;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return false;
        }
        String lowerCase = strArr[0].toLowerCase();
        Matcher matcher = this.cGi.matcher(lowerCase);
        String str3 = "";
        if (matcher.find()) {
            String group = matcher.group(1);
            str = "allthread";
            if (lowerCase != null) {
                String[] split = lowerCase.split("&");
                for (int i = 0; i < split.length; i++) {
                    if (split[i] != null && split[i].startsWith("thread_type=")) {
                        str2 = split[i].substring("thread_type=".length());
                        break;
                    }
                }
            }
            str2 = "";
            str3 = str2;
            z2 = false;
            substring = group;
            z = true;
        } else if (lowerCase != null && lowerCase.startsWith("http://tieba.baidu.com/f?")) {
            String substring2 = lowerCase.substring("http://tieba.baidu.com/f?".length());
            if (substring2 != null) {
                String[] split2 = substring2.split("&");
                int i2 = 0;
                while (true) {
                    if (i2 >= split2.length) {
                        substring = null;
                        z = false;
                        break;
                    } else if (split2[i2] == null || !split2[i2].startsWith("kz=")) {
                        i2++;
                    } else {
                        substring = split2[i2].substring(3);
                        z = true;
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
            if (!StringUtils.isNull(str3) && com.baidu.adp.lib.h.b.g(str3, 0) == 33 && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                z3 = true;
            }
            if (z3) {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(tbPageContext.getPageActivity(), substring).rf()));
            } else {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(substring, null, str)));
            }
            return true;
        } else if (z2 && !TextUtils.isEmpty(substring)) {
            com.baidu.adp.lib.h.i.f(TbadkCoreApplication.m411getInst(), dj.L(TbadkCoreApplication.m411getInst(), substring));
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10320").r("obj_locate", 3).r("obj_type", 2));
            return true;
        } else if (z) {
            tbPageContext.showToast(n.j.page_not_found);
            return true;
        } else {
            return false;
        }
    }
}
