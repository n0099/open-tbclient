package com.baidu.yuyinala.privatemessage.session.util;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.d.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.yuyinala.privatemessage.session.b.b;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes4.dex */
public final class a {
    private static long oXL = -1;

    public static String j(Context context, long j) {
        Calendar calendar = Calendar.getInstance(eoo());
        calendar.setTimeInMillis(j);
        Date time = calendar.getTime();
        Calendar calendar2 = Calendar.getInstance(eoo());
        calendar2.setTimeInMillis(m43if(System.currentTimeMillis()));
        SimpleDateFormat simpleDateFormat = null;
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", eoo());
        } else if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5) - 1) {
            return "昨天";
        } else {
            if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) >= calendar2.get(5) - 7) {
                int i = calendar.get(7);
                if (i == 2) {
                    return "星期一";
                }
                if (i == 3) {
                    return "星期二";
                }
                if (i == 4) {
                    return "星期三";
                }
                if (i == 5) {
                    return "星期四";
                }
                if (i == 6) {
                    return "星期五";
                }
                if (i == 7) {
                    return "星期六";
                }
                if (i == 1) {
                    return "星期日";
                }
            } else if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) != calendar2.get(5)) {
                simpleDateFormat = new SimpleDateFormat("MM-dd", eoo());
            } else {
                simpleDateFormat = new SimpleDateFormat("yy-MM-dd", eoo());
            }
        }
        return simpleDateFormat.format(time);
    }

    /* renamed from: if  reason: not valid java name */
    public static long m43if(long j) {
        if (oXL < 0) {
            oXL = j;
        }
        if (Math.abs(oXL - j) > 1000) {
            oXL = j;
        }
        return oXL;
    }

    public static Locale eoo() {
        return BdBaseApplication.getInst().getResources().getConfiguration().locale;
    }

    public static String ig(long j) {
        if (j <= 0) {
            return null;
        }
        if (j > 0 && j < 100) {
            return String.valueOf(j);
        }
        return "99+";
    }

    public static void a(Context context, String str, long j, boolean z, String str2, String str3, String str4, long j2, String str5) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new af(context, j + "", str, str4, z, str2, str3, j2 + "", str5)));
    }

    public static void ih(long j) {
        b.eol().ie(j);
    }

    public static String b(ChatSession chatSession) {
        if (chatSession == null) {
            return "";
        }
        return chatSession.getLastMsg();
    }
}
