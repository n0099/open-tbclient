package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.u;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class cg implements bi.a {
    Pattern dPX = Pattern.compile("http://tieba.baidu.com/p/([\\d]+)");

    @Override // com.baidu.tbadk.core.util.bi.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        String as;
        boolean z;
        String str;
        boolean z2;
        String str2;
        boolean z3 = false;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return 3;
        }
        String lowerCase = strArr[0].toLowerCase();
        Matcher matcher = this.dPX.matcher(lowerCase);
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
            as = group;
            z = true;
        } else if (lowerCase != null && lowerCase.startsWith("http://tieba.baidu.com/f?")) {
            String substring = lowerCase.substring("http://tieba.baidu.com/f?".length());
            if (substring != null) {
                String[] split2 = substring.split("&");
                int i2 = 0;
                while (true) {
                    if (i2 >= split2.length) {
                        as = null;
                        z = false;
                        break;
                    } else if (split2[i2] == null || !split2[i2].startsWith("kz=")) {
                        i2++;
                    } else {
                        as = split2[i2].substring(3);
                        z = true;
                        break;
                    }
                }
                if (!TextUtils.isEmpty(as) && as.contains("&")) {
                    as = as.split("&")[0];
                }
                if (TextUtils.isEmpty(as)) {
                    as = null;
                }
            } else {
                z = false;
                as = null;
            }
            str = "allthread";
            z2 = false;
        } else if (!lowerCase.startsWith("pb:")) {
            if (lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                as = lowerCase.substring("com.baidu.tieba://?kz=".length());
                z = false;
                str = null;
                z2 = true;
            } else if (!lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kz=")) {
                return 3;
            } else {
                as = com.baidu.tbadk.util.x.as(lowerCase, "kz=");
                z = false;
                str = null;
                z2 = false;
            }
        } else {
            as = lowerCase.substring(3);
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
        if (!StringUtils.isNull(as, true) && tbPageContext != null) {
            if (!StringUtils.isNull(str3) && com.baidu.adp.lib.h.b.g(str3, 0) == 33 && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                z3 = true;
            }
            if (z3) {
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(tbPageContext.getPageActivity(), as).ol()));
                return 1;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(as, null, str);
            createNormalCfg.setVideo_source(PbActivityConfig.KEY_VIDOE_SOURCE_PUSH);
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
            return 1;
        } else if (z2 && !TextUtils.isEmpty(as)) {
            com.baidu.adp.lib.h.i.c(TbadkCoreApplication.m9getInst(), er.K(TbadkCoreApplication.m9getInst(), as));
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10320").s("obj_locate", 3).s("obj_type", 2));
            return 1;
        } else if (z) {
            tbPageContext.showToast(u.j.page_not_found);
            return 1;
        } else {
            return 3;
        }
    }
}
