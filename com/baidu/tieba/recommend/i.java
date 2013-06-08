package com.baidu.tieba.recommend;

import android.content.Context;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class i {
    public static boolean a(Context context, String str) {
        if (str != null) {
            try {
                if (str.contains("jump_tieba_native=1")) {
                    if (str.contains("jumptoapp_browser=classic_everyday")) {
                        DailyClassicalActivity.a(context);
                        return true;
                    } else if (str.contains("nearby=1")) {
                        MainTabActivity.a(context, "goto_nearby");
                        return true;
                    } else if (str.contains("kz=")) {
                        String a = a(str, "kz=");
                        if (a != null && a.length() >= 0) {
                            NewPbActivity.a(context, a, null, "allthread");
                        }
                        return true;
                    } else if (str.contains("kw=")) {
                        String a2 = a(str, "kw=");
                        if (a2 != null && a2.length() >= 0) {
                            FrsActivity.a(context, a2, "allthread");
                        }
                        return true;
                    } else if (str.contains("tag_name=") && str.contains("tag_id=")) {
                        String a3 = a(str, "tag_id=");
                        String a4 = a(str, "tag_name=");
                        String a5 = a(str, "tag_type=");
                        String a6 = a(str, "tag_is_selected=");
                        if (a3 != null && a3.length() >= 0) {
                            TagContentActivity.a(context, a3, a4, a5, a6);
                        }
                        return true;
                    } else if (str.contains("jump_chat=1")) {
                        String a7 = a(str, "userid=");
                        String a8 = a(str, "username=");
                        String a9 = a(str, "portrait=");
                        if (a7 != null && a7.length() > 0) {
                            ChatActivity.a(context, a7, a8, a9, null, "web_bd");
                        } else {
                            ChatListActivity.a(context);
                        }
                        return true;
                    } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                        PersonInfoActivity.a(context, a(str, "userid="), a(str, "un="));
                        return true;
                    }
                }
            } catch (Exception e) {
                ae.b(i.class.getName(), "jumpTiebaNative", e.getMessage());
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
