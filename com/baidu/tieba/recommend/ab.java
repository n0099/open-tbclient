package com.baidu.tieba.recommend;

import android.content.Context;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bo;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class ab {
    public static boolean a(Context context, String str) {
        if (str != null) {
            try {
                if (str.contains("jump=outer")) {
                    UtilHelper.e(context, str);
                    return true;
                }
            } catch (Exception e) {
                bo.b(ab.class.getName(), "jumpTiebaNative", e.getMessage());
            }
        }
        if (str != null && str.contains("jump=finish_this_page") && (context instanceof com.baidu.tieba.j)) {
            ((com.baidu.tieba.j) context).finish();
            return true;
        }
        if (str != null && str.contains("jump_tieba_native=1")) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                DailyClassicalActivity.a(context);
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                PersonInfoActivity.a(context, a(str, "userid="), a(str, "un="));
                return true;
            } else if (str.contains("jump_chat=1")) {
                String a = a(str, "userid=");
                String a2 = a(str, "username=");
                String a3 = a(str, "portrait=");
                if (a != null && a.length() > 0) {
                    try {
                        PersonalChatActivity.a(context, Long.parseLong(a), a2, a3, 0, null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    ChatListActivity.a(context);
                }
                return true;
            } else if (str.contains("kz=")) {
                String a4 = a(str, "kz=");
                if (a4 != null && a4.length() >= 0) {
                    NewPbActivity.a(context, a4, (String) null, "allthread");
                }
                return true;
            } else if (str.contains("kw=")) {
                String a5 = a(str, "kw=");
                if (a5 != null && a5.length() >= 0) {
                    FrsActivity.a(context, a5, "allthread");
                }
                return true;
            }
        }
        return false;
    }

    public static String a(String str, String str2) {
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
