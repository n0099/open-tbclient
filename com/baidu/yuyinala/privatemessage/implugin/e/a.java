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
    private static a oOj;
    private Context mContext;

    private a(Context context) {
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public static synchronized a hl(Context context) {
        a aVar;
        synchronized (a.class) {
            if (oOj == null) {
                oOj = new a(context.getApplicationContext());
            }
            aVar = oOj;
        }
        return aVar;
    }

    public void add(String str, String str2) {
        if ((ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oNx == ChatInfo.ChatCategory.SMART || ChatInfo.oNx == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String hb = hb(str, str2);
            if (!TextUtils.isEmpty(hb)) {
                b.elg().onEvent(str, hb);
            }
        }
    }

    public void e(String str, String str2, int i, String str3) {
        if ((ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oNx == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f = f(str, str2, i, str3);
            if (!TextUtils.isEmpty(f)) {
                b.elg().onEvent(str, f);
            }
        }
    }

    public String hb(String str, String str2) {
        if ((ChatInfo.oNx != ChatInfo.ChatCategory.DUZHAN && ChatInfo.oNx != ChatInfo.ChatCategory.SMART && ChatInfo.oNx != ChatInfo.ChatCategory.C2C) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject hc = hc(str, str2);
            JSONObject jSONObject = new JSONObject();
            if (ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) {
                jSONObject.put("paid", ChatInfo.mPaid);
            }
            if (b.elg().isCuidLogin(this.mContext)) {
                jSONObject.put("account_type", "cuid");
            } else {
                jSONObject.put("account_type", "uid");
            }
            hc.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + hc.toString());
            return hc.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String f(String str, String str2, int i, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject hc = hc(str, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paid", ChatInfo.mPaid);
            if (b.elg().isCuidLogin(this.mContext)) {
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
            hc.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + hc.toString());
            return hc.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private JSONObject hc(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("network", getNetType());
        jSONObject.put("from", "IM");
        jSONObject.put("type", "");
        if (ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) {
            if (ChatInfo.mPainfo != null && ChatInfo.mPainfo.getSubsetType() == 16) {
                jSONObject.put("page", "xianst");
            } else {
                jSONObject.put("page", "guanfanghao");
            }
        } else if (ChatInfo.oNx == ChatInfo.ChatCategory.SMART) {
            jSONObject.put("page", "swan");
        } else if (ChatInfo.oNx == ChatInfo.ChatCategory.C2C) {
            if (ChatInfo.oNH) {
                jSONObject.put("page", "minigame");
            } else {
                jSONObject.put("page", Constants.PAGE_C2C_NAME);
            }
        }
        if (str.equals("417")) {
            jSONObject.put("source", "");
        } else {
            jSONObject.put("source", ChatInfo.oNG);
        }
        jSONObject.put("value", str2);
        return jSONObject;
    }

    private String getNetType() {
        int ht = e.ht(this.mContext);
        if (ht == 100) {
            return "wifi";
        }
        if (ht == 1 || ht == 2 || ht == 4 || ht == 7 || ht == 10) {
            return "2g";
        }
        if (ht == 3 || ht == 5 || ht == 6 || ht == 8 || ht == 9 || ht == 11 || ht == 12 || ht == 14) {
            return "3g";
        }
        if (ht == 13) {
            return "4g";
        }
        return "other";
    }
}
