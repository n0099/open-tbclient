package com.baidu.tieba.recommend;

import android.content.Context;
import android.util.Log;
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.kn.pk.PKEndActivity;
import com.baidu.tieba.kn.pk.PKWaitingActivity;
import com.baidu.tieba.kn.pk.PKingActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class bf {
    public static boolean a(Context context, String str) {
        if (str != null) {
            try {
                if (str.contains("jump=outer")) {
                    com.baidu.tieba.util.am.e(context, str);
                    return true;
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(bf.class.getName(), "jumpTiebaNative", e.getMessage());
            }
        }
        if (str != null && str.contains("jump_tieba_native=1")) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                DailyClassicalActivity.a(context);
                return true;
            } else if (str.contains("tag_name=") && str.contains("tag_id=")) {
                String a2 = a(str, "tag_id=");
                String a3 = a(str, "tag_name=");
                String a4 = a(str, "tag_type=");
                String a5 = a(str, "tag_is_selected=");
                if (a2 != null && a2.length() >= 0) {
                    TagContentActivity.a(context, a2, a3, a4, a5);
                }
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                PersonInfoActivity.a(context, a(str, "userid="), a(str, "un="));
                return true;
            } else if (str.contains("jump_chat=1")) {
                String a6 = a(str, "userid=");
                String a7 = a(str, "username=");
                String a8 = a(str, "portrait=");
                if (a6 != null && a6.length() > 0) {
                    ChatActivity.a(context, a6, a7, a8, null, "web_bd");
                } else {
                    ChatListActivity.a(context);
                }
                return true;
            } else if (str.contains("jump=shake_supperboy")) {
                return true;
            } else {
                if (str.contains("jump=supperboy_pk_start")) {
                    String a9 = a(str, "pk_id=");
                    String a10 = a(str, "pk_title=");
                    Log.d("WebviewHelper", "pkTitle = " + a10);
                    PKWaitingActivity.a(context, a9, a10);
                    return true;
                } else if (str.contains("jump=supperboy_pk_ing")) {
                    String a11 = a(str, "pk_id=");
                    String a12 = a(str, "pk_title=");
                    Log.d("WebviewHelper", "pkTitle = " + a12);
                    PKingActivity.a(context, a11, a12);
                    return true;
                } else if (str.contains("jump=supperboy_pk_end")) {
                    String a13 = a(str, "pk_id=");
                    String a14 = a(str, "pk_title=");
                    Log.d("WebviewHelper", "pkTitle = " + a14);
                    PKEndActivity.a(context, a13, a14);
                    return true;
                } else if (str.contains("kz=")) {
                    String a15 = a(str, "kz=");
                    if (a15 != null && a15.length() >= 0) {
                        NewPbActivity.a(context, a15, null, "allthread");
                    }
                    return true;
                } else if (str.contains("kw=")) {
                    String a16 = a(str, "kw=");
                    if (a16 != null && a16.length() >= 0) {
                        FrsActivity.a(context, a16, "allthread");
                    }
                    return true;
                }
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
