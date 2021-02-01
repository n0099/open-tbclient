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
    private static a paf;
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
            if (paf == null) {
                paf = new a(context.getApplicationContext());
            }
            aVar = paf;
        }
        return aVar;
    }

    public void add(String str, String str2) {
        if ((ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oZq == ChatInfo.ChatCategory.SMART || ChatInfo.oZq == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String hf = hf(str, str2);
            if (!TextUtils.isEmpty(hf)) {
                b.ejM().onEvent(str, hf);
            }
        }
    }

    public void e(String str, String str2, int i, String str3) {
        if ((ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oZq == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f = f(str, str2, i, str3);
            if (!TextUtils.isEmpty(f)) {
                b.ejM().onEvent(str, f);
            }
        }
    }

    public String hf(String str, String str2) {
        if ((ChatInfo.oZq != ChatInfo.ChatCategory.DUZHAN && ChatInfo.oZq != ChatInfo.ChatCategory.SMART && ChatInfo.oZq != ChatInfo.ChatCategory.C2C) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject hg = hg(str, str2);
            JSONObject jSONObject = new JSONObject();
            if (ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) {
                jSONObject.put("paid", ChatInfo.mPaid);
            }
            if (b.ejM().isCuidLogin(this.mContext)) {
                jSONObject.put("account_type", "cuid");
            } else {
                jSONObject.put("account_type", "uid");
            }
            hg.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + hg.toString());
            return hg.toString();
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
            JSONObject hg = hg(str, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paid", ChatInfo.mPaid);
            if (b.ejM().isCuidLogin(this.mContext)) {
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
            hg.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + hg.toString());
            return hg.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private JSONObject hg(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("network", getNetType());
        jSONObject.put("from", "IM");
        jSONObject.put("type", "");
        if (ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) {
            if (ChatInfo.mPainfo != null && ChatInfo.mPainfo.getSubsetType() == 16) {
                jSONObject.put("page", "xianst");
            } else {
                jSONObject.put("page", "guanfanghao");
            }
        } else if (ChatInfo.oZq == ChatInfo.ChatCategory.SMART) {
            jSONObject.put("page", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
        } else if (ChatInfo.oZq == ChatInfo.ChatCategory.C2C) {
            if (ChatInfo.oZB) {
                jSONObject.put("page", "minigame");
            } else {
                jSONObject.put("page", Constants.PAGE_C2C_NAME);
            }
        }
        if (str.equals("417")) {
            jSONObject.put("source", "");
        } else {
            jSONObject.put("source", ChatInfo.oZA);
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
