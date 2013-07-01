package com.baidu.tieba.recommend;

import android.content.Context;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.ab;
import com.baidu.tieba.util.z;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class i {
    public static boolean a(Context context, String str) {
        if (str != null) {
            try {
                if (str.contains("jump=outer")) {
                    ab.e(context, str);
                    return true;
                }
            } catch (Exception e) {
                z.b(i.class.getName(), "jumpTiebaNative", e.getMessage());
            }
        }
        if (str != null && str.contains("jump_tieba_native=1")) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                DailyClassicalActivity.a(context);
                return true;
            } else if (str.contains("nearby=1")) {
                MainTabActivity.a(context, "goto_nearby");
                return true;
            } else if (str.contains("kz=")) {
                String a2 = a(str, "kz=");
                if (a2 != null && a2.length() >= 0) {
                    NewPbActivity.a(context, a2, null, "allthread");
                }
                return true;
            } else if (str.contains("kw=")) {
                String a3 = a(str, "kw=");
                if (a3 != null && a3.length() >= 0) {
                    FrsActivity.a(context, a3, "allthread");
                }
                return true;
            } else if (str.contains("tag_name=") && str.contains("tag_id=")) {
                String a4 = a(str, "tag_id=");
                String a5 = a(str, "tag_name=");
                String a6 = a(str, "tag_type=");
                String a7 = a(str, "tag_is_selected=");
                if (a4 != null && a4.length() >= 0) {
                    TagContentActivity.a(context, a4, a5, a6, a7);
                }
                return true;
            } else if (str.contains("jump_chat=1")) {
                String a8 = a(str, "userid=");
                String a9 = a(str, "username=");
                String a10 = a(str, "portrait=");
                if (a8 != null && a8.length() > 0) {
                    ChatActivity.a(context, a8, a9, a10, null, "web_bd");
                } else {
                    ChatListActivity.a(context);
                }
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                PersonInfoActivity.a(context, a(str, "userid="), a(str, "un="));
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
