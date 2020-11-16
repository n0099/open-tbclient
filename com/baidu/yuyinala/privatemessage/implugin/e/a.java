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
    private static a ozd;
    private Context mContext;

    private a(Context context) {
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public static synchronized a gC(Context context) {
        a aVar;
        synchronized (a.class) {
            if (ozd == null) {
                ozd = new a(context.getApplicationContext());
            }
            aVar = ozd;
        }
        return aVar;
    }

    public void add(String str, String str2) {
        if ((ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oyr == ChatInfo.ChatCategory.SMART || ChatInfo.oyr == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String gT = gT(str, str2);
            if (!TextUtils.isEmpty(gT)) {
                b.eft().onEvent(str, gT);
            }
        }
    }

    public void b(String str, String str2, int i, String str3) {
        if ((ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oyr == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String c = c(str, str2, i, str3);
            if (!TextUtils.isEmpty(c)) {
                b.eft().onEvent(str, c);
            }
        }
    }

    public String gT(String str, String str2) {
        if ((ChatInfo.oyr != ChatInfo.ChatCategory.DUZHAN && ChatInfo.oyr != ChatInfo.ChatCategory.SMART && ChatInfo.oyr != ChatInfo.ChatCategory.C2C) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject gU = gU(str, str2);
            JSONObject jSONObject = new JSONObject();
            if (ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN) {
                jSONObject.put("paid", ChatInfo.mPaid);
            }
            if (b.eft().isCuidLogin(this.mContext)) {
                jSONObject.put("account_type", "cuid");
            } else {
                jSONObject.put("account_type", "uid");
            }
            gU.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + gU.toString());
            return gU.toString();
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
            JSONObject gU = gU(str, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paid", ChatInfo.mPaid);
            if (b.eft().isCuidLogin(this.mContext)) {
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
            gU.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + gU.toString());
            return gU.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private JSONObject gU(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("network", getNetType());
        jSONObject.put("from", "IM");
        jSONObject.put("type", "");
        if (ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN) {
            if (ChatInfo.mPainfo != null && ChatInfo.mPainfo.getSubsetType() == 16) {
                jSONObject.put("page", "xianst");
            } else {
                jSONObject.put("page", "guanfanghao");
            }
        } else if (ChatInfo.oyr == ChatInfo.ChatCategory.SMART) {
            jSONObject.put("page", "swan");
        } else if (ChatInfo.oyr == ChatInfo.ChatCategory.C2C) {
            if (ChatInfo.oyB) {
                jSONObject.put("page", "minigame");
            } else {
                jSONObject.put("page", Constants.PAGE_C2C_NAME);
            }
        }
        if (str.equals("417")) {
            jSONObject.put("source", "");
        } else {
            jSONObject.put("source", ChatInfo.oyA);
        }
        jSONObject.put("value", str2);
        return jSONObject;
    }

    private String getNetType() {
        int gK = e.gK(this.mContext);
        if (gK == 100) {
            return "wifi";
        }
        if (gK == 1 || gK == 2 || gK == 4 || gK == 7 || gK == 10) {
            return "2g";
        }
        if (gK == 3 || gK == 5 || gK == 6 || gK == 8 || gK == 9 || gK == 11 || gK == 12 || gK == 14) {
            return "3g";
        }
        if (gK == 13) {
            return "4g";
        }
        return "other";
    }
}
