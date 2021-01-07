package com.baidu.tieba.memberCenter.tail.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class d {
    public static String OI(String str) {
        return OJ(trim(str));
    }

    private static String OJ(String str) {
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

    public static String OK(String str) {
        String OJ = OJ(str);
        if (StringUtils.isNull(OJ)) {
            return TbadkCoreApplication.getInst().getString(R.string.tail_empty_toast);
        }
        if (!OM(OJ)) {
            return TbadkCoreApplication.getInst().getString(R.string.tail_invalid_emotion);
        }
        return "";
    }

    public static String OL(String str) {
        return OJ(str).trim();
    }

    public static boolean OM(String str) {
        Matcher matcher = Pattern.compile(TbFaceManager.fIs).matcher(str);
        while (matcher.find()) {
            if (TbFaceManager.bGp().DH(matcher.group()) <= 0) {
                return false;
            }
        }
        return true;
    }
}
