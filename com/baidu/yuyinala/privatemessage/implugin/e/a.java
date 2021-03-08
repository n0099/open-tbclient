package com.baidu.yuyinala.privatemessage.implugin.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.d.b;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
import com.baidu.yuyinala.privatemessage.implugin.util.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static a pcM;
    private Context mContext;

    private a(Context context) {
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public static synchronized a hA(Context context) {
        a aVar;
        synchronized (a.class) {
            if (pcM == null) {
                pcM = new a(context.getApplicationContext());
            }
            aVar = pcM;
        }
        return aVar;
    }

    public void add(String str, String str2) {
        if ((ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN || ChatInfo.pbX == ChatInfo.ChatCategory.SMART || ChatInfo.pbX == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String hh = hh(str, str2);
            if (!TextUtils.isEmpty(hh)) {
                b.eke().onEvent(str, hh);
            }
        }
    }

    public void e(String str, String str2, int i, String str3) {
        if ((ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN || ChatInfo.pbX == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f = f(str, str2, i, str3);
            if (!TextUtils.isEmpty(f)) {
                b.eke().onEvent(str, f);
            }
        }
    }

    public String hh(String str, String str2) {
        if ((ChatInfo.pbX != ChatInfo.ChatCategory.DUZHAN && ChatInfo.pbX != ChatInfo.ChatCategory.SMART && ChatInfo.pbX != ChatInfo.ChatCategory.C2C) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject hi = hi(str, str2);
            JSONObject jSONObject = new JSONObject();
            if (ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN) {
                jSONObject.put("paid", ChatInfo.mPaid);
            }
            if (b.eke().isCuidLogin(this.mContext)) {
                jSONObject.put("account_type", "cuid");
            } else {
                jSONObject.put("account_type", "uid");
            }
            hi.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + hi.toString());
            return hi.toString();
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
            JSONObject hi = hi(str, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paid", ChatInfo.mPaid);
            if (b.eke().isCuidLogin(this.mContext)) {
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
            hi.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + hi.toString());
            return hi.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private JSONObject hi(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("network", getNetType());
        jSONObject.put("from", "IM");
        jSONObject.put("type", "");
        if (ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN) {
            if (ChatInfo.mPainfo != null && ChatInfo.mPainfo.getSubsetType() == 16) {
                jSONObject.put("page", "xianst");
            } else {
                jSONObject.put("page", "guanfanghao");
            }
        } else if (ChatInfo.pbX == ChatInfo.ChatCategory.SMART) {
            jSONObject.put("page", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
        } else if (ChatInfo.pbX == ChatInfo.ChatCategory.C2C) {
            if (ChatInfo.pci) {
                jSONObject.put("page", "minigame");
            } else {
                jSONObject.put("page", Constants.PAGE_C2C_NAME);
            }
        }
        if (str.equals("417")) {
            jSONObject.put("source", "");
        } else {
            jSONObject.put("source", ChatInfo.pch);
        }
        jSONObject.put("value", str2);
        return jSONObject;
    }

    private String getNetType() {
        int hG = e.hG(this.mContext);
        if (hG == 100) {
            return "wifi";
        }
        if (hG == 1 || hG == 2 || hG == 4 || hG == 7 || hG == 10) {
            return "2g";
        }
        if (hG == 3 || hG == 5 || hG == 6 || hG == 8 || hG == 9 || hG == 11 || hG == 12 || hG == 14) {
            return "3g";
        }
        if (hG == 13) {
            return "4g";
        }
        return "other";
    }
}
