package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.w;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class co implements bb.a {
    Pattern emj = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    @Override // com.baidu.tbadk.core.util.bb.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        String aq;
        boolean z;
        String str;
        boolean z2;
        String substring;
        String str2;
        boolean z3 = false;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return 3;
        }
        String lowerCase = strArr[0].toLowerCase();
        Matcher matcher = this.emj.matcher(lowerCase);
        String str3 = "";
        if (Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEARCH_JUMP_PB, lowerCase));
            return 0;
        } else if (lowerCase.contains("bookcover:")) {
            Map<String, String> dA = com.baidu.tbadk.core.util.bb.dA(lowerCase.substring("bookcover:".length()));
            if (dA == null || dA.size() <= 0) {
                return 0;
            }
            if (com.baidu.adp.lib.g.b.g(dA.get("book_type"), 1) == 3) {
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                    return 3;
                }
                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), w.l.manga_plugin_not_install_tip);
                return 0;
            } else if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                return 3;
            } else {
                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), w.l.book_plugin_not_install_tip);
                return 0;
            }
        } else {
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
                aq = group;
                z = true;
            } else if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
                if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                    substring = lowerCase.substring("http://tieba.baidu.com/f?".length());
                } else {
                    substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring("http://tieba.baidu.com/f?".length()) : null;
                }
                if (substring != null) {
                    String[] split2 = substring.split("&");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= split2.length) {
                            aq = null;
                            z = false;
                            break;
                        } else if (split2[i2] == null || !split2[i2].startsWith("kz=")) {
                            i2++;
                        } else {
                            aq = split2[i2].substring(3);
                            z = true;
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(aq) && aq.contains("&")) {
                        aq = aq.split("&")[0];
                    }
                    if (TextUtils.isEmpty(aq)) {
                        aq = null;
                    }
                } else {
                    z = false;
                    aq = null;
                }
                str = "allthread";
                z2 = false;
            } else if (!lowerCase.startsWith("pb:")) {
                if (lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                    aq = lowerCase.substring("com.baidu.tieba://?kz=".length());
                    z = false;
                    str = null;
                    z2 = true;
                } else if (!lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kz=")) {
                    return 3;
                } else {
                    aq = com.baidu.tbadk.util.x.aq(lowerCase, "kz=");
                    z = false;
                    str = null;
                    z2 = false;
                }
            } else {
                aq = lowerCase.substring(3);
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
            if (!StringUtils.isNull(aq, true) && tbPageContext != null) {
                if (!StringUtils.isNull(str3) && com.baidu.adp.lib.g.b.g(str3, 0) == 33 && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    z3 = true;
                }
                if (z3) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(tbPageContext.getPageActivity(), aq).pg()));
                } else {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(aq, null, str);
                    if (lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(com.baidu.tbadk.util.x.aq(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                        createNormalCfg.setUserName(com.baidu.tbadk.util.x.aq(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                    }
                    createNormalCfg.setVideo_source("push");
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                }
                return 1;
            } else if (z2 && !TextUtils.isEmpty(aq)) {
                com.baidu.adp.lib.g.i.f(TbadkCoreApplication.m9getInst(), ez.ae(TbadkCoreApplication.m9getInst(), aq));
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10320").s("obj_locate", 3).s("obj_type", 2));
                return 1;
            } else if (z) {
                tbPageContext.showToast(w.l.page_not_found);
                return 1;
            } else {
                return 3;
            }
        }
    }
}
