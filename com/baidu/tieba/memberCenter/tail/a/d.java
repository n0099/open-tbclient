package com.baidu.tieba.memberCenter.tail.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class d {
    public static String NA(String str) {
        return NB(trim(str));
    }

    private static String NB(String str) {
        Pattern compile = Pattern.compile(TbadkCoreApplication.getInst().getString(R.string.tail_remove_dupe_regex));
        boolean z = false;
        int i = 0;
        String str2 = str;
        while (!z && i < 1000) {
            Matcher matcher = compile.matcher(str2);
            if (matcher.find()) {
                str2 = matcher.replaceAll(TbadkCoreApplication.getInst().getString(R.string.tail_remove_dupe_replace));
                i++;
            } else {
                z = true;
            }
        }
        return str2;
    }

    private static String trim(String str) {
        return str.trim();
    }

    public static String NC(String str) {
        String NB = NB(str);
        if (StringUtils.isNull(NB)) {
            return TbadkCoreApplication.getInst().getString(R.string.tail_empty_toast);
        }
        if (!NE(NB)) {
            return TbadkCoreApplication.getInst().getString(R.string.tail_invalid_emotion);
        }
        return "";
    }

    public static String ND(String str) {
        return NB(str).trim();
    }

    public static boolean NE(String str) {
        Matcher matcher = Pattern.compile(TbFaceManager.fDL).matcher(str);
        while (matcher.find()) {
            if (TbFaceManager.bCw().Cw(matcher.group()) <= 0) {
                return false;
            }
        }
        return true;
    }
}
