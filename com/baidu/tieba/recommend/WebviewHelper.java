package com.baidu.tieba.recommend;

import android.app.Activity;
import android.content.Context;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.chat.ImMessageCenterActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.cm;
import com.baidu.tieba.util.UtilHelper;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class WebviewHelper {
    public static final String TAG = "WebviewHelper";

    public static boolean commonJumpHelper(Context context, String str) {
        if (str != null) {
            try {
                if (str.contains("jump=outer")) {
                    UtilHelper.e(context, str);
                    return true;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(WebviewHelper.class.getName(), "jumpTiebaNative", e.getMessage());
            }
        }
        if (str != null && str.contains("jump=finish_this_page") && (context instanceof com.baidu.tieba.f)) {
            ((com.baidu.tieba.f) context).finish();
            return true;
        }
        if (str != null && str.contains("jump_tieba_native=1")) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                DailyClassicalActivity.a(context);
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                cm.a(context, getMatchStringFromURL(str, "userid="), getMatchStringFromURL(str, "un="));
                return true;
            } else if (str.contains("jump_chat=1")) {
                String matchStringFromURL = getMatchStringFromURL(str, "userid=");
                String matchStringFromURL2 = getMatchStringFromURL(str, "username=");
                String matchStringFromURL3 = getMatchStringFromURL(str, "portrait=");
                if (matchStringFromURL != null && matchStringFromURL.length() > 0) {
                    try {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001002, new com.baidu.tieba.a.c(context, Long.parseLong(matchStringFromURL), matchStringFromURL2, matchStringFromURL3, 0)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    ImMessageCenterActivity.a(context);
                }
                return true;
            } else if (str.contains("kz=")) {
                String matchStringFromURL4 = getMatchStringFromURL(str, "kz=");
                if (matchStringFromURL4 != null && matchStringFromURL4.length() >= 0) {
                    NewPbActivity.a(context, matchStringFromURL4, (String) null, "allthread");
                }
                return true;
            } else if (str.contains("kw=")) {
                String matchStringFromURL5 = getMatchStringFromURL(str, "kw=");
                if (matchStringFromURL5 != null && matchStringFromURL5.length() >= 0) {
                    FrsActivity.a(context, matchStringFromURL5, "allthread");
                }
                return true;
            } else if (str.contains("jumptologin=1") && (context instanceof Activity)) {
                LoginActivity.a((Activity) context, "", true, 0);
                return true;
            }
        }
        return false;
    }

    public static String getMatchStringFromURL(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = str2.length() + indexOf;
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            return URLDecoder.decode(str.substring(length, i));
        }
        return "";
    }
}
