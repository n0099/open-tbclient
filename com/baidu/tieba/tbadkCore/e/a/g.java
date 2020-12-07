package com.baidu.tieba.tbadkCore.e.a;

import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.util.au;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static String TN(String str) {
        String[] split;
        String[] split2;
        String[] split3;
        if (au.isEmpty(str) || (split = str.split("\\?")) == null || split.length == 0 || (split2 = split[0].split("\\/\\/")) == null || split2.length < 2 || (split3 = split2[1].split("\\/")) == null || split2.length < 2) {
            return null;
        }
        return split3[split3.length - 1];
    }

    public static String TO(String str) {
        String[] split;
        String[] split2;
        String str2;
        String[] split3;
        String str3;
        try {
            if (au.isEmpty(str) || (split = str.split("\\?")) == null || split.length == 0 || (split2 = split[0].split("\\/\\/")) == null || split2.length < 2 || (split3 = (str2 = split2[1]).split("\\/")) == null || split2.length < 2 || (str3 = split3[split3.length - 1]) == null || str3.length() == 0) {
                return null;
            }
            return str2.substring(0, (str2.length() - str3.length()) - 1);
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public static String TP(String str) {
        Uri parse;
        if (au.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return parse.getQueryParameter(BuyTBeanActivityConfig.CALLBACK);
    }

    public static String TQ(String str) {
        Uri parse;
        if (au.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return parse.getQueryParameter("notificationName");
    }

    public static String TR(String str) {
        Uri parse;
        if (au.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return parse.getQueryParameter(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    }

    public static JSONObject TS(String str) throws JSONException {
        Uri parse;
        if (au.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        String queryParameter = parse.getQueryParameter("params");
        if (au.isEmpty(queryParameter)) {
            return null;
        }
        return new JSONObject(queryParameter);
    }
}
