package com.baidu.yuyinala.privatemessage.implugin.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.d.b;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
import com.baidu.yuyinala.privatemessage.implugin.util.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static a ooe;
    private Context mContext;

    private a(Context context) {
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public static synchronized a gE(Context context) {
        a aVar;
        synchronized (a.class) {
            if (ooe == null) {
                ooe = new a(context.getApplicationContext());
            }
            aVar = ooe;
        }
        return aVar;
    }

    public void add(String str, String str2) {
        if ((ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN || ChatInfo.ons == ChatInfo.ChatCategory.SMART || ChatInfo.ons == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String gR = gR(str, str2);
            if (!TextUtils.isEmpty(gR)) {
                b.ebG().onEvent(str, gR);
            }
        }
    }

    public void b(String str, String str2, int i, String str3) {
        if ((ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN || ChatInfo.ons == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String c = c(str, str2, i, str3);
            if (!TextUtils.isEmpty(c)) {
                b.ebG().onEvent(str, c);
            }
        }
    }

    public String gR(String str, String str2) {
        if ((ChatInfo.ons != ChatInfo.ChatCategory.DUZHAN && ChatInfo.ons != ChatInfo.ChatCategory.SMART && ChatInfo.ons != ChatInfo.ChatCategory.C2C) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject gS = gS(str, str2);
            JSONObject jSONObject = new JSONObject();
            if (ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN) {
                jSONObject.put("paid", ChatInfo.mPaid);
            }
            if (b.ebG().isCuidLogin(this.mContext)) {
                jSONObject.put("account_type", "cuid");
            } else {
                jSONObject.put("account_type", "uid");
            }
            gS.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + gS.toString());
            return gS.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String c(String str, String str2, int i, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject gS = gS(str, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paid", ChatInfo.mPaid);
            if (b.ebG().isCuidLogin(this.mContext)) {
                jSONObject.put("account_type", "cuid");
            } else {
                jSONObject.put("account_type", "uid");
            }
            if (i > -1) {
                jSONObject.put("unreadNum", String.valueOf(i));
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(LogConfig.LOG_EXT_LOG, str3);
            }
            gS.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + gS.toString());
            return gS.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private JSONObject gS(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("network", getNetType());
        jSONObject.put("from", "IM");
        jSONObject.put("type", "");
        if (ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN) {
            if (ChatInfo.mPainfo != null && ChatInfo.mPainfo.getSubsetType() == 16) {
                jSONObject.put("page", "xianst");
            } else {
                jSONObject.put("page", "guanfanghao");
            }
        } else if (ChatInfo.ons == ChatInfo.ChatCategory.SMART) {
            jSONObject.put("page", "swan");
        } else if (ChatInfo.ons == ChatInfo.ChatCategory.C2C) {
            if (ChatInfo.onC) {
                jSONObject.put("page", "minigame");
            } else {
                jSONObject.put("page", Constants.PAGE_C2C_NAME);
            }
        }
        if (str.equals("417")) {
            jSONObject.put("source", "");
        } else {
            jSONObject.put("source", ChatInfo.onB);
        }
        jSONObject.put("value", str2);
        return jSONObject;
    }

    private String getNetType() {
        int gM = e.gM(this.mContext);
        if (gM == 100) {
            return "wifi";
        }
        if (gM == 1 || gM == 2 || gM == 4 || gM == 7 || gM == 10) {
            return "2g";
        }
        if (gM == 3 || gM == 5 || gM == 6 || gM == 8 || gM == 9 || gM == 11 || gM == 12 || gM == 14) {
            return "3g";
        }
        if (gM == 13) {
            return "4g";
        }
        return "other";
    }
}
