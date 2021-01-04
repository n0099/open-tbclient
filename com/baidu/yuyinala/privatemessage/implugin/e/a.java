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
    private static a oUv;
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
            if (oUv == null) {
                oUv = new a(context.getApplicationContext());
            }
            aVar = oUv;
        }
        return aVar;
    }

    public void add(String str, String str2) {
        if ((ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oTH == ChatInfo.ChatCategory.SMART || ChatInfo.oTH == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String gZ = gZ(str, str2);
            if (!TextUtils.isEmpty(gZ)) {
                b.ell().onEvent(str, gZ);
            }
        }
    }

    public void e(String str, String str2, int i, String str3) {
        if ((ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oTH == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f = f(str, str2, i, str3);
            if (!TextUtils.isEmpty(f)) {
                b.ell().onEvent(str, f);
            }
        }
    }

    public String gZ(String str, String str2) {
        if ((ChatInfo.oTH != ChatInfo.ChatCategory.DUZHAN && ChatInfo.oTH != ChatInfo.ChatCategory.SMART && ChatInfo.oTH != ChatInfo.ChatCategory.C2C) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject ha = ha(str, str2);
            JSONObject jSONObject = new JSONObject();
            if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN) {
                jSONObject.put("paid", ChatInfo.mPaid);
            }
            if (b.ell().isCuidLogin(this.mContext)) {
                jSONObject.put("account_type", "cuid");
            } else {
                jSONObject.put("account_type", "uid");
            }
            ha.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + ha.toString());
            return ha.toString();
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
            JSONObject ha = ha(str, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paid", ChatInfo.mPaid);
            if (b.ell().isCuidLogin(this.mContext)) {
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
            ha.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + ha.toString());
            return ha.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private JSONObject ha(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("network", getNetType());
        jSONObject.put("from", "IM");
        jSONObject.put("type", "");
        if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN) {
            if (ChatInfo.mPainfo != null && ChatInfo.mPainfo.getSubsetType() == 16) {
                jSONObject.put("page", "xianst");
            } else {
                jSONObject.put("page", "guanfanghao");
            }
        } else if (ChatInfo.oTH == ChatInfo.ChatCategory.SMART) {
            jSONObject.put("page", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
        } else if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C) {
            if (ChatInfo.oTS) {
                jSONObject.put("page", "minigame");
            } else {
                jSONObject.put("page", Constants.PAGE_C2C_NAME);
            }
        }
        if (str.equals("417")) {
            jSONObject.put("source", "");
        } else {
            jSONObject.put("source", ChatInfo.oTR);
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
