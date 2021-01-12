package com.baidu.tieba.tbadkCore.e.a;

import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static String So(String str) {
        String[] split;
        String[] split2;
        String[] split3;
        if (at.isEmpty(str) || (split = str.split("\\?")) == null || split.length == 0 || (split2 = split[0].split("\\/\\/")) == null || split2.length < 2 || (split3 = split2[1].split("\\/")) == null || split2.length < 2) {
            return null;
        }
        return split3[split3.length - 1];
    }

    public static String Sp(String str) {
        String[] split;
        String[] split2;
        String str2;
        String[] split3;
        String str3;
        try {
            if (at.isEmpty(str) || (split = str.split("\\?")) == null || split.length == 0 || (split2 = split[0].split("\\/\\/")) == null || split2.length < 2 || (split3 = (str2 = split2[1]).split("\\/")) == null || split2.length < 2 || (str3 = split3[split3.length - 1]) == null || str3.length() == 0) {
                return null;
            }
            return str2.substring(0, (str2.length() - str3.length()) - 1);
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public static String Sq(String str) {
        Uri parse;
        if (at.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return parse.getQueryParameter(BuyTBeanActivityConfig.CALLBACK);
    }

    public static String Sr(String str) {
        Uri parse;
        if (at.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return parse.getQueryParameter("notificationName");
    }

    public static String Ss(String str) {
        Uri parse;
        if (at.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return parse.getQueryParameter(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
    }

    public static JSONObject St(String str) throws JSONException {
        if (at.isEmpty(str)) {
            return new JSONObject();
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return new JSONObject();
        }
        String queryParameter = parse.getQueryParameter("params");
        if (at.isEmpty(queryParameter)) {
            return new JSONObject();
        }
        return new JSONObject(queryParameter);
    }
}
