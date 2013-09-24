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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.av;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class ae {
    public static boolean a(Context context, String str) {
        if (str != null) {
            try {
                if (str.contains("jump=outer")) {
                    UtilHelper.e(context, str);
                    return true;
                }
            } catch (Exception e) {
                av.b(ae.class.getName(), "jumpTiebaNative", e.getMessage());
            }
        }
        if (str != null && str.contains("jump_tieba_native=1")) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                DailyClassicalActivity.a(context);
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                PersonInfoActivity.a(context, a(str, "userid="), a(str, "un="));
                return true;
            } else if (str.contains("jump_chat=1")) {
                String a2 = a(str, "userid=");
                String a3 = a(str, "username=");
                String a4 = a(str, "portrait=");
                if (a2 != null && a2.length() > 0) {
                    ChatActivity.a(context, a2, a3, a4, null, "web_bd");
                } else {
                    ChatListActivity.a(context);
                }
                return true;
            } else if (str.contains("jump=shake_supperboy")) {
                return true;
            } else {
                if (str.contains("jump=supperboy_pk_start")) {
                    String a5 = a(str, "pk_id=");
                    String a6 = a(str, "pk_title=");
                    Log.d("WebviewHelper", "pkTitle = " + a6);
                    PKWaitingActivity.a(context, a5, a6);
                    return true;
                } else if (str.contains("jump=supperboy_pk_ing")) {
                    String a7 = a(str, "pk_id=");
                    String a8 = a(str, "pk_title=");
                    Log.d("WebviewHelper", "pkTitle = " + a8);
                    PKingActivity.a(context, a7, a8);
                    return true;
                } else if (str.contains("jump=supperboy_pk_end")) {
                    String a9 = a(str, "pk_id=");
                    String a10 = a(str, "pk_title=");
                    Log.d("WebviewHelper", "pkTitle = " + a10);
                    PKEndActivity.a(context, a9, a10);
                    return true;
                } else if (str.contains("kz=")) {
                    String a11 = a(str, "kz=");
                    if (a11 != null && a11.length() >= 0) {
                        NewPbActivity.a(context, a11, null, "allthread");
                    }
                    return true;
                } else if (str.contains("kw=")) {
                    String a12 = a(str, "kw=");
                    if (a12 != null && a12.length() >= 0) {
                        FrsActivity.a(context, a12, "allthread");
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
