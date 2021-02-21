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
/* loaded from: classes11.dex */
public class a {
    private static a paG;
    private Context mContext;

    private a(Context context) {
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public static synchronized a hB(Context context) {
        a aVar;
        synchronized (a.class) {
            if (paG == null) {
                paG = new a(context.getApplicationContext());
            }
            aVar = paG;
        }
        return aVar;
    }

    public void add(String str, String str2) {
        if ((ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oZQ == ChatInfo.ChatCategory.SMART || ChatInfo.oZQ == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String hh = hh(str, str2);
            if (!TextUtils.isEmpty(hh)) {
                b.ejU().onEvent(str, hh);
            }
        }
    }

    public void e(String str, String str2, int i, String str3) {
        if ((ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oZQ == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f = f(str, str2, i, str3);
            if (!TextUtils.isEmpty(f)) {
                b.ejU().onEvent(str, f);
            }
        }
    }

    public String hh(String str, String str2) {
        if ((ChatInfo.oZQ != ChatInfo.ChatCategory.DUZHAN && ChatInfo.oZQ != ChatInfo.ChatCategory.SMART && ChatInfo.oZQ != ChatInfo.ChatCategory.C2C) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject hi = hi(str, str2);
            JSONObject jSONObject = new JSONObject();
            if (ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN) {
                jSONObject.put("paid", ChatInfo.mPaid);
            }
            if (b.ejU().isCuidLogin(this.mContext)) {
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
            if (b.ejU().isCuidLogin(this.mContext)) {
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
        if (ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN) {
            if (ChatInfo.mPainfo != null && ChatInfo.mPainfo.getSubsetType() == 16) {
                jSONObject.put("page", "xianst");
            } else {
                jSONObject.put("page", "guanfanghao");
            }
        } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.SMART) {
            jSONObject.put("page", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
        } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.C2C) {
            if (ChatInfo.pab) {
                jSONObject.put("page", "minigame");
            } else {
                jSONObject.put("page", Constants.PAGE_C2C_NAME);
            }
        }
        if (str.equals("417")) {
            jSONObject.put("source", "");
        } else {
            jSONObject.put("source", ChatInfo.paa);
        }
        jSONObject.put("value", str2);
        return jSONObject;
    }

    private String getNetType() {
        int hH = e.hH(this.mContext);
        if (hH == 100) {
            return "wifi";
        }
        if (hH == 1 || hH == 2 || hH == 4 || hH == 7 || hH == 10) {
            return "2g";
        }
        if (hH == 3 || hH == 5 || hH == 6 || hH == 8 || hH == 9 || hH == 11 || hH == 12 || hH == 14) {
            return "3g";
        }
        if (hH == 13) {
            return "4g";
        }
        return "other";
    }
}
