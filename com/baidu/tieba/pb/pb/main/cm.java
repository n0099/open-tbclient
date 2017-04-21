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
class cm implements bb.a {
    Pattern emG = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    @Override // com.baidu.tbadk.core.util.bb.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        String ar;
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        String substring;
        String str2;
        boolean z4;
        boolean z5 = false;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return 3;
        }
        String lowerCase = strArr[0].toLowerCase();
        Matcher matcher = this.emG.matcher(lowerCase);
        String str3 = "";
        if (Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEARCH_JUMP_PB, lowerCase));
            return 0;
        } else if (lowerCase.contains("bookcover:")) {
            Map<String, String> dG = com.baidu.tbadk.core.util.bb.dG(lowerCase.substring("bookcover:".length()));
            if (dG == null || dG.size() <= 0) {
                return 0;
            }
            if (com.baidu.adp.lib.g.b.g(dG.get("book_type"), 1) == 3) {
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
                if (lowerCase == null) {
                    str2 = "";
                    z4 = false;
                } else {
                    String[] split = lowerCase.split("&");
                    int i = 0;
                    while (true) {
                        if (i >= split.length) {
                            str2 = "";
                            break;
                        } else if (split[i] != null && split[i].startsWith("thread_type=")) {
                            str2 = split[i].substring("thread_type=".length());
                            break;
                        } else {
                            i++;
                        }
                    }
                    z4 = com.baidu.adp.lib.g.b.d(com.baidu.tbadk.util.x.ar(lowerCase, "is_from_push="), false);
                }
                z2 = z4;
                z3 = false;
                str3 = str2;
                ar = group;
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
                        if (i2 < split2.length) {
                            if (split2[i2] == null || !split2[i2].startsWith("kz=")) {
                                i2++;
                            } else {
                                ar = split2[i2].substring(3);
                                z = true;
                                break;
                            }
                        } else {
                            ar = null;
                            z = false;
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(ar) && ar.contains("&")) {
                        ar = ar.split("&")[0];
                    }
                    if (TextUtils.isEmpty(ar)) {
                        ar = null;
                    }
                } else {
                    z = false;
                    ar = null;
                }
                str = "allthread";
                z2 = false;
                z3 = false;
            } else if (!lowerCase.startsWith("pb:")) {
                if (lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                    ar = lowerCase.substring("com.baidu.tieba://?kz=".length());
                    z = false;
                    str = null;
                    z2 = false;
                    z3 = true;
                } else if (!lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kz=")) {
                    return 3;
                } else {
                    ar = com.baidu.tbadk.util.x.ar(lowerCase, "kz=");
                    z = false;
                    str = null;
                    z2 = false;
                    z3 = false;
                }
            } else {
                ar = lowerCase.substring(3);
                if (strArr.length > 1) {
                    str = strArr[1];
                    z2 = false;
                    z3 = false;
                    z = true;
                } else {
                    z = true;
                    str = null;
                    z2 = false;
                    z3 = false;
                }
            }
            if (!StringUtils.isNull(ar, true) && tbPageContext != null) {
                if (!StringUtils.isNull(str3) && com.baidu.adp.lib.g.b.g(str3, 0) == 33 && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    z5 = true;
                }
                if (z5) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(tbPageContext.getPageActivity(), ar).pE()));
                } else {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(ar, null, str);
                    if (lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(com.baidu.tbadk.util.x.ar(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                        createNormalCfg.setUserName(com.baidu.tbadk.util.x.ar(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                    }
                    createNormalCfg.setVideo_source("push");
                    if (z2) {
                        createNormalCfg.setFromPushNotify();
                    }
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                }
                return 1;
            } else if (z3 && !TextUtils.isEmpty(ar)) {
                com.baidu.adp.lib.g.i.f(TbadkCoreApplication.m9getInst(), ex.ah(TbadkCoreApplication.m9getInst(), ar));
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
